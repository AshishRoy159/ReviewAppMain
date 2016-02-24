package com.mindfire.reviewapp.web.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mindfire.reviewapp.web.domain.User;
import com.mindfire.reviewapp.web.dto.PasswordDTO;
import com.mindfire.reviewapp.web.dto.UserLoginDTO;
import com.mindfire.reviewapp.web.dto.UserRegDTO;
import com.mindfire.reviewapp.web.repository.UserRepository;

/**
 * This is a Service class for all User related services.
 * @author mindfire
 *
 */
@Service
public class UserService {

	@Autowired
	public UserRepository userRepository;

	/**
	 * Adds a new entry of the user to the table.
	 * @param dto
	 * @param model 
	 * @return returns the login page if successful, else returns to the registration page.
	 */
	public String createUser(UserRegDTO dto, Model model) {

		User existingUser = userRepository.findByUsername(dto.getUsername());
		if (existingUser == null || existingUser.equals("")) {
			User userExists = userRepository.findByEmail(dto.getEmail());
			if (userExists == null || userExists.equals("")) {

				User newUser = new User();

				newUser.setFname(dto.getFname());
				newUser.setLname(dto.getLname());
				newUser.setEmail(dto.getEmail());
				newUser.setUsername(dto.getUsername());
				newUser.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
				newUser.setRole("user");
				
				User createdUser = userRepository.save(newUser);

				System.out.println(createdUser);
				if (createdUser.equals(null)) {
					return "register";
				} else {
					model.addAttribute("status", "Registerd Successfully!!. Log in to continue.");
					return "redirect:login";
				}
			} else {
				model.addAttribute("userExists", "Email already Registered!!");
				return "register";
			}
		} else {
			model.addAttribute("userExists", "Username already exists!!");
			return "register";
		}
	}

	/**
	 * this method checks in the database with provided credentials and if they match, logs in the user
	 * @param dto
	 * @param session
	 * @param model
	 * @return returns to login page if unsuccessful, else return to the website's index or admin index
	 * depending on the role.
	 */
	public String loginUser(UserLoginDTO dto, HttpSession session, Model model) {

		if(session.getAttribute("username") == null || session.getAttribute("username").equals("")){
		User checkUser = userRepository.findByUsername(dto.getUsername());

		String password = checkUser.getPassword();
		if (checkUser != null && new BCryptPasswordEncoder().matches(dto.getPassword(), password)) {

			session.setAttribute("username", checkUser.getUsername());
			if (checkUser.getRole().equals("admin")) {
				session.setAttribute("user", "admin");
				return "redirect:admin/index";
			} else {
				session.setAttribute("user", "user");
				return "redirect:index";
			}
		} else {
			model.addAttribute("status", "Incorrect Username or Password!!");
			return "login";
		}
		} else {
			return "login";
		}
	}

	/**
	 * This method provides the full credentials of the user/admin.
	 * @param dto
	 * @param model
	 * @return returns the page with full profile details
	 */
	public String viewProfile(UserLoginDTO dto, Model model, HttpSession session) {
		String username = (String)session.getAttribute("username");
		User profile = userRepository.findByUsername(username);

		if (profile == null || profile.equals("")) {
			model.addAttribute("error", "Error Occurred!!");
			return "redirect:index";
		} else {
			return "admin/profile";
		}
	}

	/**
	 * This method logs out the admin.
	 * @param model
	 * @param session
	 * @return returns to the index page of the website.
	 */
	public String logoutAdmin(Model model, HttpSession session) {
		session.invalidate();
		return "redirect:../index";
	}

	/**
	 * This method logs out the User.
	 * @param model
	 * @param session
	 * @return returns to the index page of the website.
	 */
	public String logoutUser(Model model, HttpSession session) {
		session.invalidate();
		return "redirect:index";
	}

	/**
	 * This method changes the password of the user
	 * @param dto
	 * @param model
	 * @param session
	 * @return returns the information and redirects to login page.
	 */
	public String changePassword(@ModelAttribute("password") PasswordDTO dto, Model model, HttpSession session) {
		String username = (String) session.getAttribute("username");
		User user = userRepository.findByUsername(username);

		String password = user.getPassword();
		String newPass = new BCryptPasswordEncoder().encode(dto.getNewpassword());
		if (user != null && new BCryptPasswordEncoder().matches(dto.getPassword(), password)) {
			
			userRepository.setNewPasswordForUser(username, newPass);
			session.invalidate();
			model.addAttribute("status","Successsfully Changed Password! Login to continue.");
			return "redirect:../login";
		} else {
			model.addAttribute("status","Current Password is not correct!!");
			return "changePassword";
		}
	}
}

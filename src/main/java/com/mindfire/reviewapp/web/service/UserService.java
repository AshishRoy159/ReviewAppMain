package com.mindfire.reviewapp.web.service;

import java.util.List;

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

@Service
public class UserService {

	@Autowired
	public UserRepository userRepository;

	public String createUser(UserRegDTO dto, Model model) {

		List<User> existingUser = userRepository.findByUsername(dto.getUsername());
		if (existingUser.isEmpty()) {
			List<User> userExists = userRepository.findByEmail(dto.getEmail());
			if (userExists.isEmpty()) {

				User newUser = new User();

				newUser.setFname(dto.getFname());
				newUser.setLname(dto.getLname());
				newUser.setEmail(dto.getEmail());
				newUser.setUsername(dto.getUsername());
				newUser.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
				newUser.setRole("user");
				// newUser.setCnfPassword(user.getCnfPassword());

				User createdUser = userRepository.save(newUser);

				System.out.println(createdUser);
				if (createdUser.equals(null)) {
					return "register";
				} else {
					return "doRegister";
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

	public String loginUser(UserLoginDTO dto, HttpSession session, Model model) {

		List<User> checkUser = userRepository.findByUsername(dto.getUsername());

		String password = checkUser.get(0).getPassword();
		if (checkUser != null && new BCryptPasswordEncoder().matches(dto.getPassword(), password)) {

			session.setAttribute("username", checkUser.get(0).getUsername());
			if (checkUser.get(0).getRole().equals("admin")) {
				session.setAttribute("user", "admin");
				return "redirect:admin/index";
			} else {
				session.setAttribute("user", "user");
				return "index";
			}
		} else {
			model.addAttribute("status", "Incorrect Username or Password!!");
			return "login";
		}
	}

	public String viewProfile(UserLoginDTO dto, Model model) {
		List<User> profile = userRepository.findByUsername("ashish");

		if (profile.isEmpty()) {
			model.addAttribute("error", "Error Occurred!!");
			return "redirect:index";
		} else {
			return "admin/profile";
		}
	}

	public String logoutAdmin(Model model, HttpSession session) {
		session.invalidate();
		return "redirect:../index";
	}

	public String logoutUser(Model model, HttpSession session) {
		session.invalidate();
		return "index";
	}

	public String changePassword(@ModelAttribute("password") PasswordDTO dto, Model model, HttpSession session) {
		String username = (String) session.getAttribute("username");
		List<User> user = userRepository.findByUsername(username);

		String password = user.get(0).getPassword();
		if (user != null && new BCryptPasswordEncoder().matches(dto.getPassword(), password)) {

		}
	}
}

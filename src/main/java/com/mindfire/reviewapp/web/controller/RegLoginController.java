package com.mindfire.reviewapp.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindfire.reviewapp.web.dto.UserLoginDTO;
import com.mindfire.reviewapp.web.dto.UserRegDTO;
import com.mindfire.reviewapp.web.service.UserService;

/**
 * Deals with the mapping of the login, registration and logout of the user.
 * @author mindfire
 *
 */
@Controller
public class RegLoginController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * The method stores the information of the user in the database.
	 * @param dto
	 * @param model
	 * @return returns the login page.
	 */
	@RequestMapping(value = "doRegister", method = RequestMethod.POST)
	public String register(@ModelAttribute("register") UserRegDTO dto, Model model){
        return userService.createUser(dto, model);
	}
	
	/**
	 * This method checks on the database, if the input is correct, logs in the user.
	 * @param dto
	 * @param model
	 * @param session
	 * @return returns login page if unsuccessful else returns to the index page of the website.
	 */
	@RequestMapping(value = "doLogin", method = RequestMethod.POST)
	public String login(@ModelAttribute("login") UserLoginDTO dto, Model model, HttpSession session){
		return userService.loginUser(dto,session,model);
	}
	
	/**
	 * Logs out the User.
	 * @param dto
	 * @param model
	 * @param session
	 * @return returns index page of the website.
	 */
	@RequestMapping(value = "logout", method = RequestMethod.GET )
	public String logout(@ModelAttribute("login") UserLoginDTO dto, Model model, HttpSession session){
		return userService.logoutUser(model, session);
	}

}

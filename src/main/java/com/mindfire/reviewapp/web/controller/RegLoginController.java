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

@Controller
public class RegLoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "doRegister", method = RequestMethod.POST)
	public String register(@ModelAttribute("register") UserRegDTO dto, Model model){
        return userService.createUser(dto, model);
	}
	
	@RequestMapping(value = "doLogin", method = RequestMethod.POST)
	public String login(@ModelAttribute("login") UserLoginDTO dto, Model model, HttpSession session){
		return userService.loginUser(dto,session,model);
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET )
	public String logout(@ModelAttribute("login") UserLoginDTO dto, Model model, HttpSession session){
		return userService.logoutUser(model, session);
	}

}

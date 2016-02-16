package com.mindfire.reviewapp.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindfire.reviewapp.web.dto.AppRegDTO;
import com.mindfire.reviewapp.web.dto.PasswordDTO;
import com.mindfire.reviewapp.web.dto.UserLoginDTO;
import com.mindfire.reviewapp.web.service.AppService;
import com.mindfire.reviewapp.web.service.UserService;

@Controller
public class AdminController {
	
	@Autowired
	private AppService appService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = {"admin","admin/index"}, method = RequestMethod.GET)
	public String home(Model model, @ModelAttribute("appregister") AppRegDTO dto) {
		model.addAttribute("appregister", new AppRegDTO());
			
		return "admin/index";
	}
	
	@RequestMapping(value = "admin/appRegister", method = RequestMethod.POST )
	public String appRegister(Model model, @ModelAttribute("appregister") AppRegDTO dto){
		return appService.createApp(dto, model);
	}
	@RequestMapping(value = "admin/profile", method = RequestMethod.GET )
	public String viewProfile(Model model, @ModelAttribute("profile") UserLoginDTO dto){
		return userService.viewProfile(dto, model);
	}
	
	@RequestMapping(value = "admin/comments", method = RequestMethod.GET )
	public String viewComments(Model model, @ModelAttribute("comments") UserLoginDTO dto){
		return userService.viewProfile(dto, model);
	}
	
	@RequestMapping(value = "admin/logout", method = RequestMethod.GET )
	public String logout(Model model, HttpSession session){
		return userService.logoutAdmin(model, session);
	}
	@RequestMapping(value = "admin/changePassword", method = RequestMethod.GET )
	public String changePassword(@ModelAttribute("password") PasswordDTO dto, Model model, HttpSession session){
		return userService.changePassword(dto, model, session);
	}
	@RequestMapping(value = "chngPassword", method = RequestMethod.GET)
	public String changepw(@ModelAttribute("password") PasswordDTO dto, Model model){
		return "changePassword";
	}
}

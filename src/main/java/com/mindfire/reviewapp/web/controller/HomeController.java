package com.mindfire.reviewapp.web.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mindfire.reviewapp.web.dto.AppSearchDTO;
import com.mindfire.reviewapp.web.dto.UserLoginDTO;
import com.mindfire.reviewapp.web.dto.UserRegDTO;
import com.mindfire.reviewapp.web.service.AppService;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private AppService appService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/","index"}, method = RequestMethod.GET)
	public String home(@ModelAttribute("search") AppSearchDTO dto, Locale locale, Model model) {
		LOGGER.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("search", new AppSearchDTO());
		
		return "index";
	}
	
	@RequestMapping(value = "login")
	public String login(Model model, @ModelAttribute("login") UserLoginDTO dto){
		model.addAttribute("login", new UserLoginDTO());
		return "login";
	}
	
	@RequestMapping(value = "register")
	public String register(Model model, @ModelAttribute("register") UserRegDTO dto){
		model.addAttribute("register", new UserRegDTO());
		return "register";
	}
	@RequestMapping(value = "topAndroid")
	public ModelAndView topAndroid(@ModelAttribute("search") AppSearchDTO dto, Model model){
		model.addAttribute("search", new AppSearchDTO());
		return appService.topAndroid();
	}
	@RequestMapping(value = "topWindows")
	public ModelAndView topWindows(@ModelAttribute("search") AppSearchDTO dto, Model model){
		model.addAttribute("search", new AppSearchDTO());
		return appService.topWindows();
	}
	@RequestMapping(value = "topIPhone")
	public ModelAndView topIPhone(@ModelAttribute("search") AppSearchDTO dto, Model model){
		model.addAttribute("search", new AppSearchDTO());
		return appService.topIPhone();
	}
	
	
}

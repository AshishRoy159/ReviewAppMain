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
 * Handles requests for the application home page and other page's mapping.
 * @author mindfire
 *
 */
@Controller
public class HomeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private AppService appService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @param dto
	 * @param locale
	 * @param model
	 * @return returns the home page.
	 */
	@RequestMapping(value = {"/","index"}, method = RequestMethod.GET)
	public String home(@ModelAttribute("search") AppSearchDTO dto, Locale locale, Model model) {
		LOGGER.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		return "index";
	}
	
	/**
	 * Maps the login page of the application
	 * @param model
	 * @param dto
	 * @return returns the login page
	 */
	@RequestMapping(value = "login")
	public ModelAndView login(Model model, @ModelAttribute("login") UserLoginDTO dto){
		return new ModelAndView("login");
	}
	
	/**
	 * Maps the register page of the application
	 * @param model
	 * @param dto
	 * @return returns the registration page for the user.
	 */
	@RequestMapping(value = "register")
	public String register(Model model, @ModelAttribute("register") UserRegDTO dto){
		return "register";
	}
	/**
	 * Shows all the apps which are on android platform on a page
	 * @param dto
	 * @param model
	 * @return returns the page with the list of application.
	 */
	@RequestMapping(value = "topAndroid")
	public ModelAndView topAndroid(@ModelAttribute("search") AppSearchDTO dto, Model model){
		return appService.topAndroid();
	}
	/**
	 * Shows all the apps which are on windows platform on a page
	 * @param dto
	 * @param model
	 * @return returns the page with the list of application.
	 */
	@RequestMapping(value = "topWindows")
	public ModelAndView topWindows(@ModelAttribute("search") AppSearchDTO dto, Model model){
		return appService.topWindows();
	}
	/**
	 * Shows all the apps which are on iphone platform on a page
	 * @param dto
	 * @param model
	 * @return returns the page with the list of application.
	 */
	@RequestMapping(value = "topIPhone")
	public ModelAndView topIPhone(@ModelAttribute("search") AppSearchDTO dto, Model model){
		return appService.topIPhone();
	}
	
	
}

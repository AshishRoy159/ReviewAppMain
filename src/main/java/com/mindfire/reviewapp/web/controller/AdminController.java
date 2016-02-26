package com.mindfire.reviewapp.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mindfire.reviewapp.web.dto.AppRegDTO;
import com.mindfire.reviewapp.web.dto.AppSearchDTO;
import com.mindfire.reviewapp.web.dto.DeveloperDTO;
import com.mindfire.reviewapp.web.dto.PasswordDTO;
import com.mindfire.reviewapp.web.dto.UserLoginDTO;
import com.mindfire.reviewapp.web.service.AppService;
import com.mindfire.reviewapp.web.service.DeveloperService;
import com.mindfire.reviewapp.web.service.UserService;

/**
 * This controller class controls all the admin related mappings.
 * 
 * @author mindfire
 *
 */
@Controller
public class AdminController {
	
	@Autowired
	private AppService appService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DeveloperService developerService;

	
	/**
	 * This method maps the home page of admin. There is also the Application add form in this page.
	 * 
	 * @param model
	 * @param dto
	 * @return returns the admin's index page.
	 */
	@RequestMapping(value = {"admin","admin/index"}, method = RequestMethod.GET)
	public ModelAndView home(Model model, @ModelAttribute("appregister") AppRegDTO dto) {
		return developerService.adminIndex();
	}
	
	/**
	 * This method is executed when Admin adds a new entry of an Application.
	 * 
	 * @param model
	 * @param dto
	 * @return returns the information of the app registration (Successful/Unsuccessful).
	 */
	@RequestMapping(value = "admin/appRegister", method = RequestMethod.POST )
	public String appRegister(Model model, @ModelAttribute("appregister") AppRegDTO dto){
		return appService.createApp(dto, model);
	}
	/**
	 * This method returns the profile details of the Admin.
	 * 
	 * @param model
	 * @param dto
	 * @return returns the Admin's profile page
	 */
	@RequestMapping(value = "admin/profile", method = RequestMethod.GET )
	public String viewProfile(Model model, @ModelAttribute("profile") UserLoginDTO dto, HttpSession session){
		return userService.viewProfile(dto, model,session);
	}
	
	/**
	 * This method shows all unapproved comments to the Admin.
	 * 
	 * @param model
	 * @param dto
	 * @return Returns the comments page
	 */
	@RequestMapping(value = "admin/comments", method = RequestMethod.GET )
	public String viewComments(Model model, @ModelAttribute("comments") UserLoginDTO dto, HttpSession session){
		return userService.viewProfile(dto, model,session);
	}
	
	/**
	 * This method executes the logout of the Admin.
	 * 
	 * @param dto
	 * @param model
	 * @param session
	 * @return returns to the index of the website.
	 */
	@RequestMapping(value = "admin/logout", method = RequestMethod.GET )
	public String logout(@ModelAttribute("search") AppSearchDTO dto, Model model, HttpSession session){
		model.addAttribute("search", new AppSearchDTO());
		return userService.logoutAdmin(model, session);
	}
	/**
	 * This method is to change the account password of the Admin.
	 * 
	 * @param dto
	 * @param model
	 * @param session
	 * @return Returns the information and redirects to login page.
	 */
	@RequestMapping(value = "admin/changePassword", method = RequestMethod.POST )
	public String changePassword(@ModelAttribute("password") PasswordDTO dto, Model model, HttpSession session){
		return userService.changePassword(dto, model, session);
	}
	/**
	 * This method maps the "changePassword.jsp" page.
	 * 
	 * @param dto
	 * @param model
	 * @return returns the ChangePassword page.
	 */
	@RequestMapping(value = "admin/chngPassword", method = RequestMethod.GET)
	public String changepw(@ModelAttribute("password") PasswordDTO dto, Model model){
		return "changePassword";
	}
	/**
	 * This method maps the page to add a new developer.
	 * 
	 * @param dto
	 * @param model
	 * @return returns response and redirects to the same page.
	 */
	@RequestMapping(value = "admin/developer", method = RequestMethod.GET)
	public String developer(@ModelAttribute("developer") DeveloperDTO dto, Model model){
		return "admin/addDeveloper";
	}
	/**
	 * This method is executed when admin Adds a new entry of a developer.
	 * 
	 * @param dto
	 * @param model
	 * @return returns response and redirects to the same page.
	 */
	@RequestMapping(value = "admin/addNewDeveloper", method = RequestMethod.POST)
	public String addDeveloper(@ModelAttribute("developer") DeveloperDTO dto, Model model){
		model.addAttribute("developer", new DeveloperDTO());
		return developerService.createDeveloper(dto, model);
	}
}

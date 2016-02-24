package com.mindfire.reviewapp.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mindfire.reviewapp.web.dto.AppSearchDTO;
import com.mindfire.reviewapp.web.dto.CommentRatingDTO;
import com.mindfire.reviewapp.web.exception.ResourceNotFoundException;
import com.mindfire.reviewapp.web.service.AppService;

/**
 * This Class contains all App related controls.
 * @author mindfire
 *
 */
@Controller
public class AppController {
	
	
	/**
	 * This is the exception handler method for the app id whose details are not available.
	 * @return return the not found page.
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	    public String handleResourceNotFoundException() {
	        return "notfound";
	    }

	@Autowired
	private AppService appService;
	
	/**
	 * This method searches the database for apps with matching name as input.
	 * @param dto
	 * @param model
	 * @return Returns the page with list of apps with matching name as search input.
	 */
	@RequestMapping(value = "searchDetails", method = RequestMethod.POST)
	public ModelAndView searchApp(@ModelAttribute("search") AppSearchDTO dto, Model model){
		return appService.searchApp(dto);
	}
	
	/**
	 * This method returns the details page of the particular app whose appid is provided in the URL.
	 * @param dto
	 * @param model
	 * @param appId
	 * @return returns app's detailed information and review page.
	 */
	@RequestMapping(value = "detailnreview/{appId}")
	public ModelAndView detailnreview(@ModelAttribute("search") AppSearchDTO dto, @ModelAttribute("review") CommentRatingDTO crdto, Model model,@PathVariable("appId") Integer appId){
		if (appId.equals("null")) throw new ResourceNotFoundException();
		return appService.viewAppDetails(appId);
	}
	/**
	 * This method returns the details page of the particular app after posting comment.
	 * @param dto
	 * @param model
	 * @param appId
	 * @return returns app's detailed information and review page.
	 */
	@RequestMapping(value = "detailnreview/{appId}", method = RequestMethod.POST)
	public String addReview(@ModelAttribute("search") AppSearchDTO dto, @ModelAttribute("review") CommentRatingDTO crdto, Model model, HttpSession session){
		return appService.addReview(crdto, session);
	}
	
	/**
	 * This method return the not found page if there is no entry in the database for provided app id.
	 * @return returns the not found page.
	 */
	@RequestMapping(value = "notfound")
	public String notFound(){
		return "notfound";
	}
}

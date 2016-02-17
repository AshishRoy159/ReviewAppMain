package com.mindfire.reviewapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mindfire.reviewapp.web.dto.AppSearchDTO;
import com.mindfire.reviewapp.web.service.AppService;

@Controller
public class AppController {

	@Autowired
	private AppService appService;
	
	@RequestMapping(value = "searchDetails", method = RequestMethod.POST)
	public ModelAndView searchApp(@ModelAttribute("search") AppSearchDTO dto, Model model){
		model.addAttribute("search", new AppSearchDTO()); 
		return appService.searchApp(dto);
	}
	
	@RequestMapping(value = "detailnreview/{appId}")
	public ModelAndView detailnreview(@ModelAttribute("search") AppSearchDTO dto, Model model,@PathVariable("appId") Integer appId){
		model.addAttribute("search", new AppSearchDTO());
		return appService.viewAppDetails(appId);
	}
}

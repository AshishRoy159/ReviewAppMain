package com.mindfire.reviewapp.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.mindfire.reviewapp.web.domain.Developer;
import com.mindfire.reviewapp.web.dto.DeveloperDTO;
import com.mindfire.reviewapp.web.repository.DeveloperRepository;

/**
 * This is a Service class for all Developer related services.
 * @author mindfire
 *
 */
@Service
public class DeveloperService {
	
	@Autowired
	private DeveloperRepository developerRepository;
	
	/**
	 * Thsi method adds a new developer entry to the Developer table in the database.
	 * @param dto
	 * @param model
	 * @return returns information and redirects to the same page.
	 */
	public String createDeveloper(DeveloperDTO dto, Model model){
		
		List<Developer> developer = developerRepository.findByNameIgnoreCase(dto.getName());
		if(developer.isEmpty()){
			Developer newDev = new Developer();
			
			newDev.setAddress(dto.getAddress());
			newDev.setName(dto.getName());
			newDev.setWebsite(dto.getWebsite());
			
			Developer newDeveloper = developerRepository.save(newDev);
			if(newDeveloper.equals(null)){
				model.addAttribute("status", "Failed to Add the New Developer!!");
				return "admin/addDeveloper";
			} else {
				model.addAttribute("status", "Successfully Added the Developer!!");
				return "admin/addDeveloper";
			}		
		
		} else {
			model.addAttribute("status", "Developer Already Exists");
			return "admin/addDeveloper";
		}
		
	}
	/**
	 * This method searches on the database for the available developer names on the database
	 * and shows them as a select input in app registration page.
	 * @return returns the admin's index page.
	 */
	public ModelAndView adminIndex(){
		List<Developer> devs = developerRepository.findAll();
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("devs", devs);
		return new ModelAndView("admin/index", model);
	}

}

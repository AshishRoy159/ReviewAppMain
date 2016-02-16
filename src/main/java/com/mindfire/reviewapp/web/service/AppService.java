package com.mindfire.reviewapp.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.mindfire.reviewapp.web.domain.App;
import com.mindfire.reviewapp.web.dto.AppRegDTO;
import com.mindfire.reviewapp.web.repository.AppRepository;

@Service
public class AppService {
	
	@Autowired
	private AppRepository appRepository;
	
	public String createApp(AppRegDTO dto, Model model){
		
		List<App> existingApp = appRepository.findByNameAndPlatform(dto.getAppname(), dto.getPlatform());
		if (existingApp.isEmpty()) {
			App newApp = new App();
			
			newApp.setName(dto.getAppname());
//			newApp.setDevname(dto.getDevname());
//			newApp.setWebsite(dto.getWebsite());
			newApp.setDetails(dto.getAppdetails());
			newApp.setPlatform(dto.getPlatform());
			
			App createdApp = appRepository.save(newApp);
			if(createdApp.equals(null)){
				model.addAttribute("status", "Failed to Add the New App!!");
				return "admin/index";
			} else {
				model.addAttribute("status", "Successfully Added the App!!");
				return "admin/index";
			}		
		
		} else {
			model.addAttribute("status", "App Already Exists");
			return "admin/index";
		}
	}

}

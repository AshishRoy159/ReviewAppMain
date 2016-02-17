package com.mindfire.reviewapp.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.mindfire.reviewapp.web.domain.App;
import com.mindfire.reviewapp.web.dto.AppRegDTO;
import com.mindfire.reviewapp.web.dto.AppSearchDTO;
import com.mindfire.reviewapp.web.repository.AppRepository;

@Service
public class AppService {
	
	private static final String ANDROID = "android";
	private static final String WINDOWS = "windows";
	private static final String IOS = "iOS";
	
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
	
	public ModelAndView searchApp(AppSearchDTO dto){
		
		List<App> apps = appRepository.findByNameIgnoreCaseContaining(dto.getName());
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("apps", apps);
		return new ModelAndView("searchDetails", model);
	}

	public ModelAndView viewAppDetails(Integer appId){
		List<App> apps = appRepository.findByAppId(appId);
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("apps", apps);
		return new ModelAndView("detailnreview", model);
	}
	
	public ModelAndView topAndroid(){
		List<App> apps = appRepository.findByPlatformIgnoreCase(ANDROID);
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("apps", apps);
		return new ModelAndView("topAndroid", model);
	}
	
	public ModelAndView topWindows(){
		List<App> apps = appRepository.findByPlatformIgnoreCase(WINDOWS);
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("apps", apps);
		return new ModelAndView("topWindows", model);
	}
	
	public ModelAndView topIPhone(){
		List<App> apps = appRepository.findByPlatformIgnoreCase(IOS);
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("apps", apps);
		return new ModelAndView("topIPhone", model);
	}
}

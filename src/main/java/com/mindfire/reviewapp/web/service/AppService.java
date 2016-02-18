package com.mindfire.reviewapp.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.mindfire.reviewapp.web.domain.App;
import com.mindfire.reviewapp.web.domain.Developer;
import com.mindfire.reviewapp.web.dto.AppRegDTO;
import com.mindfire.reviewapp.web.dto.AppSearchDTO;
import com.mindfire.reviewapp.web.repository.AppRepository;
import com.mindfire.reviewapp.web.repository.DeveloperRepository;

/**
 * This is a Service class for all App related services.
 * @author mindfire
 *
 */
@Service
public class AppService {
	
	private static final String ANDROID = "android";
	private static final String WINDOWS = "windows";
	private static final String IOS = "iOS";
	
	@Autowired
	private AppRepository appRepository;
	
	@Autowired
	private DeveloperRepository developerRepository;
	
	/**
	 * Creates a new app entry on the database.
	 * @param dto
	 * @param model
	 * @return reurns information and redirects to the admin home page.
	 */
	public String createApp(AppRegDTO dto, Model model){
		
		List<App> existingApp = appRepository.findByNameAndPlatform(dto.getAppname(), dto.getPlatform());
		if (existingApp.isEmpty()) {
			
			List<Developer> dev	= developerRepository.findByNameIgnoreCase(dto.getDevname());
			System.out.println(dto.getDevname());
			
			System.out.println(dev);
					
			App newApp = new App();
			
			newApp.setName(dto.getAppname());
			newApp.setDeveloperid(dev.get(0).getDeveloperId());
			newApp.setWebsite(dto.getWebsite());
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
	
	/**
	 * Searches the database for apps according to search inputs.
	 * @param dto 
	 * @return returns a page with the list of results.
	 */
	public ModelAndView searchApp(AppSearchDTO dto){
		
		List<App> apps = appRepository.findByNameIgnoreCaseContaining(dto.getName());
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("apps", apps);
		return new ModelAndView("searchDetails", model);
	}

	/**
	 * This method returns the details of the app whoose id is passed as an argument.
	 * @param appId
	 * @return returns a page with detailed result.
	 */
	public ModelAndView viewAppDetails(Integer appId){
		App apps = appRepository.findByAppId(appId);
		
		Developer dev = developerRepository.findByDeveloperId(apps.getDeveloperid());
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("apps", apps);
		model.put("dev", dev.getName());
		return new ModelAndView("detailnreview", model);
	}
	
	/**
	 * Searches the database for apps having platform as android.
	 * @return returns the page with list of results
	 */
	public ModelAndView topAndroid(){
		List<App> apps = appRepository.findByPlatformIgnoreCase(ANDROID);
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("apps", apps);
		return new ModelAndView("topAndroid", model);
	}
	
	/**
	 * Searches the database for apps having platform as Windows.
	 * @return returns the page with list of results
	 */
	public ModelAndView topWindows(){
		List<App> apps = appRepository.findByPlatformIgnoreCase(WINDOWS);
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("apps", apps);
		return new ModelAndView("topWindows", model);
	}
	
	/**
	 * Searches the database for apps having platform as iPhone.
	 * @return returns the page with list of results
	 */
	public ModelAndView topIPhone(){
		List<App> apps = appRepository.findByPlatformIgnoreCase(IOS);
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("apps", apps);
		return new ModelAndView("topIPhone", model);
	}
	
	
}

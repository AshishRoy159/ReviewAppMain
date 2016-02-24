package com.mindfire.reviewapp.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.mindfire.reviewapp.web.domain.App;
import com.mindfire.reviewapp.web.domain.Comment;
import com.mindfire.reviewapp.web.domain.Developer;
import com.mindfire.reviewapp.web.domain.Rating;
import com.mindfire.reviewapp.web.dto.AppRegDTO;
import com.mindfire.reviewapp.web.dto.AppSearchDTO;
import com.mindfire.reviewapp.web.dto.CommentRatingDTO;
import com.mindfire.reviewapp.web.exception.ResourceNotFoundException;
import com.mindfire.reviewapp.web.repository.AppRepository;
import com.mindfire.reviewapp.web.repository.CommentRepository;
import com.mindfire.reviewapp.web.repository.DeveloperRepository;
import com.mindfire.reviewapp.web.repository.RatingRepository;
import com.mindfire.reviewapp.web.repository.UserRepository;

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
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private RatingRepository ratingRepository;
	
	
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
			newApp.setDeveloper(developerRepository.findByName(dto.getDevname()));
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
	 * This method returns the details of the app whose id is passed as an argument.
	 * @param appId
	 * @return returns a page with detailed result.
	 */
	public ModelAndView viewAppDetails(Integer appId){
		App apps = appRepository.findByAppId(appId);
		
		if(apps == null || apps.equals("")){
			throw new ResourceNotFoundException();
		}
		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("apps", apps);
		
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
	/**
	 * Stores the Comment on the particular app to the database and returns to the same page.
	 * @return returns the page with list of results
	 */
	public String addReview(CommentRatingDTO dto, HttpSession session){
		
		
		
		Comment comment = new Comment();
		comment.setApp(appRepository.findByAppId(dto.getAppid()));
		comment.setUserinfo(userRepository.findByUsername(dto.getUserName()));
		comment.setComment(dto.getComment());
		
		commentRepository.save(comment);
		
		Rating rating = new Rating();
		
		rating.setApp(appRepository.findByAppId(dto.getAppid()));
		rating.setUserinfo(userRepository.findByUsername(dto.getUserName()));
		rating.setRating(dto.getRating());
		
		ratingRepository.save(rating);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("apps",comment.getApp());
		
		return "redirect:../detailnreview/{appId}";
		
	}
	
}

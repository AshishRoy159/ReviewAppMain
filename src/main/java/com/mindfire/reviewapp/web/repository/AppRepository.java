package com.mindfire.reviewapp.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindfire.reviewapp.web.domain.App;

/**
 * The App table's Repository.
 * @author mindfire
 *
 */
@Repository
public interface AppRepository extends JpaRepository<App, Long> {

	/**
	 * Finds an app by its name and platform
	 * @param name
	 * @param platform
	 * @return returns list of apps
	 */
	public List<App> findByNameAndPlatform(String name, String platform);
	
	/**
	 * Finds an app by its platform
	 * @param platform
	 * @return returns list of apps
	 */
	public List<App> findByPlatformIgnoreCase(String platform);
	
	/**
	 * Finds an app by its name.
	 * @param name
	 * @return returns list of apps
	 */
	public List<App> findByNameIgnoreCaseContaining(String name);
	
	/**
	 * Finds an app by its Id.
	 * @param id
	 * @return returns an app object.
	 */
	public App findByAppId(Integer id);
	
}

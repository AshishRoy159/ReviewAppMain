package com.mindfire.reviewapp.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindfire.reviewapp.web.domain.App;

@Repository
public interface AppRepository extends JpaRepository<App, Long> {

	public List<App> findByNameAndPlatform(String name, String platform);
	
	public List<App> findByPlatform(String platform);
}

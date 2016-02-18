package com.mindfire.reviewapp.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindfire.reviewapp.web.domain.Developer;

/**
 * This is the Repository for the Developer table in the database.
 * @author mindfire
 *
 */
@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long>{

	/**
	 * Finds a Developer details by id.
	 * @param id
	 * @return returns an object of the Developer Class.
	 */
	public Developer findByDeveloperId(Integer id);
	
	/**
	 * Finds List of Developer details by name.
	 * @param name
	 * @return returns list of objects of the Developer Class.
	 */
	public List<Developer> findByNameIgnoreCase(String name);
	
	/* (non-Javadoc)
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll()
	 */
	public List<Developer> findAll();
}

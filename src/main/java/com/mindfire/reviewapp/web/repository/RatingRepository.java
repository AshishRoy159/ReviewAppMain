package com.mindfire.reviewapp.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindfire.reviewapp.web.domain.Rating;

/**
 * This is the Repository for the Rating table in the database.
 * 
 * @author mindfire
 *
 */
@Repository
public interface RatingRepository extends JpaRepository <Rating, Integer>{

	
}

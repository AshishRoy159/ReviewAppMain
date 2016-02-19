package com.mindfire.reviewapp.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindfire.reviewapp.web.domain.Rating;

/**
 * Finds an app by its name and platform
 * @param name
 * @param platform
 * @return returns list of apps
 */
@Repository
public interface RatingRepository extends JpaRepository <Rating, Integer>{

}

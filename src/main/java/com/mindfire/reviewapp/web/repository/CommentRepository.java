package com.mindfire.reviewapp.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindfire.reviewapp.web.domain.App;
import com.mindfire.reviewapp.web.domain.Comment;

/**
 * The Comment table's Repository.
 * @author mindfire
 *
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
	
	/**
	 * Finds the list of comments of a particular app
	 * @param name
	 * @param platform
	 * @return returns list of apps
	 */
	public List<Comment> findByApp(App app); 

}

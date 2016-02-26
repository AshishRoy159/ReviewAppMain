package com.mindfire.reviewapp.web.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindfire.reviewapp.web.domain.User;

/**
 * This is the Repository for the Userinfo table in the database.
 * 
 * @author mindfire
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	/**
	 * Finds User by username.
	 * 
	 * @param username
	 * @return returns object user
	 */
	public User findByUsername(String username);
	
	/**
	 * Finds User by email.
	 * 
	 * @param email
	 * @return returns object user
	 */
	public User findByEmail(String email);
	
	/**
	 * This method sets a new password of the user.
	 * 
	 * @param username
	 * @param password
	 * @return returns the login page.
	 */
	@Modifying
	@Transactional
	@Query("update User u set u.password = :password where u.username = :username")
	Integer setNewPasswordForUser(@Param("username") String username, @Param("password") String password);
}

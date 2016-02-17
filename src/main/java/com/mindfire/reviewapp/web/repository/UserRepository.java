package com.mindfire.reviewapp.web.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindfire.reviewapp.web.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public List<User> findByUsername(String username);
	
	public List<User> findByEmail(String email);
	
	@Modifying
	@Transactional
	@Query("update User u set u.password = :password where u.username = :username")
	Integer setNewPasswordForUser(@Param("username") String username, @Param("password") String password);
}

package com.mindfire.reviewapp.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindfire.reviewapp.web.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public List<User> findByUsername(String username);
	
	public List<User> findByEmail(String email);
	
}

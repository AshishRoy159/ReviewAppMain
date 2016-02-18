package com.mindfire.reviewapp.web.dto;

/**
 * The DTO class for the Userinfo table which deals with registration of the User
 * @author mindfire
 *
 */
public class UserRegDTO {

	private String email;

	private String fname;

	private Long id;

	private String lname;

	private String password;

	private String username;
	
	public UserRegDTO(){
		
	}
	
	public UserRegDTO(String fname, String lname, String email, String username, String password){
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getFname() {
		return fname;
	}

	public Long getId() {
		return id;
	}

	public String getLname() {
		return lname;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}

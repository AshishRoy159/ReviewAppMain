package com.mindfire.reviewapp.web.dto;

/**
 * The DTO class for the Userinfo table which deals with changing password of the user
 * @author mindfire
 *
 */
public class PasswordDTO {
	private String password;
	private String newpassword;

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

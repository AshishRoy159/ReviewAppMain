package com.mindfire.reviewapp.web.dto;

/**
 * The DTO class for the Developer table which deals with registration of the Developer
 * @author mindfire
 *
 */
public class DeveloperDTO {

	private String address;
	private String name;
	private String website;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
}

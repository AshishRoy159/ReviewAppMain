package com.mindfire.reviewapp.web.dto;

/**
 * The DTO class for the App table which deals with registration of the app
 * @author mindfire
 *
 */
public class AppRegDTO {

	private String appname;
	private String devname;
	private String website;
	private String appdetails;
	private String platform;
	
	public String getAppname() {
		return appname;
	}
	public void setAppname(String appname) {
		this.appname = appname;
	}
	public String getDevname() {
		return devname;
	}
	public void setDevname(String devname) {
		this.devname = devname;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getAppdetails() {
		return appdetails;
	}
	public void setAppdetails(String appdetails) {
		this.appdetails = appdetails;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	public AppRegDTO(){
		
	}
	
	public AppRegDTO(String appname, String devname, String website, String appdetails, String platform){
		this.appname = appname;
		this.devname = devname;
		this.website = website;
		this.appdetails = appdetails;
		this.platform = platform;
	}
}

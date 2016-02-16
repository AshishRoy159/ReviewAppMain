package com.mindfire.reviewapp.web.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the app database table.
 * 
 */
@Entity
@NamedQuery(name="App.findAll", query="SELECT a FROM App a")
public class App implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="app_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer appId;

	@Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp added;

	private String bannerimg;

	private String details;

	private Integer developerid;
	
	@Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp modified;

	private String name;

	private String platform;

	private float rating;

	private String screenshots;

	public App() {
	}

	public Integer getAppId() {
		return this.appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public String getBannerimg() {
		return this.bannerimg;
	}

	public Timestamp getAdded() {
		return added;
	}

	public void setAdded(Timestamp added) {
		this.added = added;
	}

	public void setBannerimg(String bannerimg) {
		this.bannerimg = bannerimg;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Integer getDeveloperid() {
		return this.developerid;
	}

	public void setDeveloperid(Integer developerid) {
		this.developerid = developerid;
	}

	public Timestamp getModified() {
		return this.modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlatform() {
		return this.platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public float getRating() {
		return this.rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getScreenshots() {
		return this.screenshots;
	}

	public void setScreenshots(String screenshots) {
		this.screenshots = screenshots;
	}

}
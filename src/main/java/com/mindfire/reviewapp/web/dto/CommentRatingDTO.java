package com.mindfire.reviewapp.web.dto;

/**
 * The DTO class for the Comment and Rating table which deals with the storing of inputs of the user
 * @author mindfire
 *
 */
public class CommentRatingDTO {
	private int appid;
	private String comment;
	private float rating;
	private String userName;
	
	public int getAppid() {
		return appid;
	}
	public String getComment() {
		return comment;
	}
	
	
	public float getRating() {
		return rating;
	}
	public String getUserName() {
		return userName;
	}
	
	public void setAppid(int appid) {
		this.appid = appid;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public CommentRatingDTO(){
		
	}

}

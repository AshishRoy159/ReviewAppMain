package com.mindfire.reviewapp.web.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the rating database table.
 * 
 */
@Entity
@NamedQuery(name="Rating.findAll", query="SELECT r FROM Rating r")
public class Rating implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="rating_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ratingId;

	private Timestamp added;

	private double rating;

	//bi-directional many-to-one association to App
	@ManyToOne
	@JoinColumn(name="appid")
	private App app;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userid")
	private User userinfo;

	public Rating() {
	}

	public Integer getRatingId() {
		return this.ratingId;
	}

	public void setRatingId(Integer ratingId) {
		this.ratingId = ratingId;
	}

	public Timestamp getAdded() {
		return this.added;
	}

	public void setAdded(Timestamp added) {
		this.added = added;
	}

	public double getRating() {
		return this.rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public App getApp() {
		return this.app;
	}

	public void setApp(App app) {
		this.app = app;
	}

	public User getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(User userinfo) {
		this.userinfo = userinfo;
	}

}
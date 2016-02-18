package com.mindfire.reviewapp.web.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the developer database table.
 * 
 */
@Entity
@NamedQuery(name="Developer.findAll", query="SELECT d FROM Developer d")
public class Developer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="developer_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer developerId;

	@Temporal(TemporalType.DATE)
	private Date added;

	private String address;

	private Timestamp modifed;

	private String name;

	private String website;

	public Developer() {
	}

	public Integer getDeveloperId() {
		return this.developerId;
	}

	public void setDeveloperId(Integer developerId) {
		this.developerId = developerId;
	}

	public Date getAdded() {
		return this.added;
	}

	public void setAdded(Date added) {
		this.added = added;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getModifed() {
		return this.modifed;
	}

	public void setModifed(Timestamp modifed) {
		this.modifed = modifed;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	

}
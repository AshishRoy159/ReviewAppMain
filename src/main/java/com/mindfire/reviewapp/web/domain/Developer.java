package com.mindfire.reviewapp.web.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer developerId;

	@Temporal(TemporalType.DATE)
	private Date added;

	private String address;

	private Timestamp modified;

	private String name;

	private String website;

	//bi-directional many-to-one association to App
	@OneToMany(mappedBy="developer")
	private List<App> apps;

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

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<App> getApps() {
		return this.apps;
	}

	public void setApps(List<App> apps) {
		this.apps = apps;
	}

	public App addApp(App app) {
		getApps().add(app);
		app.setDeveloper(this);

		return app;
	}

	public App removeApp(App app) {
		getApps().remove(app);
		app.setDeveloper(null);

		return app;
	}

}
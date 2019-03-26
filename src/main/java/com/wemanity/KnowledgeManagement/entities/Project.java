package com.wemanity.KnowledgeManagement.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String title;

	private String businessField;

	private String customer;

	@ManyToOne
	private User userCreator;

	private Date lastModified;

	public Project(Integer id, String title, String businessField, String customer, User userCreator,
			Date lastModified) {
		super();
		this.id = id;
		this.title = title;
		this.businessField = businessField;
		this.customer = customer;
		this.userCreator = userCreator;
		this.lastModified = lastModified;
	}

	public Project() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBusinessField() {
		return businessField;
	}

	public void setBusinessField(String businessField) {
		this.businessField = businessField;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public User getUserCreator() {
		return userCreator;
	}

	public void setUserCreator(User userCreator) {
		this.userCreator = userCreator;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
}
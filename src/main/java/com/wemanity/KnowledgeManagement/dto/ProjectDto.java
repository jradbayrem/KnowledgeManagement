package com.wemanity.KnowledgeManagement.dto;

import com.wemanity.KnowledgeManagement.entities.Project;

public class ProjectDto {

	private Integer id;

	private String title;

	private String businessField;

	private String customer;

	public ProjectDto(Project project) {
		this.id = project.getId();
		this.title = project.getTitle();
		this.businessField = project.getBusinessField();
		this.customer = project.getCustomer();
	}

	public ProjectDto(Integer id, String title, String businessField, String customer) {
		super();
		this.id = id;
		this.title = title;
		this.businessField = businessField;
		this.customer = customer;
	}

	public ProjectDto() {

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
}

package com.wemanity.KnowledgeManagement.entities;

import com.wemanity.KnowledgeManagement.dto.ProjectDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

	public Project(ProjectDto projectDto){
		super();
		this.id = projectDto.getId();
		this.title = projectDto.getTitle();
		this.businessField = projectDto.getBusinessField();
		this.customer = projectDto.getCustomer();
		this.userCreator = new User(projectDto.getUserCreator());
	}





}
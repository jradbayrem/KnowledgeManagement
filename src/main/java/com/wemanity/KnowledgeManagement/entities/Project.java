package com.wemanity.KnowledgeManagement.entities;

import com.wemanity.KnowledgeManagement.dto.ProjectDto;
import com.wemanity.KnowledgeManagement.exceptions.ProjectDtoIsNullException;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
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

	public Project(ProjectDto projectDto) throws ProjectDtoIsNullException {
		if(projectDto == null){
			throw new ProjectDtoIsNullException("The used ProjectDto is null");
		}

		this.id = projectDto.getId();
		this.title = projectDto.getTitle();
		this.businessField = projectDto.getBusinessField();
		this.customer = projectDto.getCustomer();
		this.userCreator = new User(projectDto.getUserCreator());
	}





}
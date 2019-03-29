package com.wemanity.KnowledgeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wemanity.KnowledgeManagement.entities.Project;
import com.wemanity.KnowledgeManagement.services.IProjectService;
import com.wemanity.KnowledgeManagement.services.impl.ProjectServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProjectController {

	@Autowired
	IProjectService projectService;

	public ProjectController(ProjectServiceImpl projectServiceImpl) {
		this.projectService = projectServiceImpl;
	}

	public ResponseEntity<Project> createProject(Project project) {
		return null;
	}
}
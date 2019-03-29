package com.wemanity.KnowledgeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

	@RequestMapping(value = "/createProject", method = RequestMethod.POST)
	public ResponseEntity<Project> createProject(@RequestBody Project project) {
		project = this.projectService.save(project);
		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateProject", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Project> updateProject(@RequestBody Project project) {
		project = this.projectService.update(project);
		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getProjectById", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Project> getProjectById(@RequestBody Integer id) {
		Project project = this.projectService.findById(id);
		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}
}
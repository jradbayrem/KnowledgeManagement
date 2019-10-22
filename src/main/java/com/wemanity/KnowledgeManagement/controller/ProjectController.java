package com.wemanity.KnowledgeManagement.controller;

import java.util.ArrayList;
import java.util.List;

import com.wemanity.KnowledgeManagement.dto.ProjectDto;
import com.wemanity.KnowledgeManagement.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wemanity.KnowledgeManagement.entities.Project;
import com.wemanity.KnowledgeManagement.services.IProjectService;
import com.wemanity.KnowledgeManagement.services.impl.ProjectServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/api/projects")
public class ProjectController {

	@Autowired
	IProjectService projectService;
	@Autowired
	ProjectMapper projectMapper;
	public ProjectController(ProjectServiceImpl projectServiceImpl) {
		this.projectService = projectServiceImpl;
	}

	@PostMapping
	public ProjectDto createProject(@RequestBody ProjectDto projectDto) {
		try {
			projectDto = projectMapper.projectToProjectDto(projectService.save(new Project(projectDto)));
		}catch (Exception e){
			e.printStackTrace();
		}
		return projectDto;
	}
	
	@PutMapping
	public void updateProject(@RequestBody ProjectDto projectDto) {
	    try {
	        Project project = this.projectService.generateProjectWithRefreshedDataFromProjectDto(projectDto);
            this.projectService.update(project);
        }catch (Exception e){
	        e.printStackTrace();
        }
	}
	
    @GetMapping(value = "/{id}")
	public ProjectDto getProjectById(@PathVariable Integer id) {
		ProjectDto projectDto = new ProjectDto();
		try{
            projectDto = projectMapper.projectToProjectDto(projectService.findById(id).orElse(null));
        }catch (Exception e){
		    e.printStackTrace();
        }
		return projectDto;
	}
	
	@GetMapping
	public List<Project> getAllProjects() {
		List<Project> projects = new ArrayList();
		try{
		    projects = projectService.findAll();
        } catch (Exception e){
		    e.printStackTrace();
        }
        return projects;
	}
}
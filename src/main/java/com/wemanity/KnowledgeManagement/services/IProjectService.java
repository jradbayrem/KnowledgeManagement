package com.wemanity.KnowledgeManagement.services;

import java.util.List;
import java.util.Optional;

import com.wemanity.KnowledgeManagement.dto.ProjectDto;
import com.wemanity.KnowledgeManagement.entities.Project;

public interface IProjectService {
	
	public Project save(Project project);
	
	public Project update(Project projet);
	
	public void delete(Project project);
	
	public Optional<Project> findById(Integer id);
	
	public List<Project> findAll();
	
	public Project generateProjectWithRefreshedDataFromProjectDto(ProjectDto project);

}

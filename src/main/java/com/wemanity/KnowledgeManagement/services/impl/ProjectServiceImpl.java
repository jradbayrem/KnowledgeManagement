package com.wemanity.KnowledgeManagement.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.wemanity.KnowledgeManagement.entities.User;
import com.wemanity.KnowledgeManagement.exceptions.ProjectDtoIsNullException;
import com.wemanity.KnowledgeManagement.exceptions.ProjectRepositoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wemanity.KnowledgeManagement.dto.ProjectDto;
import com.wemanity.KnowledgeManagement.entities.Project;
import com.wemanity.KnowledgeManagement.repositories.IProjectRepository;
import com.wemanity.KnowledgeManagement.services.IProjectService;

@Service
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	IProjectRepository projectRepository;
	
	public ProjectServiceImpl(IProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	@Override
	public Project save(Project project) {
		try{
			project = projectRepository.save(project);
		}catch (ProjectRepositoryException e){
			e.printStackTrace();
		}
		return project;
	}

	@Override
	public Project update(Project project) {
		try {
			project =  projectRepository.save(project);
		}catch (ProjectRepositoryException e){
			e.printStackTrace();
		}
		return  project;
	}

	@Override
	public void delete(Project project) {
		try{
			projectRepository.delete(project);
		}catch (ProjectRepositoryException e){
			e.printStackTrace();
		}
	}

	@Override
	public Optional<Project> findById(Integer id) {
		Optional<Project> project = Optional.empty();
		try{
			project = projectRepository.findById(id);
		}catch (ProjectRepositoryException e){
			e.printStackTrace();
		}
		return project;
	}

	@Override
	public List<Project> findAll() {
		List<Project> projects = new ArrayList();
		try {
			projects = projectRepository.findAll();
		}catch (ProjectRepositoryException e){
			e.printStackTrace();
		}
		return projects;
	}

	@Override
	public Project generateProjectWithRefreshedDataFromProjectDto(ProjectDto projectDto) {
		if(projectDto == null){
			throw new ProjectDtoIsNullException("The used projectDto is null");
		}
		Project project = new Project();
		try{
			project = this.findById(projectDto.getId()).orElseThrow(
					() -> new ProjectRepositoryException("Project with id " + projectDto.getId() + " not found in " +
							"Database"));
					project.setBusinessField(projectDto.getBusinessField());
					project.setCustomer(projectDto.getCustomer());
					project.setTitle(projectDto.getTitle());
					project.setUserCreator(new User(projectDto.getUserCreator()));

		}catch (ProjectRepositoryException e){
			e.printStackTrace();
		}

		return project;
	}



}

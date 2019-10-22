package com.wemanity.KnowledgeManagement.services;

import java.util.List;
import java.util.Optional;

import com.wemanity.KnowledgeManagement.dto.KnowledgeDto;
import com.wemanity.KnowledgeManagement.entities.Knowledge;
import com.wemanity.KnowledgeManagement.entities.Project;
import com.wemanity.KnowledgeManagement.entities.User;

public interface IKnowledgeService {
	
	public Knowledge save(Knowledge knowledge);
	
	public Knowledge update(Knowledge knowledge);
	
	public void delete(Knowledge knowledge);
	
	public List<Knowledge> findAll();
	
	public Optional<Knowledge> findById(Integer id);
	
	public List<Knowledge> findByRelatedProject(Project project);
	
	public List<Knowledge> findByUserCreator(User user);

	public void deleteById(Integer id);

	public Knowledge generateKnowledgeWithRefreshedDataFromKnowledgeDto(KnowledgeDto knowledgeDto);



}

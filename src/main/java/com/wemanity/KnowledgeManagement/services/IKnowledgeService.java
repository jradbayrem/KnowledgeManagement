package com.wemanity.KnowledgeManagement.services;

import java.util.List;

import com.wemanity.KnowledgeManagement.entities.Knowledge;
import com.wemanity.KnowledgeManagement.entities.Project;

public interface IKnowledgeService {
	
	public Knowledge save(Knowledge knowledge);
	
	public Knowledge update(Knowledge knowledge);
	
	public void delete(Knowledge knowledge);
	
	public List<Knowledge> findAll();
	
	public Knowledge findById(Integer id);
	
	public List<Knowledge> findByRelatedProject(Project project);

}

package com.wemanity.KnowledgeManagement.services;

import java.util.List;

import com.wemanity.KnowledgeManagement.entities.Knowledge;

public interface IKnowledgeService {
	
	public Knowledge save(Knowledge knowledge);
	
	public Knowledge update(Knowledge knowledge);
	
	public void delete(Knowledge knowledge);
	
	public List<Knowledge> findAll();

}

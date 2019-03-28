package com.wemanity.KnowledgeManagement.services;

import com.wemanity.KnowledgeManagement.entities.Knowledge;

public interface IKnowledgeService {
	
	public Knowledge save(Knowledge knowledge);
	
	public Knowledge update(Knowledge knowledge);

}

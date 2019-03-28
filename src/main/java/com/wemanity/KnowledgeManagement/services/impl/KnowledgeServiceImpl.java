package com.wemanity.KnowledgeManagement.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.wemanity.KnowledgeManagement.entities.Knowledge;
import com.wemanity.KnowledgeManagement.repositories.IKnowledgeRepository;
import com.wemanity.KnowledgeManagement.services.IKnowledgeService;

public class KnowledgeServiceImpl implements IKnowledgeService {

	@Autowired
	IKnowledgeRepository knowledgeRepository;
	
	public KnowledgeServiceImpl(IKnowledgeRepository knowledgeRepository) {
		this.knowledgeRepository = knowledgeRepository;
	}

	@Override
	public Knowledge save(Knowledge knowledge) {
		return this.knowledgeRepository.save(knowledge);
	}

}

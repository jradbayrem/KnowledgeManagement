package com.wemanity.KnowledgeManagement.services.impl;

import java.util.List;

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

	@Override
	public Knowledge update(Knowledge knowledge) {
		return this.knowledgeRepository.save(knowledge);
	}

	@Override
	public void delete(Knowledge knowledge) {
		this.knowledgeRepository.delete(knowledge);
	}

	@Override
	public List<Knowledge> findAll() {
		return this.knowledgeRepository.findAll();
	}

	@Override
	public Knowledge findById(Integer id) {
		return this.knowledgeRepository.findById(id).orElse(null);
	}

}

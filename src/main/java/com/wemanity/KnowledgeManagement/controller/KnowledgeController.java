package com.wemanity.KnowledgeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wemanity.KnowledgeManagement.entities.Knowledge;
import com.wemanity.KnowledgeManagement.services.IKnowledgeService;
import com.wemanity.KnowledgeManagement.services.impl.KnowledgeServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class KnowledgeController {

	@Autowired
	IKnowledgeService knowledgeService;
	
	public KnowledgeController(KnowledgeServiceImpl knowledgeServiceImpl) {
		this.knowledgeService = knowledgeServiceImpl;
	}

	public ResponseEntity<Knowledge> createKnowledge(Knowledge knowledge) {
		return null;
	}

}
package com.wemanity.KnowledgeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "/createKnowledge", method = RequestMethod.POST)
	public ResponseEntity<Knowledge> createKnowledge(@RequestBody Knowledge knowledge) {
		knowledge = this.knowledgeService.save(knowledge);
		return new ResponseEntity<Knowledge>(knowledge, HttpStatus.OK);
	}
	
	public ResponseEntity<Knowledge> updateKnowledge( Knowledge knowledge) {
		return null;
	}

}
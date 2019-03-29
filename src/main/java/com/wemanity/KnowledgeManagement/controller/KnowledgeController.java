package com.wemanity.KnowledgeManagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wemanity.KnowledgeManagement.dto.CommentDto;
import com.wemanity.KnowledgeManagement.entities.Comment;
import com.wemanity.KnowledgeManagement.entities.Knowledge;
import com.wemanity.KnowledgeManagement.entities.User;
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
	
	@RequestMapping(value = "/updateKnowledge", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Knowledge> updateKnowledge(@RequestBody Knowledge knowledge) {
		knowledge = this.knowledgeService.update(knowledge);
		return new ResponseEntity<Knowledge>(knowledge, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/knowledges", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Knowledge>> getAllKnowledges() {
		List<Knowledge> knowledges = this.knowledgeService.findAll();
		return new ResponseEntity<>(knowledges, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/knowledgesById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Knowledge> getKnowledgesById(@RequestBody Integer id) {
		Knowledge knowledge = this.knowledgeService.findById(id);
		return new ResponseEntity<>(knowledge, HttpStatus.OK);
	}
	
	public ResponseEntity<List<Knowledge>> getByUserCreator( User user) {
		return null;
	}

}
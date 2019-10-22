package com.wemanity.KnowledgeManagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wemanity.KnowledgeManagement.entities.Knowledge;
import com.wemanity.KnowledgeManagement.entities.Project;
import com.wemanity.KnowledgeManagement.entities.User;
import com.wemanity.KnowledgeManagement.services.IKnowledgeService;
import com.wemanity.KnowledgeManagement.services.impl.KnowledgeServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/api/knowledges")
public class KnowledgeController {

	@Autowired
	IKnowledgeService knowledgeService;
	
	public KnowledgeController(KnowledgeServiceImpl knowledgeServiceImpl) {

		this.knowledgeService = knowledgeServiceImpl;
	}

	@PostMapping
	public Knowledge createKnowledge(@RequestBody Knowledge knowledge) {
		try {
			knowledge = this.knowledgeService.save(knowledge);
		}catch (Exception e){
			e.printStackTrace();
		}
		return knowledge;
	}
	
	@PutMapping
	public Knowledge updateKnowledge(@RequestBody Knowledge knowledge) {
		try{
		knowledge = this.knowledgeService.update(knowledge);
	}catch (Exception e){
		e.printStackTrace();
	}
	return knowledge;
	}
	
	@GetMapping
	public List<Knowledge> getAllKnowledges() {
		List<Knowledge> knowledges = new ArrayList();
		try {
			knowledges=	this.knowledgeService.findAll();
		}catch (Exception e){
		e.printStackTrace();
	}
		return knowledges;
	}
	
	@GetMapping(value = "/{id}")
	public Knowledge getKnowledgesById(@PathVariable Integer id) {
		Knowledge knowledge = new Knowledge();
		try{
	knowledge = this.knowledgeService.findById(id).orElse(null);
		}catch (Exception e){
			e.printStackTrace();
		}
		return knowledge;
	}
	
	@GetMapping(value = "/users/{id}")
	public List<Knowledge> getByUserCreator(@PathVariable Integer id) {
		List<Knowledge> knowledges =  new ArrayList();
		try {
		knowledges =	this.knowledgeService.findByUserCreator(null);
		}catch (Exception e){
			e.printStackTrace();
		}
		return knowledges;
	}
	
    @GetMapping(value = "/projects/{id}")
 	public List<Knowledge> getByRelatedProject(@PathVariable Integer id) {
		List<Knowledge> knowledges = this.knowledgeService.findByRelatedProject(Project.builder()
        .id(id).build());
		return knowledges;
	}

}
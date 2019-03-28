package com.wemanity.KnowledgeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wemanity.KnowledgeManagement.dto.UserDto;
import com.wemanity.KnowledgeManagement.entities.Knowledge;
import com.wemanity.KnowledgeManagement.services.ICommentService;
import com.wemanity.KnowledgeManagement.services.impl.CommentServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CommentController {

	@Autowired
	ICommentService commentService;

	public CommentController(CommentServiceImpl commentServiceImpl) {
		this.commentService = commentServiceImpl;
	}

	public ResponseEntity<List<UserDto>> getCommentsByKnowledge(Knowledge knowledge) {
		return null;
	}	
}
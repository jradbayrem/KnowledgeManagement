package com.wemanity.KnowledgeManagement.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.wemanity.KnowledgeManagement.entities.Comment;
import com.wemanity.KnowledgeManagement.repositories.ICommentRepository;
import com.wemanity.KnowledgeManagement.services.ICommentService;

public class CommentServiceImpl implements ICommentService {

	@Autowired
	ICommentRepository commentRepository;
	
	public CommentServiceImpl(ICommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}

	@Override
	public Comment save(Comment comment) {
		return this.commentRepository.save(comment);
	}

	@Override
	public Comment update(Comment comment) {
		return this.commentRepository.save(comment);
	}

	@Override
	public void delete(Comment comment) {
		this.commentRepository.delete(comment);
	}

}

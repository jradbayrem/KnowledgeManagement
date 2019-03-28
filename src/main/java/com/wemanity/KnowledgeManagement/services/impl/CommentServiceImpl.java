package com.wemanity.KnowledgeManagement.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wemanity.KnowledgeManagement.dto.CommentDto;
import com.wemanity.KnowledgeManagement.entities.Comment;
import com.wemanity.KnowledgeManagement.entities.Knowledge;
import com.wemanity.KnowledgeManagement.entities.User;
import com.wemanity.KnowledgeManagement.repositories.ICommentRepository;
import com.wemanity.KnowledgeManagement.services.ICommentService;
import com.wemanity.KnowledgeManagement.services.IUserService;

@Service
public class CommentServiceImpl implements ICommentService {

	@Autowired
	ICommentRepository commentRepository;
	@Autowired
	IUserService userService;
	
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

	@Override
	public List<Comment> findByKnowledge(Knowledge knowledge) {
		return this.commentRepository.findByKnowledge(knowledge);
	}

	@Override
	public Comment getCommentFromCommentDto(CommentDto comment) {
		Comment myComment = new Comment(comment.getId(),comment.getTitle(),comment.getContent(),new User(),new Date());
		return new Comment(comment.getId(),comment.getTitle(),comment.getContent(),new User(),new Date());
	}

}

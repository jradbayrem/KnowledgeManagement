package com.wemanity.KnowledgeManagement.services;

import java.util.List;
import java.util.Optional;

import com.wemanity.KnowledgeManagement.dto.CommentDto;
import com.wemanity.KnowledgeManagement.entities.Comment;
import com.wemanity.KnowledgeManagement.entities.Knowledge;

public interface ICommentService {

	public Comment save(Comment comment);

	public Comment update(Comment comment);
	
	public void delete(Comment comment);
	
	public List<Comment> findByKnowledge(Knowledge knowledge);

	public Optional<Comment> findById(Integer id);
}

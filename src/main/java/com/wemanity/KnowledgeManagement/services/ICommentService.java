package com.wemanity.KnowledgeManagement.services;

import com.wemanity.KnowledgeManagement.entities.Comment;

public interface ICommentService {

	public Comment save(Comment comment);

	public Comment update(Comment comment);
	
	public void delete(Comment comment);

}

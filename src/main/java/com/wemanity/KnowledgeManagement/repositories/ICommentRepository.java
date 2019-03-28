package com.wemanity.KnowledgeManagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wemanity.KnowledgeManagement.entities.Comment;
import com.wemanity.KnowledgeManagement.entities.Knowledge;

public interface ICommentRepository extends JpaRepository<Comment, Integer> {
	
	public List<Comment> findByKnowledge(Knowledge knowldge);

}
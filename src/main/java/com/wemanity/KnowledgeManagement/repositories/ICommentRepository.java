package com.wemanity.KnowledgeManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wemanity.KnowledgeManagement.entities.Comment;

public interface ICommentRepository extends JpaRepository<Comment, Integer> {

}
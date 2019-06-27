package com.wemanity.KnowledgeManagement.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.wemanity.KnowledgeManagement.exceptions.CommentRepositoryException;
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
		try{
		comment = this.commentRepository.save(comment);
		}catch (CommentRepositoryException e){
			e.printStackTrace();
		}
		return comment;
	}

	@Override
	public Comment update(Comment comment) {
		try{
			comment = this.commentRepository.save(comment);
		}catch (CommentRepositoryException e){
			e.printStackTrace();
		}
		return comment;	}

	@Override
	public void delete(Comment comment) {

		try{
			this.commentRepository.delete(comment);
		}catch (CommentRepositoryException e){
			e.printStackTrace();
		}
	}

	@Override
	public List<Comment> findByKnowledge(Knowledge knowledge) {

		List<Comment> comments = new ArrayList();
		try{
			comments = this.commentRepository.findByKnowledge(knowledge);
		}catch (CommentRepositoryException e){
			e.printStackTrace();
		}
		return comments;
	}

    @Override
    public Optional<Comment> findById(Integer id) {
        return null;
    }


}

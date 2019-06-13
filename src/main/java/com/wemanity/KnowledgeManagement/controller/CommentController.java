package com.wemanity.KnowledgeManagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wemanity.KnowledgeManagement.dto.CommentDto;
import com.wemanity.KnowledgeManagement.entities.Comment;
import com.wemanity.KnowledgeManagement.entities.Knowledge;
import com.wemanity.KnowledgeManagement.services.ICommentService;
import com.wemanity.KnowledgeManagement.services.impl.CommentServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CommentController {

	@Autowired
	ICommentService commentService;

	private Comment operationComment;

	public CommentController(CommentServiceImpl commentServiceImpl) {
		this.commentService = commentServiceImpl;
	}

	@GetMapping(value = "/comments")
	public ResponseEntity<List<CommentDto>> getCommentsByKnowledge(@RequestBody Knowledge knowledge) {
		List<Comment> comments = this.commentService.findByKnowledge(knowledge);
		List<CommentDto> commentsDto = new ArrayList<CommentDto>();
		for (Comment currentComment : comments) {
			commentsDto.add(new CommentDto(currentComment));
		}
		return new ResponseEntity<>(commentsDto, HttpStatus.OK);
	}

	@PostMapping(value = "/createComment")
	public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
		comment = this.commentService.save(comment);
		return new ResponseEntity<Comment>(comment, HttpStatus.OK);
	}
	
	@PutMapping (value = "/updateComment")
	public CommentDto updateComment(@RequestBody CommentDto commentDto) {
        operationComment = new Comment(commentDto);
        this.commentService.update(operationComment);
		return commentDto;
	}

    public Comment getOperationComment() {
        return operationComment;
    }

    public void setOperationComment(Comment operationComment) {
        this.operationComment = operationComment;
    }
}
package com.wemanity.KnowledgeManagement.controller;

import java.util.ArrayList;
import java.util.List;

 import com.wemanity.KnowledgeManagement.dto.KnowledgeDto;
import com.wemanity.KnowledgeManagement.mapper.CommentMapper;
import com.wemanity.KnowledgeManagement.mapper.KnowledgeMapper;
import com.wemanity.KnowledgeManagement.services.IKnowledgeService;
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

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    KnowledgeMapper knowledgeMapper;

    @Autowired
    IKnowledgeService knowledgeService;

    public CommentController(CommentServiceImpl commentServiceImpl) {
        this.commentService = commentServiceImpl;
    }

    @GetMapping(value = "/comments")
    public List<CommentDto> getCommentsByKnowledge(@RequestBody KnowledgeDto knowledgeDto) {
        //Optional<Knowledge> knowledge = knowledgeService.findById(knowledgeDto.getId());
        return commentMapper.commentListToCommentDtoList(this.commentService.findByKnowledge(new Knowledge( )));
    }

    @PostMapping(value = "/createComment")
    public CommentDto createComment(@RequestBody CommentDto commentDto) {
        try {
            commentDto = this.commentMapper.commentToCommentDto(this.commentService.save(new Comment(commentDto)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return commentDto;

    }

    @PutMapping(value = "/updateComment")
    public void updateComment(@RequestBody CommentDto commentDto) {
        //return this.commentService.update(Comment);

    }

}
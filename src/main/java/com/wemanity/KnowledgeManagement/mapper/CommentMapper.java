package com.wemanity.KnowledgeManagement.mapper;


import com.wemanity.KnowledgeManagement.dto.CommentDto;
import com.wemanity.KnowledgeManagement.entities.Comment;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class CommentMapper {

    @Autowired
    KnowledgeMapper knowledgeMapper;
    @Autowired
    UserMapper userMapper;

    public CommentDto commentToCommentDto(Comment comment) {
        CommentDto commentDto = CommentDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .title(comment.getTitle())
                .knowledge(knowledgeMapper.knowledgeToKnowledgeDto(comment.getKnowledge()))
                .userCreator(userMapper.userToUserDto(comment.getUserCreator()))
                .build();
        return commentDto;
    }

    public List<CommentDto> commentListToCommentDtoList(List<Comment> comments) {
        List<CommentDto> commentDtos = new ArrayList();
        comments.parallelStream().forEach(
                comment -> {
                    commentDtos.add(this.commentToCommentDto(comment));

                }
        );
        return commentDtos;
    }
}


package com.wemanity.KnowledgeManagement.dto;

import com.wemanity.KnowledgeManagement.entities.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CommentDto {

    private Integer id;

    private String title;

    private String content;

    private UserDto userCreator;

    private KnowledgeDto knowledge;

    private Date lastModified;




}

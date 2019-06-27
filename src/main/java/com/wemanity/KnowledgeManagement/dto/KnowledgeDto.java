package com.wemanity.KnowledgeManagement.dto;

import java.util.ArrayList;
import java.util.List;

import com.wemanity.KnowledgeManagement.entities.Comment;
import com.wemanity.KnowledgeManagement.entities.Knowledge;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class KnowledgeDto {

    private Integer id;

    private String title;

    private String description;

    private String context;

    private ProjectDto relatedProject;

    private String langage;

    private String endType;

    private List<CommentDto> comments;

    private UserDto userCreator;




}

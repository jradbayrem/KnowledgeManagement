package com.wemanity.KnowledgeManagement.dto;

import com.wemanity.KnowledgeManagement.entities.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProjectDto {

    private Integer id;

    private String title;

    private String businessField;

    private String customer;

    private UserDto userCreator;



}

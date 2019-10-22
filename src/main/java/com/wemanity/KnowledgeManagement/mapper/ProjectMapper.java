package com.wemanity.KnowledgeManagement.mapper;

import com.wemanity.KnowledgeManagement.dto.ProjectDto;
import com.wemanity.KnowledgeManagement.entities.Project;
import com.wemanity.KnowledgeManagement.exceptions.ProjectIsNullException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class ProjectMapper {

    public ProjectDto projectToProjectDto(Project project) throws ProjectIsNullException {
        if(project == null){
            throw new ProjectIsNullException("Cannot map the Project to ProjectDto. The given project is null");
        }
        ProjectDto projectDto = ProjectDto.builder()
                .id(project.getId())
                .title(project.getTitle())
                .customer(project.getCustomer())
                .businessField(project.getBusinessField())
                .build();
        return projectDto;
    }

    public List<ProjectDto> projectListToProjectDtoList(List<Project> projects) {
        List<ProjectDto> projectDtos = new ArrayList();
        projects.parallelStream().forEach(
                project -> {
                    projectDtos.add(this.projectToProjectDto(project));
                }
        );
        return projectDtos;
    }

}

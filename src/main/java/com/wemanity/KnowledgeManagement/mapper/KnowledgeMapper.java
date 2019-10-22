 package com.wemanity.KnowledgeManagement.mapper;

import com.wemanity.KnowledgeManagement.dto.KnowledgeDto;
import com.wemanity.KnowledgeManagement.entities.Knowledge;
import com.wemanity.KnowledgeManagement.exceptions.KnowledgeIsNullException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class KnowledgeMapper {

    @Autowired
    CommentMapper commentMapper;
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    UserMapper userMapper;

    public KnowledgeDto knowledgeToKnowledgeDto(Knowledge knowledge){
        if (knowledge == null){
            throw new KnowledgeIsNullException("Cannot map the Knowledge to KnowledgeDto. The given knowledge is null");
        }
        KnowledgeDto knowledgeDto = KnowledgeDto.builder()
                .context(knowledge.getContext())
                .description(knowledge.getDescription())
                .endType(knowledge.getEndType())
                .id(knowledge.getId())
                .langage(knowledge.getLangage())
                .title(knowledge.getTitle())
                .relatedProject(projectMapper.projectToProjectDto(knowledge.getRelatedProject()))
                .userCreator(userMapper.userToUserDto(knowledge.getUserCreator()))
                .comments( CollectionUtils.isEmpty(knowledge.getComments()) ?
                        (commentMapper.commentListToCommentDtoList(knowledge.getComments())) : null  )
                .build();
        return knowledgeDto;

    }


    public  List<KnowledgeDto> knowledgeListToKnowledgeDtoList(List<Knowledge> knowledges){
        List<KnowledgeDto> knowledgeDtos = new ArrayList();
        knowledges.parallelStream().forEach(
                knowledge -> {
                    knowledgeDtos.add(this.knowledgeToKnowledgeDto(knowledge));
                }
        );
        return knowledgeDtos;
    }
}

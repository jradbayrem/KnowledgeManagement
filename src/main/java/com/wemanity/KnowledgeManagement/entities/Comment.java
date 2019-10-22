package com.wemanity.KnowledgeManagement.entities;

import com.wemanity.KnowledgeManagement.dto.CommentDto;
import com.wemanity.KnowledgeManagement.exceptions.CommentDtoIsNullException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    private String title;

	private String content;

	@ManyToOne
	private User userCreator;
	
	@ManyToOne
	private Knowledge knowledge;

	private Date lastModified;

	public Comment(CommentDto commentDto) throws CommentDtoIsNullException {
		if(commentDto == null){
			throw new CommentDtoIsNullException("The used commentDto is null");
		}
		this.id = commentDto.getId();
		this.title = commentDto.getTitle();
		this.content = commentDto.getContent();
		this.userCreator = new User(commentDto.getUserCreator());
		this.lastModified = commentDto.getLastModified();
		this.knowledge = new Knowledge(commentDto.getKnowledge());

	}


}
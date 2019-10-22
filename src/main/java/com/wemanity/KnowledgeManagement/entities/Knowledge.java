package com.wemanity.KnowledgeManagement.entities;

import com.wemanity.KnowledgeManagement.dto.KnowledgeDto;
import com.wemanity.KnowledgeManagement.exceptions.KnowledgeDtoIsNullException;
import com.wemanity.KnowledgeManagement.exceptions.KnowledgeIsNullException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Knowledge {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String title;

	private String description;

	private String context;

	@ManyToOne
	private Project relatedProject;

	private String langage;

	private String endType;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Comment> comments;

	@ManyToOne
	private User userCreator;

	private Date lastModified;


	public Knowledge(KnowledgeDto knowledgeDto) throws KnowledgeDtoIsNullException {
		if(knowledgeDto == null){
			throw new KnowledgeDtoIsNullException("The used knowledgeDto is null");
		}
		this.id = knowledgeDto.getId();
		this.title= knowledgeDto.getTitle();
		this.description = knowledgeDto.getDescription();
		this.context = knowledgeDto.getContext();
		this.relatedProject = new Project(knowledgeDto.getRelatedProject());
		this.userCreator = new User(knowledgeDto.getUserCreator());
		this.comments = new ArrayList();
		if(CollectionUtils.isEmpty(knowledgeDto.getComments()))
		{
			knowledgeDto.getComments()
					.parallelStream
							().forEach(
					commentDto -> {
						this.comments.add(new Comment(commentDto));
					}
			);
		}

	}


}

package com.wemanity.KnowledgeManagement.dto;

import java.util.ArrayList;
import java.util.List;
import com.wemanity.KnowledgeManagement.entities.Comment;
import com.wemanity.KnowledgeManagement.entities.Knowledge;

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

	public KnowledgeDto(Knowledge knowledge) {
		this.id = knowledge.getId();
		this.title = knowledge.getTitle();
		this.description = knowledge.getDescription();
		this.context = knowledge.getContext();
		this.relatedProject = new ProjectDto(knowledge.getRelatedProject());
		this.langage = knowledge.getLangage();
		this.endType = knowledge.getEndType();
		comments = new ArrayList<CommentDto>();
		for(Comment currentComment : knowledge.getComments()) {
			comments.add(new CommentDto(currentComment));
		}
		this.userCreator = new UserDto(knowledge.getUserCreator());
	}
	
	public KnowledgeDto(Integer id, String title, String description, String context, ProjectDto relatedProject,
			String langage, String endType, List<CommentDto> comments, UserDto userCreator) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.context = context;
		this.relatedProject = relatedProject;
		this.langage = langage;
		this.endType = endType;
		this.comments = comments;
		this.userCreator = userCreator;
	}

	public KnowledgeDto() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public ProjectDto getRelatedProject() {
		return relatedProject;
	}

	public void setRelatedProject(ProjectDto relatedProject) {
		this.relatedProject = relatedProject;
	}

	public String getLangage() {
		return langage;
	}

	public void setLangage(String langage) {
		this.langage = langage;
	}

	public String getEndType() {
		return endType;
	}

	public void setEndType(String endType) {
		this.endType = endType;
	}

	public List<CommentDto> getComments() {
		return comments;
	}

	public void setComments(List<CommentDto> comments) {
		this.comments = comments;
	}

	public UserDto getUserCreator() {
		return userCreator;
	}

	public void setUserCreator(UserDto userCreator) {
		this.userCreator = userCreator;
	}
}

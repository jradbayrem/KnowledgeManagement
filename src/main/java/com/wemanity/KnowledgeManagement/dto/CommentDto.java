package com.wemanity.KnowledgeManagement.dto;

import com.wemanity.KnowledgeManagement.entities.Comment;

public class CommentDto {

	private Integer id;

	private String title;

	private String content;

	private UserDto userCreator;
	
	private KnowledgeDto knowledge;

	public CommentDto(Comment comment) {
		this.id = comment.getId();
		this.title = comment.getTitle();
		this.content = comment.getContent();
		this.userCreator = new UserDto(comment.getUserCreator());
		this.knowledge = new KnowledgeDto(comment.getKnowledge());
	}

	public CommentDto(Integer id, String title, String content, UserDto userCreator, KnowledgeDto knowledge) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.userCreator = userCreator;
		this.knowledge = knowledge;
	}

	public CommentDto() {

		this.userCreator = new UserDto();
		this.knowledge = new KnowledgeDto();
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public UserDto getUserCreator() {
		return userCreator;
	}

	public void setUserCreator(UserDto userCreator) {
		this.userCreator = userCreator;
	}

	public KnowledgeDto getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(KnowledgeDto knowledge) {
		this.knowledge = knowledge;
	}
}

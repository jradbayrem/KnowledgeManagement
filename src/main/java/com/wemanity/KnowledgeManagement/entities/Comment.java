package com.wemanity.KnowledgeManagement.entities;

import com.wemanity.KnowledgeManagement.dto.CommentDto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

	public Comment(Integer id, String title, String content, User userCreator, Date lastModified) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.userCreator = userCreator;
		this.lastModified = lastModified;
	}

	public Comment(CommentDto commentDto){
		super();
		this.id = commentDto.getId();
		this.title = commentDto.getTitle();
		this.content = commentDto.getContent();
		this.userCreator = new User(commentDto.getUserCreator());

	}

	public Comment() {

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

	public User getUserCreator() {
		return userCreator;
	}

	public void setUserCreator(User userCreator) {
		this.userCreator = userCreator;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Knowledge getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(Knowledge knowledge) {
		this.knowledge = knowledge;
	}
	
	

}
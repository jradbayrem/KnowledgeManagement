package com.wemanity.KnowledgeManagement.entities;

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

	public Knowledge(Integer id, String title, String description, String context, Project relatedProject,
			String langage, String endType, List<Comment> comments, User userCreator, Date lastModified) {
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
		this.lastModified = lastModified;
	}

	public Knowledge() {

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

	public Project getRelatedProject() {
		return relatedProject;
	}

	public void setRelatedProject(Project relatedProject) {
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
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
}

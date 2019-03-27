package com.wemanity.KnowledgeManagement.dto;

import com.wemanity.KnowledgeManagement.entities.User;

public class UserDto {

	private Integer id;

	private String login;

	private String password;

	private String firstName;

	private String lastName;

	private String departement;

	private String email;

	public UserDto(User user) {
		this.id = user.getId();
		this.login = user.getLogin();
		this.password = user.getPassword();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.departement = user.getDepartement();
		this.email = user.getEmail();
	}

	public UserDto(Integer id, String login, String password, String firstName, String lastName, String departement,
			String email) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.departement = departement;
		this.email = email;
	}

	public UserDto() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

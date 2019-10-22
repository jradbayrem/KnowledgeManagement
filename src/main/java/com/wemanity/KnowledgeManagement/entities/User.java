package com.wemanity.KnowledgeManagement.entities;

import com.wemanity.KnowledgeManagement.dto.UserDto;
import com.wemanity.KnowledgeManagement.exceptions.UserDtoIsNullException;
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
@Entity
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String login;

	private String password;

	private String firstName;

	private String lastName;

	private String departement;

	private String email;

	private boolean activated;



	private Date lastModified;


	public User(UserDto userDto) throws UserDtoIsNullException {
		if(userDto == null){
			throw new UserDtoIsNullException("The used UserDto is null");
		}
		this.id = userDto.getId();
		this.login = userDto.getLogin();
		this.password = userDto.getPassword();
		this.firstName = userDto.getFirstName();
		this.lastName = userDto.getLastName();
		this.departement = userDto.getDepartement();
		this.email = userDto.getEmail();
	}


}
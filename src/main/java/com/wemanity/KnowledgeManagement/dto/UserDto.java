package com.wemanity.KnowledgeManagement.dto;

import com.wemanity.KnowledgeManagement.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private Integer id;

	private String login;

	private String password;

	private String firstName;

	private String lastName;

	private String departement;

	private String email;



}

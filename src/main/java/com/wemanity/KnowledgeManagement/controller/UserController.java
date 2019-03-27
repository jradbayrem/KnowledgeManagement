package com.wemanity.KnowledgeManagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wemanity.KnowledgeManagement.dto.UserDto;
import com.wemanity.KnowledgeManagement.entities.User;
import com.wemanity.KnowledgeManagement.services.IUserService;
import com.wemanity.KnowledgeManagement.services.impl.UserServiceImpl;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {

	@Autowired
	IUserService userService;

	public UserController(UserServiceImpl userServiceImpl) {
		userService = userServiceImpl;
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<UserDto>> getAllUsers() {
		List<User> users = new ArrayList<>();
		users = userService.findAll();
		List<UserDto> userDtoList = new ArrayList<UserDto>();
		for(User currentUser: users) {
			userDtoList.add(new UserDto(currentUser));
		}
		return new ResponseEntity<>(userDtoList, HttpStatus.OK);
	}


}
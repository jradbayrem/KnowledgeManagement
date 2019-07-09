package com.wemanity.KnowledgeManagement.controller;

import java.util.ArrayList;
import java.util.List;

import com.wemanity.KnowledgeManagement.exceptions.CommentRepositoryException;
import com.wemanity.KnowledgeManagement.exceptions.UserDtoIsNullException;
import com.wemanity.KnowledgeManagement.exceptions.UserRepositoryException;
import com.wemanity.KnowledgeManagement.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	@Autowired
	UserMapper userMapper;
	public UserController(UserServiceImpl userServiceImpl) {
		userService = userServiceImpl;
	}

	@GetMapping(value = "/users")
	public List<UserDto> getAllUsers() {
		List<UserDto> userDtoList = new ArrayList();
		try {
			List<User> users = userService.findAll();
			users.parallelStream().forEach(
					currentUser -> {
						userDtoList.add(userMapper.userToUserDto(currentUser));
					}
			);
		}catch (Exception e){
			e.printStackTrace();
		}
		return userDtoList;
	}


	@PutMapping(value = "/updateUser")
	public void updateUser(@RequestBody UserDto userDto) {
		try {
			User user = userService.generateUserWithRefreshedDataFromUserDto(userDto);
			userService.update(user);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@PostMapping(value = "/createUser")
	public UserDto createUser(@RequestBody UserDto userDto) {

		try {
			userDto = userMapper.userToUserDto(userService.save(new User(userDto)));
		}catch (Exception e){
			e.printStackTrace();
		}
			return userDto;
	}
	
}
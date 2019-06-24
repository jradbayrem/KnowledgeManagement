package com.wemanity.KnowledgeManagement.controller;

import java.util.ArrayList;
import java.util.List;

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
		List<User> users = userService.findAll();
		List<UserDto> userDtoList = new ArrayList();
		users.parallelStream().forEach(
				currentUser -> {
					userDtoList.add(userMapper.userToUserDto(currentUser));
				}
		);
		return userDtoList;
	}

	@PutMapping(value = "/updateUser")
	public void updateUser(@RequestBody UserDto userDto) {
		User user = userService.refreshAndMapUserFromUserDto(userDto);
	    userService.update(user);
	}

	@PostMapping(value = "/createUser")
	public UserDto createUser(@RequestBody UserDto userDto) {
			return userMapper.userToUserDto(userService.save(new User(userDto)));
	}
	
}
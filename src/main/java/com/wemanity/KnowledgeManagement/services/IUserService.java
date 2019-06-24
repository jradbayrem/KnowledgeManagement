package com.wemanity.KnowledgeManagement.services;

import java.util.List;

import com.wemanity.KnowledgeManagement.dto.UserDto;
import com.wemanity.KnowledgeManagement.entities.User;

public interface IUserService {
	
	 User save(User user);
	
	 User update(User user);
	
	 void delete(User user);
	
	 User findById(Integer id);
	
	 List<User> findAll();
	
	 User findByFirstNameAndLastName(String firstName, String lastName);
	
	 User getUserFromUserDto(UserDto userDto);

	 User refreshAndMapUserFromUserDto(UserDto userDto);

}
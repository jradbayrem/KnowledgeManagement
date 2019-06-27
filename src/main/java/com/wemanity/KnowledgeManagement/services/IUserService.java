package com.wemanity.KnowledgeManagement.services;

import java.util.List;
import java.util.Optional;

import com.wemanity.KnowledgeManagement.dto.UserDto;
import com.wemanity.KnowledgeManagement.entities.User;
import com.wemanity.KnowledgeManagement.exceptions.UserDtoIsNullException;

public interface IUserService {
	
	 User save(User user);
	
	 User update(User user);
	
	 void delete(User user);
	
	 Optional<User> findById(Integer id);
	
	 List<User> findAll();
	
	 Optional<User> findByFirstNameAndLastName(String firstName, String lastName);

	 User generateUserWithRefreshedDataFromUserDto(UserDto userDto) throws UserDtoIsNullException;

}
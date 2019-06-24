package com.wemanity.KnowledgeManagement.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wemanity.KnowledgeManagement.dto.UserDto;
import com.wemanity.KnowledgeManagement.entities.User;
import com.wemanity.KnowledgeManagement.repositories.IUserRepository;
import com.wemanity.KnowledgeManagement.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository userRepository;
	
	public UserServiceImpl(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@Override
	public User save(User user) {
		return  userRepository.save(user);
	}
	@Override
	public User update(User user) {
		return  userRepository.save(user);
	}
	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}
	@Override
	public User findById(Integer id) {
		return userRepository.findById(id).orElse(new User());
	}
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
	@Override
	public User findByFirstNameAndLastName(String firstName, String lastName) {
		return userRepository.findFirst1ByFirstNameAndLastName(firstName, lastName);
	}
	@Override
	public User getUserFromUserDto(UserDto userDto) {
		return new User(userDto);
	}

	@Override
	public User refreshAndMapUserFromUserDto(UserDto userDto) {
		User user = this.findById(userDto.getId());
		user.setLogin(userDto.getLogin());
		user.setDepartement(userDto.getDepartement());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setPassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());
		return user;
	}


}
package com.wemanity.KnowledgeManagement.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.wemanity.KnowledgeManagement.exceptions.UserDtoIsNullException;
import com.wemanity.KnowledgeManagement.exceptions.UserRepositoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
		try{
			user = userRepository.save(user);
		}catch (UserRepositoryException e){
			e.printStackTrace();
		}
		return  user;
	}
	@Override
	public User update(User user) {
		try{
			user = userRepository.save(user);
		}catch (UserRepositoryException e){
			e.printStackTrace();
		}
		return  user;
	}
	@Override
	public void delete(User user) {
		try{
			userRepository.delete(user);
		}catch (UserRepositoryException e){
			e.printStackTrace();
		}
	}
	@Override
	public Optional<User> findById(Integer id) {
		Optional<User> user = Optional.empty();
		try{
			user = userRepository.findById(id);
		}catch (UserRepositoryException e){
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList();
		try{
			users= userRepository.findAll();
		}catch (UserRepositoryException e){
			e.printStackTrace();
		}
		return users;
	}
	@Override
	public Optional<User> findByFirstNameAndLastName(String firstName, String lastName) {
		Optional<User> user = Optional.empty();
		try {
			user = Optional.of(userRepository.findFirst1ByFirstNameAndLastName(firstName, lastName));
		}catch (UserRepositoryException e){
			e.printStackTrace();
		}

		return user;
	}


	@Override
	public User generateUserWithRefreshedDataFromUserDto(UserDto userDto) throws UserDtoIsNullException {
		if(userDto == null){
		    throw new UserDtoIsNullException("The used UserDto is null");
        }
	    User user = new User();
		try {
			user = this.findById(userDto.getId()).orElseThrow(
					() -> new UserRepositoryException("User with Id " + userDto.getId() + " not found in DataBase")
			);
			user.setLogin(userDto.getLogin());
			user.setDepartement(userDto.getDepartement());
			user.setFirstName(userDto.getFirstName());
			user.setLastName(userDto.getLastName());
			user.setPassword(userDto.getPassword());
			user.setEmail(userDto.getEmail());

		}catch (UserRepositoryException e){
			e.printStackTrace();
		}
		return user;
	}


}
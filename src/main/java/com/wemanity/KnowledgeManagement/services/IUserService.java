package com.wemanity.KnowledgeManagement.services;

import java.util.List;

import com.wemanity.KnowledgeManagement.entities.User;

public interface IUserService {
	
	public User save(User user);
	
	public User update(User user);
	
	public void delete(User user);
	
	public User findById(Integer id);
	
	public List<User> findAll();

}
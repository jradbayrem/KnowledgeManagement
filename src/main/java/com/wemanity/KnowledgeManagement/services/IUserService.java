package com.wemanity.KnowledgeManagement.services;

import com.wemanity.KnowledgeManagement.entities.User;

public interface IUserService {
	
	public User save(User user);
	
	public User update(User user);
	
	public void delete(User user);
	
	public User findById(Integer id);

}
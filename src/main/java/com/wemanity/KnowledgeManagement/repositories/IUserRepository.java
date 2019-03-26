package com.wemanity.KnowledgeManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wemanity.KnowledgeManagement.entities.User;


public interface IUserRepository extends JpaRepository<User, Integer> {

}

package com.wemanity.KnowledgeManagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wemanity.KnowledgeManagement.entities.Knowledge;
import com.wemanity.KnowledgeManagement.entities.Project;
import com.wemanity.KnowledgeManagement.entities.User;

public interface IKnowledgeRepository extends JpaRepository<Knowledge, Integer> {
	
	public List<Knowledge> findByRelatedProject(Project project);
	
	public List<Knowledge> findByUserCreator(User user);

}
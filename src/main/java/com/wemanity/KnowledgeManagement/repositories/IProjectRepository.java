package com.wemanity.KnowledgeManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wemanity.KnowledgeManagement.entities.Project;

public interface IProjectRepository extends JpaRepository<Project, Integer> {

}

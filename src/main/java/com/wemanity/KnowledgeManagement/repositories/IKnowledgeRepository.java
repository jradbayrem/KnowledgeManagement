package com.wemanity.KnowledgeManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wemanity.KnowledgeManagement.entities.Knowledge;

public interface IKnowledgeRepository extends JpaRepository<Knowledge, Integer> {

}
package com.wemanity.KnowledgeManagement.exceptions;

import org.springframework.dao.DataAccessException;

public class ProjectRepositoryException extends DataAccessException {

    public ProjectRepositoryException(String message){
        super(message);

    }
}

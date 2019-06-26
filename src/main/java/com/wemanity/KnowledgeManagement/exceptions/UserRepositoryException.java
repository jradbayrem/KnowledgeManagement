package com.wemanity.KnowledgeManagement.exceptions;

import org.springframework.dao.DataAccessException;

public class UserRepositoryException extends DataAccessException {

    public UserRepositoryException(String message){
        super(message);
    }

}

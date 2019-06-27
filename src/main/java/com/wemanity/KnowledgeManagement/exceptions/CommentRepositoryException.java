package com.wemanity.KnowledgeManagement.exceptions;

import org.springframework.dao.DataAccessException;

public class CommentRepositoryException extends DataAccessException {

    public CommentRepositoryException(String message){
        super(message);
    }
}

package com.wemanity.KnowledgeManagement.exceptions;

import org.springframework.dao.DataAccessException;

public class KnowledgeRepositoryException extends DataAccessException {

    public KnowledgeRepositoryException(String message){
        super(message);

    }
}

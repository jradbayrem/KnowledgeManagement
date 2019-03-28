package com.wemanity.KnowledgeManagement.test.services;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wemanity.KnowledgeManagement.entities.Comment;
import com.wemanity.KnowledgeManagement.entities.Knowledge;
import com.wemanity.KnowledgeManagement.entities.User;
import com.wemanity.KnowledgeManagement.repositories.ICommentRepository;
import com.wemanity.KnowledgeManagement.services.impl.CommentServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceImplTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CommentServiceImplTest.class);
	private CommentServiceImpl commentService;
	@Mock
	ICommentRepository commentRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		commentService = new CommentServiceImpl(commentRepository);
	}
	
	@Test
	public void should_store_when_save_is_called() {
		LOGGER.info("--------------- Executing should_store_when_save_is_called test Of CommentServiceImplTest ---------------");
		Comment myComment = new Comment();
		commentService.save(myComment);
		Mockito.verify(commentRepository).save(myComment);
	}
	
	@Test
	public void should_update_when_update_is_called() {
		LOGGER.info("--------------- Executing should_update_when_update_is_called test Of CommentServiceImplTest ---------------");
		Comment myComment = new Comment();
		commentService.update(myComment);
		Mockito.verify(commentRepository).save(myComment);
	}
	
	@Test
	public void should_delete_when_delete_is_called() {
		LOGGER.info("--------------- Executing should_delete_when_delete_is_called test Of CommentServiceImplTest ---------------");
		Comment myComment = new Comment();
		commentService.delete(myComment);
		Mockito.verify(commentRepository).delete(myComment);
	}
	
	@Test
	public void should_search_by_knowledge_when_findByKnowledge_is_called() {
		LOGGER.info("--------------- Executing should_search_by_knowledge_when_findByKnowledge_is_called test Of CommentServiceImplTest ---------------");
		Knowledge myKnowledge = new Knowledge(1, "myTitle", "myDescription", "myContext",null, "myLangage", "myEndType", null, new User(), new Date());
		commentService.findByKnowledge(myKnowledge);
		Mockito.verify(commentRepository).findByKnowledge(myKnowledge);
	}

}

package com.wemanity.KnowledgeManagement.test.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.ArrayList;
import java.util.Date;

import com.wemanity.KnowledgeManagement.dto.ProjectDto;
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

import com.wemanity.KnowledgeManagement.dto.CommentDto;
import com.wemanity.KnowledgeManagement.dto.KnowledgeDto;
import com.wemanity.KnowledgeManagement.dto.UserDto;
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
	
	@Test
	public void should_get_a_not_null_comment_when_comment_constructor_for_dto_is_called() {
		LOGGER.info("--------------- Executing should_get_a_not_null_comment_when_comment_constructor_for_dto_is_called test Of CommentServiceImplTest ---------------");
	KnowledgeDto knowledgeDto= new KnowledgeDto();
	knowledgeDto.setRelatedProject(new ProjectDto());
	knowledgeDto.getRelatedProject().setUserCreator(new UserDto());
	knowledgeDto.setUserCreator(new UserDto());
	knowledgeDto.setComments(new ArrayList());
		CommentDto commentDto = new CommentDto(1, "myTitle", "myContent", new UserDto(), knowledgeDto,new Date());
		Comment myComment = new Comment(commentDto) ;//= commentService.getCommentFromCommentDto(commentDto);
		assertNotNull(myComment);
		assertNotNull(myComment.getId());
		assertEquals(myComment.getId(),commentDto.getId());
		assertNotNull(myComment.getTitle());
		assertEquals(myComment.getTitle(),commentDto.getTitle());
		assertNotNull(myComment.getContent());
		assertEquals(myComment.getContent(),commentDto.getContent());
		assertNotNull(myComment.getLastModified());

	}

	@Test
	public void should_search_by_id_when_findById_is_called(){
		LOGGER.info("--------------- Executing should_search_by_id_when_findById_is_called test Of CommentServiceImplTest ---------------");
		commentService.findById(new Integer(1));
		Mockito.verify(commentRepository).findById(anyInt());

	}

}

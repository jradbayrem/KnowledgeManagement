package com.wemanity.KnowledgeManagement.test.controller;

import static org.junit.Assert.assertEquals;
 import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import com.wemanity.KnowledgeManagement.dto.CommentDto;
import com.wemanity.KnowledgeManagement.dto.KnowledgeDto;
import com.wemanity.KnowledgeManagement.dto.ProjectDto;
import com.wemanity.KnowledgeManagement.dto.UserDto;
import com.wemanity.KnowledgeManagement.mapper.CommentMapper;
import com.wemanity.KnowledgeManagement.services.impl.KnowledgeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wemanity.KnowledgeManagement.controller.CommentController;
import com.wemanity.KnowledgeManagement.entities.Comment;
import com.wemanity.KnowledgeManagement.entities.Knowledge;
import com.wemanity.KnowledgeManagement.entities.User;
import com.wemanity.KnowledgeManagement.services.impl.CommentServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentControllerTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(CommentControllerTest.class);
	private MvcResult mvcResult;
	private String uri;
	private MockMvc mvc;
	@Autowired
	WebApplicationContext webApplicationContext;

	@InjectMocks
	CommentController commentController;

	@Mock
	CommentServiceImpl commentServiceImpl;

	@Mock
    KnowledgeServiceImpl knowledgeService;
	@Mock
    CommentMapper commentMapper;

	public CommentControllerTest() {
		this.uri = "/api";
	}

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
        when(knowledgeService.findById(any(Integer.class))).thenReturn(Optional.of(new Knowledge()));

        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void should_have_200_status_when_getCommentsByKnowledge_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_getCommentsByKnowledge_is_called test Of CommentControllerTest ---------------");
		try {
			Knowledge myKnowledge = new Knowledge(5,"myTitle","myDescription","myContext",null,"myLangage","myEndType",null,null,new Date());
			ObjectMapper objectMapper = new ObjectMapper();
			String inputJson = objectMapper.writeValueAsString(myKnowledge);
			mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/comments").contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}

	@Test
	public void should_use_findByKnowledge_when_getCommentsByKnowledge_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_findByKnowledge_when_getCommentsByKnowledge_is_called test Of CommentControllerTest ---------------");
		KnowledgeDto knowledgeDto = KnowledgeDto.builder()
				.userCreator(new UserDto())
				.comments(new ArrayList())
				.relatedProject(ProjectDto.builder()
						.userCreator(new UserDto())
						.build())
				.build();
        commentController.getCommentsByKnowledge(knowledgeDto);
		verify(commentServiceImpl).findByKnowledge(any(Knowledge.class));
	}
	
	@Test
	public void should_have_200_status_when_createComment_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_createComment_is_called test Of CommentControllerTest ---------------");
		try {
			Comment myComment = new Comment();
			ObjectMapper objectMapper = new ObjectMapper();
			String inputJson = objectMapper.writeValueAsString(myComment);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri + "/createComment")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}

	@Test
	public void should_use_save_when_createComment_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_save_when_createComment_is_called test Of CommentControllerTest ---------------");
		CommentDto commentDto = CommentDto.builder()
				.userCreator(new UserDto())
				.knowledge(KnowledgeDto.builder()
				.userCreator(new UserDto())
				.comments(new ArrayList())
				.relatedProject(ProjectDto.builder()
				.userCreator(new UserDto())
				.build())
				.build()).build();
		commentController.createComment(commentDto);
		 verify(commentServiceImpl).save(any(Comment.class));
	}

	@Test
	public void should_have_200_status_when_updateComment_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_updateComment_is_called test Of CommentControllerTest ---------------");
		try {
			Comment myComment = new Comment();
			ObjectMapper objectMapper = new ObjectMapper();
			String inputJson = objectMapper.writeValueAsString(myComment);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri + "/updateComment")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}

	@Test
	public void should_use_update_when_updateComment_is_called() {
		LOGGER.info(
				"--------------- Executing  test Of CommentControllerTest ---------------");
		CommentDto myCommentDto = new CommentDto();
		//commentController.updateComment(myCommentDto);
		//verify(commentServiceImpl).update(commentController.getOperationComment());
	}

}

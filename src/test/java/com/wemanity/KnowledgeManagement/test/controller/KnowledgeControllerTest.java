package com.wemanity.KnowledgeManagement.test.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import com.wemanity.KnowledgeManagement.controller.KnowledgeController;
import com.wemanity.KnowledgeManagement.entities.Comment;
import com.wemanity.KnowledgeManagement.entities.Knowledge;
import com.wemanity.KnowledgeManagement.entities.Project;
import com.wemanity.KnowledgeManagement.services.impl.KnowledgeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KnowledgeControllerTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(KnowledgeControllerTest.class);
	private MvcResult mvcResult;
	private String uri;
	private MockMvc mvc;
	@Autowired
	WebApplicationContext webApplicationContext;
	@Mock
	KnowledgeServiceImpl knowledgeServiceImpl;
	KnowledgeController knowledgeController;

	public KnowledgeControllerTest() {
		this.uri = "/api";
	}

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		knowledgeController = new KnowledgeController(knowledgeServiceImpl);
	}

	@Test
	public void should_have_200_status_when_createKnowledge_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_createKnowledge_is_called test Of KnowledgeControllerTest ---------------");
		try {
			Knowledge myKnowledge = new Knowledge(1, "myTitle", "myDescription", "myContext", null, "myLangage",
					"endType", null, null, new Date());
			ObjectMapper objectMapper = new ObjectMapper();
			String inputJson = objectMapper.writeValueAsString(myKnowledge);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri + "/createKnowledge")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}

	@Test
	public void should_use_save_when_createKnowledge_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_save_when_createComment_is_called test Of KnowledgeControllerTest ---------------");
		Knowledge myKnowledge = new Knowledge();
		knowledgeController.createKnowledge(myKnowledge);
		verify(knowledgeServiceImpl).save(myKnowledge);
	}

	@Test
	public void should_have_200_status_when_updateKnowledge_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_updateKnowledge_is_called test Of KnowledgeControllerTest ---------------");
		try {
			Knowledge myKnowledge = new Knowledge(1, "myTitle", "myDescription", "myContext", null, "myLangage",
					"endType", null, null, new Date());
			ObjectMapper objectMapper = new ObjectMapper();
			String inputJson = objectMapper.writeValueAsString(myKnowledge);
			mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri + "/updateKnowledge")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}

	@Test
	public void should_use_update_when_updateKnowledge_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_update_when_updateKnowledge_is_called test Of KnowledgeControllerTest ---------------");
		Knowledge myKnowledge = new Knowledge();
		knowledgeController.updateKnowledge(myKnowledge);
		verify(knowledgeServiceImpl).update(myKnowledge);
	}

	@Test
	public void should_have_200_status_when_getAllKnowledge_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_getAllKnowledge_is_called test Of KnowledgeControllerTest ---------------");
		try {
			mvcResult = mvc
					.perform(MockMvcRequestBuilders.get(uri + "/knowledges").accept(MediaType.APPLICATION_JSON_VALUE))
					.andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}

	@Test
	public void should_use_findAll_when_getAllKnowledge_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_findAll_when_getAllKnowledge_is_called test Of KnowledgeControllerTest ---------------");
		knowledgeController.getAllKnowledges();
		verify(knowledgeServiceImpl).findAll();
	}

	@Test
	public void should_have_200_status_when_getKnowledgeById_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_getKnowledgeById_is_called test Of KnowledgeControllerTest ---------------");
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			String inputJson = objectMapper.writeValueAsString(1);
			mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/knowledgesById")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}

	@Test
	public void should_use_findAll_when_getKnowledgeById_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_findAll_when_getKnowledgeById_is_called test Of KnowledgeControllerTest ---------------");
		knowledgeController.getKnowledgesById(1);
		verify(knowledgeServiceImpl).findById(1);
	}

}

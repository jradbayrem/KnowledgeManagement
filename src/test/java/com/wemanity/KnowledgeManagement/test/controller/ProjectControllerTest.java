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
import com.wemanity.KnowledgeManagement.controller.ProjectController;
import com.wemanity.KnowledgeManagement.entities.Comment;
import com.wemanity.KnowledgeManagement.entities.Project;
import com.wemanity.KnowledgeManagement.services.impl.ProjectServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectControllerTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectControllerTest.class);
	private MvcResult mvcResult;
	private String uri;
	private MockMvc mvc;
	@Autowired
	WebApplicationContext webApplicationContext;
	@Mock
	ProjectServiceImpl projectServiceImpl;
	ProjectController projectController;

	public ProjectControllerTest() {
		this.uri = "/api";
	}

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		projectController = new ProjectController(projectServiceImpl);
	}
	
	@Test
	public void should_have_200_status_when_createProject_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_createProject_is_called test Of ProjectControllerTest ---------------");
		try {
			Project myProject = new Project(1,"myTitle","myBusinessField","myCustomer",null,new Date());
			ObjectMapper objectMapper = new ObjectMapper();
			String inputJson = objectMapper.writeValueAsString(myProject);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri + "/createProject")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}

	@Test
	public void should_use_save_when_createProject_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_save_when_createProject_is_called test Of ProjectControllerTest ---------------");
		Project myProject = new Project();
		projectController.createProject(myProject);
		verify(projectServiceImpl).save(myProject);
	}
}

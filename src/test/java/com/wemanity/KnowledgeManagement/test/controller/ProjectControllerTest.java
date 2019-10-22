package com.wemanity.KnowledgeManagement.test.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import java.util.Date;

import com.wemanity.KnowledgeManagement.dto.ProjectDto;
import com.wemanity.KnowledgeManagement.dto.UserDto;
import com.wemanity.KnowledgeManagement.mapper.ProjectMapper;
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
import com.wemanity.KnowledgeManagement.controller.ProjectController;
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
	private WebApplicationContext webApplicationContext;
	@InjectMocks
	private ProjectController projectController;
	@Mock
	private ProjectMapper projectMapper;
	@Mock
	private ProjectServiceImpl projectServiceImpl;

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
			ProjectDto projectDto = new ProjectDto();
			ObjectMapper objectMapper = new ObjectMapper();
			String inputJson = objectMapper.writeValueAsString(projectDto);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri + "/projects")
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
		doReturn(new ProjectDto()).when(projectMapper).projectToProjectDto(new Project());
		projectController.createProject(ProjectDto.builder().userCreator(new UserDto()).build());
		verify(projectServiceImpl).save(any(Project.class));
	}
	
	@Test
	public void should_have_200_status_when_updateProject_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_updateProject_is_called test Of ProjectControllerTest ---------------");
		try {
			ProjectDto projectDto = new ProjectDto();
			ObjectMapper objectMapper = new ObjectMapper();
			String inputJson = objectMapper.writeValueAsString(projectDto);
			mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri + "/projects")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}

	@Test
	public void should_use_update_when_updateProject_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_update_when_updateProject_is_called test Of ProjectControllerTest ---------------");
		ProjectDto projectDto = new ProjectDto();
		doReturn(new Project()).when(projectServiceImpl).generateProjectWithRefreshedDataFromProjectDto(projectDto);
		projectController.updateProject(projectDto);
		verify(projectServiceImpl).update(any(Project.class));
	}
	
	@Test
	public void should_have_200_status_when_getProjectById_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_getProjectById_is_called test Of ProjectControllerTest ---------------");
		try {
			mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/projects"+"/1")).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}

	@Test
	public void should_use_search_by_id_when_getProjectById_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_search_by_id_when_getProjectById_is_called test Of ProjectControllerTest ---------------");
		projectController.getProjectById(1);
		verify(projectServiceImpl).findById(anyInt());
	}
	
	@Test
	public void should_have_200_status_when_getAllProjects_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_getAllProjects_is_called test Of ProjectControllerTest ---------------");
		try {
			mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/projects")).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}

	@Test
	public void should_use_search_all_when_getAllProjects_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_search_all_when_getAllProjects_is_called test Of ProjectControllerTest ---------------");
		projectController.getAllProjects();
		verify(projectServiceImpl).findAll();
	}
}

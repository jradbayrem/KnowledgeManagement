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

import com.wemanity.KnowledgeManagement.controller.UserController;
import com.wemanity.KnowledgeManagement.entities.User;
import com.wemanity.KnowledgeManagement.services.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerTest.class);
	private MvcResult mvcResult;
	private String uri;
	private MockMvc mvc;
	@Autowired
	WebApplicationContext webApplicationContext;
	@Mock
	UserServiceImpl userServiceImpl;
	UserController userController;

	public UserControllerTest() {
		this.uri = "/api";
	}

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		userController = new UserController(userServiceImpl);
	}

	@Test
	public void should_have_200_status_when_getAllUsers_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_getAllUsers_is_called test Of UserServiceImplTest ---------------");
		try {
			mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri + "/users").accept(MediaType.APPLICATION_JSON_VALUE))
					.andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}

	@Test
	public void should_use_findAll_when_getAllUsers_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_findAll_when_getAllUsers_is_called test Of UserServiceImplTest ---------------");
		userController.getAllUsers();
		verify(userServiceImpl).findAll();
	}

	@Test
	public void should_have_200_status_when_updateUser_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_updateUser_is_called test Of UserServiceImplTest ---------------");
		try {
			mvcResult = mvc
					.perform(MockMvcRequestBuilders.get(uri + "/updateUser").accept(MediaType.APPLICATION_JSON_VALUE))
					.andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}

	@Test
	public void should_use_update_when_updateUser_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_update_when_updateUser_is_called test Of UserServiceImplTest ---------------");
		User myUser = new User(1, "myLogin", "myPassword", "myFirstName", "myLastName", "myDepartement", "myEmail",
				false, null, new Date());
		userController.updateUser(myUser);
		verify(userServiceImpl).update(myUser);
	}

}

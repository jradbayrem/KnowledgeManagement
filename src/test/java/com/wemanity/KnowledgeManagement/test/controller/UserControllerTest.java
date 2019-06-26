package com.wemanity.KnowledgeManagement.test.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;

import com.wemanity.KnowledgeManagement.dto.UserDto;
import com.wemanity.KnowledgeManagement.mapper.UserMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
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

	@InjectMocks
   private UserController userController;

    @Mock
	private UserServiceImpl userServiceImpl;
    @Mock
    private UserMapper userMapper;


	public UserControllerTest() {
		this.uri = "/api";
	}

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		when(userServiceImpl.generateUserWithRefreshedDataFromUserDto(any(UserDto.class))).thenReturn(new User());
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
			UserDto userDto = new UserDto();
			ObjectMapper objectMapper = new ObjectMapper();
			String inputJson = objectMapper.writeValueAsString(userDto);
			MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri + "/updateUser")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
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
		UserDto userDto = new UserDto();
		userController.updateUser(userDto);
		verify(userServiceImpl).update(any(User.class));
	}

	@Test
	public void should_have_200_status_when_createUser_is_called() {
		LOGGER.info(
				"--------------- Executing should_have_200_status_when_createUser_is_called test Of UserServiceImplTest ---------------");
		try {
			UserDto userDto = new UserDto();
			ObjectMapper objectMapper = new ObjectMapper();
			String inputJson = objectMapper.writeValueAsString(userDto);
			mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri + "/createUser")
					.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
			assertEquals(200, mvcResult.getResponse().getStatus());
		} catch (Exception e) {
			LOGGER.error("An exception occured");
			e.printStackTrace();
		}
	}

	@Test
	public void should_use_save_when_createUser_is_called() {
		LOGGER.info(
				"--------------- Executing should_use_save_when_createUser_is_called test Of UserServiceImplTest ---------------");
		UserDto userDto = new UserDto();
        doReturn(new UserDto()).when(userMapper).userToUserDto(any(User.class));

        userController.createUser(userDto);
		verify(userServiceImpl).save(any(User.class));
	}
}

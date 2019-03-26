package com.wemanity.KnowledgeManagement.test;

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

import com.wemanity.KnowledgeManagement.entities.User;
import com.wemanity.KnowledgeManagement.repositories.IUserRepository;
import com.wemanity.KnowledgeManagement.services.impl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
	
	private UserServiceImpl userService;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImplTest.class);

	@Mock
	private IUserRepository userRepository;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		userService = new UserServiceImpl(userRepository);
	}

	@Test
	public void should_store_when_save_is_called() {
		LOGGER.info("--------------- Executing should_store_when_save_is_called test Of UserServiceImplTest ---------------");
		User myUser = new User();
		userService.save(myUser);
		Mockito.verify(userRepository).save(myUser);
	}

}

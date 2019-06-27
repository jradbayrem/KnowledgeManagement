package com.wemanity.KnowledgeManagement.test.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.wemanity.KnowledgeManagement.exceptions.UserDtoIsNullException;
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

import com.wemanity.KnowledgeManagement.dto.UserDto;
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
        LOGGER.info("--------------- Executing should_store_when_save_is_called test Of UserServiceImplTest " +
                "---------------");
        User myUser = new User();
        userService.save(myUser);
        Mockito.verify(userRepository).save(myUser);
    }

    @Test
    public void should_update_when_update_is_called() {
        LOGGER.info("--------------- Executing should_update_when_update_is_called test Of UserServiceImplTest " +
                "---------------");
        User myUser = new User();
        userService.update(myUser);
        Mockito.verify(userRepository).save(myUser);
    }

    @Test
    public void should_delete_when_delete_is_called() {
        LOGGER.info("--------------- Executing should_delete_when_delete_is_called test Of UserServiceImplTest " +
                "---------------");
        User myUser = new User();
        userService.delete(myUser);
        Mockito.verify(userRepository).delete(myUser);
    }

    @Test
    public void should_search_by_id_when_findById_is_called() {
        LOGGER.info("--------------- Executing should_search_by_id_when_findById_is_called test Of " +
                "UserServiceImplTest ---------------");
        Integer id = 1;
        userService.findById(id);
        Mockito.verify(userRepository).findById(id);
    }

    @Test
    public void should_search_all_when_findAll_is_called() {
        LOGGER.info("--------------- Executing should_search_all_when_findAll_is_called test Of UserServiceImplTest " +
                "---------------");
        userService.findAll();
        Mockito.verify(userRepository).findAll();
    }

    @Test
    public void should_search_by_firstname_and_last_name_when_findByFirstNameAndLastName_is_called() {
        LOGGER.info("--------------- Executing " +
                "should_search_by_firstname_and_last_name_when_findByFirstNameAndLastName_is_called test Of " +
                "UserServiceImplTest ---------------");
        String firstName = "John";
        String lastName = "Doe";
        when(userRepository.findFirst1ByFirstNameAndLastName(any(String.class), any(String.class))).thenReturn(new
                User());
        userService.findByFirstNameAndLastName(firstName, lastName);
        Mockito.verify(userRepository).findFirst1ByFirstNameAndLastName(firstName, lastName);
    }

    @Test
    public void should_get_a_not_null_user_when_user_constructor_for_dto_is_called() {
        LOGGER.info("--------------- Executing should_get_a_not_null_user_when_user_constructor_for_dto_is_called " +
                "test Of UserServiceImplTest ---------------");
        UserDto userDto = new UserDto(1, "myLogin", "myPassword", "myFirstName", "myLastName", "myDepartement",
                "myEmail");
        User myUser = new User(userDto);
        assertNotNull(myUser);
        assertNotNull(myUser.getId());
        assertEquals(myUser.getId(), userDto.getId());
        assertNotNull(myUser.getLogin());
        assertEquals(myUser.getLogin(), userDto.getLogin());
        assertNotNull(myUser.getFirstName());
        assertEquals(myUser.getFirstName(), userDto.getFirstName());
        assertNotNull(myUser.getLastName());
        assertEquals(myUser.getLastName(), userDto.getLastName());
        assertNotNull(myUser.getPassword());
        assertEquals(myUser.getPassword(), userDto.getPassword());
        assertNotNull(myUser.getDepartement());
        assertEquals(myUser.getDepartement(), userDto.getDepartement());
        assertNotNull(myUser.getEmail());
        assertEquals(myUser.getEmail(), userDto.getEmail());
    }

    @Test(expected = UserDtoIsNullException.class)
    public void
    should_throw_UserDtoIsNullException_when_generateUserWithRefreshedDataFromUserDto_is_called_and_userDto_is_null() {
        LOGGER.info("--------------- Executing should_throw_UserDtoIsNullException_when_generateUserWithRefreshedDataFromUserDto_is_called_and_userDto_is_null test Of CommentServiceImplTest ---------------");

        UserDto userDto = null;
        userService.generateUserWithRefreshedDataFromUserDto(userDto);
    }
}

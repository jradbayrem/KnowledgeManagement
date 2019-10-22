package com.wemanity.KnowledgeManagement.mapper;

import com.wemanity.KnowledgeManagement.dto.UserDto;
import com.wemanity.KnowledgeManagement.entities.User;
import com.wemanity.KnowledgeManagement.exceptions.UserIsNullException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class UserMapper {

    public UserDto userToUserDto(User user) throws UserIsNullException{
        if(user == null){
            throw  new UserIsNullException("Cannot map the User to UserDto. The given User is Null");
        }
        return UserDto.builder()
                .departement(user.getDepartement())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .id(user.getId())
                .lastName(user.getLastName())
                .login(user.getLogin())
                .password(user.getPassword())
                .build();
    }

    public List<UserDto> userListToUserDtoList(List<User> users){

        ArrayList userDtos = new ArrayList();
        users.parallelStream().forEach(
                user -> userDtos.add(this.userToUserDto(user))
        );
        return userDtos;
    }
}

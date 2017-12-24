package com.wonder.wonder.dto.conerter.impl;

import com.wonder.wonder.dto.UserDto;
import com.wonder.wonder.dto.conerter.UserConverter;
import com.wonder.wonder.model.User;
import org.springframework.stereotype.Service;

/**
 * Creator: Pavlenko Bohdan
 * Date: 03.12.2017
 * Project: wonder
 */
@Service
public class UserConverterImpl implements UserConverter {
    @Override
    public UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getUsername());
        return userDto;
    }

    @Override
    public User convertToEntity(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setUserName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }
}

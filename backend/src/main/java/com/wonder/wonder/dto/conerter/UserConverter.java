package com.wonder.wonder.dto.conerter;

import com.wonder.wonder.dto.UserDto;
import com.wonder.wonder.model.User;

/**
 * Creator: Pavlenko Bohdan
 * Date: 03.12.2017
 * Project: wonder
 */
public interface UserConverter {
    UserDto convertToDto(User user);
    User convertToEntity(UserDto userDto);
}

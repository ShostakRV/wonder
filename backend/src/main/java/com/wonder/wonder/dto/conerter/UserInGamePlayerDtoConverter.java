package com.wonder.wonder.dto.conerter;

import com.wonder.wonder.dto.PlayerDto;
import com.wonder.wonder.dto.UserDto;
import com.wonder.wonder.model.User;
import com.wonder.wonder.model.UserInGame;

/**
 * Creator: Pavlenko Bohdan
 * Date: 03.12.2017
 * Project: wonder
 */
public interface UserInGamePlayerDtoConverter {

    PlayerDto convertToDto(UserInGame userInGame);

    UserInGame convertToEntity(PlayerDto playerDto);
}

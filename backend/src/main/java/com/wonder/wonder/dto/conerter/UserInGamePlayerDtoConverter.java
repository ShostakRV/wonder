package com.wonder.wonder.dto.conerter;

import com.wonder.wonder.dto.PlayerDto;
import com.wonder.wonder.dto.UserDto;
import com.wonder.wonder.model.User;
import com.wonder.wonder.model.UserInGame;
/**
 * Created b.missurenko
 * Date **.12.17.
 */
public interface UserInGamePlayerDtoConverter {

    PlayerDto convertToDto(UserInGame userInGame);

    UserInGame convertToEntity(PlayerDto playerDto);
}

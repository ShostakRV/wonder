package com.wonder.wonder.dto.conerter;

import com.wonder.wonder.dto.GameStatisticDto;
import com.wonder.wonder.dto.UserDto;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.User;
import com.wonder.wonder.model.UserInGame;

/**
 * Created b.missurenko
 * Date **.12.17.
 */
public interface GameStatisticByUserInGameDtoConverter {


    GameStatisticDto convertToDto(UserInGame userInGame);

}

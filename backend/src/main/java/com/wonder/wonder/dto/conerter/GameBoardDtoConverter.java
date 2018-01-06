package com.wonder.wonder.dto.conerter;

import com.wonder.wonder.dto.BoardDto;
import com.wonder.wonder.dto.UserDto;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.User;

/**
 * Created b.missurenko
 * Date **.12.17.
 */
public interface GameBoardDtoConverter {
    BoardDto convertToDto(Game game);
    Game convertToEntity(BoardDto boardDto);
}

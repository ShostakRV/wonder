package com.wonder.wonder.dto.conerter;

import com.wonder.wonder.dto.BoardDto;
import com.wonder.wonder.dto.UserDto;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.User;

/**
 * Creator: Pavlenko Bohdan
 * Date: 03.12.2017
 * Project: wonder
 */
public interface GameBoardDtoConverter {
    BoardDto convertToDto(Game game);
    Game convertToEntity(BoardDto boardDto);
}

package com.wonder.wonder.service;

import com.wonder.wonder.dto.BoardDto;
import com.wonder.wonder.dto.GameViewDto;
import com.wonder.wonder.model.Game;

import java.util.List;

/**
 * Created by bm
 * DAte 27.06.17.
 */
public interface GameService {


    void createGame(String gameName);

    List<GameViewDto> showGameInJoinPhaseInLobby();

    boolean joinToGame(long gameId);


    void startGame(long gameId);

    void countPoint(Game game);


}

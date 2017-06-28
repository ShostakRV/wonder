package com.wonder.wonder.service;

import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.User;

import java.util.List;

/**
 * Created by bm
 * DAte 27.06.17.
 */
public interface GameService {


    void createGame(String gameName);

    List<Game> showLobby();

    void save(Game game);

    boolean joinToGame(long playerId,String playerName); // or User user

    void startGame();




}

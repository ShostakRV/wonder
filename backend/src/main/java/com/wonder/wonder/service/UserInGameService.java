package com.wonder.wonder.service;

import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.UserInGame;

import java.util.List;

/**
  Created by bm on 12.07.17.
 */
public interface UserInGameService {

    UserInGame getUserInGameByGameId(long gameId);

    UserInGame getUserInGameById(long userInGameId);

    List<UserInGame> getAllUserInGameByGameId(long gameId);


     void save(UserInGame userInGame);









}

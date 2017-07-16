package com.wonder.wonder.service;

import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.UserInGame;

import java.util.List;

/**
 * Created by bm on 12.07.17.
 */
public interface UserInGameService {

    List<UserInGame> getAllUserInGameByGameId(long gameId);

    UserInGame getUserInGameByGameIDAndUserId(long gameId, long userId);

    void save(UserInGame userInGame);








}

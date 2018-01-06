package com.wonder.wonder.service.impl;

import com.wonder.wonder.dao.UserInGameDao;
import com.wonder.wonder.model.UserInGame;
import com.wonder.wonder.service.UserInGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
  Created by bm on 12.07.17.
 */
@Component
public class UserInGameServiceImpl implements UserInGameService {

    private UserInGameDao userInGameDao;

    @Autowired
    public UserInGameServiceImpl(UserInGameDao userInGameDao) {
        this.userInGameDao = userInGameDao;
    }


    @Override
    public UserInGame getUserInGameByGameId(long gameId) {
        return userInGameDao.findByGameId(gameId);

    }

    @Override
    public UserInGame getUserInGameById(long userInGameId) {
        return userInGameDao.findById(userInGameId);
    }

    @Override
    public List<UserInGame> getAllUserInGameByGameId(long gameId) {
        return userInGameDao.findAllByGameId(gameId);
    }


    @Override
    public void save(UserInGame userInGame) {
        userInGameDao.save(userInGame);
    }

    @Override
    public List<UserInGame> getGameResult(Long gameId) {
        return null;
    }

    @Override
    public UserInGame getUserInGameByIdAndGameId(Long userInGameId, Long gameId) {
        return userInGameDao.findByIdAndGameId(userInGameId,gameId);
    }

    //        playerDto.setGold(); // TODO METOD COUNT GOLD BY EVENT
//        playerDto.getCardsOnHand(); TODO METOD Передачі кард між гравцями

}

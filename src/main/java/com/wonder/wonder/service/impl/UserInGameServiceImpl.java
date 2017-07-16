package com.wonder.wonder.service.impl;

import com.wonder.wonder.dao.UserInGameDao;
import com.wonder.wonder.model.UserInGame;
import com.wonder.wonder.service.UserInGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bm on 12.07.17.
 */
@Component
public class UserInGameServiceImpl implements UserInGameService {

    private UserInGameDao userInGameDao;

    @Autowired
    public UserInGameServiceImpl(UserInGameDao userInGameDao) {
        this.userInGameDao = userInGameDao;
    }


    @Override
    public List<UserInGame> getAllUserInGameByGameId(long gameId) {
        return new ArrayList<UserInGame>(userInGameDao.findAllByGameId(gameId));
    }

    @Override
    public UserInGame getUserInGameByGameIDAndUserId(long gameId, long userId) {
        return userInGameDao.findByGameIdAndUserInGameId(gameId, userId);
    }

    @Override
    public void save(UserInGame userInGame) {
        userInGameDao.save(userInGame);
    }


}
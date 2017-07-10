package com.wonder.wonder.service.impl;

import com.wonder.wonder.dao.GameDao;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.service.GameService;
import org.springframework.stereotype.Component;
import sun.misc.Contended;

import java.util.List;

/**
 * Created by bm
 * DAte 27.06.17.
 */

/**
 * Manage only any game
 */
@Component
public class GameServiceImpl implements GameService {

    private GameDao gameDao;

    public GameServiceImpl(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    @Override
    public void createGame(Long userId, Integer players) {

    }

    @Override
    public List<Game> showLobby() {
        return null;
    }// maybe rest controller

    @Override
    public boolean joinToGame(Long playerId) {
        return false;
    }

    @Override
    public void userStartGameFullGame(Long gameId) {

    }
}

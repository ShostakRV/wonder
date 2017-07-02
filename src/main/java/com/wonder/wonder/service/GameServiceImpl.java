package com.wonder.wonder.service;

import com.wonder.wonder.dao.GameDao;
import com.wonder.wonder.model.Game;
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
    public void createGame(String gameName) {

    }

    @Override
    public List<Game> showLobby() {
        return null;
    }

    @Override
    public void save(Game game) {

    }

    @Override
    public boolean joinToGame(long playerId, String playerName) {
        return false;
    }

    @Override
    public void startGame() {

    }
}

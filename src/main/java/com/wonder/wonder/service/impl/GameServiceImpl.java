package com.wonder.wonder.service.impl;

import com.wonder.wonder.dao.GameDao;
import com.wonder.wonder.dao.UserDao;
import com.wonder.wonder.dao.UserInGameDao;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.User;
import com.wonder.wonder.model.UserInGame;
import com.wonder.wonder.service.GameService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.Contended;

import java.util.ArrayList;
import java.util.Arrays;
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

    private UserDao userDao;

    private UserInGameDao userInGameDao;

    public GameServiceImpl(GameDao gameDao, UserDao userDao, UserInGameDao userInGameDao) {
        this.gameDao = gameDao;
        this.userDao = userDao;
        this.userInGameDao = userInGameDao;
    }

    @Override
    @Transactional
    public void save(Game game) {
        gameDao.save(game);
        userInGameDao.save(game.getUserInGames());
    }

    @Override
    public void createGame(Long userId, Integer players) {
        if (userDao.findById(userId) == null) {
            throw new RuntimeException("No exist User with this id!!!");
        }
        Game game = new Game();
        UserInGame userInGame = new UserInGame();
        User user = new User();
        user.setId(userId);
        userInGame.setUser(user);
        game.setUserInGames(Arrays.asList(userInGame));
        game.setPlayers(players);
        game.setPhase("KIT");
        gameDao.save(game);
    }

    @Override
    public List<Game> showLobby() {
        List<Game> gameList = new ArrayList<>();
        gameList.addAll(gameDao.findAllByPhase("KIT"));
        return gameList;
    }// maybe rest controller

    @Override
    public boolean joinToGame(Long gameId, Long playerId) {
        if (gameDao.findById(gameId) == null) {
            throw new RuntimeException("No exist Game with this id!!!");
        }
        Game game = gameDao.findById(gameId);
        if (game.getPlayers() == 4) {
            throw new RuntimeException("Game was full!!!");
        }
        UserInGame userInGame = new UserInGame();
        User user = new User();
        user.setId(playerId);
        userInGame.setUser(user);

        List<UserInGame> userInGameList = game.getUserInGames();
        game.setUserInGames(Arrays.asList(userInGame));
        game.setPhase("KIT");
        gameDao.save(game);
        return true;
    }

    @Override
    public void userStartGameFullGame(Long gameId) {

    }
}

package com.wonder.wonder.service.impl;

import com.wonder.wonder.businessLogic.GamePhase;
import com.wonder.wonder.dao.GameDao;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.User;
import com.wonder.wonder.model.UserInGame;
import com.wonder.wonder.service.GameService;
import com.wonder.wonder.service.UserInGameService;
import com.wonder.wonder.service.UserService;
import com.wonder.wonder.util.AuthenticationWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    private final GameDao gameDao;

    private final UserService userService;

    private final UserInGameService userInGameService;

    private final AuthenticationWrapper authenticationWrapper;

    @Autowired
    public GameServiceImpl(GameDao gameDao, UserService userService, UserInGameService userInGameService, AuthenticationWrapper authenticationWrapper) {
        this.gameDao = gameDao;
        this.userService = userService;
        this.userInGameService = userInGameService;
        this.authenticationWrapper = authenticationWrapper;
    }

    @Override
    public void passCardToAnotherUserInGame(Game game) {

    }

    @Override
    public void war(Game game) {

    }

    @Override
    public void exchangeCardSetBetweenPlayers(Game game) {

    }

    @Override
    public void countPoint(Game game) {

    }

    @Override
    public Long createGame() {
        User user = authenticationWrapper.getCurrentUser();

        if (userService.getUserById(user.getId()) == null) {
            throw new RuntimeException("No exist User with this id!!!");
        }
        Game game = new Game();
        game.setPhase(GamePhase.JOIN_PHASE);
        gameDao.save(game);
        joinToGame(game.getId());
        return game.getId();
    }

    @Override
    public List<Game> showLobby() {
        return gameDao.findAllByPhase(GamePhase.JOIN_PHASE);
    }


    @Override
    public boolean joinToGame(Long gameId) {
        User user = authenticationWrapper.getCurrentUser();
        Game game = gameDao.findById(gameId);

        if (game == null) {
            throw new RuntimeException("No exist Game with this id!!!");
        }

        if (userInGameService.getAllUserInGameByGameId(gameId).size() >= 14) {
            throw new RuntimeException("Game was full!!!");
        }
        if (userService.getUserById(user.getId()) == null) {
            throw new RuntimeException("No exist User with this id!!!");
        }
        // if user in game and try to join  game again
        UserInGame userInGame = new UserInGame();
        userInGame.setUser(user);
        userInGame.setGame(game);
        userInGameService.save(userInGame);
        return true;
    }

    @Override
    public void userStartGameFullGame(Long gameId) {
        Game game = gameDao.findById(gameId);
        // To do check if user has right to start game (get user from spring security context )
        if (game.getUserInGames().size() >= 3) {
            game.setPhase(GamePhase.STROKE_AGE_1_1_START);
            gameDao.save(game);
        } else {
            throw new RuntimeException("Need more users for start!!!");
        }

    }
}

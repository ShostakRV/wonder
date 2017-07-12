package com.wonder.wonder.service.impl;

import com.wonder.wonder.dao.GameDao;
import com.wonder.wonder.dao.UserDao;
import com.wonder.wonder.dao.UserInGameDao;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.User;
import com.wonder.wonder.model.UserInGame;
import com.wonder.wonder.service.GameService;
import com.wonder.wonder.service.UserInGameService;
import com.wonder.wonder.service.UserService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    private UserService userService;

    private UserInGameService userInGameService;

    public GameServiceImpl(GameDao gameDao, UserService userService, UserInGameService userInGameService) {
        this.gameDao = gameDao;
        this.userService = userService;
        this.userInGameService = userInGameService;
    }

    @Override
    @Transactional
    public void save(Game game) {
        gameDao.save(game);
    }

    @Override
    public void createGame(Long userId, Integer players) {
//
//        if (userDao.findById(userId) == null) {
//            throw new RuntimeException("No exist User with this id!!!");
//        }
        Game game = new Game();

        game.setPhase("KIT");

        UserInGame userInGame = new UserInGame();
        User user = new User();
        user.setId(userId);
        userInGame.setUser(user);

        game.getUserInGames().add(userInGame);
        this.save(game);
    }

    @Override
    public List<Game> showLobby() {
        return gameDao.findAllByPhase("KIT");
    }// maybe rest controller

    @Override
    public boolean joinToGame(Long gameId, Authentication Authentication) {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) a.getPrincipal();                                // nullExeption or class
        Game game = gameDao.findById(gameId);
//todo  get user from spring security context
        if (game == null) {
            throw new RuntimeException("No exist Game with this id!!!");
        }
        if (game.getUserInGames().size() == 10) {
            throw new RuntimeException("Game was full!!!");
        }
        if (userService.getUseById(currentUser.getId()) == null) {
            throw new RuntimeException("No exist User with this id!!!");
        }
        UserInGame userInGame = new UserInGame();
        userInGame.setUser(currentUser);
        userInGameService.save(userInGame);
        return true;
    }

    @Override
    public void userStartGameFullGame(Long gameId) {
        Game game = gameDao.findById(gameId);
        // To do check if user has right to start game (get user from spring security context )
        if (game.getUserInGames().size() >= 3) {
            game.setPhase("IN_PROGRESS");
            gameDao.save(game);
        } else {
            throw new RuntimeException("Need more users for start!!!");
        }

    }
}

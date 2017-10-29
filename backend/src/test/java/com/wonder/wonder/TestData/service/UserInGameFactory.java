package com.wonder.wonder.TestData.service;

import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.User;
import com.wonder.wonder.model.UserInGame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bm on 10.08.17.
 */
public class UserInGameFactory {


    // called user in game
    public static List<UserInGame> listUserInGameInit(Integer usersInGame, Long gameId) {
        Game game = new Game();
        game.setId(gameId);
        List<UserInGame> userInGames = new ArrayList<>();
        if (usersInGame >= 1) {
            userInGames.add(userInGameInit(1L, 1L, game));
            if (usersInGame >= 2) {
                userInGames.add(userInGameInit(2L, 2L, game));
                if (usersInGame >= 3) {
                    userInGames.add(userInGameInit(3L, 3L, game));
                    if (usersInGame >= 4) {
                        userInGames.add(userInGameInit(4L, 4L, game));
                        if (usersInGame >= 5) {
                            userInGames.add(userInGameInit(5L, 5L, game));
                        }
                    }
                }
            }
        }
        return userInGames;
    }


    // here need game no usr id
    public static UserInGame userInGameInit(long userId, Long userInGameId, Game game) {
        User user = new User();
        user.setId(userId);
        UserInGame userInGame = new UserInGame();
        userInGame.setUser(user);
        userInGame.setId(userInGameId);
        userInGame.setGame(game);

        return userInGame;
    }
}

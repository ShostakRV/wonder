package com.wonder.wonder.service;

import com.wonder.wonder.model.Event;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.User;
import com.wonder.wonder.model.UserInGame;
import org.springframework.security.core.Authentication;

import java.util.List;

/**
 * Created by bm
 * DAte 27.06.17.
 */
public interface GameService {


    void createGame(Long userId, Integer players);

    List<Game> showLobby();

    boolean joinToGame(Long gameId);

    void userStartGameFullGame(Long gameId);

//    void startGame(UserInGame userInGame);  // in game + list enum vonder
//
//    // create cardSet
//    void giveCardSetPlayers(UserInGame userInGame, String type, Integer age); // or game

    void save(Game game);

    // thin
    void passCardTOAnotherUserInGame(Game game);

    void war(Game game);

    void exchangeCardSetBetweenPlayers(Game game);

    void countPoint(Game game);


}

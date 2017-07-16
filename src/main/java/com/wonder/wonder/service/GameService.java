package com.wonder.wonder.service;

import com.wonder.wonder.model.Game;

import java.util.List;

/**
 * Created by bm
 * DAte 27.06.17.
 */
public interface GameService {


    Long createGame();

    List<Game> showLobby();

    boolean joinToGame(Long gameId);

    void userStartGameFullGame(Long gameId);

//    void startGame(UserInGame userInGame);  // in game + list enum vonder
//
//    // create cardSet
//    void giveCardSetPlayers(UserInGame userInGame, String type, Integer age); // or game


    //todo add annotation
    void passCardToAnotherUserInGame(Game game);

    void war(Game game);

    //todo add annotation
    void exchangeCardSetBetweenPlayers(Game game);

    void countPoint(Game game);


}

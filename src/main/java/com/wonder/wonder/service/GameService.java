package com.wonder.wonder.service;

import com.wonder.wonder.dto.GameViewDto;
import com.wonder.wonder.model.Game;

import java.util.List;

/**
 * Created by bm
 * DAte 27.06.17.
 */
public interface GameService {


    long createGame();

    List<GameViewDto> getGameViewDtoForJoinPhase();

    boolean joinToGame(Long gameId);

    void startGame(long gameId);

//    void startGame(UserInGame userInGame);  // in game + list enum vonder
//
//    // create cardSet
//    void giveCardSetPlayers(UserInGame userInGame, String type, Integer age); // or game


//
//    void passCardToAnotherUserInGame(Game game);
//
//    void war(Game game);

//    //todo add annotation
//    void exchangeCardSetBetweenPlayers(Game game);

    void countPoint(Game game);


}

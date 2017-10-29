package com.wonder.wonder.TestData.service;

import com.wonder.wonder.model.Game;
import com.wonder.wonder.phase.GamePhase;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by bm on 10.08.17.
 */
public class GameFactory {

    public static Game gameInit(Long gameId, Integer playersInGame, GamePhase gamePhase) {
        Game game = new Game();
        game.setName(gameId.hashCode() + "");
        game.setId(gameId);
        game.setPhaseGame(gamePhase);
        game.setUserInGames(UserInGameFactory.listUserInGameInit(playersInGame, gameId));
        return game;
    }


    public static List<Game> gameInitListPhaseJoin_Phase() {
        List<Game> gameList = new ArrayList<>();
        gameList.add(gameInit(1L, 1, GamePhase.JOIN_PHASE));
        gameList.add(gameInit(2L, 2, GamePhase.JOIN_PHASE));
        gameList.add(gameInit(3L, 3, GamePhase.JOIN_PHASE));
        gameList.add(gameInit(4L, 4, GamePhase.JOIN_PHASE));
        gameList.add(gameInit(5L, 5, GamePhase.JOIN_PHASE));
        return gameList;
    }
}

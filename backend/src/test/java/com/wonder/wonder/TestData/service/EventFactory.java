package com.wonder.wonder.TestData.service;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.model.*;
import com.wonder.wonder.phase.UserActionOnCard;
import com.wonder.wonder.phase.GamePhase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bm on 10.08.17.
 */
public class EventFactory {

    public static Event eventInit(UserInGame userInGame, Game game,
                                  GamePhase gamePhase, Integer round, Integer subPhaseRound,
                                  GameCard playCard, UserActionOnCard userActionOnCard, GameCard chainCard,
                                  Integer goldChange) {

        Event event = new Event();
        event.setGame(game);
        event.setUserInGame(userInGame);
        event.setGamePhase(gamePhase);
        event.setPhaseRound(round);
        event.setSubPhaseRound(subPhaseRound);
        event.setCard(playCard);
        event.setUserActionOnCard(userActionOnCard);
        event.setChainCard(chainCard);
        event.setGoldChange(goldChange);
        return event;
    }

    public static List<Event> eventListForOneUser(Integer age, Integer round) {
        List<Event> allEvent = new ArrayList<>();
        if (age == 1) {
            if (round == 1) {
                return allEvent;
            }
        }
        return allEvent;
    }


}

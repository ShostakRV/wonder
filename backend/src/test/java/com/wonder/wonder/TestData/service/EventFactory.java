package com.wonder.wonder.TestData.service;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.cards.MainCard;
import com.wonder.wonder.model.*;
import com.wonder.wonder.phase.EventPhaseUserChoose;
import com.wonder.wonder.phase.GamePhase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bm on 10.08.17.
 */
public class EventFactory {

    public static Event eventInit(UserInGame userInGame, Game game,
                                  GamePhase gamePhase, Integer round, Integer ohase_choose_do,
                                  GameCard playCard, EventPhaseUserChoose eventPhaseUserChoose, MainCard chainCard,
                                  Integer goldChange) {

        Event event = new Event();
        event.setGame(game);
        event.setUserInGame(userInGame);
        event.setGamePhase(gamePhase);
        event.setPhaseRound(round);
        event.setPhaseChooseDo(ohase_choose_do);
        event.setCard((MainCard) playCard);
        event.setEventPhaseUserChoose(eventPhaseUserChoose);
        event.setChainCard(chainCard);
        event.setGoldChange(goldChange);
        return event;
    }

    public static List<Event> eventListInitThreeUser(Integer age, Integer round, Integer usersCount) {
        List<Event> allEvent = new ArrayList<>();

        return allEvent;
    }

}

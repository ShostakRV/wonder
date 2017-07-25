package com.wonder.wonder.service.impl;

import com.wonder.wonder.dto.EventDto;
import com.wonder.wonder.model.Event;
import com.wonder.wonder.service.EventService;
import com.wonder.wonder.service.GameService;
import com.wonder.wonder.service.WonderGameService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by bm on 16.07.17.
 */
//@Scope(value = "request")
@Component
public class WonderGameServiceImpl implements WonderGameService {
    private GameService gameService;

    private EventService eventService;
//    private List<Event> eventList;

    //    void exchangeCardSetBetweenPlayers(Game game);
//    void passCardToAnotherUserInGame(Game game);

    //    void war(Game game);


    // can be build card(resource) vs resource another player
    // no have dublicate
    // sale card
    // cpetioal ability end round
    // befor war spetial ability wonder
    // end age war
    // end count point

    @Override
    public void playCard(EventDto eventDto) {

        Event e = new Event();
        eventService.save(e);
        // if all players played card
        // then
//        doFinishStroke();
    }

}

package com.wonder.wonder.service.impl;

import com.wonder.wonder.model.Event;
import com.wonder.wonder.service.EventService;
import com.wonder.wonder.service.GameService;
import com.wonder.wonder.service.WonderGameService;

/**
 * Created by bm on 16.07.17.
 */
public class WonderGameServiceImpl implements WonderGameService {
    private GameService gameService;

    private EventService eventService;


    @Override
    public void playCard(Object event) {
        Event e = new Event();
        eventService.save(e);
        // if all players played card
        // then
//        doFinishStroke();
    }
}

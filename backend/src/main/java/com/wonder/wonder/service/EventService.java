package com.wonder.wonder.service;

import com.wonder.wonder.model.Event;

import javax.smartcardio.Card;
import java.util.List;

/**
 * Created by bm on 13.07.17.
 */
public interface EventService {

        List<Event> getAllEventByGameId(long gameId);

    void save(Event event);
}

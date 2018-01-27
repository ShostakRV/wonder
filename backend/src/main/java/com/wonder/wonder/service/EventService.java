package com.wonder.wonder.service;

import com.wonder.wonder.model.Event;
import com.wonder.wonder.phase.GamePhase;

import java.util.List;

/**
 * Created by bm on 13.07.17.
 */
public interface EventService {

    List<Event> getAllEventByGameId(long gameId);

    void save(Event event);

    List<Event> getAllLastEvent(long gameId, GamePhase gamePhase, Integer phaseRound, Integer phaseChooseDo);
}

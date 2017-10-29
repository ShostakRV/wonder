package com.wonder.wonder.service.impl;

import com.wonder.wonder.dao.EventDao;
import com.wonder.wonder.model.Event;
import com.wonder.wonder.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by bm on 02.08.17.
 */
@Component
public class EventServiceImpl implements EventService {

    private EventDao eventDao;

    @Autowired
    public EventServiceImpl(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @Override
    public List<Event> getAllEventByGameId(long gameId) {
        return eventDao.findByGameId(gameId);
    }

    @Override
    public void save(Event event) {
        eventDao.save(event);
    }
}

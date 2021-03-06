package com.wonder.wonder.dto.conerter.impl;

import com.wonder.wonder.dto.EventDto;
import com.wonder.wonder.dto.conerter.EventConverter;
import com.wonder.wonder.model.Event;
/**
 * Created b.missurenko
 * Date **.12.17.
 */
public class EventConverterImpl implements EventConverter {
    @Override
    public EventDto convertToDto(Event event) {
        EventDto eventDto = new EventDto();
//        eventDto.setUserActionOnCard(event.getUserActionOnCard());
//        eventDto.setChainCard(event.getChainCard());
//        eventDto.setPlayOnCardForEvent(event.getCard());
        eventDto.setUserInGameId(event.getUserInGame().getId());
        return eventDto;
    }

    @Override
    public Event convertToEntity(EventDto eventDto) {
        Event event = new Event();
        event.setCard(eventDto.getPlayOnCardForEvent());
        event.setChainCard(eventDto.getChainCard());
//        event.setUserInGame(); // TODO METOD FIND BY ID ?
//        event.set TODO METOD FOR CHECK RESOURSE ?
        return null;
    }
}

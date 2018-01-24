package com.wonder.wonder.service.util;

import com.wonder.wonder.model.Event;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReceiverForEventByWonderGameServer {

    private List<Event> eventList = new ArrayList<>();

    @JmsListener(destination = "eventToSave", containerFactory = "myFactory")
    public void receiveMessage(Event event) {
        eventList.add(event);
        if (eventList.size() == 7) {
            for (Event e : eventList) {

            }
        }
    }

    protected Event createNewEvent(Event event) {
        Event newEvent = new Event();
        newEvent.setGame(event.getGame());
        newEvent.setUserInGame(event.getUserInGame());
        newEvent.setGamePhase(event.getGamePhase());
        newEvent.setPhaseRound(event.getPhaseRound());
        newEvent.setPhaseChooseDo(event.getPhaseChooseDo());

        return newEvent;
    }
}


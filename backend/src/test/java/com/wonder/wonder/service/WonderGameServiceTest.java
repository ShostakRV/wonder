package com.wonder.wonder.service;

import com.wonder.wonder.model.Event;
import com.wonder.wonder.service.impl.WonderGameServiceImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


/**
 * Created by bm on 25.07.17.
 */
@ExtendWith(SpringExtension.class)
public class WonderGameServiceTest {
    private static final long GAME_ID = 1L;
    private static final long USER_ID = 1L;
    @Spy
    @InjectMocks
    WonderGameServiceImpl wonderGameService;

    @Mock
    GameService gameService;

    @Mock
    EventService eventService;

    @Test
    @Disabled
    public void userWantBuildMoreThenMaxLevelWonder() {

    }

    @Test
    @Disabled
    public void userWantBuildDublicate() {

        when(eventService.getAllEventByGameId(GAME_ID)).thenReturn(allEventInGame());
    }

    public List<Event> allEventInGame() {
        List<Event> events = new ArrayList<>();

        return events;
    }

    public List<Event> allEventUser(int position) {
        List<Event> events = new ArrayList<>();

        return events;
    }


    @Test
    public void userSellCard() {

    }

    @Test
    @Disabled
    public void userNoHaveResourceForBuild() {
        Boolean b = new Boolean("TruE");
        assertEquals(b, false);
    }

    @Test
    public void userBuildCard() {


    }

    @Test
    public void userBuildWonder() {

    }


}

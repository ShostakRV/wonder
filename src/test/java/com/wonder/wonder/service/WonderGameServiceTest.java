package com.wonder.wonder.service;

import com.wonder.wonder.model.Event;
import com.wonder.wonder.service.impl.WonderGameServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


/**
 * Created by bm on 25.07.17.
 */
@RunWith(MockitoJUnitRunner.class)
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

    @Test(expected = RuntimeException.class)
    public void userWantBuildMoreThenMaxLevelWonder() {

    }

    @Test(expected = RuntimeException.class)
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
    public void userNoHaveResourceForBuild() {

    }

    @Test
    public void userBuildCard() {

    }

    @Test
    public void userBuildWonder() {

    }


}

package com.wonder.wonder.service;

import com.wonder.wonder.service.impl.WonderGameServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by bm on 25.07.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class WonderGameServiceTest {

    @Spy
    @InjectMocks
    WonderGameServiceImpl wonderGameService;

    @Mock
    GameService gameService;

    @Mock
    EventService eventService;

@Test
public void userSellCard(){

}


}

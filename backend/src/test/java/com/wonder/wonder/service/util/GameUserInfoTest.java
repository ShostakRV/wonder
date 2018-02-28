package com.wonder.wonder.service.util;

import com.wonder.wonder.TestData.service.UserInGameFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GameUserInfoTest {

    private GameUserInfo gameUserInfo;

    @Before
    public void setUp() {
        gameUserInfo = new GameUserInfo(UserInGameFactory.userInGameInitPhaseAge_1_ZERO());
    }

    @Test
    public void createGameUserInfo() {

    }

}

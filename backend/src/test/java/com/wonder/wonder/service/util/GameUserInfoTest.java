package com.wonder.wonder.service.util;

import com.wonder.wonder.TestData.service.UserInGameFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class GameUserInfoTest {

    private GameUserInfo gameUserInfo;

    @BeforeAll
    public void setUp() {
        gameUserInfo = new GameUserInfo(UserInGameFactory.userInGameInitPhaseAge_1_ZERO());
    }

    @Test
    public void createGameUserInfo() {

    }

}

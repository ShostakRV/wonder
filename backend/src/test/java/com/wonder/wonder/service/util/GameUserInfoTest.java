package com.wonder.wonder.service.util;

import com.wonder.wonder.TestData.service.GameFactory;
import com.wonder.wonder.TestData.service.GameUserInfoFactory;
import com.wonder.wonder.TestData.service.UserInGameFactory;
import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.phase.GamePhase;
import com.wonder.wonder.phase.UserActionOnCard;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GameUserInfoTest {


    @Mock
    private GameUserInfo gameUserInfo;

    @Before
    public void setUp() {
        gameUserInfo = new GameUserInfo(UserInGameFactory
                .userInGameInit(0, 101L, GameFactory.gameInit(1001L, 3, GamePhase.AGE_1)));
    }

    @Test
    public void userChooseActionOnCardBuild() {
        boolean result = gameUserInfo.build(UserActionOnCard.BUILD);
        assertEquals(result, true);

    }
    @Test
    public void userChooseActionOnCardBuildWonder() {
        boolean result = gameUserInfo.buildWonder(UserActionOnCard.BUILD_WONDER);
        assertEquals(result, true);

    }
    @Test
    public void userChooseActionOnCardBuildZeus() {
        boolean result = gameUserInfo.buildZeus(UserActionOnCard.BUILD_ZEUS);
        assertEquals(result, true);

    }
    @Test
    public void userChooseActionOnCardBuildByChain() {
        boolean result = gameUserInfo.buildChain(GameCard.EAST_TRADING_POST);
        assertEquals(result, true);

    }
    @Test
    public void userChooseActionOnCard() {
        boolean result = gameUserInfo.build(UserActionOnCard.BUILD);
        assertEquals(result, true);

    }
    @Test
    public void  addWonderBaseResourse() {
        boolean result = gameUserInfo.addWonderBaseResourse(new GameUserInfo(UserInGameFactory
                .userInGameInitPhaseAge_1()));
        assertEquals(result, true);

    }

}

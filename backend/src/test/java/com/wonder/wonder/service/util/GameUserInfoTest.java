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

//    @Test
//    public void userChooseActionOnCardBuildTest() {
//        boolean result = gameUserInfo.build(UserActionOnCard.BUILD);
//        assertEquals(result, true);
//
//    }
//
//    @Test
//    public void userChooseActionOnCardBuildWonderTest() {
//        boolean result = gameUserInfo.buildWonder(UserActionOnCard.BUILD_WONDER);
//        assertEquals(result, true);
//
//    }
//
//    @Test
//    public void userChooseActionOnCardBuildZeusTest() {
//        boolean result = gameUserInfo.buildZeus(UserActionOnCard.BUILD_ZEUS);
//        assertEquals(result, true);
//
//    }
//
//    @Test
//    public void userChooseActionOnCardBuildByChainTest() {
//        boolean result = gameUserInfo.buildChain(GameCard.EAST_TRADING_POST);
//        assertEquals(result, true);
//
//    }
//
//    @Test
//    public void cardGiveResourseTest() {
//        boolean resultNoGive = gameUserInfo.cardGiveResources(GameResource.NO_RESOURCE);
//        assertEquals(resultNoGive, false);
//
//        boolean give = gameUserInfo.cardGiveResources(GameResource.DOUBLE_CLAY);
//        assertEquals(give, true);
//    }
//
//    @Test
//    public void eventCardContainZeusAbilityTest() {
//        boolean result = gameUserInfo.isZeusDiscauntEnabledCard(GameCard.STATUE_SECOND_B);
//        assertEquals(result, true);
//    }
//
//    @Test
//    public void eventCardContainCanBuildLastCardTest() {
//        boolean result = gameUserInfo.isHaveLastCardCanBuildPassiveCard(GameCard.GARDENS_SECOND_B);
//        assertEquals(result, true);
//    }
//
//    @Test
//    public void eventCardContainHaveLeftTradeBrownTest() {
//        boolean result = gameUserInfo.isHaveLeftTradeBrownCard(GameCard.WEST_TRADING_POST);
//        assertEquals(result, true);
//    }
//
//    @Test
//    public void eventCardContainHaveRigrhTradeBrownTest() {
//        boolean result = gameUserInfo.isHaveRigrhTradeBrownCard(GameCard.EAST_TRADING_POST);
//        assertEquals(result, true);
//    }
//
//    @Test
//    public void eventCardContainHaveRigrhAndLeftTradeSilverTest() {
//        boolean result = gameUserInfo.isHaveRigrhAndLeftTradeSilverCard(GameCard.MARKETPLACE);
//        assertEquals(result, true);
//    }
//
//    @Test
//    public void eventCardContainHaveRigrhAndLeftTradeBrownTest() {
//        boolean result = gameUserInfo.isHaveRigrhAndLeftTradeBrownCard(gameUserInfo, GameCard.STATUE_SECOND_B);
//        assertEquals(result, true);
//        assertEquals(gameUserInfo.isTradeBrownRight(), true);
//        assertEquals(gameUserInfo.isTradeBrownLeft(), true);
//    }
//
//    @Test
//    public void addGoldToNewEventTest() {
//        gameUserInfo.addGoldToNewEvent(10);
//        assertEquals(gameUserInfo.getEventToSave().getGoldChange(), new Integer(10));
//    }
//
//    @Test(expected = RuntimeException.class)
//    public void addWonderBaseResourseUserHaveResourseBeforeTest() {
//
//
//    }
//
//    @Test
//    public void addWonderBaseResourseTest() {
//        GameResource giveWonder = gameUserInfo
//                .getWonder()
//                .getWonderLevelCard()
//                .get(0)
//                .getGiveResource();
//        gameUserInfo.addWonderBaseResourse(gameUserInfo, giveWonder);
//        List<GameResource> wonderResourse = Collections.singletonList(giveWonder);
//        assertEquals(gameUserInfo.getUserResource(), wonderResourse);
//
//    }

    @Test
    public void createGameUserInfo() {

    }

}

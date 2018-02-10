package com.wonder.wonder.service.util;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.cards.GameResource;
import com.wonder.wonder.cards.WonderCard;
import com.wonder.wonder.model.Event;
import com.wonder.wonder.model.UserInGame;
import com.wonder.wonder.phase.GamePhase;
import com.wonder.wonder.phase.UserActionOnCard;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameUserInfoUtils {

    public static Map<Long, GameUserInfo> createGameUserInfo(List<Event> events) {
        List<Event> sortedListEvents = events.stream()
                .sorted(Comparator.comparingLong(Event::getId))
                .collect(Collectors.toList());

        Map<Long, GameUserInfo> mapGameUserInfo = new HashMap<>();
        for (Event event : sortedListEvents) {
            UserInGame userInGame = event.getUserInGame();
            long userInGameId = userInGame.getId();
// CREATE GameUserInfo if no HAVE USER ID LIKE KEY
            GameUserInfo gameUserInfo = mapGameUserInfo.get(userInGameId);
            if (gameUserInfo == null) {
                gameUserInfo = new GameUserInfo(userInGame);
                addWonderBaseResourse(gameUserInfo, gameUserInfo
                        .getWonder()
                        .getWonderLevelCard()
                        .get(0)
                        .getGiveResource());
                mapGameUserInfo.put(userInGameId, gameUserInfo);

            }
//* MAUSOLEUM
// DO LIST ALL CARD WHAT MAUSOLEUM CAN DO REDIRECTION
            if (gameUserInfo.getWonder().equals(WonderCard.THE_MAUSOLEUM_OF_HALICARNASSUS_SIDE_A)
                    || gameUserInfo.getWonder().equals(WonderCard.THE_MAUSOLEUM_OF_HALICARNASSUS_SIDE_B)) {
                if (event.getUserActionOnCard().equals(UserActionOnCard.SELL_CARD)) {
                    gameUserInfo.getAllDropsCards().add(event.getCard());
                }
            }

//* MAUSOLEUM

// COUNT GOLD BY NOW
// WHAT DO EVENT AND WHAT GIVE
            int userGoldByNow = gameUserInfo.getUserGold() + event.getGoldChange();
            gameUserInfo.setUserGold(userGoldByNow);
            GameCard eventCard = event.getCard();
            UserActionOnCard playCardChoose = event.getUserActionOnCard();
            GameCard chainBuild = event.getChainCard();
            GameResource cardGiveResource = eventCard.getGiveResource();
// WHAT DO EVENT AND WHAT GIVE
            /**
             * Count  * */
            gameUserInfo.setUserGold(userGoldByNow);
            int warPoint;
            int wonderLervel;

            if (buildWonder(playCardChoose)) {
// BUILT WONDER LEVEL CARD
                GameCard wonderLevelBuilt = gameUserInfo
                        .getWonder()
                        .getWonderLevelCard()
                        .get(gameUserInfo.getWonderLevel());
// ADD +! LEVEL WONDER
                wonderLervel = gameUserInfo.getWonderLevel() + 1;
                gameUserInfo.setWonderLevel(wonderLervel);
//ADD WAR POINT BY WONDER
                warPoint = gameUserInfo.getUserWarPoint() + wonderLevelBuilt
                        .getArmyPower()
                        .getPoints();
                gameUserInfo.setUserWarPoint(warPoint);
//ADD BUILT CARD WONDER
                gameUserInfo.getUserBuiltCards().add(wonderLevelBuilt);

                if (cardGiveResources(wonderLevelBuilt.getGiveResource())) {
//ADD USER RESOURCE BY WONDER
                    gameUserInfo.getUserResource()
                            .add(wonderLevelBuilt.getGiveResource());
                }

// ACTIVE OR NOT Wonder Garden PASSIVE
                if (isHaveLastCardCanBuildPassiveCard(eventCard)) {
                    gameUserInfo.setGarderPassiveChooseEightCard(true);
                } else if (isHaveRigrhAndLeftTradeBrownCard(eventCard)) {
// ACTIVE OR NOT BROWN TRADE
                    gameUserInfo.setTradeBrownRight(true);
                    gameUserInfo.setTradeBrownLeft(true);
                } else if (isZeusDiscauntEnabledCard(eventCard)) {
// ACTIVE OR NOT ZEUS FREE BUILD CARD
// AND ZEUS NOT USE PASSIVE YET
                    gameUserInfo.setZeusPassiveWonder(true);  // wonder ZEUS
                    gameUserInfo.setZeusPassiveWonderActive(true);
                }
// ACTIVE OR NOT MAUSOLEUM RESURRECTION
                if (isBuildMausoleumResectionCard(event.getCard())) {
                    gameUserInfo.setBuildGalicarnas(true);// todo 100% bug
                }
            }
//ACTIVE OR DEACTIVATE ABILITY IF ZEUS BUILT IN THIS AGE
// IF DEACTIVATE SET AGE WHEN USED
            if (buildZeus(playCardChoose)) {
                GamePhase gamePhase = event.getGamePhase();
                if (gamePhase.equals(gameUserInfo.getZeusWasUsedInThisAge())) {
                    gameUserInfo.setZeusPassiveWonderActive(true);
                } else {
                    gameUserInfo.setZeusWasUsedInThisAge(gamePhase);
                    gameUserInfo.setZeusPassiveWonderActive(false);
                }
            }
//BUILT CARD BY BASIC RULE
            // BY ZEUS AND
            // BY CHAIN
            if (build(playCardChoose)
                    || buildZeus(playCardChoose)
                    || buildChain(chainBuild)) {
// ADD USER BUILT CARD
                gameUserInfo.getUserBuiltCards().add(eventCard);
// ADD RESOURCE BY CARD
                if (cardGiveResources(cardGiveResource)) {
                    gameUserInfo.getUserResource().add(cardGiveResource);
                }
//ADD WAR POINT BY CARD
                warPoint = gameUserInfo.getUserWarPoint() + eventCard
                        .getArmyPower()
                        .getPoints();

                gameUserInfo.setUserWarPoint(warPoint);
// ACTIVE OR NOT BROWN TRADE
                if (isHaveLeftTradeBrownCard(eventCard)) {
                    gameUserInfo.setTradeBrownLeft(true);
                } else if (isHaveRigrhTradeBrownCard(eventCard)) {
                    gameUserInfo.setTradeBrownRight(true);
// ACTIVE OR NOT SILVER TRADE
                } else if (isHaveRigrhAndLeftTradeSilverCard(eventCard)) {
                    gameUserInfo.setTradeSilverRightAndLeft(true);
                }


            }
            //TODO
//            if (event.getItems().getGivePoint() == -1) {
//                gameUserInfo.setCountLoose(gameUserInfo.getCountLoose() + 1);
//            } else if (event.getItems().getGivePoint() > 0) {
//                gameUserInfo.setCountWinWar(gameUserInfo.getCountWinWar() + event.getItems().getGivePoint());
//            }


        }
        return mapGameUserInfo;
    }

    public static boolean build(UserActionOnCard userActionOnCard) {
        return userActionOnCard.equals(UserActionOnCard.BUILD);
    }


    public static boolean buildZeus(UserActionOnCard eventUserChoose) {
        return eventUserChoose.equals(UserActionOnCard.BUILD_ZEUS);
    }


    public static boolean buildWonder(UserActionOnCard userActionOnCard) {
        return userActionOnCard.equals(UserActionOnCard.BUILD_WONDER);
    }


    public static boolean cardGiveResources(GameResource pastCardgiveResource) {
        return !pastCardgiveResource.equals(GameResource.NO_RESOURCE);
    }


    public static boolean buildChain(GameCard pastChainBuild) {
        return pastChainBuild != null;
    }

    /**
     * @param gameUserInfo current user now
     * @param resource     base resource by main WONDER
     */
    protected static void addWonderBaseResourse(GameUserInfo gameUserInfo, GameResource resource) {
        if (gameUserInfo.getUserResource().size() == 0) {
            gameUserInfo.getUserResource().add(resource);
        } else {
            throw new RuntimeException("you huck game you no can have resource before wonder");
        }
    }

    public static boolean isBuildMausoleumResectionCard(GameCard gameCard) {
        return gameCard.equals(GameCard.MAUSOLEUM_SECOND_A)
                || gameCard.equals(GameCard.MAUSOLEUM_FIRST_B)
                || gameCard.equals(GameCard.MAUSOLEUM_SECOND_B)
                || gameCard.equals(GameCard.MAUSOLEUM_THIRD_B);
    }


    public static boolean isZeusDiscauntEnabledCard(GameCard eventCard) {
        return eventCard.equals(GameCard.STATUE_SECOND_B);
    }


    public static boolean isHaveLastCardCanBuildPassiveCard(GameCard eventCard) {
        return eventCard.equals(GameCard.GARDENS_SECOND_B);
    }


    public static boolean isHaveLeftTradeBrownCard(GameCard eventCard) {
        return eventCard.equals(GameCard.WEST_TRADING_POST);
    }


    public static boolean isHaveRigrhTradeBrownCard(GameCard eventCard) {
        return eventCard.equals(GameCard.EAST_TRADING_POST);
    }


    public static boolean isHaveRigrhAndLeftTradeBrownCard(GameCard eventCard) {
        return eventCard.equals(GameCard.STATUE_SECOND_B);
    }

    public static boolean isHaveRigrhAndLeftTradeSilverCard(GameCard eventCard) {
        return eventCard.equals(GameCard.MARKETPLACE);
    }
}

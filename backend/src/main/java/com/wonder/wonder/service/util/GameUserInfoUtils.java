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
            GameUserInfo gameUserInfo = mapGameUserInfo.get(userInGameId);
            if (gameUserInfo == null) {
                gameUserInfo = new GameUserInfo(userInGame);
                GameResource wonderResource = gameUserInfo.getWonder().getWonderLevelCard().get(0).getGiveResource();
                addWonderBaseResourse(gameUserInfo, wonderResource);
                mapGameUserInfo.put(userInGameId, gameUserInfo);
            }
            WonderCard userWonder = gameUserInfo.getWonder();

            boolean isAddDropCard = false;
            if (userWonder.equals(WonderCard.THE_MAUSOLEUM_OF_HALICARNASSUS_SIDE_A)
                    || userWonder.equals(WonderCard.THE_MAUSOLEUM_OF_HALICARNASSUS_SIDE_B)) {
                isAddDropCard = true;
            }

            UserActionOnCard userActionOnCard = event.getUserActionOnCard();
            if (isAddDropCard) {
                boolean isDropCard = false;
                if (userActionOnCard.equals(UserActionOnCard.SELL_CARD)) {
                    isDropCard = true;
                }
                if (isDropCard) {
                    gameUserInfo.getAllDropsCards().add(event.getCard());
                }
            }

            int userGoldByNow = gameUserInfo.getUserGold() + event.getGoldChange();
            gameUserInfo.setUserGold(userGoldByNow);
            GameCard chainBuild = event.getChainCard();

            gameUserInfo.setUserGold(userGoldByNow);
            if (isBuildWonder(userActionOnCard)) {
                buildWonder(gameUserInfo, event);
            }

            if (isBuildZeus(userActionOnCard)) {
                useZeusPower(gameUserInfo, event);
            }

            boolean isBuildChain = false;
            if (chainBuild != null) {
                isBuildChain = true;
            }

            if (isBuild(userActionOnCard) || isBuildZeus(userActionOnCard) || isBuildChain) {
                build(gameUserInfo, event);

            }

            //TODO WAR CALCULATE
//            if (event.getItems().getGivePoint() == -1) {
//                gameUserInfo.setCountLoose(gameUserInfo.getCountLoose() + 1);
//            } else if (event.getItems().getGivePoint() > 0) {
//                gameUserInfo.setCountWinWar(gameUserInfo.getCountWinWar() + event.getItems().getGivePoint());
//            }
        }
        return mapGameUserInfo;
    }

    private static void build(GameUserInfo gameUserInfo, Event event) {
        GameCard eventCard = event.getCard();
        GameResource cardGiveResource = eventCard.getGiveResource();
        addBuiltCard(gameUserInfo, eventCard);

        if (isCardGiveResources(cardGiveResource)) {
            gameUserInfo.getUserResource().add(cardGiveResource);
        }

        int warPoint = gameUserInfo.getUserWarPoint() + eventCard
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

    protected static void useZeusPower(GameUserInfo gameUserInfo, Event event) {
        GamePhase gamePhase = event.getGamePhase();
        if (gamePhase.equals(gameUserInfo.getZeusWasUsedInThisAge())) {
            gameUserInfo.setZeusPassiveWonderActive(true);
        } else {
            gameUserInfo.setZeusWasUsedInThisAge(gamePhase);
            gameUserInfo.setZeusPassiveWonderActive(false);
        }

    }

    public static boolean isBuildWonder(UserActionOnCard userActionOnCard) {
        return userActionOnCard.equals(UserActionOnCard.BUILD_WONDER);
    }

    private static void buildWonder(GameUserInfo gameUserInfo, Event event) {
        GameCard eventCard = event.getCard();
        List<GameCard> allLevelWonderCard = gameUserInfo.getWonder().getWonderLevelCard();
        GameCard wonderLevelBuilt = allLevelWonderCard.get(gameUserInfo.getWonderLevel());
        addWonderLevel(gameUserInfo);
        addWarpower(gameUserInfo, wonderLevelBuilt);
        addBuiltCard(gameUserInfo, wonderLevelBuilt);

        boolean isCardGiveResources = isCardGiveResources(wonderLevelBuilt.getGiveResource());
        if (isCardGiveResources) {
            addHasResource(gameUserInfo, wonderLevelBuilt);
        }

        boolean isHaveLastCardCanBuildPassiveCard = eventCard.equals(GameCard.GARDENS_SECOND_B);
        if (isHaveLastCardCanBuildPassiveCard) {
            addHaveLastCardCanBuildPassiveCard(gameUserInfo);
        }

        boolean isHaveRightAndLeftTradeBrownCard = eventCard.equals(GameCard.STATUE_SECOND_B);
        if (isHaveRightAndLeftTradeBrownCard) {
            addHaveRightAndLeftTradeBrownCard(gameUserInfo);
        }

        boolean isZeusDiscauntEnabledCard = eventCard.equals(GameCard.STATUE_SECOND_B);
        if (isZeusDiscauntEnabledCard) {
            addZeusDiscauntEnabledCard(gameUserInfo);
        }

        boolean isBuildMausoleumResectionCard = false;

        if (eventCard.equals(GameCard.MAUSOLEUM_SECOND_A)
                || eventCard.equals(GameCard.MAUSOLEUM_FIRST_B)
                || eventCard.equals(GameCard.MAUSOLEUM_SECOND_B)
                || eventCard.equals(GameCard.MAUSOLEUM_THIRD_B)) {
            isBuildMausoleumResectionCard = true;
        }

        if (isBuildMausoleumResectionCard) {
            gameUserInfo.setBuildGalicarnas(true);  // todo 100% bug
        }

    }

    protected static void addZeusDiscauntEnabledCard(GameUserInfo gameUserInfo) {
        gameUserInfo.setZeusPassiveWonder(true);
        gameUserInfo.setZeusPassiveWonderActive(true);
    }

    protected static void addHaveLastCardCanBuildPassiveCard(GameUserInfo gameUserInfo) {
        gameUserInfo.setGarderPassiveChooseEightCard(true);
    }

    protected static void addHaveRightAndLeftTradeBrownCard(GameUserInfo gameUserInfo) {
        gameUserInfo.setTradeBrownRight(true);
        gameUserInfo.setTradeBrownLeft(true);
    }

    protected static void addHasResource(GameUserInfo gameUserInfo, GameCard gameCard) {
        gameUserInfo.getUserResource()
                .add(gameCard.getGiveResource());

    }

    protected static void addBuiltCard(GameUserInfo gameUserInfo, GameCard gameCard) {
        gameUserInfo.getUserBuiltCards().add(gameCard);
    }

    protected static void addWarpower(GameUserInfo gameUserInfo, GameCard gameCard) {
        int warPoint = gameUserInfo.getUserWarPoint() + gameCard
                .getArmyPower()
                .getPoints();
        gameUserInfo.setUserWarPoint(warPoint);
    }

    protected static void addWonderLevel(GameUserInfo gameUserInfo) {
        int wonderLervel = gameUserInfo.getWonderLevel() + 1;
        gameUserInfo.setWonderLevel(wonderLervel);
    }

    public static boolean isBuild(UserActionOnCard userActionOnCard) {
        return userActionOnCard.equals(UserActionOnCard.BUILD);
    }


    public static boolean isBuildZeus(UserActionOnCard eventUserChoose) {
        return eventUserChoose.equals(UserActionOnCard.BUILD_ZEUS);
    }


    public static boolean isCardGiveResources(GameResource pastCardgiveResource) {
        return !pastCardgiveResource.equals(GameResource.NO_RESOURCE);
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

    public static boolean isHaveLeftTradeBrownCard(GameCard eventCard) {
        return eventCard.equals(GameCard.WEST_TRADING_POST);
    }


    public static boolean isHaveRigrhTradeBrownCard(GameCard eventCard) {
        return eventCard.equals(GameCard.EAST_TRADING_POST);
    }

    public static boolean isHaveRigrhAndLeftTradeSilverCard(GameCard eventCard) {
        return eventCard.equals(GameCard.MARKETPLACE);
    }
}

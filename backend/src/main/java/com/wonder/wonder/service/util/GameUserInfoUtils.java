package com.wonder.wonder.service.util;

import com.wonder.wonder.cards.*;
import com.wonder.wonder.model.Event;
import com.wonder.wonder.model.Item;
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
                mapGameUserInfo.put(userInGameId, gameUserInfo);
            }
            WonderCard userWonder = gameUserInfo.getWonder();

            boolean isAddDropCard = userWonder.equals(WonderCard.THE_MAUSOLEUM_OF_HALICARNASSUS_SIDE_A)
                    || userWonder.equals(WonderCard.THE_MAUSOLEUM_OF_HALICARNASSUS_SIDE_B);

            UserActionOnCard userActionOnCard = event.getUserActionOnCard();
            if (isAddDropCard) {
                boolean isDropCard = userActionOnCard.equals(UserActionOnCard.SELL_CARD);
                if (isDropCard) {
                    gameUserInfo.addDropCard(event.getCard());
                }
            }

            int userGoldByNow = gameUserInfo.getUserGold() + event.getGoldChange();
            gameUserInfo.addGoldToNewEvent(userGoldByNow);

            boolean wonderIsBuilt = userActionOnCard.equals(UserActionOnCard.BUILD_WONDER);
            if (wonderIsBuilt) {
                gameUserInfo.addWonderLavel();
            }
            if (userActionOnCard.isBuildZeus()) {
                GamePhase gamePhase = event.getGamePhase();
                if (gamePhase.equals(gameUserInfo.getZeusWasUsedInThisAge())) {
                    gameUserInfo.addZeusPassiveWonderActive(true);
                } else {
                    gameUserInfo.addZeusWasUsedInThisAge(gamePhase);
                    gameUserInfo.addZeusPassiveWonderActive(false);
                }
            }

            GameCard chainBuild = event.getChainCard();
            boolean isBuildChain = chainBuild != null;

            if (isBuild(userActionOnCard) || userActionOnCard.isBuildZeus() || isBuildChain || wonderIsBuilt ||
                    userActionOnCard.equals(UserActionOnCard.RESURRECT_CARD)) {
                GameCard eventCard = event.getCard();
                gameUserInfo.addBuiltCard(eventCard);
                gameUserInfo.addWarPower(eventCard);
                eventCard.getTradeDiscount().doActive(gameUserInfo);

                boolean isHaveLastCardCanBuildPassiveCard = eventCard.equals(GameCard.GARDENS_SECOND_B);
                if (isHaveLastCardCanBuildPassiveCard) {
                    gameUserInfo.addHaveLastCardCanBuildPassive();
                }
                boolean isCanChoosePurpleCardInEnd = eventCard.equals(GameCard.STATUE_ZEUS_THIRD_B);
                if (isCanChoosePurpleCardInEnd) {
                    gameUserInfo.addCanChoosePurpleCardInEnd();
                }

                if (eventCard.equals(GameCard.MAUSOLEUM_SECOND_A)
                        || eventCard.equals(GameCard.MAUSOLEUM_FIRST_B)
                        || eventCard.equals(GameCard.MAUSOLEUM_SECOND_B)
                        || eventCard.equals(GameCard.MAUSOLEUM_THIRD_B)) {
                    gameUserInfo.addResurrectActivate(event.getGamePhase(), event.getPhaseRound());
                }
            }
            addWarItem(gameUserInfo, event);
        }
        return mapGameUserInfo;
    }

    protected static void addWarItem(GameUserInfo gameUserInfo, Event event) {
        List<Item> warAndLooseAndA_Draw = event.getItemList();
        for (Item item : warAndLooseAndA_Draw) {
            int givePoints = item.getItems().getGivePoint();
            if (givePoints == -1) {
                gameUserInfo.setCountLoose(gameUserInfo.getCountLoose() + 1);
            } else if (givePoints > 0) {
                gameUserInfo.setCountWinWar(gameUserInfo.getCountWinWar() + givePoints);
            }
        }
    }

    public static boolean isBuild(UserActionOnCard userActionOnCard) {
        return userActionOnCard.equals(UserActionOnCard.BUILD);//todo like with zeus
    }

}

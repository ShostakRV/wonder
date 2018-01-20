package com.wonder.wonder.service.impl;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.cards.GameResource;
import com.wonder.wonder.model.Event;
import com.wonder.wonder.model.UserInGame;
import com.wonder.wonder.phase.GamePhase;
import com.wonder.wonder.phase.UserActionOnCard;
import com.wonder.wonder.service.GameUserInfoService;
import com.wonder.wonder.service.util.GameUserInfo;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GameUserInfoServiceImpl implements GameUserInfoService {

    @Override
    public boolean build(UserActionOnCard userActionOnCard) {
        return userActionOnCard.equals(UserActionOnCard.BUILD);
    }

    @Override
    public boolean buildZeus(UserActionOnCard eventUserChoose) {
        return eventUserChoose.equals(UserActionOnCard.BUILD_ZEUS);
    }

    @Override
    public boolean buildWonder(UserActionOnCard userActionOnCard) {
        return userActionOnCard.equals(UserActionOnCard.BUILD_WONDER);
    }

    @Override
    public boolean cardGiveResources(GameResource pastCardgiveResource) {
        return !pastCardgiveResource.equals(GameResource.NO_RESOURCE);
    }

    @Override
    public boolean buildChain(GameCard pastChainBuild) {
        return pastChainBuild != null;
    }

    @Override
    public void addWonderBaseResourse(GameUserInfo gameUserInfo, GameResource resource) {
        if (gameUserInfo.getUserResource().size() == 0) {
            gameUserInfo.getUserResource().add(resource);
        } else {
            throw new RuntimeException("you huck game you no can have resource before wonder");
        }
    }

    @Override
    public Map<Long, GameUserInfo> createGameUserInfo(List<Event> events) {
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
            int userGold = gameUserInfo.getUserGold() + event.getGoldChange();
            gameUserInfo.setUserGold(userGold);
            GameCard eventCard = event.getCard();
            UserActionOnCard playCardChoose = event.getUserActionOnCard();
            GameCard chainBuild = event.getChainCard();
            GameResource cardgiveResource = eventCard.getGiveResource();
            /**
             * Count
             * */
            addWonderBaseResourse(gameUserInfo, gameUserInfo
                    .getWonder()
                    .getWonderLevelCard()
                    .get(0)
                    .getGiveResource());
            userGold += gameUserInfo.getUserGold() + 3;
            gameUserInfo.setUserGold(userGold);
            int warPoint;
            int wonderLervel;
            if (buildWonder(playCardChoose)) {
                GameCard wonderLevelBuilt = gameUserInfo
                        .getWonder()
                        .getWonderLevelCard()
                        .get(gameUserInfo.getWonderLevel());
                wonderLervel = gameUserInfo.getWonderLevel() + 1;
                gameUserInfo.setWonderLevel(wonderLervel);
                warPoint = gameUserInfo.getUserWarPoint() + wonderLevelBuilt
                        .getArmyPower()
                        .getPoints();
                gameUserInfo.setUserWarPoint(warPoint);
                gameUserInfo.getUserBuiltCards().add(wonderLevelBuilt);

                if (cardGiveResources(wonderLevelBuilt
                        .getGiveResource())) {
                    gameUserInfo.getUserResource()
                            .add(wonderLevelBuilt.getGiveResource());
                }

                // wonder Garden
                if (isHaveLastCardCanBuildPassiveCard(eventCard)) {
                    gameUserInfo.setGarderPassiveWonder(true);
                } else if (isHaveRigrhAndLeftTradeBrownCard(eventCard)) {
                    gameUserInfo.setTradeBrownRight(true);
                    gameUserInfo.setTradeBrownLeft(true);
                } else if (isZeusDiscauntEnabledCard(eventCard)) {
                    gameUserInfo.setZeusPassiveWonder(true);
                    gameUserInfo.setZeusPassiveWonderActive(true);
                }
                // wonder ZEUS

            }

            if (buildZeus(playCardChoose)) {
                GamePhase gamePhase = event.getGamePhase();
                if(!gamePhase.equals(gameUserInfo.getZeusWasUserInAge())){

                }

            }

            if (build(playCardChoose)
                    || buildZeus(playCardChoose)
                    || buildChain(chainBuild)) {
                gameUserInfo.getUserBuiltCards().add(eventCard);
                if (cardGiveResources(cardgiveResource)) {
                    gameUserInfo.getUserResource().add(cardgiveResource);
                }
                warPoint = gameUserInfo.getUserWarPoint() + eventCard
                        .getArmyPower()
                        .getPoints();

                gameUserInfo.setUserWarPoint(warPoint);
                if (isHaveLeftTradeBrownCard(eventCard)) {
                    gameUserInfo.setTradeBrownLeft(true);
                } else if (isHaveRigrhTradeBrownCard(eventCard)) {
                    gameUserInfo.setTradeBrownRight(true);
                } else if (isHaveRigrhAndLeftTradeSilverCard(eventCard)) {
                    gameUserInfo.setTradeSilverRightAndLeft(true);
                }


            }
        }
        return mapGameUserInfo;
    }

    @Override
    public boolean isZeusDiscauntEnabledCard(GameCard eventCard) {
        return eventCard.equals(GameCard.STATUE_SECOND_B);
    }

    @Override
    public boolean isHaveLastCardCanBuildPassiveCard(GameCard eventCard) {
        return eventCard.equals(GameCard.GARDENS_SECOND_B);
    }

    @Override
    public boolean isHaveLeftTradeBrownCard(GameCard eventCard) {
        return eventCard.equals(GameCard.WEST_TRADING_POST);
    }

    @Override
    public boolean isHaveRigrhTradeBrownCard(GameCard eventCard) {
        return eventCard.equals(GameCard.EAST_TRADING_POST);
    }

    @Override
    public boolean isHaveRigrhAndLeftTradeBrownCard(GameCard eventCard) {
        return eventCard.equals(GameCard.STATUE_SECOND_B);
    }

    @Override
    public boolean isHaveRigrhAndLeftTradeSilverCard(GameCard eventCard) {
        return eventCard.equals(GameCard.MARKETPLACE);
    }
}

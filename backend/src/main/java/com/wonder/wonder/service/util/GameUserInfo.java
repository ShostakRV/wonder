package com.wonder.wonder.service.util;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.cards.GameResource;

import com.wonder.wonder.cards.WonderCard;
import com.wonder.wonder.model.Event;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.UserInGame;
import com.wonder.wonder.phase.UserActionOnCard;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class GameUserInfo {
    private final long userId;
    private List<GameCard> userBuiltCards;
    private List<GameResource> userResource;

    private WonderCard wonder;

    private int wonderLevel;

    private int userGold;

    private int userWarPoint;

    private Integer position;

    private boolean zeusPassiveWonder;

    private boolean garderPassiveWonder;

    private boolean tradeSilverRightAndLeft;

    private boolean tradeBrownRight;

    private boolean tradeBrownLeft;

    private final Event eventToSave;


    public GameUserInfo(UserInGame userInGame) {
        this.userId = userInGame.getUser().getId();
        this.wonder = userInGame.getWonder();
        this.eventToSave = new Event();
        this.position = userInGame.getPosition();
        eventToSave.setUserInGame(userInGame);
        eventToSave.setGame(userInGame.getGame());

    }

    protected boolean build(UserActionOnCard userActionOnCard) {
        return userActionOnCard.equals(UserActionOnCard.BUILD);

    }

    protected boolean buildZeus(UserActionOnCard eventUserChoose) {
        return eventUserChoose.equals(UserActionOnCard.BUILD_ZEUS);
    }

    protected boolean buildWonder(UserActionOnCard userActionOnCard) {
        return userActionOnCard.equals(UserActionOnCard.BUILD_WONDER);
    }

    protected boolean cardGiveResources(GameResource pastCardgiveResource) {
        return !pastCardgiveResource.equals(GameResource.NO_RESOURCE);
    }

    protected boolean buildChain(GameCard pastChainBuild) {
        return pastChainBuild != null;
    }

    protected boolean addWonderBaseResourse(GameUserInfo gameUserInfo) {
        if (userResource.size() == 0) {
            userResource.add(gameUserInfo
                    .getWonder()
                    .getWonderLevelCard()
                    .get(0)
                    .getGiveResource());
            return true;
        } else {
            return false;
        }

    }


    public List<GameUserInfo> createGameUserInfo(List<GameUserInfo> userInfoList, List<Event> events) {
        for (GameUserInfo gameUserInfo : userInfoList) {
            List<Event> sortedListEvents = events.stream()
                    .sorted(Comparator.comparingLong(Event::getId))
                    .collect(Collectors.toList());

            addWonderBaseResourse(gameUserInfo);

            for (Event event : sortedListEvents) {
                userGold += event.getGoldChange();
                GameCard eventCard = event.getCard();
                UserActionOnCard playCardChoose = event.getUserActionOnCard();
                GameCard chainBuild = event.getChainCard();
                GameResource cardgiveResource = eventCard.getGiveResource();
                /**
                 * Count
                 */

                if (buildWonder(playCardChoose)) {
                    GameCard wonderLevelBuilt = gameUserInfo
                            .getWonder()
                            .getWonderLevelCard()
                            .get(wonderLevel);
                    ++wonderLevel;
                    userWarPoint += wonderLevelBuilt
                            .getArmyPower()
                            .getPoints();
                    userBuiltCards.add(wonderLevelBuilt);
                    if (cardGiveResources(wonderLevelBuilt
                            .getGiveResource())) {
                        userResource
                                .add(wonderLevelBuilt.getGiveResource());
                    }

                    zeusPassiveWonder = isZeusDiscauntEnabled(eventCard);

                    garderPassiveWonder = isHaveLastCardCanBuildPassive(eventCard);

                    isHaveRigrhAndLeftTradeBrown(eventCard);
                }
                if (build(playCardChoose)
                        | buildZeus(playCardChoose)
                        | buildChain(chainBuild)) {
                    userGold += eventCard
                            .getGoldNeededForConstruction();
                    userBuiltCards.add(eventCard);
                    if (cardGiveResources(cardgiveResource)) {
                        userResource.add(cardgiveResource);
                    }
                    userWarPoint += eventCard
                            .getArmyPower()
                            .getPoints();

                    tradeBrownLeft = isHaveLeftTradeBrown(eventCard);

                    tradeBrownRight = isHaveRigrhTradeBrown(eventCard);

                }

            }
            gameUserInfo.setUserBuiltCards(userBuiltCards);
            gameUserInfo.setUserGold(userGold);
            gameUserInfo.setUserResource(userResource);
            gameUserInfo.setUserWarPoint(userWarPoint);

        }
        return userInfoList;
    }

    public boolean isZeusDiscauntEnabled(GameCard eventCard) {
        return eventCard.equals(GameCard.STATUE_SECOND_B);
    }

    public boolean isHaveLastCardCanBuildPassive(GameCard eventCard) {
        return eventCard.equals(GameCard.GARDENS_SECOND_B);
    }

    public boolean isHaveLeftTradeBrown(GameCard eventCard) {
        return eventCard.equals(GameCard.WEST_TRADING_POST);
    }

    public boolean isHaveRigrhTradeBrown(GameCard eventCard) {
        return eventCard.equals(GameCard.EAST_TRADING_POST);
    }

    public boolean isHaveRigrhAndLeftTradeBrown(GameCard eventCard) {
        if (eventCard.equals(GameCard.GARDENS_SECOND_B)) {
            tradeBrownRight = true;
            tradeBrownLeft = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean isHaveRigrhAndLeftTradeSilver(GameCard eventCard) {
        return eventCard.equals(GameCard.STATUE_FIRST_B);
    }


    public void addGoldToNewEvent(int gold) {
        eventToSave.setGoldChange(gold);
    }

    public Event getEventToSave() {
        return eventToSave;
    }
}

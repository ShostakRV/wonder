package com.wonder.wonder.service.util;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.cards.GameResource;

import com.wonder.wonder.cards.WonderCard;
import com.wonder.wonder.model.Event;
import com.wonder.wonder.model.UserInGame;
import com.wonder.wonder.phase.UserActionOnCard;
import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Data
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

    protected void addWonderBaseResourse(GameResource resource) {
        if (userResource.size() == 0) {
            userResource.add(resource);

        } else {
            throw new RuntimeException("");
        }

    }


    public List<GameUserInfo> createGameUserInfo(List<GameUserInfo> userInfoList, List<Event> events) {
        for (GameUserInfo gameUserInfo : userInfoList) {
            List<GameCard> userBuiltCards = new ArrayList<>();
            List<GameResource> userResource = new ArrayList<>();

            WonderCard wonder;

            int wonderLevel = 0;

            int userGold = 0;

            int userWarPoint = 0;

            Integer position;

            boolean zeusPassiveWonder;

            boolean garderPassiveWonder;

            boolean tradeSilverRightAndLeft;

            boolean tradeBrownRight;

            boolean tradeBrownLeft;

            final Event eventToSave;

            List<Event> sortedListEvents = events.stream()
                    .sorted(Comparator.comparingLong(Event::getId))
                    .collect(Collectors.toList());
// TODO gameUserInfoMap
            addWonderBaseResourse(gameUserInfo
                    .getWonder()
                    .getWonderLevelCard()
                    .get(0)
                    .getGiveResource());
            userGold += 3;

            for (Event event : sortedListEvents) {
                userGold += event.getGoldChange();
                GameCard eventCard = event.getCard();
                UserActionOnCard playCardChoose = event.getUserActionOnCard();
                GameCard chainBuild = event.getChainCard();
                GameResource cardgiveResource = eventCard.getGiveResource();
                /**
                 * Count
                 */
// TODO wonder card built by card
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
                    // TODO for wonder ZEUS
                    zeusPassiveWonder = isZeusDiscauntEnabled(eventCard);

                    garderPassiveWonder = isHaveLastCardCanBuildPassive(eventCard);

                    // TODO for wonder Garden
                    isHaveRigrhAndLeftTradeBrown(eventCard);
                }
                if (build(playCardChoose)
                        || buildZeus(playCardChoose)
                        || buildChain(chainBuild)) {

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

    public boolean sellCard(UserActionOnCard userActionOnCard) {
        return userActionOnCard.equals(UserActionOnCard.SELL_CARD);

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

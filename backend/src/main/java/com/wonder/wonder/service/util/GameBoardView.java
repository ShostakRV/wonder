package com.wonder.wonder.service.util;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.cards.GameResource;

import com.wonder.wonder.model.Event;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.phase.UserActionOnCard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.collect;

public class GameBoardView {
    private final List<Event> events;
    private final List<GameUserInfo> userInfoList;
    private long currentUserId;

    public GameBoardView(Game game, long currentUserId) {
        this.events = game.getEvents();
        this.currentUserId = currentUserId;
        this.userInfoList = createGameUserInfo(game);
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


    protected List<GameUserInfo> createGameUserInfo(Game game) {
        List<GameUserInfo> userInfoList = game.getUserInGames().stream()
                .map(GameUserInfo::new)
                .sorted(Comparator.comparingLong(GameUserInfo::getPosition))
                .collect(Collectors.toList());

        for (GameUserInfo gameUserInfo : userInfoList) {
            List<GameCard> cardWasBuild = new ArrayList<>();
            List<GameResource> resourceWhatHaveUser = new ArrayList<>();
//            List<PassiveAbility> passiveAbilities = new ArrayList<>();
            int goldHaveUser = 0;
            int wonderLevel = 0;
            int warPoint = 0;
            List<Event> sortedListEvents = events.stream()
                    .sorted(Comparator.comparingLong(Event::getId))
                    .collect(Collectors.toList());
            if (resourceWhatHaveUser.size() == 0) {
                resourceWhatHaveUser.add(gameUserInfo
                        .getWonder()
                        .getWonderLevelCard()
                        .get(0)
                        .getGiveResource());
            }
            for (Event event : sortedListEvents) {
                goldHaveUser += event.getGoldChange();
                GameCard eventCard = event.getCard();
                UserActionOnCard playCardChoose = event.getUserActionOnCard();
                GameCard chainBuild = event.getChainCard();
                GameResource cardgiveResource = eventCard.getGiveResource();
                /**
                 * Count
                 */

                if (buildWonder(playCardChoose)) {
                    ++wonderLevel;
                    GameCard wonderLevelBuilt = gameUserInfo
                            .getWonder()
                            .getWonderLevelCard()
                            .get(wonderLevel);
                    warPoint += wonderLevelBuilt
                            .getArmyPower()
                            .getPoints();
                    cardWasBuild.add(wonderLevelBuilt);
                    if (cardGiveResources(wonderLevelBuilt
                            .getGiveResource())) {
                        resourceWhatHaveUser
                                .add(wonderLevelBuilt.getGiveResource());
                    }

//                    if (cardGiveAbility(wonderLevelBuilt.getPassiveAbilityWrong())) {
//                        passiveAbilities.add(wonderLevelBuilt.getPassiveAbilityWrong());
//                    }
                }
                if (build(playCardChoose)
                        | buildZeus(playCardChoose)
                        | buildChain(chainBuild)) {
                    goldHaveUser += eventCard
                            .getGoldNeededForConstruction();
                    cardWasBuild.add(eventCard);
                    if (cardGiveResources(cardgiveResource)) {
                        resourceWhatHaveUser.add(cardgiveResource);
                    }
                    warPoint += eventCard
                            .getArmyPower()
                            .getPoints();
//                    if (cardGiveAbility(eventCard.getPassiveAbilityWrong())) {
//                        passiveAbilities.add(eventCard.getPassiveAbilityWrong());
//                    }
                }
            }
            gameUserInfo.setUserBuiltCards(cardWasBuild);
            gameUserInfo.setUserGold(goldHaveUser);
            gameUserInfo.setUserResource(resourceWhatHaveUser);
            gameUserInfo.setUserWarPoint(warPoint);

        }
        return userInfoList;
    }

    public GameUserInfo getCurrentUserGameInfo() {
        return userInfoList.stream()
                .filter(gameUserInfo -> gameUserInfo.getUserId() == currentUserId)
                .findAny()
                .orElseThrow(RuntimeException::new);
    }

    public void setCurrentUser(int userId) {
        currentUserId = userId;
    }


    public GameCard getLastBuiltCard() {
        return getCurrentUserGameInfo()
                .getUserBuiltCards()
                .get(getCurrentUserGameInfo()
                        .getUserBuiltCards()
                        .size() - 1);
    }


    public List<GameResource> getUserResources() {
        return getCurrentUserGameInfo()
                .getUserResource();
    }

    public List<GameCard> getCurrentUserBuildCard() {
        return getCurrentUserGameInfo()
                .getUserBuiltCards();
    }

    public GameUserInfo getLeftSiteUser() {
        int position = getCurrentUserGameInfo()
                .getPosition();
        if (position == userInfoList.size() - 1) {
            return userInfoList
                    .stream().filter(gameUserInfo -> gameUserInfo.getPosition() == 0)
                    .findFirst()
                    .orElseThrow(RuntimeException::new);
        }
        return userInfoList
                .stream().filter(gameUserInfo -> gameUserInfo.getPosition() == position + 1)
                .findFirst()
                .orElseThrow(RuntimeException::new);

    }
// UserInGame

    public GameUserInfo getRightSiteUser() {
        int position = getCurrentUserGameInfo()
                .getPosition();
        if (position == 0) {
            return userInfoList
                    .stream().filter(gameUserInfo -> gameUserInfo.getPosition() == userInfoList.size() - 1)
                    .findFirst()
                    .orElseThrow(RuntimeException::new);
        }
        return userInfoList
                .stream().filter(gameUserInfo -> gameUserInfo.getPosition() == position - 1)
                .findFirst()
                .orElseThrow(RuntimeException::new);

    }

//    public boolean isZeusDiscauntEnabled() {
//        return getCurrentUserGameInfo()
//                .getPassiveAbilityList()
//                .stream()
//                .anyMatch(passiveAbility -> passiveAbility.equals(PassiveAbility.BUILD_BY_ZEUS));
//    }

//    public boolean isHaveLastCardCanBuildPassive() {
//        return getCurrentUserGameInfo()
//                .getPassiveAbilityList()
//                .stream()
//                .anyMatch(passiveAbility -> passiveAbility.equals(PassiveAbility.KEEP_LAST_CARD));
//    }

//    public boolean isHaveLeftTradeBrownRight() {
//        return getCurrentUserGameInfo()
//                .getPassiveAbilityList()
//                .stream()
//                .anyMatch(passiveAbility -> passiveAbility.equals(PassiveAbility.TRADE_LEFT));
//    }

//    public boolean isHaveRigrhTradeBrownLeft() {
//        return getCurrentUserGameInfo()
//                .getPassiveAbilityList()
//                .stream()
//                .anyMatch(passiveAbility -> passiveAbility.equals(PassiveAbility.TRADE_RIGHT));
//    }

//    public boolean isHaveRigrhTradeSilverLeftAndRight() {
//        return getCurrentUserGameInfo()
//                .getPassiveAbilityList()
//                .stream()
//                .anyMatch(passiveAbility -> passiveAbility.equals(PassiveAbility.TRADE_BOTH_SIDE));
//    }

    // TODO ASK TRADE LEFT BROWN
    public int getWarFlagCount() {
        return getCurrentUserGameInfo()
                .getUserWarPoint();
    }

    public int getGoldHaveUser() {
        return getCurrentUserGameInfo()
                .getUserGold();
    }

    public int getUserWonderLevel() {
        return getCurrentUserGameInfo()
                .getWonderLevel();
    }

}

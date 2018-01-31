package com.wonder.wonder.service.util;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.cards.GameResource;

import com.wonder.wonder.cards.WonderCard;
import com.wonder.wonder.model.Event;
import com.wonder.wonder.model.Game;

import java.util.List;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.collect;


public class GameBoardView {
    private final List<Event> events; // TODO ASK WE NOT USE THIS
    private final List<GameUserInfo> userInfoList;
    private long currentUserId;

    public GameBoardView(Game game, long currentUserId, List<GameUserInfo> gameUserInfoList) {
        this.events = game.getEvents();
        this.currentUserId = currentUserId;
        this.userInfoList = gameUserInfoList;
    }

    public GameUserInfo getCurrentUserGameInfo() {
        return userInfoList.stream()
                .filter(gameUserInfo -> gameUserInfo.getUserId() == currentUserId)
                .findAny()
                .orElseThrow(RuntimeException::new);
    }

    public void setCurrentUser(long userId) {
        currentUserId = userId;
    }

    public boolean isGarbenPassiveBuilt() {
        return userInfoList.stream()
                .anyMatch(GameUserInfo::isGarderPassiveWonder);
    }

    //TODO ASK HOW FIND AND IS TRUE RETURN ID
    public boolean isMavzoleumPowerWasBuilt() {
        return userInfoList.stream()
                .anyMatch(GameUserInfo::isBuildGalicarnas);
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


    public boolean isWinLeftPlayerInWar() {
        return (getCurrentUserGameInfo()
                .getUserWarPoint() - getLeftSiteUser().getUserWarPoint()) > 0;
    }

    public boolean isWinRightPlayerInWar() {
        return (getCurrentUserGameInfo()
                .getUserWarPoint() - getRightSiteUser().getUserWarPoint()) > 0;
    }

    public int getGoldHaveUser() {
        return getCurrentUserGameInfo()
                .getUserGold();
    }

    public int getUserWonderLevel() {
        return getCurrentUserGameInfo()
                .getWonderLevel();
    }

    public List<Event> getAllEvents() {
        return events;
    }

}

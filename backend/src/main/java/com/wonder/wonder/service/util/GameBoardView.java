package com.wonder.wonder.service.util;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.cards.GameResource;

import com.wonder.wonder.model.Event;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.phase.UserActionOnCard;
import org.springframework.stereotype.Service;

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


    protected List<GameUserInfo> createGameUserInfo(Game game) {
        List<GameUserInfo> userInfoList = game.getUserInGames().stream()
                .map(GameUserInfo::new)
                .sorted(Comparator.comparingLong(GameUserInfo::getPosition))
                .collect(Collectors.toList());
        GameUserInfo gameUserInfo = userInfoList.stream()
                .findFirst()
                .orElseThrow(RuntimeException::new);
        userInfoList = gameUserInfo.createGameUserInfo(userInfoList, events);
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

    public List<Event> getAllEvents() {
        return events;
    }

}

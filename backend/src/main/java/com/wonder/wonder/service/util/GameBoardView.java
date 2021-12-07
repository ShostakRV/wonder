package com.wonder.wonder.service.util;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.jms.Items;
import com.wonder.wonder.model.Event;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.Item;

import java.util.List;


public class GameBoardView {
    private final List<Event> events; // TODO ASK WE NOT USE THIS

    private final List<GameUserInfo> userInfoList;// todo map <positionId, GameUserInfo >
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
                .anyMatch(GameUserInfo::isGarderPassiveChooseEightCard);
    }

    //TODO ASK HOW FIND AND IS TRUE RETURN ID
    public boolean isMavzoleumPowerWasBuilt() {
        return userInfoList.stream()
                .anyMatch(GameUserInfo::isActivateResurrectAction);
    }

    public GameCard getLastBuiltCard() {
        return getCurrentUserGameInfo()
                .getUserBuiltCards()
                .get(getCurrentUserGameInfo()
                        .getUserBuiltCards()
                        .size() - 1);
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


    public int isWinLeftPlayerInWar() {
        int warPoint = getCurrentUserGameInfo().getUserWarPoint() - getLeftSiteUser().getUserWarPoint();
        return Integer.compare(warPoint, 0);
    }

    public int isWinRightPlayerInWar() {
        int warPoint = getCurrentUserGameInfo().getUserWarPoint() - getRightSiteUser().getUserWarPoint();
        return Integer.compare(warPoint, 0);
    }

    public int getUserWonderLevel() {
        return getCurrentUserGameInfo()
                .getWonderLevel();
    }

    public void addItemToNewEvent(Items items) {
        Event toSave = getCurrentUserGameInfo().getEventToSave();
        Item item = new Item();
        item.setItems(items);
        item.setEvent(toSave);
        toSave.getItemList().add(item);
    }

    public boolean isPurpleWasBuild() {
        return userInfoList.stream()
                .anyMatch(GameUserInfo::isZuesPurpleChoose);
    }
}

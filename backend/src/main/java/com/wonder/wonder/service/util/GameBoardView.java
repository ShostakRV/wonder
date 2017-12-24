package com.wonder.wonder.service.util;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.cards.GameResource;
import com.wonder.wonder.model.Event;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.UserInGame;

import java.util.ArrayList;
import java.util.List;

public class GameBoardView {
    private final List<Event> events;
    private final List<GameUserInfo> userInfoList;
    private int currentUserId;


    public GameBoardView(Game game) {
        this.events = game.getEvents(); //todo
        this.userInfoList = null;//todo

    }

    public void setCurrentUser(int userId) {
        currentUserId = userId;
    }

    public GameCard getLastBuiltCard() {
        return null;
    }

    public List<GameResource> getUserResources() {

        return null;
    }

    public List<GameCard> getCurrentUserCard() {

        return null;
    }

    public UserInGame getRightSiteUser() {

        return null;
    }

    public UserInGame getLeftSiteUser() {

        return null;
    }

    public boolean isZeusDiscauntEnabled() {

        return false;
    }

//    public boolean isGelicarnassBuild(){}

    public int getWarFlagCount() {

        return 0;
    }
}

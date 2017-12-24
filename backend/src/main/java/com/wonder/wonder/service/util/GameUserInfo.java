package com.wonder.wonder.service.util;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.cards.GameResource;
import com.wonder.wonder.model.Event;
import com.wonder.wonder.model.UserInGame;

import java.util.List;

public class GameUserInfo {
    final long userId;
    List<GameCard> userCards;
    List<GameResource> userResource;

    int userGold;

    int userWarPoint;

    int wonderLevel;

    private final Event eventToSave;


    public GameUserInfo(UserInGame userInGame) {
        this.userId = userInGame.getUser().getId();
        this.eventToSave = new Event();
        eventToSave.setUserInGame(userInGame);
        eventToSave.setGame(userInGame.getGame());
    }
}

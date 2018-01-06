package com.wonder.wonder.service.util;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.cards.GameResource;

import com.wonder.wonder.cards.WonderCard;
import com.wonder.wonder.model.Event;
import com.wonder.wonder.model.UserInGame;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    private final Event eventToSave;


    public GameUserInfo(UserInGame userInGame) {
        this.userId = userInGame.getUser().getId();
        this.wonder = userInGame.getWonder();
        this.eventToSave = new Event();
        this.position = userInGame.getPosition();
        eventToSave.setUserInGame(userInGame);
        eventToSave.setGame(userInGame.getGame());

    }

    public void addGoldToNewEvent(int gold) {
        eventToSave.setGoldChange(gold);
    }

    public Event getEventToSave() {
        return eventToSave;
    }
}

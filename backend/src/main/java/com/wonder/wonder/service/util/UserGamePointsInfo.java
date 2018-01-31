package com.wonder.wonder.service.util;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.cards.ScientistGuild;
import com.wonder.wonder.jms.Items;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.UserInGame;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class UserGamePointsInfo {

    UserInGame userInGame;

    private int userGold;

    private int countLoose;

    private List<GameCard> gameCardList = new ArrayList<>();

    private boolean purpureCardWarLooseOn;

    List<Items> warWinItems = new ArrayList<>();

    Map<ScientistGuild, Integer> countScientistSymbol = new HashMap<>();

    public UserGamePointsInfo(UserInGame userInGame) {
        this.userInGame = userInGame;
    }

    public void addGold(int gold) {
        userGold += gold;
    }
}

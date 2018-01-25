package com.wonder.wonder.service.util;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.cards.GameResource;

import com.wonder.wonder.cards.WonderCard;
import com.wonder.wonder.dao.GameDao;
import com.wonder.wonder.model.Event;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.UserInGame;
import com.wonder.wonder.phase.GamePhase;
import com.wonder.wonder.phase.UserActionOnCard;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class GameUserInfo {

    private final long userId;
    private List<GameCard> userBuiltCards = new ArrayList<>();
    private List<GameResource> userResource = new ArrayList<>();

    // IF YOU HAVE WONDER GALICARNAS YOU HAVE CARD HERE
    private List<GameCard> allDropsCards = new ArrayList<>();

    private WonderCard wonder;

    private int wonderLevel;

    private int userGold;

    private int userWarPoint;

    private Integer position;

    private boolean zeusPassiveWonder;

    private boolean zeusPassiveWonderActive;

    private GamePhase zeusWasUserInAge;

    private boolean garderPassiveWonder;

    private boolean tradeSilverRightAndLeft;

    private boolean tradeBrownRight;

    private boolean tradeBrownLeft;

    private final Event eventToSave;

    private boolean canBuildByChainCurrentCard;

    private int changeGoldByOnBuildEvent;

    private boolean buildGalicarnas;

    public GameUserInfo(UserInGame userInGame) {
        this.userId = userInGame.getUser().getId();
        this.wonder = userInGame.getWonder();
        this.position = userInGame.getPosition();
        this.eventToSave = new Event();
        eventToSave.setUserInGame(userInGame);
        eventToSave.setGame(userInGame.getGame());
        eventToSave.setUserInGame(userInGame);
        Game game = userInGame.getGame();
        eventToSave.setGamePhase(game.getPhaseGame());
        eventToSave.setPhaseRound(game.getPhaseRound());
        eventToSave.setPhaseChooseDo(game.getPhaseChooseDo());

    }

    public void addGoldToNewEvent(int gold) {
        changeGoldByOnBuildEvent += gold;
    }

}

package com.wonder.wonder.service.util;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.cards.GameResource;

import com.wonder.wonder.cards.ScientistGuild;
import com.wonder.wonder.cards.WonderCard;
import com.wonder.wonder.dao.GameDao;
import com.wonder.wonder.jms.Items;
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

    // IF YOU HAVE WONDER GALICARNAS MAUSOLEUM YOU HAVE CARD HERE
    private List<GameCard> allDropsCards = new ArrayList<>();

    private WonderCard wonder;

    private int wonderLevel;

    private int userGold;

    private int userWarPoint;

    private Integer position;
    //**
    //  ZEUS WONDER // IS BUILD SECOND CARD ZEUS SIDE B
    private boolean zeusPassiveWonder;
    // IS USER OR NOT ZEUS ABILITY IN THIS AGE
    private boolean zeusPassiveWonderActive;
    // IN WHAT AGE WAS USED ZEUS ABILITY
    private GamePhase zeusWasUsedInThisAge;
    // ZEUS WONDER
    //**
    // if YOU SHOOCE CARD FOR BUILT LIKE CHAIN AND YOU HAVE CARD FOR CHAIN
    private boolean canBuildByChainCurrentCard;

    private boolean buildGalicarnas;

    private boolean garderPassiveChooseEightCard;

    //**
    //TRADE PASSIVE RESOURSE buy COST 1 gold
    private boolean tradeSilverRightAndLeft;

    private boolean tradeBrownRight;

    private boolean tradeBrownLeft;
    //TRADE PASSIVE RESOURSE buy COST 1 gold
    //**

    //**
    // parametrs for calculate points
    //TODO NEED COUNT
    private int countLoose;

    private boolean purpureCardWarLooseOn;
    // NEED TAKE USER ACTION CHOOSE CARD
    boolean canShooseScientist;
    // NEED TAKE USER ACTION CHOOSE CARD
    boolean canShoosePurpure;


    //TODO NEED COUNT
    private int countWinWar;

    private Map<ScientistGuild, Integer> countScientistSymbol = new HashMap<>();
    //**

    //**
    private final Event eventToSave;


    public GameUserInfo(UserInGame userInGame) {
        this.userId = userInGame.getUser().getId();
        this.wonder = userInGame.getWonder();
        this.position = userInGame.getPosition();
        this.eventToSave = new Event();
        eventToSave.setUserInGame(userInGame);
        eventToSave.setGame(userInGame.getGame());
        Game game = userInGame.getGame();
        eventToSave.setGamePhase(game.getPhaseGame());
        eventToSave.setPhaseRound(game.getPhaseRound());
        eventToSave.setPhaseChooseDo(game.getPhaseChooseDo());

    }

    public void addGoldToNewEvent(int gold) {
        eventToSave.setGoldChange(eventToSave.getGoldChange() + gold);
    }

}

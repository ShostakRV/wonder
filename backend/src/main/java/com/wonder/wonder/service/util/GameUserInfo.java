package com.wonder.wonder.service.util;

import com.wonder.wonder.cards.*;

import com.wonder.wonder.model.Event;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.UserInGame;
import com.wonder.wonder.phase.GamePhase;
import lombok.Data;

import java.util.*;

@Data
public class GameUserInfo {

    private final long userId;
    private List<GameCard> userBuiltCards = new ArrayList<>();
//    private List<GameResource> userResource = new ArrayList<>();

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
    //** MAUSOLEUM
    private int roundResurrectActivate;

    private boolean activateResurrectAction;

    private GamePhase ageResurrectActivate;
//** MAUSOLEUM


    private boolean garderPassiveChooseEightCard;

    //**
    //TRADE PASSIVE RESOURSE buy COST 1 gold
    private boolean tradeSilverRightAndLeft;

    private boolean tradeBrownRight;

    private boolean tradeBrownLeft;
    //TRADE PASSIVE RESOURSE buy COST 1 gold
    //**

    private int buyBrouwnLeft = 2;
    private int buyBrouwnRight = 2;
    private int buySilver = 2;

    List<BaseResource> allResourceForBuild = new ArrayList<>();

    List<BaseResource> allChooseUserResources = new ArrayList<>();

    List<BaseResource> buyResources = new ArrayList<>();
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

    public void addWonderLavel() {
        wonderLevel++;
    }

    public void addZeusDiscauntEnabledCard() {
        setZeusPassiveWonder(true);
        setZeusPassiveWonderActive(true);
    }

    public void addZeusPassiveWonderActive(boolean state) {
        setZeusPassiveWonderActive(state);
    }

    public void addZeusWasUsedInThisAge(GamePhase gamePhase) {
        setZeusWasUsedInThisAge(gamePhase);
    }

    public void addHaveRigrhAndLeftTradeSilver() {
        setTradeSilverRightAndLeft(true);
    }

    public void addHaveRigrhTradeBrown() {
        setTradeBrownRight(true);
    }

    public void addHaveLeftTradeBrown() {
        setTradeBrownLeft(true);
    }

    public void addHaveLastCardCanBuildPassive() {
        setGarderPassiveChooseEightCard(true);
    }

    public void addHaveRightAndLeftTradeBrown() {
        setTradeBrownRight(true);
        setTradeBrownLeft(true);
    }

    public void addBuiltCard(GameCard gameCard) {
        getUserBuiltCards().add(gameCard);
    }

    public void addWarPower(GameCard gameCard) {
        int warPointsForCard = gameCard.getArmyPower().getPoints();
        int warPoint = getUserWarPoint() + warPointsForCard;
        setUserWarPoint(warPoint);
    }

    public void changeCostBuyBrownLeft() {
        buyBrouwnLeft = 1;
    }

    public void changeBuyBrouwnRight() {
        buyBrouwnRight = 1;
    }

    public void changeBuySilverRightAndLeft() {
        buySilver = 1;
    }

    public void addGoldForSale() {
        eventToSave.setGoldChange(3);
    }

    public void addCanBuildByChain() {
        setCanBuildByChainCurrentCard(true);
    }

    public void addDropCard(GameCard card) {
        getAllDropsCards().add(card);
    }

    public void addResurrectActivate(GamePhase gamePhase, Integer phaseRound) {
        setAgeResurrectActivate(gamePhase);
        setRoundResurrectActivate(phaseRound);
    }

    public void addResourcesForBuild(List<BaseResource> baseResources) {
        allResourceForBuild.addAll(baseResources);
    }
}

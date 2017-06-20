package com.wonder.wonder.service.cards.resouse_NeedRename;

import com.wonder.wonder.service.cards.Card;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Creator: bm
 * Date: 15.06.17.
 */
public enum GameCard implements Card {

// brown card first age resource card

    LUMBER_YARD(1, 3, GameCardColor.BROWN, ActionSide.DOWN, 0, GameResource.WOOD, 0, false, false, 0, false, null, false, null, null, 0, null),
    LUMBER_YARD_FOR_4_PLAYERS(1, 4, GameCardColor.BROWN, ActionSide.DOWN, 0, GameResource.WOOD, 0, false, false, 0, false, null, false, null, null, 0, null),
    STONE_PIT(1, 3, GameCardColor.BROWN, ActionSide.DOWN, 0, GameResource.STONE, 0, false, false, 0, false, null, false, null, null, 0, null),
    STONE_PIT_FOR_5_PLAYERS(1, 5, GameCardColor.BROWN, ActionSide.DOWN, 0, GameResource.STONE, 0, false, false, 0, false, null, false, null, null, 0, null),
    CLAY_POOL(1, 3, GameCardColor.BROWN, ActionSide.DOWN, 0, GameResource.CLAY, 0, false, false, 0, false, null, false, null, null, 0, null),
    CLAY_POOL_FOR_5_PLAYERS(1, 5, GameCardColor.BROWN, ActionSide.DOWN, 0, GameResource.CLAY, 0, false, false, 0, false, null, false, null, null, 0, null),
    ORE_VEIN(1, 3, GameCardColor.BROWN, ActionSide.DOWN, 0, GameResource.IRON, 0, false, false, 0, false, null, false, null, null, 0, null),

// brown second age

    SAWMILL(1, 3, GameCardColor.BROWN, ActionSide.DOWN, 0, GameResource.DOUBLE_WOOD, 0, false, false, 0, false, null, false, null, null, 1, null),
    SAWMILL_FOR_4_PLAYERS(1, 4, GameCardColor.BROWN, ActionSide.DOWN, 0, GameResource.DOUBLE_WOOD, 0, false, false, 0, false, null, false, null, null, 1, null),
    QUARRY(1, 3, GameCardColor.BROWN, ActionSide.DOWN, 0, GameResource.DOUBLE_STONE, 0, false, false, 0, false, null, false, null, null, 1, null),
    QUARRY_FOR_4_PLAYERS(1, 4, GameCardColor.BROWN, ActionSide.DOWN, 0, GameResource.DOUBLE_STONE, 0, false, false, 0, false, null, false, null, null, 1, null),
    BRICKYARD(1, 3, GameCardColor.BROWN, ActionSide.DOWN, 0, GameResource.DOUBLE_CLAY, 0, false, false, 0, false, null, false, null, null, 1, null),
    BRICKYARD_FOR_4_PLAYERS(1, 4, GameCardColor.BROWN, ActionSide.DOWN, 0, GameResource.DOUBLE_CLAY, 0, false, false, 0, false, null, false, null, null, 1, null),
    FOUNDRY(1, 3, GameCardColor.BROWN, ActionSide.DOWN, 0, GameResource.DOUBLE_IRON, 0, false, false, 0, false, null, false, null, null, 1, null),
    FOUNDRY_FOR_4_PLAYERS(1, 4, GameCardColor.BROWN, ActionSide.DOWN, 0, GameResource.DOUBLE_IRON, 0, false, false, 0, false, null, false, null, null, 1, null),

//brown half

    TREE_FARM(1, 6, GameCardColor.BROWN, ActionSide.DOWN, 0, GameResource.WOOD_OR_CLAY, 0, false, false, 0, false, null, false, null, null, 1, null),
    EXCAVATION(1, 4, GameCardColor.BROWN, ActionSide.DOWN, 0, GameResource.STONE_OR_CLAY, 0, false, false, 0, false, null, false, null, null, 1, null),
    CLAY_PIT(1, 3, GameCardColor.BROWN, ActionSide.DOWN, 0, GameResource.IRON_OR_CLAY, 0, false, false, 0, false, null, false, null, null, 1, null),
    TIMBER_YARD(1, 3, GameCardColor.BROWN, ActionSide.DOWN, 0, GameResource.STONE_OR_WOOD, 0, false, false, 0, false, null, false, null, null, 1, null),
    FOREST_CAVE(1, 5, GameCardColor.BROWN, ActionSide.DOWN, 0, GameResource.WOOD_OR_IRON, 0, false, false, 0, false, null, false, null, null, 1, null),
    MINE(1, 6, GameCardColor.BROWN, ActionSide.DOWN, 0, GameResource.STONE_OR_IRON, 0, false, false, 0, false, null, false, null, null, 1, null),

//silver card first + second age

    LOOM(1, 3, GameCardColor.SILVER, ActionSide.DOWN, 0, GameResource.SILK, 0, false, false, 0, false, null, false, null, null, 0, null),
    LOOM_FOR_6_PLAYERS(1, 6, GameCardColor.SILVER, ActionSide.DOWN, 0, GameResource.SILK, 0, false, false, 0, false, null, false, null, null, 0, null),
    LOOM_FOR_5_PLAYERS(2, 5, GameCardColor.SILVER, ActionSide.DOWN, 0, GameResource.SILK, 0, false, false, 0, false, null, false, null, null, 0, null),
    LOOM_FOR_3_PLAYERS_AGE_2(2, 3, GameCardColor.SILVER, ActionSide.DOWN, 0, GameResource.SILK, 0, false, false, 0, false, null, false, null, null, 0, null),

    GLASSWORKS(1, 3, GameCardColor.SILVER, ActionSide.DOWN, 0, GameResource.GLASS, 0, false, false, 0, false, null, false, null, null, 0, null),
    GLASSWORKS_FOR_6_PLAYERS(1, 6, GameCardColor.SILVER, ActionSide.DOWN, 0, GameResource.GLASS, 0, false, false, 0, false, null, false, null, null, 0, null),
    GLASSWORKS_FOR_5_PLAYERS(2, 5, GameCardColor.SILVER, ActionSide.DOWN, 0, GameResource.GLASS, 0, false, false, 0, false, null, false, null, null, 0, null),
    GLASSWORKS_FOR_3_PLAYERS_AGE_2(2, 3, GameCardColor.SILVER, ActionSide.DOWN, 0, GameResource.GLASS, 0, false, false, 0, false, null, false, null, null, 0, null),

    PRESS(1, 3, GameCardColor.SILVER, ActionSide.DOWN, 0, GameResource.PARCHMENT, 0, false, false, 0, false, null, false, null, null, 0, null),
    PRESS_FOR_6_PLAYERS(1, 6, GameCardColor.SILVER, ActionSide.DOWN, 0, GameResource.PARCHMENT, 0, false, false, 0, false, null, false, null, null, 0, null),
    PRESS_FOR_5_PLAYERS(2, 5, GameCardColor.SILVER, ActionSide.DOWN, 0, GameResource.PARCHMENT, 0, false, false, 0, false, null, false, null, null, 0, null),
    PRESS_FOR_3_PLAYERS_AGE_2(2, 3, GameCardColor.SILVER, ActionSide.DOWN, 0, GameResource.PARCHMENT, 0, false, false, 0, false, null, false, null, null, 0, null),

// Yellow card first age

    // trade card
    EAST_TRADING_POST(1, 3, GameCardColor.YELLOW, ActionSide.RIGHT, 0, null, 0, true, false, 0, false, null, false, null, null, 0, null),
    WEST_TRADING_POST(1, 3, GameCardColor.YELLOW, ActionSide.LEFT, 0, null, 0, true, false, 0, false, null, false, null, null, 0, null),
    MARKETPLACE(1, 3, GameCardColor.YELLOW, ActionSide.RIGHT_AND_LEFT, 0, null, 0, true, false, 0, false, null, false, null, null, 0, null),

    // give gold
    TAVERN(1, 4, GameCardColor.YELLOW, null, 0, null, 0, false, true, 5, false, null, false, null, null, 0, null),

// Yellow card second age

    //resouce give yellow
    CARAVANSERY(2, 3, GameCardColor.YELLOW, ActionSide.DOWN, 0, GameResource.STONE_OR_IRON_OR_CLAY_OR_WOOD, 0, false, false, 0, false, null, false, null, Arrays.asList("MARKETPLACE"), 0, BaseResource.WOOD, BaseResource.WOOD),
    FORUM(2, 3, GameCardColor.YELLOW, ActionSide.DOWN, 0, GameResource.SILK_OR_GLASS_OR_PARCHMENT, 0, false, false, 0, false, null, false, null, Arrays.asList("EAST_TRADING_POST", "EAST_TRADING_POST"), 0, BaseResource.CLAY, BaseResource.CLAY),

// end


    VINEYARD(2, 3, GameCardColor.YELLOW, ActionSide.RIGHT_AND_LEFT_AND_DOWN, 0, null, 0, false, true, 1, false, null, false, Arrays.asList(GameCardColor.BROWN), null, 0, null),


    BAZAR(2, 3, GameCardColor.YELLOW, ActionSide.RIGHT_AND_LEFT_AND_DOWN, 0, null, 0, false, true, 2, false, null, false, Arrays.asList(GameCardColor.SILVER), null, 0, null),

// thierd  age gold

//card what give point and gold for cardColor

    HAVEN(3, 3, GameCardColor.YELLOW, ActionSide.DOWN, 1, null, 0, false, true, 1, false, null, false, Arrays.asList(GameCardColor.BROWN), Arrays.asList("DISPENSARY"), 0, BaseResource.SILK, BaseResource.IRON, BaseResource.WOOD),
    LIGHTHOUSE(3, 3, GameCardColor.YELLOW, ActionSide.DOWN, 1, null, 0, false, true, 1, false, null, false, Arrays.asList(GameCardColor.YELLOW), Arrays.asList("CARAVANSERY"), 0, BaseResource.GLASS, BaseResource.STONE),
    CHAMBER_OF_COMMERCE(4, 3, GameCardColor.YELLOW, ActionSide.DOWN, 2, null, 0, false, true, 2, false, null, false, Arrays.asList(GameCardColor.YELLOW), null, 0, BaseResource.CLAY, BaseResource.CLAY, BaseResource.PARCHMENT),

//card what give point for vonderLevel

    ARENA(3, 3, GameCardColor.YELLOW, ActionSide.DOWN, 2, null, 0, false, true, 3, false, null, false, null, Arrays.asList("DISPENSARY"), 0, BaseResource.CLAY, BaseResource.CLAY, BaseResource.PARCHMENT),

//first age blue

    PAWNSHOP(1, 4, GameCardColor.BLUE, ActionSide.DOWN, 3, null, 0, false, false, 0, false, null, false, null, null, 0, null),
    BATHS(1, 3, GameCardColor.BLUE, ActionSide.DOWN, 3, null, 0, false, false, 0, false, null, false, null, null, 0, BaseResource.STONE),
    ALTAR(1, 3, GameCardColor.BLUE, ActionSide.DOWN, 2, null, 0, false, false, 0, false, null, false, null, null, 0, null),
    THEATER(1, 3, GameCardColor.BLUE, ActionSide.DOWN, 2, null, 0, false, false, 0, false, null, false, null, null, 0, null),

// second age  blue

    AQUEDUCT(2, 3, GameCardColor.BLUE, ActionSide.DOWN, 5, null, 0, false, false, 0, false, null, false, null, Arrays.asList("BATHS"), 0, BaseResource.STONE, BaseResource.STONE, BaseResource.STONE),
    TEMPLE(2, 3, GameCardColor.BLUE, ActionSide.DOWN, 3, null, 0, false, false, 0, false, null, false, null, Arrays.asList("ALTAR"), 0, BaseResource.WOOD, BaseResource.CLAY, BaseResource.GLASS),
    STATUE(2, 3, GameCardColor.BLUE, ActionSide.DOWN, 4, null, 0, false, false, 0, false, null, false, null, Arrays.asList("THEATER"), 0, BaseResource.WOOD, BaseResource.IRON, BaseResource.IRON),
    COURTHOUSE(2, 3, GameCardColor.BLUE, ActionSide.DOWN, 4, null, 0, false, false, 0, false, null, false, null, Arrays.asList("SCRIPTORIUM"), 0, BaseResource.CLAY, BaseResource.CLAY, BaseResource.SILK),

//blue thierd age

    PANTHEON(3, 3, GameCardColor.BLUE, ActionSide.DOWN, 7, null, 0, false, false, 0, false, null, false, null, Arrays.asList("TEMPLE"), 0, BaseResource.CLAY, BaseResource.CLAY, BaseResource.IRON, BaseResource.PARCHMENT, BaseResource.SILK, BaseResource.GLASS),
    GARDENS(3, 3, GameCardColor.BLUE, ActionSide.DOWN, 5, null, 0, false, false, 0, false, null, false, null, Arrays.asList("STATUE"), 0, BaseResource.WOOD, BaseResource.CLAY, BaseResource.CLAY),
    TOWN_HALL(3, 3, GameCardColor.BLUE, ActionSide.DOWN, 6, null, 0, false, false, 0, false, null, false, null, null, 0, BaseResource.GLASS, BaseResource.IRON, BaseResource.STONE, BaseResource.STONE),
    PALACE(3, 3, GameCardColor.BLUE, ActionSide.DOWN, 8, null, 0, false, false, 0, false, null, false, null, null, 0, BaseResource.GLASS, BaseResource.PARCHMENT, BaseResource.SILK, BaseResource.CLAY, BaseResource.WOOD, BaseResource.IRON, BaseResource.STONE),
    SENATE(3, 3, GameCardColor.BLUE, ActionSide.DOWN, 6, null, 0, false, false, 0, false, null, false, null, Arrays.asList("LIBRARY"), 0, BaseResource.IRON, BaseResource.STONE, BaseResource.WOOD, BaseResource.WOOD),

//first age  red

    STOCKADE(1, 3, GameCardColor.RED, ActionSide.DOWN, 0, null, 1, false, false, 0, false, null, false, null, null, 0, BaseResource.WOOD),
    BARRACKS(1, 3, GameCardColor.RED, ActionSide.DOWN, 0, null, 1, false, false, 0, false, null, false, null, null, 0, BaseResource.IRON),
    GUARD_TOWER(1, 3, GameCardColor.RED, ActionSide.DOWN, 0, null, 1, false, false, 0, false, null, false, null, null, 0, BaseResource.CLAY),

//red  second age

    WALLS(2, 3, GameCardColor.RED, ActionSide.DOWN, 0, null, 2, false, false, 0, false, null, false, null, null, 0, BaseResource.STONE, BaseResource.STONE, BaseResource.STONE),
    TRAINING_GROUND(2, 4, GameCardColor.RED, ActionSide.DOWN, 0, null, 2, false, false, 0, false, null, false, null, null, 0, BaseResource.WOOD, BaseResource.IRON, BaseResource.IRON),
    STABLES(2, 3, GameCardColor.RED, ActionSide.DOWN, 0, null, 2, false, false, 0, false, null, false, null, Arrays.asList("APOTHECARY"), 0, BaseResource.IRON, BaseResource.CLAY, BaseResource.WOOD),// GreenCardImpl.APOTHECARY
    ARCHERY_RANGE(2, 3, GameCardColor.RED, ActionSide.DOWN, 0, null, 2, false, false, 0, false, null, false, null, Arrays.asList("WORKSHOP"), 0, BaseResource.WOOD, BaseResource.WOOD, BaseResource.IRON),//GreenCardImpl.WORKSHOP

// red thierd age

    FORTIFICATIONS(3, 3, GameCardColor.RED, ActionSide.DOWN, 0, null, 3, false, false, 0, false, null, false, null, Arrays.asList("WALLS"), 0, BaseResource.STONE, BaseResource.IRON, BaseResource.IRON, BaseResource.IRON),
    CIRCUS(3, 4, GameCardColor.RED, ActionSide.DOWN, 0, null, 3, false, false, 0, false, null, false, null, Arrays.asList("TRAINING_GROUND"), 0, BaseResource.STONE, BaseResource.STONE, BaseResource.STONE, BaseResource.IRON),
    ARSENAL(3, 3, GameCardColor.RED, ActionSide.DOWN, 0, null, 3, false, false, 0, false, null, false, null, null, 0, BaseResource.IRON, BaseResource.WOOD, BaseResource.WOOD, BaseResource.SILK),
    SIEGE_WORKSHOP(3, 3, GameCardColor.RED, ActionSide.DOWN, 0, null, 3, false, false, 0, false, null, false, null, Arrays.asList("LABORATORY"), 0, BaseResource.WOOD, BaseResource.CLAY, BaseResource.CLAY, BaseResource.CLAY),

// green first age

    APOTHECARY(1, 3, GameCardColor.GREEN, ActionSide.DOWN, 0, null, 0, false, false, 0, true, ScientistGuild.COMPASSE, false, null, null, 0, BaseResource.SILK),
    WORKSHOP(1, 3, GameCardColor.GREEN, ActionSide.DOWN, 0, null, 0, false, false, 0, true, ScientistGuild.GEAR, false, null, null, 0, BaseResource.GLASS),
    SCRIPTORIUM1(1, 3, GameCardColor.GREEN, ActionSide.DOWN, 0, null, 0, false, false, 0, true, ScientistGuild.NAMEPLATE, false, null, null, 0, BaseResource.PARCHMENT),

//green  second age

    DISPENSARY(2, 3, GameCardColor.GREEN, ActionSide.DOWN, 0, null, 0, false, false, 0, true, ScientistGuild.COMPASSE, false, null, Arrays.asList("APOTHECARY"), 0, BaseResource.IRON, BaseResource.IRON, BaseResource.GLASS),
    LABORATORY(2, 3, GameCardColor.GREEN, ActionSide.DOWN, 0, null, 0, false, false, 0, true, ScientistGuild.GEAR, false, null, Arrays.asList("WORKSHOP"), 0, BaseResource.CLAY, BaseResource.CLAY, BaseResource.PARCHMENT),
    LIBRARY(2, 3, GameCardColor.GREEN, ActionSide.DOWN, 0, null, 0, false, false, 0, true, ScientistGuild.NAMEPLATE, false, null, Arrays.asList("SCRIPTORIUM1"), 0, BaseResource.STONE, BaseResource.STONE, BaseResource.SILK),
    SCHOOL(2, 3, GameCardColor.GREEN, ActionSide.DOWN, 0, null, 0, false, false, 0, true, ScientistGuild.NAMEPLATE, false, null, null, 0, BaseResource.WOOD, BaseResource.PARCHMENT),

//green thierd age

    LODGE(3, 3, GameCardColor.GREEN, ActionSide.DOWN, 0, null, 0, false, false, 0, true, ScientistGuild.COMPASSE, false, null, Arrays.asList("DISPENSARY"), 0, BaseResource.CLAY, BaseResource.CLAY, BaseResource.SILK, BaseResource.PARCHMENT),
    OBSERVATORY(3, 3, GameCardColor.GREEN, ActionSide.DOWN, 0, null, 0, false, false, 0, true, ScientistGuild.GEAR, false, null, Arrays.asList("LABORATORY"), 0, BaseResource.IRON, BaseResource.IRON, BaseResource.GLASS, BaseResource.SILK),
    UNIVERSITY(3, 3, GameCardColor.GREEN, ActionSide.DOWN, 0, null, 0, false, false, 0, true, ScientistGuild.NAMEPLATE, false, null, Arrays.asList("LIBRARY"), 0, BaseResource.WOOD, BaseResource.WOOD, BaseResource.PARCHMENT, BaseResource.GLASS),
    ACADEMY(3, 3, GameCardColor.GREEN, ActionSide.DOWN, 0, null, 0, false, false, 0, true, ScientistGuild.COMPASSE, false, null, Arrays.asList("SCHOOL"), 0, BaseResource.STONE, BaseResource.STONE, BaseResource.STONE, BaseResource.GLASS),
    STUDY(3, 3, GameCardColor.GREEN, ActionSide.DOWN, 0, null, 0, false, false, 0, true, ScientistGuild.GEAR, false, null, Arrays.asList("SCHOOL"), 0, BaseResource.WOOD, BaseResource.PARCHMENT, BaseResource.SILK),


// purple card

//cards what give point for cardColor

    WORKERS_GUILDSTUDY(3, 3, GameCardColor.PURPLE, ActionSide.RIGHT_AND_LEFT, 1, null, 0, false, false, 0, false, null, true, Arrays.asList(GameCardColor.BROWN), null, 0, BaseResource.IRON, BaseResource.IRON, BaseResource.CLAY, BaseResource.STONE, BaseResource.WOOD),
    CRAFTMENS_GUILD(3, 3, GameCardColor.PURPLE, ActionSide.DOWN, 2, null, 0, false, false, 0, false, null, true, Arrays.asList(GameCardColor.SILVER), null, 0, BaseResource.IRON, BaseResource.IRON, BaseResource.STONE, BaseResource.STONE),
    TRADERS_GUILD(3, 3, GameCardColor.PURPLE, ActionSide.RIGHT_AND_LEFT, 1, null, 0, false, false, 0, false, null, true, Arrays.asList(GameCardColor.YELLOW), null, 0, BaseResource.SILK, BaseResource.GLASS, BaseResource.PARCHMENT),
    PHILOSOPHERS_GUILD(3, 3, GameCardColor.PURPLE, ActionSide.RIGHT_AND_LEFT, 1, null, 0, false, false, 0, false, null, true, Arrays.asList(GameCardColor.GREEN), null, 0, BaseResource.CLAY, BaseResource.CLAY, BaseResource.CLAY, BaseResource.SILK, BaseResource.PARCHMENT),
    SPY_GUILD(3, 3, GameCardColor.PURPLE, ActionSide.RIGHT_AND_LEFT, 1, null, 0, false, false, 0, false, null, true, Arrays.asList(GameCardColor.RED), null, 0, BaseResource.CLAY, BaseResource.CLAY, BaseResource.CLAY, BaseResource.GLASS),
    MAGISTRATES_GUILD(3, 3, GameCardColor.PURPLE, ActionSide.RIGHT_AND_LEFT, 1, null, 0, false, false, 0, false, null, true, Arrays.asList(GameCardColor.BLUE), null, 0, BaseResource.WOOD, BaseResource.WOOD, BaseResource.WOOD, BaseResource.STONE, BaseResource.GLASS),

//card what give point for 3_cardColor

    SHIPOWNERS_GUILD(3, 3, GameCardColor.PURPLE, ActionSide.RIGHT_AND_LEFT, 1, null, 0, false, false, 0, false, null, true, Arrays.asList(GameCardColor.BROWN, GameCardColor.SILVER, GameCardColor.PURPLE), null, 0, BaseResource.WOOD, BaseResource.WOOD, BaseResource.WOOD, BaseResource.STONE, BaseResource.SILK),

//card what give ScientistGuild // 11

    SCIENTISTS_GUILD(3, 3, GameCardColor.PURPLE, ActionSide.DOWN, 0, null, 0, false, false, 0, true, ScientistGuild.NAMEPLATE_OR_COMPASSE_OR_GEAR, false, null, null, 0, BaseResource.WOOD, BaseResource.WOOD, BaseResource.IRON, BaseResource.IRON, BaseResource.PARCHMENT),

//card what give point for vonderLevel

// need rebuild

    BUILDERS_GUILD(3, 3, GameCardColor.PURPLE, ActionSide.DOWN, 2, null, 0, false, false, 0, false, null, true, Arrays.asList(GameCardColor.SILVER), null, 0, BaseResource.STONE, BaseResource.STONE, BaseResource.CLAY, BaseResource.CLAY,BaseResource.GLASS),


// need realise logic for cards

// need rebuild

    STRATEGY_GUILD(3, 3, GameCardColor.PURPLE, ActionSide.DOWN, 2, null, 0, false, false, 0, false, null, true, Arrays.asList(GameCardColor.SILVER), null, 0, BaseResource.IRON, BaseResource.IRON, BaseResource.STONE, BaseResource.SILK),;

    private final int age;
    private final int userNumber; // if we have one uniqe card we no need whis field
    private final GameCardColor gameCardColor;
    private final ActionSide actionSide;
    private final int givePointForOneCard; // line 5
    private final GameResource giveResource;
    private final int armyPower;
    private final boolean tradeCard;// 8 line // all card write
    private final boolean changeGoldCard;
    private final int giveGoldForOneCard;
    private final boolean scientistGuildCard; // 11 line
    private final ScientistGuild signScientistGuild;
    private final boolean cardNeedWeedAndMix; // 13
    private final List<GameCardColor> colorCardForPointOrGold; //14
    private final List<String> chain;

    private final int goldNeededForConstruction;
    private final List<BaseResource> resourcesNeedForBuild;

    GameCard(int age, int userNumber, GameCardColor gameCardColor, ActionSide actionSide, int givePointForOneCard, GameResource giveResource, int armyPower, boolean tradeCard, boolean changeGoldCard, int giveGoldForOneCard, boolean scientistGuildCard, ScientistGuild signScientistGuild, boolean cardNeedWeedAndMix, List<GameCardColor> colorCardForPointOrGold, List<String> chain, int goldNeededForConstruction, BaseResource... resourcesNeedForBuild) {
        this.age = age;
        this.userNumber = userNumber;
        this.gameCardColor = gameCardColor;
        this.actionSide = actionSide;
        this.givePointForOneCard = givePointForOneCard;
        this.giveResource = giveResource;
        this.armyPower = armyPower;
        this.tradeCard = tradeCard;
        this.changeGoldCard = changeGoldCard;
        this.giveGoldForOneCard = giveGoldForOneCard;
        this.scientistGuildCard = scientistGuildCard;
        this.signScientistGuild = signScientistGuild;
        this.cardNeedWeedAndMix = cardNeedWeedAndMix;
        this.colorCardForPointOrGold = colorCardForPointOrGold;
        this.chain = chain;

        this.goldNeededForConstruction = goldNeededForConstruction;
        this.resourcesNeedForBuild = Collections.unmodifiableList(Arrays.asList(resourcesNeedForBuild));
    }

    @Override
    public List<Card> getAllCard(int numberPlayer, int age) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public void setField(List<Card> cards) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public boolean isResourceOf(GameCardColor color) {
        return color == gameCardColor;
    }

    @Override
    public boolean isTradeCard() {
        return false;
    }

    @Override
    public boolean isCardChangeGold() {
        return false;
    }

    @Override
    public boolean isScientistGuild() {
        return false;
    }

    @Override
    public boolean isCardNeedWeedAndMix() {
        return false;
    }

    @Override
    public GameResource getResource() {
        return null;
    }
}

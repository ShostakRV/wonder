package com.wonder.wonder.cards;

import com.wonder.wonder.cards.calc.point.CalcPointStrategy;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Creator: bm
 * Date: 15.06.17.
 */
@Getter
public enum GameCard {

// brown card first age resource card

    LUMBER_YARD(1, 3, GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.WOOD, 0, null, null, 0, BaseResource.NONE),

    STONE_PIT(1, 3, GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.STONE, 0, null, null, 0, BaseResource.NONE),

    CLAY_POOL(1, 3, GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.CLAY, 0, null, null, 0, BaseResource.NONE),

    ORE_VEIN(1, 3, GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.IRON, 0, null, null, 0, BaseResource.NONE),

// brown second age

    SAWMILL(1, 3, GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.DOUBLE_WOOD, 0, null, null, 1, BaseResource.NONE),

    QUARRY(1, 3, GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.DOUBLE_STONE, 0, null, null, 1, BaseResource.NONE),

    BRICKYARD(1, 3, GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.DOUBLE_CLAY, 0, null, null, 1, BaseResource.NONE),

    FOUNDRY(1, 3, GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.DOUBLE_IRON, 0, null, null, 1, BaseResource.NONE),


//brown half

    TREE_FARM(1, 6, GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.WOOD_OR_CLAY, 0, null, null, 1, BaseResource.NONE),
    EXCAVATION(1, 4, GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.STONE_OR_CLAY, 0, null, null, 1, BaseResource.NONE),
    CLAY_PIT(1, 3, GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.IRON_OR_CLAY, 0, null, null, 1, BaseResource.NONE),
    TIMBER_YARD(1, 3, GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.STONE_OR_WOOD, 0, null, null, 1, BaseResource.NONE),
    FOREST_CAVE(1, 5, GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.WOOD_OR_IRON, 0, null, null, 1, BaseResource.NONE),
    MINE(1, 6, GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.STONE_OR_IRON, 0, null, null, 1, BaseResource.NONE),

////silver card first + second age

    LOOM(1, 3, GameCardColor.SILVER, CalcPointStrategy.none(), GameResource.SILK, 0, null, null, 0, BaseResource.NONE),

    GLASSWORKS(1, 3, GameCardColor.SILVER, CalcPointStrategy.none(), GameResource.GLASS, 0, null, null, 0, BaseResource.NONE),

    PRESS(1, 3, GameCardColor.SILVER, CalcPointStrategy.none(), GameResource.PARCHMENT, 0, null, null, 0, BaseResource.NONE),


// Yellow card first age

    // trade card
    EAST_TRADING_POST(1, 3, GameCardColor.YELLOW, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 0, null, null, 0, BaseResource.NONE), //ActionSide.RIGHT,
    WEST_TRADING_POST(1, 3, GameCardColor.YELLOW, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 0, null, null, 0, BaseResource.NONE), //  ActionSide.LEFT,
    MARKETPLACE(1, 3, GameCardColor.YELLOW, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 0, null, null, 0, BaseResource.NONE),//  ActionSide.RIGHT_AND_LEFT,

    // give gold
    TAVERN(1, 4, GameCardColor.YELLOW, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 0, null, null, 0, BaseResource.NONE), // give money 5

// Yellow card second age

    //resouce give yellow
    CARAVANSERY(2, 3, GameCardColor.YELLOW, CalcPointStrategy.none(), GameResource.STONE_OR_IRON_OR_CLAY_OR_WOOD, 0, null, Collections.singletonList("MARKETPLACE"), 0, BaseResource.WOOD, BaseResource.WOOD),
    FORUM(2, 3, GameCardColor.YELLOW, CalcPointStrategy.none(), GameResource.SILK_OR_GLASS_OR_PARCHMENT, 0, null, Arrays.asList("EAST_TRADING_POST", "EAST_TRADING_POST"), 0, BaseResource.CLAY, BaseResource.CLAY),
    //
// end
// action                           point            color card             gold give
// ActionSide.RIGHT_AND_LEFT_AND_DOWN, 1,Arrays.asList(GameCardColor.BROWN),1
    VINEYARD(2, 3, GameCardColor.YELLOW, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 0, null, null, 0, BaseResource.NONE),

    // ActionSide.RIGHT_AND_LEFT_AND_DOWN, 2,Arrays.asList(GameCardColor.SILVER),2
    BAZAR(2, 3, GameCardColor.YELLOW, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 0, null, null, 0, BaseResource.NONE),

// thierd  age gold

//card what give point and gold for cardColor

    // action         point       color card             gold give
//ActionSide.DOWN, 1,Arrays.asList(GameCardColor.BROWN),1
    HAVEN(3, 3, GameCardColor.YELLOW, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 0, null, Collections.singletonList("DISPENSARY"), 0, BaseResource.SILK, BaseResource.IRON, BaseResource.WOOD),
    //ActionSide.DOWN, 1,Arrays.asList(GameCardColor.YELLOW),1
    LIGHTHOUSE(3, 3, GameCardColor.YELLOW, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 0, null, Collections.singletonList("CARAVANSERY"), 0, BaseResource.GLASS, BaseResource.STONE),

    //ActionSide.DOWN, 2,

    CHAMBER_OF_COMMERCE(4, 3, GameCardColor.YELLOW, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 0, null, null, 0, BaseResource.CLAY, BaseResource.CLAY, BaseResource.PARCHMENT),

    //card what give point for vonderLevel
// action     point    gold give
//ActionSide.DOWN, 1,3
    ARENA(3, 3, GameCardColor.YELLOW, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 0, null, Collections.singletonList("DISPENSARY"), 0, BaseResource.CLAY, BaseResource.CLAY, BaseResource.PARCHMENT),


//first age blue

    PAWNSHOP(1, 4, GameCardColor.BLUE, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, 0, null, null, 0, BaseResource.NONE),
    BATHS(1, 3, GameCardColor.BLUE, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, 0, null, null, 0, BaseResource.STONE),
    ALTAR(1, 3, GameCardColor.BLUE, CalcPointStrategy.simple(2), GameResource.NO_RESOURCE, 0, null, null, 0, BaseResource.NONE),
    THEATER(1, 3, GameCardColor.BLUE, CalcPointStrategy.simple(2), GameResource.NO_RESOURCE, 0, null, null, 0, BaseResource.NONE),
// second age  blue

    AQUEDUCT(2, 3, GameCardColor.BLUE, CalcPointStrategy.simple(5), GameResource.NO_RESOURCE, 0, null, Collections.singletonList("BATHS"), 0, BaseResource.STONE, BaseResource.STONE, BaseResource.STONE),
    TEMPLE(2, 3, GameCardColor.BLUE, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, 0, null, Collections.singletonList("ALTAR"), 0, BaseResource.WOOD, BaseResource.CLAY, BaseResource.GLASS),
    STATUE(2, 3, GameCardColor.BLUE, CalcPointStrategy.simple(4), GameResource.NO_RESOURCE, 0, null, Collections.singletonList("THEATER"), 0, BaseResource.WOOD, BaseResource.IRON, BaseResource.IRON),
    COURTHOUSE(2, 3, GameCardColor.BLUE, CalcPointStrategy.simple(4), GameResource.NO_RESOURCE, 0, null, Collections.singletonList("SCRIPTORIUM"), 0, BaseResource.CLAY, BaseResource.CLAY, BaseResource.SILK),

////blue thierd age

    PANTHEON(3, 3, GameCardColor.BLUE, CalcPointStrategy.simple(7), GameResource.NO_RESOURCE, 0, null, Collections.singletonList("TEMPLE"), 0, BaseResource.CLAY, BaseResource.CLAY, BaseResource.IRON, BaseResource.PARCHMENT, BaseResource.SILK, BaseResource.GLASS),
    GARDENS(3, 3, GameCardColor.BLUE, CalcPointStrategy.simple(5), GameResource.NO_RESOURCE, 0, null, Collections.singletonList("STATUE"), 0, BaseResource.WOOD, BaseResource.CLAY, BaseResource.CLAY),
    TOWN_HALL(3, 3, GameCardColor.BLUE, CalcPointStrategy.simple(6), GameResource.NO_RESOURCE, 0, null, null, 0, BaseResource.GLASS, BaseResource.IRON, BaseResource.STONE, BaseResource.STONE),
    PALACE(3, 3, GameCardColor.BLUE, CalcPointStrategy.simple(8), GameResource.NO_RESOURCE, 0, null, null, 0, BaseResource.GLASS, BaseResource.PARCHMENT, BaseResource.SILK, BaseResource.CLAY, BaseResource.WOOD, BaseResource.IRON, BaseResource.STONE),
    SENATE(3, 3, GameCardColor.BLUE, CalcPointStrategy.simple(6), GameResource.NO_RESOURCE, 0, null, Collections.singletonList("LIBRARY"), 0, BaseResource.IRON, BaseResource.STONE, BaseResource.WOOD, BaseResource.WOOD),

//first age  red

    STOCKADE(1, 3, GameCardColor.RED, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 1, null, null, 0, BaseResource.WOOD),
    BARRACKS(1, 3, GameCardColor.RED, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 1, null, null, 0, BaseResource.IRON),
    GUARD_TOWER(1, 3, GameCardColor.RED, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 1, null, null, 0, BaseResource.CLAY),

//red  second age

    WALLS(2, 3, GameCardColor.RED, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 2, null, null, 0, BaseResource.STONE, BaseResource.STONE, BaseResource.STONE),
    TRAINING_GROUND(2, 4, GameCardColor.RED, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 2, null, null, 0, BaseResource.WOOD, BaseResource.IRON, BaseResource.IRON),
    STABLES(2, 3, GameCardColor.RED, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 2, null, Collections.singletonList("APOTHECARY"), 0, BaseResource.IRON, BaseResource.CLAY, BaseResource.WOOD),// GreenCardImpl.APOTHECARY
    ARCHERY_RANGE(2, 3, GameCardColor.RED, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 2, null, Collections.singletonList("WORKSHOP"), 0, BaseResource.WOOD, BaseResource.WOOD, BaseResource.IRON),//GreenCardImpl.WORKSHOP

// red thierd age

    FORTIFICATIONS(3, 3, GameCardColor.RED, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 3, null, Collections.singletonList("WALLS"), 0, BaseResource.STONE, BaseResource.IRON, BaseResource.IRON, BaseResource.IRON),
    CIRCUS(3, 4, GameCardColor.RED, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 3, null, Collections.singletonList("TRAINING_GROUND"), 0, BaseResource.STONE, BaseResource.STONE, BaseResource.STONE, BaseResource.IRON),
    ARSENAL(3, 3, GameCardColor.RED, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 3, null, null, 0, BaseResource.IRON, BaseResource.WOOD, BaseResource.WOOD, BaseResource.SILK),
    SIEGE_WORKSHOP(3, 3, GameCardColor.RED, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 3, null, Collections.singletonList("LABORATORY"), 0, BaseResource.WOOD, BaseResource.CLAY, BaseResource.CLAY, BaseResource.CLAY),

// green first age

    APOTHECARY(1, 3, GameCardColor.GREEN, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 0, ScientistGuild.COMPASSE, null, 0, BaseResource.SILK),
    WORKSHOP(1, 3, GameCardColor.GREEN, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 0, ScientistGuild.GEAR, null, 0, BaseResource.GLASS),
    SCRIPTORIUM(1, 3, GameCardColor.GREEN, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 0, ScientistGuild.NAMEPLATE, null, 0, BaseResource.PARCHMENT),

//green  second age

    DISPENSARY(2, 3, GameCardColor.GREEN, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 0, ScientistGuild.COMPASSE, Collections.singletonList("APOTHECARY"), 0, BaseResource.IRON, BaseResource.IRON, BaseResource.GLASS),
    LABORATORY(2, 3, GameCardColor.GREEN, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 0, ScientistGuild.GEAR, Collections.singletonList("WORKSHOP"), 0, BaseResource.CLAY, BaseResource.CLAY, BaseResource.PARCHMENT),
    LIBRARY(2, 3, GameCardColor.GREEN, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 0, ScientistGuild.NAMEPLATE, Collections.singletonList("SCRIPTORIUM"), 0, BaseResource.STONE, BaseResource.STONE, BaseResource.SILK),
    SCHOOL(2, 3, GameCardColor.GREEN, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 0, ScientistGuild.NAMEPLATE, null, 0, BaseResource.WOOD, BaseResource.PARCHMENT),

//green thierd age

    LODGE(3, 3, GameCardColor.GREEN, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 0, ScientistGuild.COMPASSE, Collections.singletonList("DISPENSARY"), 0, BaseResource.CLAY, BaseResource.CLAY, BaseResource.SILK, BaseResource.PARCHMENT),
    OBSERVATORY(3, 3, GameCardColor.GREEN, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 0, ScientistGuild.GEAR, Collections.singletonList("LABORATORY"), 0, BaseResource.IRON, BaseResource.IRON, BaseResource.GLASS, BaseResource.SILK),
    UNIVERSITY(3, 3, GameCardColor.GREEN, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 0, ScientistGuild.NAMEPLATE, Collections.singletonList("LIBRARY"), 0, BaseResource.WOOD, BaseResource.WOOD, BaseResource.PARCHMENT, BaseResource.GLASS),
    ACADEMY(3, 3, GameCardColor.GREEN, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 0, ScientistGuild.COMPASSE, Collections.singletonList("SCHOOL"), 0, BaseResource.STONE, BaseResource.STONE, BaseResource.STONE, BaseResource.GLASS),
    STUDY(3, 3, GameCardColor.GREEN, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 0, ScientistGuild.GEAR, Collections.singletonList("SCHOOL"), 0, BaseResource.WOOD, BaseResource.PARCHMENT, BaseResource.SILK),


// purple card

//cards what give point for cardColor

    WORKERS_GUILDSTUDY(3, 3, GameCardColor.PURPLE, CalcPointStrategy.color(ActionSide.RIGHT_AND_LEFT, 1, Collections.singletonList(GameCardColor.BROWN)), GameResource.NO_RESOURCE, 0, null, null, 0, BaseResource.IRON, BaseResource.IRON, BaseResource.CLAY, BaseResource.STONE, BaseResource.WOOD),
    CRAFTMENS_GUILD(3, 3, GameCardColor.PURPLE, CalcPointStrategy.color(ActionSide.RIGHT_AND_LEFT, 2, Collections.singletonList(GameCardColor.SILVER)), GameResource.NO_RESOURCE, 0, null, null, 0, BaseResource.IRON, BaseResource.IRON, BaseResource.STONE, BaseResource.STONE),
    TRADERS_GUILD(3, 3, GameCardColor.PURPLE, CalcPointStrategy.color(ActionSide.RIGHT_AND_LEFT, 1, Collections.singletonList(GameCardColor.YELLOW)), GameResource.NO_RESOURCE, 0, null, null, 0, BaseResource.SILK, BaseResource.GLASS, BaseResource.PARCHMENT),
    PHILOSOPHERS_GUILD(3, 3, GameCardColor.PURPLE, CalcPointStrategy.color(ActionSide.RIGHT_AND_LEFT, 1, Collections.singletonList(GameCardColor.GREEN)), GameResource.NO_RESOURCE, 0, null, null, 0, BaseResource.CLAY, BaseResource.CLAY, BaseResource.CLAY, BaseResource.SILK, BaseResource.PARCHMENT),
    SPY_GUILD(3, 3, GameCardColor.PURPLE, CalcPointStrategy.color(ActionSide.RIGHT_AND_LEFT, 1, Collections.singletonList(GameCardColor.RED)), GameResource.NO_RESOURCE, 0, null, null, 0, BaseResource.CLAY, BaseResource.CLAY, BaseResource.CLAY, BaseResource.GLASS),
    MAGISTRATES_GUILD(3, 3, GameCardColor.PURPLE, CalcPointStrategy.color(ActionSide.RIGHT_AND_LEFT, 1, Collections.singletonList(GameCardColor.BLUE)), GameResource.NO_RESOURCE, 0, null, null, 0, BaseResource.WOOD, BaseResource.WOOD, BaseResource.WOOD, BaseResource.STONE, BaseResource.GLASS),

//card what give point for 3_cardColor

    SHIPOWNERS_GUILD(3, 3, GameCardColor.PURPLE, CalcPointStrategy.color(ActionSide.DOWN, 1, Arrays.asList(GameCardColor.BROWN, GameCardColor.SILVER, GameCardColor.PURPLE)), GameResource.NO_RESOURCE, 0, null, null, 0, BaseResource.WOOD, BaseResource.WOOD, BaseResource.WOOD, BaseResource.STONE, BaseResource.SILK),

//card what give ScientistGuild // 11

    SCIENTISTS_GUILD(3, 3, GameCardColor.PURPLE, CalcPointStrategy.none(), GameResource.NO_RESOURCE, 0, ScientistGuild.NAMEPLATE_OR_COMPASSE_OR_GEAR, null, 0, BaseResource.WOOD, BaseResource.WOOD, BaseResource.IRON, BaseResource.IRON, BaseResource.PARCHMENT),

//card what give point for vonderLevel

// need rebuild

    BUILDERS_GUILD(3, 3, GameCardColor.PURPLE, CalcPointStrategy.wonderLevel(ActionSide.RIGHT_AND_LEFT_AND_DOWN, 1), GameResource.NO_RESOURCE, 0, ScientistGuild.NONE, noChains(), 0, BaseResource.STONE, BaseResource.STONE, BaseResource.CLAY, BaseResource.CLAY, BaseResource.GLASS),


    STRATEGY_GUILD(3, 3, GameCardColor.PURPLE, CalcPointStrategy.warLoose(ActionSide.DOWN), GameResource.NO_RESOURCE, 0, ScientistGuild.NONE, noChains(), 0, BaseResource.IRON, BaseResource.IRON, BaseResource.STONE, BaseResource.SILK),;


    private final int age;
    private final int userNumber;
    private final CalcPointStrategy strategy;
    private final GameCardColor gameCardColor;
    private final GameResource giveResource;
    private final int armyPower;
    private final ScientistGuild signScientistGuild;

    private final List<String> chain;
    private final int goldNeededForConstruction;
    private final List<BaseResource> resourcesNeedForBuild;

    // boolen tradeCard;
    // int changeGold;


    GameCard(int age, int userNumber, GameCardColor gameCardColor, CalcPointStrategy calcPointStrategy, GameResource giveResource,
             int armyPower, ScientistGuild signScientistGuild, List<String> chain, int goldNeededForConstruction,
             BaseResource... resourcesNeedForBuild) {
        this.age = age;
        this.userNumber = userNumber;
        this.strategy = calcPointStrategy;
        this.gameCardColor = gameCardColor;
        this.giveResource = giveResource;
        this.armyPower = armyPower; // to think, probaly it can be strategy
        this.signScientistGuild = signScientistGuild;

        this.chain = chain;
        this.goldNeededForConstruction = goldNeededForConstruction;
        this.resourcesNeedForBuild = Collections.unmodifiableList(Arrays.asList(resourcesNeedForBuild));
    }

    private static List<String> noChains() {
        return Collections.emptyList();
    }

    public boolean isResourceOf(GameCardColor color) {
        return color == gameCardColor;
    }

    public boolean isTradeCard() {
        return false;
    }

    public boolean isCardChangeGold() {
        return false;
    }

    public boolean isScientistGuild() {
        return false;
    }

    public boolean isCardNeedWeedAndMix() {
        return false;
    }

    public GameResource getResource() {
        return null;
    }
}

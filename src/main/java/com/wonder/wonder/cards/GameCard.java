package com.wonder.wonder.cards;

import com.wonder.wonder.cards.calc.point.CalcPointStrategy;
import com.wonder.wonder.cards.events.OnBuildEvent;
import com.wonder.wonder.cards.passiveAbility.OnBuildAbility;
import com.wonder.wonder.cards.warPoint.WarPoint;
import lombok.Getter;

import java.util.ArrayList;
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
// 3, 4
    LUMBER_YARD(1, players(3,4), GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.WOOD, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.NONE),
    // 3.5
    STONE_PIT(1, players(3,5), GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.STONE, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.NONE),
//3.5
    CLAY_POOL(1, players(3,5), GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.CLAY, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.NONE),
//3.4
    ORE_VEIN(1, players(3,4), GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.IRON, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.NONE),

// brown second age
//3.4
    SAWMILL(2, players(3,4), GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.DOUBLE_WOOD, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.NONE),
    //3.4
    QUARRY(2, players(3,4), GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.DOUBLE_STONE, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.NONE),
    //3.4
    BRICKYARD(2, players(3,4), GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.DOUBLE_CLAY, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.NONE),
    //3.4
    FOUNDRY(2, players(3,4), GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.DOUBLE_IRON, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.NONE),


//brown half

    TREE_FARM(1, players(6), GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.WOOD_OR_CLAY, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.NONE),
    EXCAVATION(1, players(4), GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.STONE_OR_CLAY, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.NONE),
    CLAY_PIT(1, players(3), GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.IRON_OR_CLAY, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.NONE),
    TIMBER_YARD(1, players(3), GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.STONE_OR_WOOD, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.NONE),
    FOREST_CAVE(1, players(5), GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.WOOD_OR_IRON, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.NONE),
    MINE(1, players(6), GameCardColor.BROWN, CalcPointStrategy.none(), GameResource.STONE_OR_IRON, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.NONE),

////silver card first + second age
//3.6
    LOOM(1, players(3,6), GameCardColor.SILVER, CalcPointStrategy.none(), GameResource.SILK, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.NONE),
//3.6
    GLASSWORKS(1, players(3,6), GameCardColor.SILVER, CalcPointStrategy.none(), GameResource.GLASS, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.NONE),
//3.6
    PRESS(1, players(3,6), GameCardColor.SILVER, CalcPointStrategy.none(), GameResource.PARCHMENT, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.NONE),
// second age
    //3.5
    //3.5
    //3.5

// Yellow card first age

    // trade card
    //3.7
    EAST_TRADING_POST(1, players(3,7), GameCardColor.YELLOW, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.NONE),
//3.7
    WEST_TRADING_POST(1, players(3,7), GameCardColor.YELLOW, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.NONE),
//3.6
    MARKETPLACE(1, players(3,6), GameCardColor.YELLOW, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(),  0, OnBuildEvent.none(), BaseResource.NONE),

    // give gold
    //4.5.7
    TAVERN(1, players(4,5,7), GameCardColor.YELLOW, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.receiveGold(ActionSide.DOWN, 5), BaseResource.NONE),

// Yellow card second age

    //resouce give yellow
//3.5.6
    CARAVANSERY(2, players(3,5,6), GameCardColor.YELLOW, CalcPointStrategy.none(), GameResource.STONE_OR_IRON_OR_CLAY_OR_WOOD, WarPoint.simple(0), ScientistGuild.NONE, Collections.singletonList("MARKETPLACE"), 0, OnBuildEvent.none(), BaseResource.WOOD, BaseResource.WOOD),
// 3.6.7
    FORUM(2, players(3,6,7), GameCardColor.YELLOW, CalcPointStrategy.none(), GameResource.SILK_OR_GLASS_OR_PARCHMENT, WarPoint.simple(0), ScientistGuild.NONE, Arrays.asList("EAST_TRADING_POST", "EAST_TRADING_POST"), 0, OnBuildEvent.none(), BaseResource.CLAY, BaseResource.CLAY),
    //
// end
//3.6
    VINEYARD(2, players(3,6), GameCardColor.YELLOW, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.receiveGoldByColorCard(ActionSide.RIGHT_AND_LEFT_AND_DOWN, 1, GameCardColor.BROWN), BaseResource.NONE),

//4.7
    BAZAR(2, players(4,7), GameCardColor.YELLOW, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.receiveGoldByColorCard(ActionSide.RIGHT_AND_LEFT_AND_DOWN, 2, GameCardColor.SILVER), BaseResource.NONE),

// thierd  age gold

//card what give point and gold for cardColor

//3.4
    HAVEN(3, players(3,4), GameCardColor.YELLOW, CalcPointStrategy.color(ActionSide.DOWN, 1, Collections.singletonList(GameCardColor.BROWN)), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, Collections.singletonList("DISPENSARY"), 0, OnBuildEvent.receiveGoldByColorCard(ActionSide.DOWN, 1, GameCardColor.BROWN), BaseResource.SILK, BaseResource.IRON, BaseResource.WOOD),
//3.6
    LIGHTHOUSE(3, players(3,6), GameCardColor.YELLOW, CalcPointStrategy.color(ActionSide.DOWN, 1, Collections.singletonList(GameCardColor.YELLOW)), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, Collections.singletonList("CARAVANSERY"), 0, OnBuildEvent.receiveGoldByColorCard(ActionSide.DOWN, 1, GameCardColor.YELLOW), BaseResource.GLASS, BaseResource.STONE),

//4.6
    CHAMBER_OF_COMMERCE(3, players(4,6), GameCardColor.YELLOW, CalcPointStrategy.color(ActionSide.DOWN, 2, Collections.singletonList(GameCardColor.SILVER)), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.receiveGoldByColorCard(ActionSide.DOWN, 2, GameCardColor.SILVER), BaseResource.CLAY, BaseResource.CLAY, BaseResource.PARCHMENT),

    //card what give point for vonderLevel

//3.5.7
    ARENA(3, players(3,5,7), GameCardColor.YELLOW, CalcPointStrategy.wonderLevel(ActionSide.DOWN, 1), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, Collections.singletonList("DISPENSARY"), 0, OnBuildEvent.receiveGoldByWonder(ActionSide.DOWN, 3), BaseResource.CLAY, BaseResource.CLAY, BaseResource.PARCHMENT),


//first age blue
//4.7
    PAWNSHOP(1, players(4,7), GameCardColor.BLUE, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.NONE),
//3.7
    BATHS(1, players(3,7), GameCardColor.BLUE, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.STONE),
//3.5
    ALTAR(1, players(3,5), GameCardColor.BLUE, CalcPointStrategy.simple(2), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.NONE),
//3.6
    THEATER(1, players(3,6), GameCardColor.BLUE, CalcPointStrategy.simple(2), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.NONE),
// second age  blue
//3.7
    AQUEDUCT(2, players(3,7), GameCardColor.BLUE, CalcPointStrategy.simple(5), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, Collections.singletonList("BATHS"), 0, OnBuildEvent.none(), BaseResource.STONE, BaseResource.STONE, BaseResource.STONE),
//3.6
    TEMPLE(2, players(3,6), GameCardColor.BLUE, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, Collections.singletonList("ALTAR"), 0, OnBuildEvent.none(), BaseResource.WOOD, BaseResource.CLAY, BaseResource.GLASS),
//3.7
    STATUE(2, players(3,7), GameCardColor.BLUE, CalcPointStrategy.simple(4), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, Collections.singletonList("THEATER"), 0, OnBuildEvent.none(), BaseResource.WOOD, BaseResource.IRON, BaseResource.IRON),
//3.5
    COURTHOUSE(2, players(3,5), GameCardColor.BLUE, CalcPointStrategy.simple(4), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, Collections.singletonList("SCRIPTORIUM"), 0, OnBuildEvent.none(), BaseResource.CLAY, BaseResource.CLAY, BaseResource.SILK),

////blue thierd age
//3.6
    PANTHEON(3, players(3,6), GameCardColor.BLUE, CalcPointStrategy.simple(7), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, Collections.singletonList("TEMPLE"), 0, OnBuildEvent.none(), BaseResource.CLAY, BaseResource.CLAY, BaseResource.IRON, BaseResource.PARCHMENT, BaseResource.SILK, BaseResource.GLASS),
//3.4
    GARDENS(3, players(3,4), GameCardColor.BLUE, CalcPointStrategy.simple(5), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, Collections.singletonList("STATUE"), 0, OnBuildEvent.none(), BaseResource.WOOD, BaseResource.CLAY, BaseResource.CLAY),
//3.5.6
    TOWN_HALL(3, players(3,5,6), GameCardColor.BLUE, CalcPointStrategy.simple(6), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.GLASS, BaseResource.IRON, BaseResource.STONE, BaseResource.STONE),
//3.7
    PALACE(3, players(3,7), GameCardColor.BLUE, CalcPointStrategy.simple(8), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.GLASS, BaseResource.PARCHMENT, BaseResource.SILK, BaseResource.CLAY, BaseResource.WOOD, BaseResource.IRON, BaseResource.STONE),
//3.5
    SENATE(3, players(3,5), GameCardColor.BLUE, CalcPointStrategy.simple(6), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, Collections.singletonList("LIBRARY"), 0, OnBuildEvent.none(), BaseResource.IRON, BaseResource.STONE, BaseResource.WOOD, BaseResource.WOOD),

//first age  red
//3.7
    STOCKADE(1, players(3,7), GameCardColor.RED, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(1), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.WOOD),
//3.5
    BARRACKS(1, players(3,5), GameCardColor.RED, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(1), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.IRON),
//3.4
    GUARD_TOWER(1, players(3,4), GameCardColor.RED, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(1), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.CLAY),

//red  second age
//3.7
    WALLS(2, players(3,7), GameCardColor.RED, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(2), null, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.STONE, BaseResource.STONE, BaseResource.STONE),
//4.6.7
    TRAINING_GROUND(2, players(4,6,7), GameCardColor.RED, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(2), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.WOOD, BaseResource.IRON, BaseResource.IRON),
//3.5
    STABLES(2, players(3,5), GameCardColor.RED, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(2), ScientistGuild.NONE, Collections.singletonList("APOTHECARY"), 0, OnBuildEvent.none(), BaseResource.IRON, BaseResource.CLAY, BaseResource.WOOD),
//3.6
    ARCHERY_RANGE(2, players(3,6), GameCardColor.RED, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(2), ScientistGuild.NONE, Collections.singletonList("WORKSHOP"), 0, OnBuildEvent.none(), BaseResource.WOOD, BaseResource.WOOD, BaseResource.IRON),

// red thierd age
//3.7
    FORTIFICATIONS(3, players(3,7), GameCardColor.RED, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(3), ScientistGuild.NONE, Collections.singletonList("WALLS"), 0, OnBuildEvent.none(), BaseResource.STONE, BaseResource.IRON, BaseResource.IRON, BaseResource.IRON),
    //4.5.6
    CIRCUS(3, players(4,5,6), GameCardColor.RED, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(3), ScientistGuild.NONE, Collections.singletonList("TRAINING_GROUND"), 0, OnBuildEvent.none(), BaseResource.STONE, BaseResource.STONE, BaseResource.STONE, BaseResource.IRON),
//3.4.7
    ARSENAL(3, players(3,4,7), GameCardColor.RED, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(3), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.IRON, BaseResource.WOOD, BaseResource.WOOD, BaseResource.SILK),
//3.5
    SIEGE_WORKSHOP(3, players(3,5), GameCardColor.RED, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(3), ScientistGuild.NONE, Collections.singletonList("LABORATORY"), 0, OnBuildEvent.none(), BaseResource.WOOD, BaseResource.CLAY, BaseResource.CLAY, BaseResource.CLAY),

// green first age
//3.5
    APOTHECARY(1, players(3,5), GameCardColor.GREEN, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.COMPASSE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.SILK),
//3.7
    WORKSHOP(1, players(3,7), GameCardColor.GREEN, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.GEAR, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.GLASS),
//3.4
    SCRIPTORIUM(1, players(3,4), GameCardColor.GREEN, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NAMEPLATE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.PARCHMENT),

//green  second age
//3.4
    DISPENSARY(2, players(3,4), GameCardColor.GREEN, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.COMPASSE, Collections.singletonList("APOTHECARY"), 0, OnBuildEvent.none(), BaseResource.IRON, BaseResource.IRON, BaseResource.GLASS),
//3.5
    LABORATORY(2, players(3,5), GameCardColor.GREEN, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.GEAR, Collections.singletonList("WORKSHOP"), 0, OnBuildEvent.none(), BaseResource.CLAY, BaseResource.CLAY, BaseResource.PARCHMENT),
//3.6
    LIBRARY(2, players(3,6), GameCardColor.GREEN, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NAMEPLATE, Collections.singletonList("SCRIPTORIUM"), 0, OnBuildEvent.none(), BaseResource.STONE, BaseResource.STONE, BaseResource.SILK),
//3.7
    SCHOOL(2, players(3,7), GameCardColor.GREEN, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NAMEPLATE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.WOOD, BaseResource.PARCHMENT),

//green thierd age
//3.6
    LODGE(3, players(3,6), GameCardColor.GREEN, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.COMPASSE, Collections.singletonList("DISPENSARY"), 0, OnBuildEvent.none(), BaseResource.CLAY, BaseResource.CLAY, BaseResource.SILK, BaseResource.PARCHMENT),
//3.7
    OBSERVATORY(3, players(3,7), GameCardColor.GREEN, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.GEAR, Collections.singletonList("LABORATORY"), 0, OnBuildEvent.none(), BaseResource.IRON, BaseResource.IRON, BaseResource.GLASS, BaseResource.SILK),
//3.4
    UNIVERSITY(3, players(3,4), GameCardColor.GREEN, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NAMEPLATE, Collections.singletonList("LIBRARY"), 0, OnBuildEvent.none(), BaseResource.WOOD, BaseResource.WOOD, BaseResource.PARCHMENT, BaseResource.GLASS),
//3.7
    ACADEMY(3, players(3,7), GameCardColor.GREEN, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.COMPASSE, Collections.singletonList("SCHOOL"), 0, OnBuildEvent.none(), BaseResource.STONE, BaseResource.STONE, BaseResource.STONE, BaseResource.GLASS),
//3.5
    STUDY(3, players(3,5), GameCardColor.GREEN, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.GEAR, Collections.singletonList("SCHOOL"), 0, OnBuildEvent.none(), BaseResource.WOOD, BaseResource.PARCHMENT, BaseResource.SILK),


// purple card

//cards what give point for cardColor

    WORKERS_GUILDSTUDY(3, players(3), GameCardColor.PURPLE, CalcPointStrategy.color(ActionSide.RIGHT_AND_LEFT, 1, Collections.singletonList(GameCardColor.BROWN)), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.IRON, BaseResource.IRON, BaseResource.CLAY, BaseResource.STONE, BaseResource.WOOD),

    CRAFTMENS_GUILD(3, players(3), GameCardColor.PURPLE, CalcPointStrategy.color(ActionSide.RIGHT_AND_LEFT, 2, Collections.singletonList(GameCardColor.SILVER)), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.IRON, BaseResource.IRON, BaseResource.STONE, BaseResource.STONE),

    TRADERS_GUILD(3, players(3), GameCardColor.PURPLE, CalcPointStrategy.color(ActionSide.RIGHT_AND_LEFT, 1, Collections.singletonList(GameCardColor.YELLOW)), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.SILK, BaseResource.GLASS, BaseResource.PARCHMENT),

    PHILOSOPHERS_GUILD(3, players(3), GameCardColor.PURPLE, CalcPointStrategy.color(ActionSide.RIGHT_AND_LEFT, 1, Collections.singletonList(GameCardColor.GREEN)), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.CLAY, BaseResource.CLAY, BaseResource.CLAY, BaseResource.SILK, BaseResource.PARCHMENT),

    SPY_GUILD(3, players(3), GameCardColor.PURPLE, CalcPointStrategy.color(ActionSide.RIGHT_AND_LEFT, 1, Collections.singletonList(GameCardColor.RED)), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.CLAY, BaseResource.CLAY, BaseResource.CLAY, BaseResource.GLASS),

    MAGISTRATES_GUILD(3, players(3), GameCardColor.PURPLE, CalcPointStrategy.color(ActionSide.RIGHT_AND_LEFT, 1, Collections.singletonList(GameCardColor.BLUE)), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.WOOD, BaseResource.WOOD, BaseResource.WOOD, BaseResource.STONE, BaseResource.GLASS),

//card what give point for 3_cardColor

    SHIPOWNERS_GUILD(3, players(3), GameCardColor.PURPLE, CalcPointStrategy.color(ActionSide.DOWN, 1, Arrays.asList(GameCardColor.BROWN, GameCardColor.SILVER, GameCardColor.PURPLE)), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.WOOD, BaseResource.WOOD, BaseResource.WOOD, BaseResource.STONE, BaseResource.SILK),

//card what give ScientistGuild // 1

    SCIENTISTS_GUILD(3, players(3), GameCardColor.PURPLE, CalcPointStrategy.none(), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NAMEPLATE_OR_COMPASSE_OR_GEAR, new ArrayList<>(), 0, OnBuildEvent.none(), BaseResource.WOOD, BaseResource.WOOD, BaseResource.IRON, BaseResource.IRON, BaseResource.PARCHMENT),

//card what give point for vonderLevel


    BUILDERS_GUILD(3, players(3), GameCardColor.PURPLE, CalcPointStrategy.wonderLevel(ActionSide.RIGHT_AND_LEFT_AND_DOWN, 1), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, noChains(), 0, OnBuildEvent.none(), BaseResource.STONE, BaseResource.STONE, BaseResource.CLAY, BaseResource.CLAY, BaseResource.GLASS),


    STRATEGY_GUILD(3, players(3), GameCardColor.PURPLE, CalcPointStrategy.warLoose(ActionSide.DOWN), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, noChains(), 0, OnBuildEvent.none(), BaseResource.IRON, BaseResource.IRON, BaseResource.STONE, BaseResource.SILK),;


    private final int age;
    private final List<Integer> onPlayers;
    private final CalcPointStrategy strategy;
    private final GameCardColor gameCardColor;
    private final GameResource giveResource;
    private final WarPoint armyPower;
    private final ScientistGuild signScientistGuild;
    private final List<String> chain;
    private final int goldNeededForConstruction;
    private final OnBuildEvent onBuildEvent;
    private final List<BaseResource> resourcesNeedForBuild;



    GameCard(int age, List<Integer> onPlayers, GameCardColor gameCardColor, CalcPointStrategy calcPointStrategy, GameResource giveResource,
             WarPoint armyPower, ScientistGuild signScientistGuild, List<String> chain, int goldNeededForConstruction,
             OnBuildEvent onBuildEvent, BaseResource... resourcesNeedForBuild) {
        this.age = age;
        this.onPlayers = onPlayers;
        this.strategy = calcPointStrategy;
        this.gameCardColor = gameCardColor;
        this.giveResource = giveResource;
        this.armyPower = armyPower;
        this.signScientistGuild = signScientistGuild;
        this.chain = chain;
        this.goldNeededForConstruction = goldNeededForConstruction;
        this.onBuildEvent = onBuildEvent;
        this.resourcesNeedForBuild = Collections.unmodifiableList(Arrays.asList(resourcesNeedForBuild));
    }

    private static List<String> noChains() {
        return Collections.emptyList();
    }

    private static List<Integer> players(Integer... players) {
        return Collections.unmodifiableList(Arrays.asList(players));
    }

    public boolean isResourceOf(GameCardColor color) {
        return color == gameCardColor;
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

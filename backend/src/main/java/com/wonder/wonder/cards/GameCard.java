package com.wonder.wonder.cards;

import com.wonder.wonder.cards.calc.point.CalcPointStrategy;
import com.wonder.wonder.cards.events.OnBuildEvent;
import com.wonder.wonder.cards.passiveAbility.TradeDiscount;
import com.wonder.wonder.cards.warPoint.WarPoint;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.wonder.wonder.cards.GameCardColor.BROWN;
import static com.wonder.wonder.cards.GameResource.*;
import static com.wonder.wonder.cards.GameResource.WOOD;
import static com.wonder.wonder.cards.calc.point.CalcPointStrategy.nonePoints;
import static com.wonder.wonder.cards.events.OnBuildEvent.emptyBuildEvent;
import static com.wonder.wonder.cards.warPoint.WarPoint.warPoint;

/**
 * Creator: bm
 * Date: 15.06.17.
 */
@Getter
public enum GameCard {

    // brown card first age resource card
// 3, 4
    LUMBER_YARD(1, players(3, 4), BROWN, nonePoints(), WOOD, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),
    // 3.5
    STONE_PIT(1, players(3, 5), BROWN, nonePoints(), STONE, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),
    //3.5
    CLAY_POOL(1, players(3, 5), BROWN, nonePoints(), CLAY, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),
    //3.4
    ORE_VEIN(1, players(3, 4), BROWN, nonePoints(), IRON, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),

    // brown second age
//3.4
    SAWMILL(2, players(3, 4), BROWN, nonePoints(), DOUBLE_WOOD, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),
    //3.4
    QUARRY(2, players(3, 4), BROWN, nonePoints(), DOUBLE_STONE, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),
    //3.4
    BRICKYARD(2, players(3, 4), BROWN, nonePoints(), DOUBLE_CLAY, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),
    //3.4
    FOUNDRY(2, players(3, 4), BROWN, nonePoints(), DOUBLE_IRON, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),


//brown half

    TREE_FARM(1, players(6), BROWN, nonePoints(), WOOD_OR_CLAY, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),
    EXCAVATION(1, players(4), BROWN, nonePoints(), STONE_OR_CLAY, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),
    CLAY_PIT(1, players(3), BROWN, nonePoints(), IRON_OR_CLAY, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),
    TIMBER_YARD(1, players(3), BROWN, nonePoints(), STONE_OR_WOOD, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),
    FOREST_CAVE(1, players(5), BROWN, nonePoints(), WOOD_OR_IRON, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),
    MINE(1, players(6), BROWN, nonePoints(), STONE_OR_IRON, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),

    ////silver card first + second age
//3.6
    LOOM(1, players(3, 6), GameCardColor.SILVER, nonePoints(), SILK, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),
    //3.6
    GLASSWORKS(1, players(3, 6), GameCardColor.SILVER, nonePoints(), GLASS, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),
    //3.6
    PRESS(1, players(3, 6), GameCardColor.SILVER, nonePoints(), PARCHMENT, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),
// second age
    //3.5
    //3.5
    //3.5

// Yellow card first age

    // trade card
    //3.7
    EAST_TRADING_POST(1, players(3, 7), GameCardColor.YELLOW, nonePoints(), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),
    //3.7
    WEST_TRADING_POST(1, players(3, 7), GameCardColor.YELLOW, nonePoints(), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),
    //3.6
    MARKETPLACE(1, players(3, 6), GameCardColor.YELLOW, nonePoints(), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),

    // give gold
    //4.5.7
    TAVERN(1, players(4, 5, 7), GameCardColor.YELLOW, nonePoints(), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), OnBuildEvent.receiveGold(ActionSide.DOWN, 5)),

// Yellow card second age

    //resouce give yellow
//3.5.6
    CARAVANSERY(2, players(3, 5, 6), GameCardColor.YELLOW, nonePoints(), STONE_OR_IRON_OR_CLAY_OR_WOOD, warPoint(0), ScientistGuild.NONE, Collections.singletonList("MARKETPLACE"), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.WOOD, BaseResource.WOOD),
    // 3.6.7
    FORUM(2, players(3, 6, 7), GameCardColor.YELLOW, nonePoints(), SILK_OR_GLASS_OR_PARCHMENT, warPoint(0), ScientistGuild.NONE, Arrays.asList("EAST_TRADING_POST", "EAST_TRADING_POST"), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.CLAY, BaseResource.CLAY),
    //
// end
//3.6
    VINEYARD(2, players(3, 6), GameCardColor.YELLOW, nonePoints(), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), OnBuildEvent.receiveGoldByColorCard(ActionSide.RIGHT_AND_LEFT_AND_DOWN, 1, BROWN)),

    //4.7
    BAZAR(2, players(4, 7), GameCardColor.YELLOW, nonePoints(), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), OnBuildEvent.receiveGoldByColorCard(ActionSide.RIGHT_AND_LEFT_AND_DOWN, 2, GameCardColor.SILVER)),

// thierd  age gold

//card what give point and gold for cardColor

    //3.4
    HAVEN(3, players(3, 4), GameCardColor.YELLOW, CalcPointStrategy.color(ActionSide.DOWN, 1, Collections.singletonList(BROWN)), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, Collections.singletonList("DISPENSARY"), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), OnBuildEvent.receiveGoldByColorCard(ActionSide.DOWN, 1, BROWN), BaseResource.SILK, BaseResource.IRON, BaseResource.WOOD),
    //3.6
    LIGHTHOUSE(3, players(3, 6), GameCardColor.YELLOW, CalcPointStrategy.color(ActionSide.DOWN, 1, Collections.singletonList(GameCardColor.YELLOW)), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, Collections.singletonList("CARAVANSERY"), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), OnBuildEvent.receiveGoldByColorCard(ActionSide.DOWN, 1, GameCardColor.YELLOW), BaseResource.GLASS, BaseResource.STONE),

    //4.6
    CHAMBER_OF_COMMERCE(3, players(4, 6), GameCardColor.YELLOW, CalcPointStrategy.color(ActionSide.DOWN, 2, Collections.singletonList(GameCardColor.SILVER)), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), OnBuildEvent.receiveGoldByColorCard(ActionSide.DOWN, 2, GameCardColor.SILVER), BaseResource.CLAY, BaseResource.CLAY, BaseResource.PARCHMENT),

    //card what give point for vonderLevel

    //3.5.7
    ARENA(3, players(3, 5, 7), GameCardColor.YELLOW, CalcPointStrategy.wonderLevel(ActionSide.DOWN, 1), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, Collections.singletonList("DISPENSARY"), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), OnBuildEvent.receiveGoldByWonder(ActionSide.DOWN, 3), BaseResource.CLAY, BaseResource.CLAY, BaseResource.PARCHMENT),


    //first age blue
//4.7
    PAWNSHOP(1, players(4, 7), GameCardColor.BLUE, CalcPointStrategy.simple(3), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),
    //3.7
    BATHS(1, players(3, 7), GameCardColor.BLUE, CalcPointStrategy.simple(3), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.STONE),
    //3.5
    ALTAR(1, players(3, 5), GameCardColor.BLUE, CalcPointStrategy.simple(2), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),
    //3.6
    THEATER(1, players(3, 6), GameCardColor.BLUE, CalcPointStrategy.simple(2), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),
    // second age  blue
//3.7
    AQUEDUCT(2, players(3, 7), GameCardColor.BLUE, CalcPointStrategy.simple(5), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, Collections.singletonList("BATHS"), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.STONE, BaseResource.STONE, BaseResource.STONE),
    //3.6
    TEMPLE(2, players(3, 6), GameCardColor.BLUE, CalcPointStrategy.simple(3), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, Collections.singletonList("ALTAR"), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.WOOD, BaseResource.CLAY, BaseResource.GLASS),
    //3.7
    STATUE(2, players(3, 7), GameCardColor.BLUE, CalcPointStrategy.simple(4), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, Collections.singletonList("THEATER"), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.WOOD, BaseResource.IRON, BaseResource.IRON),
    //3.5
    COURTHOUSE(2, players(3, 5), GameCardColor.BLUE, CalcPointStrategy.simple(4), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, Collections.singletonList("SCRIPTORIUM"), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.CLAY, BaseResource.CLAY, BaseResource.SILK),

    ////blue thierd age
//3.6
    PANTHEON(3, players(3, 6), GameCardColor.BLUE, CalcPointStrategy.simple(7), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, Collections.singletonList("TEMPLE"), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.CLAY, BaseResource.CLAY, BaseResource.IRON, BaseResource.PARCHMENT, BaseResource.SILK, BaseResource.GLASS),
    //3.4
    GARDENS(3, players(3, 4), GameCardColor.BLUE, CalcPointStrategy.simple(5), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, Collections.singletonList("STATUE"), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.WOOD, BaseResource.CLAY, BaseResource.CLAY),
    //3.5.6
    TOWN_HALL(3, players(3, 5, 6), GameCardColor.BLUE, CalcPointStrategy.simple(6), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.GLASS, BaseResource.IRON, BaseResource.STONE, BaseResource.STONE),
    //3.7
    PALACE(3, players(3, 7), GameCardColor.BLUE, CalcPointStrategy.simple(8), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.GLASS, BaseResource.PARCHMENT, BaseResource.SILK, BaseResource.CLAY, BaseResource.WOOD, BaseResource.IRON, BaseResource.STONE),
    //3.5
    SENATE(3, players(3, 5), GameCardColor.BLUE, CalcPointStrategy.simple(6), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, Collections.singletonList("LIBRARY"), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.IRON, BaseResource.STONE, BaseResource.WOOD, BaseResource.WOOD),

    //first age  red
//3.7
    STOCKADE(1, players(3, 7), GameCardColor.RED, nonePoints(), NO_RESOURCE, warPoint(1), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.WOOD),
    //3.5
    BARRACKS(1, players(3, 5), GameCardColor.RED, nonePoints(), NO_RESOURCE, warPoint(1), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.IRON),
    //3.4
    GUARD_TOWER(1, players(3, 4), GameCardColor.RED, nonePoints(), NO_RESOURCE, warPoint(1), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.CLAY),

    //red  second age
//3.7
    WALLS(2, players(3, 7), GameCardColor.RED, nonePoints(), NO_RESOURCE, warPoint(2), null, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.STONE, BaseResource.STONE, BaseResource.STONE),
    //4.6.7
    TRAINING_GROUND(2, players(4, 6, 7), GameCardColor.RED, nonePoints(), NO_RESOURCE, warPoint(2), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.WOOD, BaseResource.IRON, BaseResource.IRON),
    //3.5
    STABLES(2, players(3, 5), GameCardColor.RED, nonePoints(), NO_RESOURCE, warPoint(2), ScientistGuild.NONE, Collections.singletonList("APOTHECARY"), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.IRON, BaseResource.CLAY, BaseResource.WOOD),
    //3.6
    ARCHERY_RANGE(2, players(3, 6), GameCardColor.RED, nonePoints(), NO_RESOURCE, warPoint(2), ScientistGuild.NONE, Collections.singletonList("WORKSHOP"), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.WOOD, BaseResource.WOOD, BaseResource.IRON),

    // red thierd age
//3.7
    FORTIFICATIONS(3, players(3, 7), GameCardColor.RED, nonePoints(), NO_RESOURCE, warPoint(3), ScientistGuild.NONE, Collections.singletonList("WALLS"), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.STONE, BaseResource.IRON, BaseResource.IRON, BaseResource.IRON),
    //4.5.6
    CIRCUS(3, players(4, 5, 6), GameCardColor.RED, nonePoints(), NO_RESOURCE, warPoint(3), ScientistGuild.NONE, Collections.singletonList("TRAINING_GROUND"), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.STONE, BaseResource.STONE, BaseResource.STONE, BaseResource.IRON),
    //3.4.7
    ARSENAL(3, players(3, 4, 7), GameCardColor.RED, nonePoints(), NO_RESOURCE, warPoint(3), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.IRON, BaseResource.WOOD, BaseResource.WOOD, BaseResource.SILK),
    //3.5
    SIEGE_WORKSHOP(3, players(3, 5), GameCardColor.RED, nonePoints(), NO_RESOURCE, warPoint(3), ScientistGuild.NONE, Collections.singletonList("LABORATORY"), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.WOOD, BaseResource.CLAY, BaseResource.CLAY, BaseResource.CLAY),

    // green first age
//3.5
    APOTHECARY(1, players(3, 5), GameCardColor.GREEN, nonePoints(), NO_RESOURCE, warPoint(0), ScientistGuild.COMPASSE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.SILK),
    //3.7
    WORKSHOP(1, players(3, 7), GameCardColor.GREEN, nonePoints(), NO_RESOURCE, warPoint(0), ScientistGuild.GEAR, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.GLASS),
    //3.4
    SCRIPTORIUM(1, players(3, 4), GameCardColor.GREEN, nonePoints(), NO_RESOURCE, warPoint(0), ScientistGuild.NAMEPLATE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.PARCHMENT),

    //green  second age
//3.4
    DISPENSARY(2, players(3, 4), GameCardColor.GREEN, nonePoints(), NO_RESOURCE, warPoint(0), ScientistGuild.COMPASSE, Collections.singletonList("APOTHECARY"), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.IRON, BaseResource.IRON, BaseResource.GLASS),
    //3.5
    LABORATORY(2, players(3, 5), GameCardColor.GREEN, nonePoints(), NO_RESOURCE, warPoint(0), ScientistGuild.GEAR, Collections.singletonList("WORKSHOP"), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.CLAY, BaseResource.CLAY, BaseResource.PARCHMENT),
    //3.6
    LIBRARY(2, players(3, 6), GameCardColor.GREEN, nonePoints(), NO_RESOURCE, warPoint(0), ScientistGuild.NAMEPLATE, Collections.singletonList("SCRIPTORIUM"), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.STONE, BaseResource.STONE, BaseResource.SILK),
    //3.7
    SCHOOL(2, players(3, 7), GameCardColor.GREEN, nonePoints(), NO_RESOURCE, warPoint(0), ScientistGuild.NAMEPLATE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.WOOD, BaseResource.PARCHMENT),

    //green thierd age
//3.6
    LODGE(3, players(3, 6), GameCardColor.GREEN, nonePoints(), NO_RESOURCE, warPoint(0), ScientistGuild.COMPASSE, Collections.singletonList("DISPENSARY"), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.CLAY, BaseResource.CLAY, BaseResource.SILK, BaseResource.PARCHMENT),
    //3.7
    OBSERVATORY(3, players(3, 7), GameCardColor.GREEN, nonePoints(), NO_RESOURCE, warPoint(0), ScientistGuild.GEAR, Collections.singletonList("LABORATORY"), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.IRON, BaseResource.IRON, BaseResource.GLASS, BaseResource.SILK),
    //3.4
    UNIVERSITY(3, players(3, 4), GameCardColor.GREEN, nonePoints(), NO_RESOURCE, warPoint(0), ScientistGuild.NAMEPLATE, Collections.singletonList("LIBRARY"), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.WOOD, BaseResource.WOOD, BaseResource.PARCHMENT, BaseResource.GLASS),
    //3.7
    ACADEMY(3, players(3, 7), GameCardColor.GREEN, nonePoints(), NO_RESOURCE, warPoint(0), ScientistGuild.COMPASSE, Collections.singletonList("SCHOOL"), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.STONE, BaseResource.STONE, BaseResource.STONE, BaseResource.GLASS),
    //3.5
    STUDY(3, players(3, 5), GameCardColor.GREEN, nonePoints(), NO_RESOURCE, warPoint(0), ScientistGuild.GEAR, Collections.singletonList("SCHOOL"), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.WOOD, BaseResource.PARCHMENT, BaseResource.SILK),


// purple card

//cards what give point for cardColor

    WORKERS_GUILDSTUDY(3, players(3), GameCardColor.PURPLE, CalcPointStrategy.color(ActionSide.RIGHT_AND_LEFT, 1, Collections.singletonList(BROWN)), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.IRON, BaseResource.IRON, BaseResource.CLAY, BaseResource.STONE, BaseResource.WOOD),

    CRAFTMENS_GUILD(3, players(3), GameCardColor.PURPLE, CalcPointStrategy.color(ActionSide.RIGHT_AND_LEFT, 2, Collections.singletonList(GameCardColor.SILVER)), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.IRON, BaseResource.IRON, BaseResource.STONE, BaseResource.STONE),

    TRADERS_GUILD(3, players(3), GameCardColor.PURPLE, CalcPointStrategy.color(ActionSide.RIGHT_AND_LEFT, 1, Collections.singletonList(GameCardColor.YELLOW)), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.SILK, BaseResource.GLASS, BaseResource.PARCHMENT),

    PHILOSOPHERS_GUILD(3, players(3), GameCardColor.PURPLE, CalcPointStrategy.color(ActionSide.RIGHT_AND_LEFT, 1, Collections.singletonList(GameCardColor.GREEN)), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.CLAY, BaseResource.CLAY, BaseResource.CLAY, BaseResource.SILK, BaseResource.PARCHMENT),

    SPY_GUILD(3, players(3), GameCardColor.PURPLE, CalcPointStrategy.color(ActionSide.RIGHT_AND_LEFT, 1, Collections.singletonList(GameCardColor.RED)), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.CLAY, BaseResource.CLAY, BaseResource.CLAY, BaseResource.GLASS),

    MAGISTRATES_GUILD(3, players(3), GameCardColor.PURPLE, CalcPointStrategy.color(ActionSide.RIGHT_AND_LEFT, 1, Collections.singletonList(GameCardColor.BLUE)), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.WOOD, BaseResource.WOOD, BaseResource.WOOD, BaseResource.STONE, BaseResource.GLASS),

//card what give point for 3_cardColor

    SHIPOWNERS_GUILD(3, players(3), GameCardColor.PURPLE, CalcPointStrategy.color(ActionSide.DOWN, 1, Arrays.asList(BROWN, GameCardColor.SILVER, GameCardColor.PURPLE)), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.WOOD, BaseResource.WOOD, BaseResource.WOOD, BaseResource.STONE, BaseResource.SILK),

//card what give ScientistGuild // 1

    SCIENTISTS_GUILD(3, players(3), GameCardColor.PURPLE, nonePoints(), NO_RESOURCE, warPoint(0), ScientistGuild.NAMEPLATE_OR_COMPASSE_OR_GEAR, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.WOOD, BaseResource.WOOD, BaseResource.IRON, BaseResource.IRON, BaseResource.PARCHMENT),

//card what give point for vonderLevel


    BUILDERS_GUILD(3, players(3), GameCardColor.PURPLE, CalcPointStrategy.wonderLevel(ActionSide.RIGHT_AND_LEFT_AND_DOWN, 1), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.STONE, BaseResource.STONE, BaseResource.CLAY, BaseResource.CLAY, BaseResource.GLASS),


    STRATEGY_GUILD(3, players(3), GameCardColor.PURPLE, CalcPointStrategy.warLoose(ActionSide.DOWN), NO_RESOURCE, warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.IRON, BaseResource.IRON, BaseResource.STONE, BaseResource.SILK),

    //--------------------------------------------------------- Wonders


    // giza
    GIZA_MAIN(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.nonePoints(), GameResource.STONE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),


    GIZA_FIRST_A(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.STONE, BaseResource.STONE),

    GIZA_SECOND_A(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(5), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.WOOD, BaseResource.WOOD),

    GIZA_THIRD_A(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(7), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.STONE, BaseResource.STONE, BaseResource.STONE, BaseResource.STONE),


    GIZA_FIRST_B(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.WOOD, BaseResource.WOOD),

    GIZA_SECOND_B(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(5), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.STONE, BaseResource.STONE, BaseResource.STONE),

    GIZA_THIRD_B(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(5), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.CLAY, BaseResource.CLAY, BaseResource.CLAY),

    GIZA_FOURTH_B(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(7), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.PARCHMENT, BaseResource.STONE, BaseResource.STONE, BaseResource.STONE, BaseResource.STONE),


//colos

    COLOSSUS_MAIN(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.nonePoints(), GameResource.IRON, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),


    COLOSSUS_FIRST_A(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.WOOD, BaseResource.WOOD),

    COLOSSUS_SECOND_A(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(0), GameResource.NO_RESOURCE, WarPoint.warPoint(2), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.CLAY, BaseResource.CLAY, BaseResource.CLAY),

    COLOSSUS_THIRD_A(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(7), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.IRON, BaseResource.IRON, BaseResource.IRON, BaseResource.IRON),


    COLOSSUS_FIRST_B(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, WarPoint.warPoint(1), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), OnBuildEvent.receiveGold(ActionSide.DOWN, 3), BaseResource.STONE, BaseResource.STONE, BaseResource.STONE),

    COLOSSUS_SECOND_B(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(4), GameResource.NO_RESOURCE, WarPoint.warPoint(1), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), OnBuildEvent.receiveGold(ActionSide.DOWN, 4), BaseResource.IRON, BaseResource.IRON, BaseResource.IRON, BaseResource.IRON),


//LIGHTHOUSE

    ALEXANDRIA_MAIN(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.nonePoints(), GameResource.GLASS, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),


    ALEXANDRIA_FIRST_A(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.STONE, BaseResource.STONE),

    ALEXANDRIA_SECOND_A(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(0), GameResource.STONE_OR_IRON_OR_CLAY_OR_WOOD, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.IRON, BaseResource.IRON),

    ALEXANDRIA_THIRD_A(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(7), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.GLASS, BaseResource.GLASS),


    ALEXANDRIA_FIRST_B(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(0), GameResource.STONE_OR_IRON_OR_CLAY_OR_WOOD, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.CLAY, BaseResource.CLAY),

    ALEXANDRIA_SECOND_B(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(0), GameResource.SILK_OR_GLASS_OR_PARCHMENT, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.WOOD, BaseResource.WOOD),

    ALEXANDRIA_THIRD_B(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(7), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.STONE, BaseResource.STONE, BaseResource.STONE),


    // TEMPLE_OF_ARTEMIS_IN_EPHESUS

    ARTEMIS_MAIN(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.nonePoints(), GameResource.PARCHMENT, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),


    ARTEMIS_FIRST_A(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.STONE, BaseResource.STONE),

    ARTEMIS_SECOND_A(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(0), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), OnBuildEvent.receiveGold(ActionSide.DOWN, 9), BaseResource.WOOD, BaseResource.WOOD),

    ARTEMIS_THIRD_A(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(7), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.PARCHMENT, BaseResource.PARCHMENT),


    ARTEMIS_FIRST_B(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(2), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), OnBuildEvent.receiveGold(ActionSide.DOWN, 4), BaseResource.WOOD, BaseResource.WOOD),

    ARTEMIS_SECOND_B(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), OnBuildEvent.receiveGold(ActionSide.DOWN, 4), BaseResource.STONE, BaseResource.STONE, BaseResource.STONE),

    ARTEMIS_THIRD_B(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(5), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), OnBuildEvent.receiveGold(ActionSide.DOWN, 4), BaseResource.GLASS, BaseResource.SILK),


    //Garden

    GARDENS_MAIN(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.nonePoints(), GameResource.CLAY, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),


    GARDENS_FIRST_A(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.CLAY, BaseResource.CLAY),

    GARDENS_SECOND_A(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(0), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NAMEPLATE_OR_COMPASSE_OR_GEAR, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.WOOD, BaseResource.WOOD, BaseResource.WOOD),

    GARDENS_THIRD_A(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(7), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.CLAY, BaseResource.CLAY, BaseResource.CLAY, BaseResource.CLAY),


    GARDENS_FIRST_B(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.SILK, BaseResource.CLAY),

    GARDENS_SECOND_B(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(0), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.WOOD, BaseResource.WOOD),

    GARDENS_THIRD_B(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(0), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NAMEPLATE_OR_COMPASSE_OR_GEAR, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.PARCHMENT, BaseResource.CLAY, BaseResource.CLAY, BaseResource.CLAY),


    //ZEUS

    STATUE_MAIN(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.nonePoints(), GameResource.WOOD, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),


    STATUE_FIRST_A(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.WOOD, BaseResource.WOOD),

    STATUE_SECOND_A(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(0), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.STONE, BaseResource.STONE),

    STATUE_THIRD_A(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(7), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.IRON, BaseResource.IRON),


    STATUE_FIRST_B(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(0), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.WOOD, BaseResource.WOOD),

    STATUE_SECOND_B(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(5), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.STONE, BaseResource.STONE, BaseResource.STONE),

    STATUE_THIRD_B(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(5), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.IRON, BaseResource.IRON, BaseResource.SILK),


//MAUSOLEUM

    MAUSOLEUM_MAIN(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.nonePoints(), GameResource.SILK, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent()),


    MAUSOLEUM_FIRST_A(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.CLAY, BaseResource.CLAY),

    MAUSOLEUM_SECOND_A(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(0), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.IRON, BaseResource.IRON, BaseResource.IRON),

    MAUSOLEUM_THIRD_A(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(7), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.SILK, BaseResource.SILK),


    MAUSOLEUM_FIRST_B(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(2), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.IRON, BaseResource.IRON),

    MAUSOLEUM_SECOND_B(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(1), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.CLAY, BaseResource.CLAY, BaseResource.CLAY),

    MAUSOLEUM_THIRD_B(0, Arrays.asList(3, 4, 5, 6, 7), GameCardColor.NO_COLOR, CalcPointStrategy.simple(0), GameResource.NO_RESOURCE, WarPoint.warPoint(0), ScientistGuild.NONE, noChains(), 0, TradeDiscount.create(ActionSide.NONE, GameCardColor.NO_COLOR), emptyBuildEvent(), BaseResource.GLASS, BaseResource.SILK, BaseResource.PARCHMENT);


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
    private final TradeDiscount tradeDiscount;


    GameCard(int age, List<Integer> onPlayers, GameCardColor gameCardColor,
             CalcPointStrategy calcPointStrategy,
             GameResource giveResource,
             WarPoint armyPower,
             ScientistGuild signScientistGuild,
             List<String> chain,
             int goldNeededForConstruction,
             TradeDiscount tradeDiscount,
             OnBuildEvent onBuildEvent,
             BaseResource... resourcesNeedForBuild) {
        this.age = age;
        this.onPlayers = onPlayers;
        this.strategy = calcPointStrategy;
        this.gameCardColor = gameCardColor;
        this.giveResource = giveResource;
        this.armyPower = armyPower;
        this.signScientistGuild = signScientistGuild;
        this.chain = chain;
        this.tradeDiscount = tradeDiscount;
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


}

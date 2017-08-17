package com.wonder.wonder.cards;

import com.wonder.wonder.cards.calc.point.CalcPointStrategy;
import com.wonder.wonder.cards.events.OnBuildEvent;
import com.wonder.wonder.cards.warPoint.WarPoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by bm on 27.07.17.
 */
public enum WonderLevelCard implements GameCard {

// giza
GIZA_MAIN(0, CalcPointStrategy.none(), GameResource.STONE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.NONE),


    GIZA_FIRST_A(1, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.STONE, BaseResource.STONE),

    GIZA_SECOND_A(2, CalcPointStrategy.simple(5), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.WOOD, BaseResource.WOOD),

    GIZA_THIRD_A(3, CalcPointStrategy.simple(7), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.STONE, BaseResource.STONE, BaseResource.STONE, BaseResource.STONE),


    GIZA_FIRST_B(1, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.WOOD, BaseResource.WOOD),

    GIZA_SECOND_B(2, CalcPointStrategy.simple(5), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.STONE, BaseResource.STONE, BaseResource.STONE),

    GIZA_THIRD_B(3, CalcPointStrategy.simple(5), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.CLAY, BaseResource.CLAY, BaseResource.CLAY),

    GIZA_FOURTH_B(4, CalcPointStrategy.simple(7), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.PARCHMENT, BaseResource.STONE, BaseResource.STONE, BaseResource.STONE, BaseResource.STONE),


//colos

    COLOSSUS_MAIN(0, CalcPointStrategy.none(), GameResource.IRON, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.NONE),


    COLOSSUS_FIRST_A(1, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.WOOD, BaseResource.WOOD),

    COLOSSUS_SECOND_A(2, CalcPointStrategy.simple(0), GameResource.NO_RESOURCE, WarPoint.simple(2), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.CLAY, BaseResource.CLAY, BaseResource.CLAY),

    COLOSSUS_THIRD_A(3, CalcPointStrategy.simple(7), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.IRON, BaseResource.IRON, BaseResource.IRON, BaseResource.IRON),


    COLOSSUS_FIRST_B(1, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, WarPoint.simple(1), ScientistGuild.NONE, OnBuildEvent.receiveGold(ActionSide.DOWN, 3), BaseResource.STONE, BaseResource.STONE, BaseResource.STONE),

    COLOSSUS_SECOND_B(2, CalcPointStrategy.simple(4), GameResource.NO_RESOURCE, WarPoint.simple(1), ScientistGuild.NONE, OnBuildEvent.receiveGold(ActionSide.DOWN, 4), BaseResource.IRON, BaseResource.IRON, BaseResource.IRON, BaseResource.IRON),


//LIGHTHOUSE

    ALEXANDRIA_MAIN(0, CalcPointStrategy.none(), GameResource.GLASS, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.NONE),


    ALEXANDRIA_FIRST_A(1, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.STONE, BaseResource.STONE),

    ALEXANDRIA_SECOND_A(2, CalcPointStrategy.simple(0), GameResource.STONE_OR_IRON_OR_CLAY_OR_WOOD, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.IRON, BaseResource.IRON),

    ALEXANDRIA_THIRD_A(3, CalcPointStrategy.simple(7), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.GLASS, BaseResource.GLASS),


    ALEXANDRIA_FIRST_B(1, CalcPointStrategy.simple(0), GameResource.STONE_OR_IRON_OR_CLAY_OR_WOOD, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.CLAY, BaseResource.CLAY),

    ALEXANDRIA_SECOND_B(2, CalcPointStrategy.simple(0), GameResource.SILK_OR_GLASS_OR_PARCHMENT, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.WOOD, BaseResource.WOOD),

    ALEXANDRIA_THIRD_B(3, CalcPointStrategy.simple(7), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.STONE, BaseResource.STONE, BaseResource.STONE),


    // TEMPLE_OF_ARTEMIS_IN_EPHESUS

    ARTEMIS_MAIN(0, CalcPointStrategy.none(), GameResource.PARCHMENT, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.NONE),


    ARTEMIS_FIRST_A(1, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.STONE, BaseResource.STONE),

    ARTEMIS_SECOND_A(2, CalcPointStrategy.simple(0), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.receiveGold(ActionSide.DOWN, 9), BaseResource.WOOD, BaseResource.WOOD),

    ARTEMIS_THIRD_A(3, CalcPointStrategy.simple(7), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.PARCHMENT, BaseResource.PARCHMENT),


    ARTEMIS_FIRST_B(1, CalcPointStrategy.simple(2), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.receiveGold(ActionSide.DOWN, 4), BaseResource.WOOD, BaseResource.WOOD),

    ARTEMIS_SECOND_B(2, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.receiveGold(ActionSide.DOWN, 4), BaseResource.STONE, BaseResource.STONE, BaseResource.STONE),

    ARTEMIS_THIRD_B(3, CalcPointStrategy.simple(5), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.receiveGold(ActionSide.DOWN, 4), BaseResource.GLASS, BaseResource.SILK),


    //Garden

    GARDENS_MAIN(0, CalcPointStrategy.none(), GameResource.CLAY, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.NONE),


    GARDENS_FIRST_A(1, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.CLAY, BaseResource.CLAY),

     GARDENS_SECOND_A(2, CalcPointStrategy.simple(0), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NAMEPLATE_OR_COMPASSE_OR_GEAR, OnBuildEvent.none(), BaseResource.WOOD,BaseResource.WOOD, BaseResource.WOOD),

    GARDENS_THIRD_A(3, CalcPointStrategy.simple(7), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.CLAY, BaseResource.CLAY, BaseResource.CLAY, BaseResource.CLAY),


    GARDENS_FIRST_B(1, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.SILK, BaseResource.CLAY),

     GARDENS_SECOND_B(2, CalcPointStrategy.simple(0), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.WOOD, BaseResource.WOOD),

    GARDENS_THIRD_B(3, CalcPointStrategy.simple(0), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NAMEPLATE_OR_COMPASSE_OR_GEAR, OnBuildEvent.none(), BaseResource.PARCHMENT, BaseResource.CLAY, BaseResource.CLAY, BaseResource.CLAY),


    //ZEUS

    STATUE_MAIN(0, CalcPointStrategy.none(), GameResource.WOOD, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.NONE),


    STATUE_FIRST_A(1, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.WOOD, BaseResource.WOOD),

     STATUE_SECOND_A(2, CalcPointStrategy.simple(0), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(),  BaseResource.STONE, BaseResource.STONE),

    STATUE_THIRD_A(3, CalcPointStrategy.simple(7), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.IRON, BaseResource.IRON),


    STATUE_FIRST_B(1, CalcPointStrategy.simple(0), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(),BaseResource.WOOD, BaseResource.WOOD),

    STATUE_SECOND_B(2, CalcPointStrategy.simple(5), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.STONE, BaseResource.STONE, BaseResource.STONE),

     STATUE_THIRD_B(3, CalcPointStrategy.simple(5), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.IRON,BaseResource.IRON, BaseResource.SILK),


//MAUSOLEUM

    MAUSOLEUM_MAIN(0, CalcPointStrategy.none(), GameResource.SILK, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.NONE),


    MAUSOLEUM_FIRST_A(1, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.CLAY, BaseResource.CLAY),

     MAUSOLEUM_SECOND_A(2, CalcPointStrategy.simple(0), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.IRON,BaseResource.IRON,BaseResource.IRON),

    MAUSOLEUM_THIRD_A(3, CalcPointStrategy.simple(7), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.SILK, BaseResource.SILK),


     MAUSOLEUM_FIRST_B(1, CalcPointStrategy.simple(2), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(),BaseResource.IRON, BaseResource.IRON),

     MAUSOLEUM_SECOND_B(2, CalcPointStrategy.simple(1), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.CLAY, BaseResource.CLAY, BaseResource.CLAY),

     MAUSOLEUM_THIRD_B(3, CalcPointStrategy.simple(0), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.GLASS, BaseResource.SILK, BaseResource.PARCHMENT),



    ;


    private final int wonderLevel;
    private final CalcPointStrategy strategy;

    private final GameResource giveResource;
    private final WarPoint armyPower;
    private final ScientistGuild signScientistGuild;


    private final OnBuildEvent onBuildEvent;
    private final List<BaseResource> resourcesNeedForBuild;
    // boolen tradeCard;


    WonderLevelCard(int wonderLevel, CalcPointStrategy calcPointStrategy,
                    GameResource giveResource,
                    WarPoint armyPower, ScientistGuild signScientistGuild,
                    OnBuildEvent onBuildEvent, BaseResource... resourcesNeedForBuild) {

        this.wonderLevel = wonderLevel;
        this.strategy = calcPointStrategy;

        this.giveResource = giveResource;
        this.armyPower = armyPower;
        this.signScientistGuild = signScientistGuild;


        this.onBuildEvent = onBuildEvent;
        this.resourcesNeedForBuild = Collections.unmodifiableList(Arrays.asList(resourcesNeedForBuild));
    }


    @Override
    public CalcPointStrategy getStrategy() {
        return strategy;
    }

    @Override
    public GameCardColor getGameCardColor() {
        return GameCardColor.NO_COLOR;
    }

    @Override
    public GameResource getGiveResource() {
        return giveResource;
    }

    @Override
    public WarPoint getArmyPower() {
        return armyPower;
    }

    @Override
    public ScientistGuild getSignScientistGuild() {
        return signScientistGuild;
    }

    @Override
    public List<String> getChain() {
        return new ArrayList<>();
    }

    @Override
    public int getGoldNeededForConstruction() {
        return 0;
    }

    @Override
    public OnBuildEvent getOnBuildEvent() {
        return onBuildEvent;
    }

    @Override
    public List<BaseResource> getResourcesNeedForBuild() {
        return resourcesNeedForBuild;
    }

    public int getWonderLevel() {
        return wonderLevel;
    }
}

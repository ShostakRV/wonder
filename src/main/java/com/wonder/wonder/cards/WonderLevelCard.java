package com.wonder.wonder.cards;

import com.wonder.wonder.cards.calc.point.CalcPointStrategy;
import com.wonder.wonder.cards.events.OnBuildEvent;
import com.wonder.wonder.cards.warPoint.WarPoint;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by bm on 27.07.17.
 */
public enum WonderLevelCard {


    GIZA_MAIN(WonderCard.THE_PYRAMIDS_OF_GIZA_SIDE_A, 0, CalcPointStrategy.none(), GameResource.STONE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.NONE),

    GIZA_FIRST(WonderCard.THE_PYRAMIDS_OF_GIZA_SIDE_A, 1, CalcPointStrategy.simple(3), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.STONE, BaseResource.STONE),

    GIZA_SECOND(WonderCard.THE_PYRAMIDS_OF_GIZA_SIDE_A, 2, CalcPointStrategy.simple(5), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.WOOD, BaseResource.WOOD),

    GIZA_THIRD(WonderCard.THE_PYRAMIDS_OF_GIZA_SIDE_A, 3, CalcPointStrategy.simple(7), GameResource.NO_RESOURCE, WarPoint.simple(0), ScientistGuild.NONE, OnBuildEvent.none(), BaseResource.STONE, BaseResource.STONE, BaseResource.STONE, BaseResource.STONE),;


    private final WonderCard wonderCard;
    private final int wonderLevel;
    private final CalcPointStrategy strategy;

    private final GameResource giveResource;
    private final WarPoint armyPower;
    private final ScientistGuild signScientistGuild;


    private final OnBuildEvent onBuildEvent;
    private final List<BaseResource> resourcesNeedForBuild;
    // boolen tradeCard;


    WonderLevelCard(WonderCard wonderCard, int wonderLevel, CalcPointStrategy calcPointStrategy,
                    GameResource giveResource,
                    WarPoint armyPower, ScientistGuild signScientistGuild,
                    OnBuildEvent onBuildEvent, BaseResource... resourcesNeedForBuild) {
        this.wonderCard = wonderCard;
        this.wonderLevel = wonderLevel;
        this.strategy = calcPointStrategy;

        this.giveResource = giveResource;
        this.armyPower = armyPower;
        this.signScientistGuild = signScientistGuild;


        this.onBuildEvent = onBuildEvent;
        this.resourcesNeedForBuild = Collections.unmodifiableList(Arrays.asList(resourcesNeedForBuild));
    }
}

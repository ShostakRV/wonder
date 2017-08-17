package com.wonder.wonder.cards;

import com.wonder.wonder.cards.calc.point.CalcPointStrategy;
import com.wonder.wonder.cards.events.OnBuildEvent;
import com.wonder.wonder.cards.warPoint.WarPoint;

import java.util.List;

/**
 * Created by bm on 01.08.17.
 */
public interface GameCard {

    CalcPointStrategy getStrategy();

    GameCardColor getGameCardColor();

    GameResource getGiveResource();

    WarPoint getArmyPower();

    ScientistGuild getSignScientistGuild();

    List<String> getChain();

    int getGoldNeededForConstruction();

    OnBuildEvent getOnBuildEvent();

    List<BaseResource> getResourcesNeedForBuild();
}

package com.wonder.wonder.cards.calc.point;

import com.wonder.wonder.cards.ActionSide;
import com.wonder.wonder.cards.GameCardColor;

import java.util.List;

/**
 * Created: godex
 * DATE: 20.06.17.
 */
public class ColorCardCalcPointStrategyImpl implements CalcPointStrategy {
    private final ActionSide actionSide;
    private final int pointForOneCard;
    private final List<GameCardColor> colorList;

    public ColorCardCalcPointStrategyImpl(ActionSide actionSide, int pointForOneCard, List<GameCardColor> colorList) {
        this.actionSide = actionSide;
        this.pointForOneCard = pointForOneCard;
        this.colorList = colorList;
    }

    @Override
    public int getPoints() {

        return 0;
    }
}

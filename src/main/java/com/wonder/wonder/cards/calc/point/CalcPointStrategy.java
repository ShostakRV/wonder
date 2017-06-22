package com.wonder.wonder.cards.calc.point;

import com.wonder.wonder.cards.ActionSide;
import com.wonder.wonder.cards.GameCardColor;

import java.util.List;

/**
 * Created: godex
 * DATE: 20.06.17.
 */
public interface CalcPointStrategy {
    int getPoints();

    default CalcPointStrategy simple(int point) {
        return new SimpleCalcPointStrategyImpl(point);
    }

    default CalcPointStrategy color(ActionSide actionSide, int pointForOneCard, List<GameCardColor> colorList) {
        return new ColorCardCalcPointStrategyImpl(actionSide, pointForOneCard, colorList);
    }

    default CalcPointStrategy warLoose(ActionSide actionSide) {
        return new WarLooseCalcPointStrategyImpl(actionSide);
    }

    default CalcPointStrategy wonderLevel(ActionSide actionSide, int pointForOneCard) {
        return new WonderLevelCalcPointStrategyImpl(actionSide, pointForOneCard);
    }

    default CalcPointStrategy none() {
        return new SimpleCalcPointStrategyImpl(0);
    }

}

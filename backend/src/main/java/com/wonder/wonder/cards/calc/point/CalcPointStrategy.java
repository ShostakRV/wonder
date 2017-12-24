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

    static CalcPointStrategy simple(int point) {
        return new SimpleCalcPointStrategyImpl(point);
    }

    static CalcPointStrategy color(ActionSide actionSide, int pointForOneCard, List<GameCardColor> colorList) {
        return new ColorCardCalcPointStrategyImpl(actionSide, pointForOneCard, colorList);
    }

    static CalcPointStrategy warLoose(ActionSide actionSide) {
        return new WarLooseCalcPointStrategyImpl(actionSide);
    }

    static CalcPointStrategy wonderLevel(ActionSide actionSide, int pointForOneCard) {
        return new WonderLevelCalcPointStrategyImpl(actionSide, pointForOneCard);
    }

    static CalcPointStrategy nonePoints() {
        return new SimpleCalcPointStrategyImpl(0);
    }

}

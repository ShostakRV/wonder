package com.wonder.wonder.service.cards.calc.point;

import com.wonder.wonder.service.cards.ActionSide;

/**
 * Created: godex
 * DATE: 20.06.17.
 */
public class WarLooseCalcPointStrategyImpl implements CalcPointStrategy {
    private final ActionSide actionSide;

    public WarLooseCalcPointStrategyImpl(ActionSide actionSide) {
        this.actionSide = actionSide;
    }

    @Override
    public int getPoints() {
        return 0;
    }
}

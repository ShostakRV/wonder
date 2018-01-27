package com.wonder.wonder.cards.calc.point;

import com.wonder.wonder.cards.ActionSide;
import com.wonder.wonder.service.util.GameBoardView;

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
    public int getPoints(GameBoardView boardView) {
        return 0;
    }
}

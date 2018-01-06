package com.wonder.wonder.cards.calc.point;

import com.wonder.wonder.cards.ActionSide;
import lombok.Data;

/**
 * Created: godex
 * DATE: 20.06.17.
 */
@Data
public class WonderLevelCalcPointStrategyImpl implements CalcPointStrategy {
    private final ActionSide actionSide;
    private final int pointForOneLevelCard;

    public WonderLevelCalcPointStrategyImpl(ActionSide actionSide, int pointForOneLevelCard) {
        this.actionSide = actionSide;
        this.pointForOneLevelCard = pointForOneLevelCard;
    }

    @Override
    public int getPoints() {
        return 0;
    }
}

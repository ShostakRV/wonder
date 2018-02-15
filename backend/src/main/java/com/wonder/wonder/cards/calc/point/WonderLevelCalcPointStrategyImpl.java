package com.wonder.wonder.cards.calc.point;

import com.wonder.wonder.cards.ActionSide;
import com.wonder.wonder.service.util.GameBoardView;
import lombok.Data;

/**
 * Created: godex
 * DATE: 20.06.17.
 */
@Data
public class WonderLevelCalcPointStrategyImpl implements CalcPointStrategy {
    private final ActionSide actionSide;
    private final int pointForOneLevelCard;

    WonderLevelCalcPointStrategyImpl(ActionSide actionSide, int pointForOneLevelCard) {
        this.actionSide = actionSide;
        this.pointForOneLevelCard = pointForOneLevelCard;
    }

    @Override
    public int getPoints(GameBoardView boardView) {
        int points = 0;
        if (actionSide.equals(ActionSide.DOWN)) {
            points = pointForOneLevelCard * boardView.getUserWonderLevel();
        } else if (actionSide.equals(ActionSide.RIGHT_AND_LEFT_AND_DOWN)) {
            int wonderLevelRight = boardView.getRightSiteUser().getWonderLevel();
            int wonderLevelLeft = boardView.getLeftSiteUser().getWonderLevel();
            points = pointForOneLevelCard * (wonderLevelLeft + wonderLevelRight + boardView.getUserWonderLevel());
        }
        return points;
    }
}

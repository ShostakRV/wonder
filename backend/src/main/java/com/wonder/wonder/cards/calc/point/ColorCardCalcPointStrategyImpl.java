package com.wonder.wonder.cards.calc.point;

import com.wonder.wonder.cards.ActionSide;
import com.wonder.wonder.cards.GameCardColor;
import com.wonder.wonder.service.util.GameBoardView;

import java.util.List;
import java.util.stream.Collectors;

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
    public int getPoints(GameBoardView boardView) {
        return pointForOneCard * buildCardColorCount(boardView);

    }

    protected int buildCardColorCount(GameBoardView boardView) {
        int count = 0;
        if (actionSide.equals(ActionSide.DOWN)) {
            count = boardView.getCurrentUserGameInfo()
                    .getUserBuiltCards()
                    .stream()
                    .filter(gameCard -> colorList.contains(gameCard.getGameCardColor()))
                    .collect(Collectors.toList()).size();
        } else if (actionSide.equals(ActionSide.DOWN)) {
            int colorCardSizeRight = boardView.getRightSiteUser()
                    .getUserBuiltCards()
                    .stream()
                    .filter(gameCard -> colorList.contains(gameCard.getGameCardColor()))
                    .collect(Collectors.toList()).size();

            int colorCardSizeLEft = boardView.getLeftSiteUser()
                    .getUserBuiltCards()
                    .stream()
                    .filter(gameCard -> colorList.contains(gameCard.getGameCardColor()))
                    .collect(Collectors.toList()).size();
            count = colorCardSizeRight + colorCardSizeLEft;
        }
        return count;
    }
}

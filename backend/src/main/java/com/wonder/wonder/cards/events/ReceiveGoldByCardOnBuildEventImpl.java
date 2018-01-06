package com.wonder.wonder.cards.events;

import com.wonder.wonder.cards.ActionSide;
import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.cards.GameCardColor;
import com.wonder.wonder.service.util.GameBoardView;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created bm
 * Date 25.06.17.
 */
public class ReceiveGoldByCardOnBuildEventImpl implements OnBuildEvent {
    private final ActionSide actionSide;
    private final int pointForOneCard;
    private final GameCardColor color;

    public ReceiveGoldByCardOnBuildEventImpl(ActionSide actionSide, int pointForOneCard, GameCardColor color) {
        this.actionSide = actionSide;
        this.pointForOneCard = pointForOneCard;
        this.color = color;
    }
//

    @Override
    public void doAction(GameBoardView boardView) {
        int addGold = 0;
        if (actionSide.equals(ActionSide.DOWN)
                | actionSide.equals(ActionSide.RIGHT_AND_LEFT_AND_DOWN)) {
            addGold += pointForOneCard * buildCardColorCount(boardView);
        }
        if (actionSide.equals(ActionSide.LEFT)
                | actionSide.equals(ActionSide.RIGHT_AND_LEFT)
                | actionSide.equals(ActionSide.RIGHT_AND_LEFT_AND_DOWN)) {
            addGold += pointForOneCard * buildCardColorCountLeft(boardView);
        }
        if (actionSide.equals(ActionSide.RIGHT)
                | actionSide.equals(ActionSide.RIGHT_AND_LEFT)
                | actionSide.equals(ActionSide.RIGHT_AND_LEFT_AND_DOWN)) {
            addGold += pointForOneCard * buildCardColorCountRight(boardView);
        }
        boardView.getCurrentUserGameInfo().addGoldToNewEvent(addGold);
    }

    protected int buildCardColorCount(GameBoardView boardView) {
        return boardView.getCurrentUserGameInfo()
                .getUserBuiltCards()
                .stream()
                .filter(gameCard -> gameCard.getGameCardColor().equals(color))
                .collect(Collectors.toList()).size();

    }
    protected int buildCardColorCountLeft(GameBoardView boardView) {
        return boardView.getLeftSiteUser()
                .getUserBuiltCards()
                .stream()
                .filter(gameCard -> gameCard.getGameCardColor().equals(color))
                .collect(Collectors.toList()).size();

    }
    protected int buildCardColorCountRight(GameBoardView boardView) {
        return boardView.getRightSiteUser()
                .getUserBuiltCards()
                .stream()
                .filter(gameCard -> gameCard.getGameCardColor().equals(color))
                .collect(Collectors.toList()).size();

    }
}

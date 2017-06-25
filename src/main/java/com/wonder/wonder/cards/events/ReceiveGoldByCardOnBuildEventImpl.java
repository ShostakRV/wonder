package com.wonder.wonder.cards.events;

import com.wonder.wonder.cards.ActionSide;
import com.wonder.wonder.cards.GameCardColor;

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
    public void doAction() {

    }
}

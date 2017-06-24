package com.wonder.wonder.cards.event1.on1.build1;

import com.wonder.wonder.cards.ActionSide;
import com.wonder.wonder.cards.GameCardColor;
import lombok.Data;

/**
 * Created: godex
 * DATE: 20.06.17.
 */
@Data
public class ReceiveGoldOnBuildEventImpl implements OnBuildEvent {
    private final ActionSide actionSide;
    private final int pointForOneCard;
    private final GameCardColor color;

    public ReceiveGoldOnBuildEventImpl(ActionSide actionSide, int pointForOneCard, GameCardColor color) {
        this.actionSide = actionSide;
        this.pointForOneCard = pointForOneCard;
        this.color = color;
    }


    @Override
    public void doAction() {
        //
    }
}

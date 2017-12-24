package com.wonder.wonder.cards.events;

import com.wonder.wonder.cards.ActionSide;
import com.wonder.wonder.cards.GameCardColor;

/**
 * Created: godex
 * DATE: 20.06.17.
 */
public interface OnBuildEvent {
    static OnBuildEvent emptyBuildEvent() {
        return () -> {        };
    }

    static OnBuildEvent receiveGold(ActionSide actionSide, int goldForOneCard) {
        return new ReceiveGoldOnBuildEventImpl(actionSide, goldForOneCard);
    }
    static OnBuildEvent receiveGoldByColorCard(ActionSide actionSide, int goldForOneCard, GameCardColor color) {
        return new ReceiveGoldByCardOnBuildEventImpl(actionSide, goldForOneCard, color);
    }

    void doAction();

    static OnBuildEvent receiveGoldByWonder(ActionSide actionSide, int goldForOneCard) {
        return new ReceiveGoldByWonderOnBuildEventImpl(actionSide, goldForOneCard);
    }
}

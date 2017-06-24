package com.wonder.wonder.cards.events;

import com.wonder.wonder.cards.ActionSide;
import com.wonder.wonder.cards.GameCardColor;

/**
 * Created: godex
 * DATE: 20.06.17.
 */
public interface OnBuildEvent {
    static OnBuildEvent none() {
        return () -> {        };
    }

    static OnBuildEvent receiveGold(ActionSide actionSide, int pointForOneCard, GameCardColor color) {
        return new ReceiveGoldOnBuildEventImpl(actionSide, pointForOneCard, color);
    }

    void doAction();
}

package com.wonder.wonder.cards.events;

import com.wonder.wonder.cards.ActionSide;
import com.wonder.wonder.cards.GameCardColor;
import lombok.Data;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Created: godex
 * DATE: 20.06.17.
 */
@Data
public class ReceiveGoldOnBuildEventImpl implements OnBuildEvent {
    private final ActionSide actionSide;
    private final int pointForOneCard;


    public ReceiveGoldOnBuildEventImpl(ActionSide actionSide, int pointForOneCard) {
        this.actionSide = actionSide;
        this.pointForOneCard = pointForOneCard;

    }


    @Override
    public void doAction() {


    }
}

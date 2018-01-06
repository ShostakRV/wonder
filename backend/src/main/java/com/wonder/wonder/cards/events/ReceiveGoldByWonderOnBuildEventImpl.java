package com.wonder.wonder.cards.events;

import com.wonder.wonder.cards.ActionSide;
import com.wonder.wonder.service.util.GameBoardView;
import lombok.Data;

/**
 * Created bm
 * Date 25.06.17.
 */
@Data
public class ReceiveGoldByWonderOnBuildEventImpl implements OnBuildEvent {
    private final ActionSide actionSide;
    private final int pointForOneCard;

    public ReceiveGoldByWonderOnBuildEventImpl(ActionSide actionSide, int pointForOneCard) {
        this.actionSide = actionSide;
        this.pointForOneCard = pointForOneCard;
    }

    @Override
    public void doAction(GameBoardView boardView) {

    }
}

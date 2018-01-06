package com.wonder.wonder.cards.events;

import com.wonder.wonder.cards.ActionSide;
import com.wonder.wonder.service.util.GameBoardView;
import lombok.Data;

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
    public void doAction(GameBoardView boardView) {
            int addGold = 0;
            if (actionSide.equals(ActionSide.DOWN)) {
                addGold += pointForOneCard;
            }
            // TODO ASK ABOUT ABOTHER VERSION
            boardView.getCurrentUserGameInfo().addGoldToNewEvent(addGold);
        }


}

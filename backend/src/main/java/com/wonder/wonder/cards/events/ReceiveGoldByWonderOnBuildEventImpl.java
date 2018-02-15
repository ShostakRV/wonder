package com.wonder.wonder.cards.events;

import com.wonder.wonder.cards.ActionSide;
import com.wonder.wonder.service.util.GameBoardView;
import lombok.Data;

import java.util.stream.Collectors;

/**
 * Created bm
 * Date 25.06.17.
 */
@Data
public class ReceiveGoldByWonderOnBuildEventImpl implements OnBuildEvent {
    private final ActionSide actionSide;
    private final int pointForOneCard;

    ReceiveGoldByWonderOnBuildEventImpl(ActionSide actionSide, int pointForOneCard) {
        this.actionSide = actionSide;
        this.pointForOneCard = pointForOneCard;
    }

    @Override
    public void doAction(GameBoardView boardView) {
        int addGold = 0;
        if (actionSide.equals(ActionSide.DOWN)) {
            addGold += pointForOneCard * boardView.getUserWonderLevel();
            boardView.getCurrentUserGameInfo().addGoldToNewEvent(addGold);
        }else {
            throw new RuntimeException("unexpected behavior someting");
        }


    }

}

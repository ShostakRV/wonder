package com.wonder.wonder.cards.passiveAbility;

import com.wonder.wonder.cards.ActionSide;
import com.wonder.wonder.cards.BaseResource;
import com.wonder.wonder.cards.GameCardColor;
import com.wonder.wonder.cards.events.OnBuildEvent;
import com.wonder.wonder.service.util.GameUserInfo;
import lombok.Data;

import java.util.List;

/**
 * Created bm
 * Date 25.06.17.
 */
// NOT USE
@Data
public class TradeDiscount {
    private final ActionSide actionSide;
    private final GameCardColor cardColor;

    private TradeDiscount(ActionSide actionSide, GameCardColor cardColor) {
        this.actionSide = actionSide;
        this.cardColor = cardColor;
    }

    public static TradeDiscount create(ActionSide actionSide, GameCardColor cardColor) {
        return new TradeDiscount(actionSide, cardColor);
    }

    public void doActivePasiive(GameUserInfo gameUserInfo) {
        if (actionSide == ActionSide.RIGHT_AND_LEFT) {
            if (cardColor == GameCardColor.BROWN) {
                gameUserInfo.addHaveRightAndLeftTradeBrown();

            }
            if (cardColor == GameCardColor.SILVER) {
                gameUserInfo.addHaveRigrhAndLeftTradeSilver();
            }
        }
        if (cardColor == GameCardColor.BROWN) {
            if (actionSide == ActionSide.LEFT) {
                gameUserInfo.addHaveLeftTradeBrown();
            } else if (actionSide == ActionSide.RIGHT) {
                gameUserInfo.addHaveRigrhTradeBrown();
            }
        }

    }
}

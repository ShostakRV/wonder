package com.wonder.wonder.cards.passiveAbility;

import com.wonder.wonder.cards.ActionSide;
import com.wonder.wonder.cards.BaseResource;
import com.wonder.wonder.cards.GameCardColor;
import com.wonder.wonder.cards.events.OnBuildEvent;
import lombok.Data;

import java.util.List;

/**
 * Created bm
 * Date 25.06.17.
 */
@Data
public class TradeDiscount {
    private final ActionSide actionSide;
    private final GameCardColor cardColor;

    private TradeDiscount(ActionSide actionSide, GameCardColor cardColor) {
        this.actionSide = actionSide;
        this.cardColor = cardColor;
    }

    public static TradeDiscount create(ActionSide actionSide, GameCardColor cardColor){
        return new TradeDiscount(actionSide, cardColor);
    }
}

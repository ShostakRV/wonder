package com.wonder.wonder.cards.passiveAbility;

import com.wonder.wonder.cards.ActionSide;
import com.wonder.wonder.cards.BaseResource;

import java.util.List;


/**
 * Created bm
 * Date 25.06.17.
 */
public interface OnBuildAbility {
    static OnBuildAbility none() {
        return () -> {        };
    }

    static OnBuildAbility trade(ActionSide actionSide, List listBaseResource ) {
        return new TradeOnBuildAbilityImpl(actionSide,listBaseResource);
    }

    void ability();
}

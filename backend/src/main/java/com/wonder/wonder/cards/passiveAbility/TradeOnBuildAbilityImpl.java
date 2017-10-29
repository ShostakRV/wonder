package com.wonder.wonder.cards.passiveAbility;

import com.wonder.wonder.cards.ActionSide;
import com.wonder.wonder.cards.BaseResource;
import com.wonder.wonder.cards.events.OnBuildEvent;
import lombok.Data;

import java.util.List;

/**
 * Created bm
 * Date 25.06.17.
 */
@Data
public class TradeOnBuildAbilityImpl implements OnBuildAbility {
    private final ActionSide actionSide;
    private final List<BaseResource> baseResourceList;

    public TradeOnBuildAbilityImpl(ActionSide actionSide,List<BaseResource> baseResourceList) {
        this.actionSide = actionSide;
        this.baseResourceList = baseResourceList;
    }

    @Override
    public void ability() {

    }
}

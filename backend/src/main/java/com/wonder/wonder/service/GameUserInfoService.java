package com.wonder.wonder.service;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.cards.GameResource;
import com.wonder.wonder.model.Event;
import com.wonder.wonder.phase.UserActionOnCard;
import com.wonder.wonder.service.util.GameUserInfo;

import java.util.List;
import java.util.Map;


public interface GameUserInfoService {

    boolean build(UserActionOnCard userActionOnCard);

    boolean buildZeus(UserActionOnCard eventUserChoose);

    boolean buildWonder(UserActionOnCard userActionOnCard);

    boolean cardGiveResources(GameResource pastCardgiveResource);

    boolean buildChain(GameCard pastChainBuild);

    void addWonderBaseResourse(GameUserInfo gameUserInfo, GameResource resource);

    Map<Long, GameUserInfo> createGameUserInfo(List<Event> events);

    boolean isZeusDiscauntEnabledCard(GameCard eventCard);

    boolean isHaveLastCardCanBuildPassiveCard(GameCard eventCard);

    boolean isHaveLeftTradeBrownCard(GameCard eventCard);

    boolean isHaveRigrhTradeBrownCard(GameCard eventCard);

    boolean isHaveRigrhAndLeftTradeBrownCard(GameCard eventCard);

    boolean isHaveRigrhAndLeftTradeSilverCard(GameCard eventCard);
}

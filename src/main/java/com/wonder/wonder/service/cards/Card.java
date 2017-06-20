package com.wonder.wonder.service.cards;

import com.wonder.wonder.service.cards.resouse_NeedRename.GameCardColor;
import com.wonder.wonder.service.cards.resouse_NeedRename.GameResource;

import java.util.List;

/**
 * Creator: bm
 * Date: 14.06.17.
 */
public interface Card {
    List<Card> getAllCard(int numberPlayer,int age);
    void setField(List<Card> cards); // delete in future

    boolean isResourceOf( GameCardColor color); // maybe isCardOf



    boolean isTradeCard();

    boolean isCardChangeGold();  // Debt card + Gold give card

    boolean isScientistGuild();

    boolean isCardNeedWeedAndMix();

    GameResource getResource();

}

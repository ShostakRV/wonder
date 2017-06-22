package com.wonder.wonder.service.cards;

/**
 * Creator: bm
 * Date: 14.06.17.
 */
public interface Card {

    boolean isResourceOf( GameCardColor color); // maybe isCardOf



    boolean isTradeCard();

    boolean isCardChangeGold();  // Debt card + Gold give card

    boolean isScientistGuild();

    boolean isCardNeedWeedAndMix();

    GameResource getResource();

}

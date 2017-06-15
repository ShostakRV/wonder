package com.wonder.wonder.service.cards;

import com.wonder.wonder.service.cards.resouse.GameCardColor;
import com.wonder.wonder.service.cards.resouse.GameResource;

import java.util.List;

/**
 * Creator: bm
 * Date: 14.06.17.
 */
public interface Card {
    List<Card> getAllCard(int numberPlayer,int age);
    void setField(List<Card> cards);

    boolean isResourceOf( GameCardColor color);

    boolean isResourceCard();

    GameResource getResource();
}

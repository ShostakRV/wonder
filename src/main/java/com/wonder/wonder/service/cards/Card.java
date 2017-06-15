package com.wonder.wonder.service.cards;

import java.util.List;

/**
 * Creator: bm
 * Date: 14.06.17.
 */
public interface Card {
    List<Card> getAllCard(int numberPlayer,int age);
    void setField(List<Card> cards);
}

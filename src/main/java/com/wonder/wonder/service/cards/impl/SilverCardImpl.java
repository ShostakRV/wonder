package com.wonder.wonder.service.cards.impl;

import com.wonder.wonder.service.cards.Card;
import com.wonder.wonder.service.cards.resouse.Resouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Creator: bm
 * Date: 13.06.17.
 */
// need add count cards +3 +4 +5 +6 +7 people

public enum SilverCardImpl implements Card {
    //silver first age + second age 3+3 = 6
    LOOM(Resouse.SILK),
    GLASSWORKS(Resouse.GLASS),
    PRESS(Resouse.PARCHMENT);

    Resouse giveResourse;

    SilverCardImpl(Resouse giveResourse) {
        this.giveResourse = giveResourse;
    }

    public Resouse getGiveResourse() {
        return giveResourse;
    }

    @Override
    public List<Card> getAllCard() {
        List<Card> cards = new ArrayList<>();
        cards.add(SilverCardImpl.LOOM);
        cards.add(SilverCardImpl.GLASSWORKS);
        cards.add(SilverCardImpl.PRESS);

        return cards;
    }
    @Override
    public void setField() {}


}



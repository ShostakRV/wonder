package com.wonder.wonder.service.cards;

import com.wonder.wonder.service.cards.impl.*;
import com.wonder.wonder.service.cards.resouse.Resouse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Creator: bm
 * Date: 14.06.17.
 */
public class CardTest {
    @Test
    public void getAllCardsBlue() {
        Card card = BlueCardImpl.PAWNSHOP;
        int size = card.getAllCard(3,1).size();
        assertEquals(13, size);

    }

    @Test
    public void getAllCardsBlueSetFieldAQUEDUCT() {
        Card cardMain = BlueCardImpl.PAWNSHOP;
        List<Card> cards = cardMain.getAllCard(3,3);

        for (Card card : cards) {
            BlueCardImpl blueCard = (BlueCardImpl) card;
            String nameClass = "";
            if (blueCard.getChain() != null) {
                String[] pathClass = blueCard.getChain().getClass().toString().split("\\.");
                nameClass = pathClass[6];
            }
            int point = blueCard.getTakeBluePoint();
            String name = blueCard.name();
            if (name.equals("AQUEDUCT")) {
                assertEquals(5, point);
                if (nameClass.equals("BlueCardImpl")) {
                    BlueCardImpl chainBlue = (BlueCardImpl) blueCard.getChain();
                    assertEquals(BlueCardImpl.BATHS, chainBlue);
                }
//                else if(nameClass.equals("GreenCardImp")) {
//                    GreenCardImpl chainGreen = (GreenCardImpl) blueCard.getChain();
//                    assertEquals(GreenCardImpl., chainGreen);
//                }
                List<Resouse> resouses = new ArrayList<>();
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.STONE);
                assertEquals(resouses, blueCard.getResourseNeededForConstruction());
            }
        }
    }


    @Test
    public void getAllCardsYellow() {
        Card card = YellowCardImpl.ARENA;
        int size = card.getAllCard(3,1).size();
        assertEquals(0, size);
    }

    @Test
    public void getAllCardsPurple() {
        Card card = PurpleImpl.BUILDERS_GUILD;
        int size = card.getAllCard(3,1).size();
        assertEquals(0, size);
    }

    @Test
    public void getAllCardsRed() {
        Card card = RedCardImpl.STOCKADE;
        int size = card.getAllCard(3,1).size();
        assertEquals(11, size);
    }

    @Test
    public void getAllCardsBrown() {
        Card card = BrownCardImpl.BRICKYARD;
        int size = card.getAllCard(3,1).size();
        assertEquals(14, size);
    }

    @Test
    public void getAllCardsGreen() {
        Card card = GreenCardImpl.ACADEMY;
        int size = card.getAllCard(3,1).size();
        assertEquals(12, size);
    }

    @Test
    public void getAllCardsByNumberPlayer() {
        Card card = GreenCardImpl.ACADEMY;
        int size = card.getAllCard(3,1).size();
        assertEquals(0, size);
    }


}

package com.wonder.wonder.service.cards;

import com.wonder.wonder.service.cards.impl.*;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Creator: bm
 * Date: 14.06.17.
 */
public class CardTest {
    @Test
    public void getAllCardsBlue() {
        Card card = BlueCardImpl.PAWNSHOP;
        int size = card.getAllCard().size();
        assertEquals(13, size);

    }
    @Test
    public void getAllCardsSilver() {
        Card card = SilverCardImpl.LOOM;
        int size = card.getAllCard().size();
        assertEquals(3, size);

    }
    @Test
    public void getAllCardsYellow() {
        Card card = YellowCardImpl.ARENA;
        int size = card.getAllCard().size();
        assertEquals(0, size);
    }

    @Test
    public void getAllCardsPurple() {
        Card card = PurpleImpl.BUILDERS_GUILD;
        int size = card.getAllCard().size();
        assertEquals(0, size);
    }
    @Test
    public void getAllCardsRed() {
        Card card = RedCardImpl.STOCKADE;
        int size = card.getAllCard().size();
        assertEquals(11, size);
    }
    @Test
    public void getAllCardsBrown() {
        Card card = BrownCardImpl.BRICKYARD;
        int size = card.getAllCard().size();
        assertEquals(14, size);
    }
    @Test
    public void getAllCardsGreen() {
        Card card = GreenCardImpl.ACADEMY;
        int size = card.getAllCard().size();
        assertEquals(12, size);
    }
    @Test
    public void getAllCardsByNumberPlayer() {
        Card card = GreenCardImpl.ACADEMY;
        int size = card.getAllCard().size();
        assertEquals(0, size);
    }


}

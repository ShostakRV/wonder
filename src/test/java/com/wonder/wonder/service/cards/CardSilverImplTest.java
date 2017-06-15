package com.wonder.wonder.service.cards;

import com.wonder.wonder.service.cards.impl.SilverCardImpl;
import com.wonder.wonder.service.cards.resouse.Resouse;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Creator: bm
 * Date: 15.06.17.
 */
public class CardSilverImplTest {

    @Test
    public void getAllCards_3Players_1age() {
        Card card = SilverCardImpl.LOOM;
        List<Card> cardList = card.getAllCard(3, 1);
        int size = cardList.size();
        assertEquals(3, size);
    }

    @Test
    public void getAllCards_Resouce_Give() {
        Card card = SilverCardImpl.LOOM;
        List<Card> cardList = card.getAllCard(3, 1);
        for (Card card1 : cardList) {
            SilverCardImpl silverCard = (SilverCardImpl) card1;
            switch (silverCard.name()) {
                case "LOOM":
                    assertEquals(Resouse.SILK, silverCard.getGiveResourse());
                    break;
                case "GLASSWORKS":
                    assertEquals(Resouse.GLASS, silverCard.getGiveResourse());
                    break;
                case "PRESS":
                    assertEquals(Resouse.PARCHMENT, silverCard.getGiveResourse());
                    break;
            }
        }
    }

    @Test
    public void getAllCards_6Players_1age() {
        Card card = SilverCardImpl.LOOM;
        int size = card.getAllCard(6, 1).size();
        assertEquals(6, size);

    }

    @Test
    public void getAllCards_3Players_2age() {
        Card card = SilverCardImpl.LOOM;
        int size = card.getAllCard(3, 2).size();
        assertEquals(3, size);
    }

    @Test
    public void getAllCards_5Players_2age() {
        Card card = SilverCardImpl.LOOM;
        int size = card.getAllCard(5, 2).size();
        assertEquals(6, size);

    }

    @Test
    public void getAllCards_Resouce_Give_2Age() {
        Card card = SilverCardImpl.LOOM;
        List<Card> cardList = card.getAllCard(3, 1);
        for (Card card1 : cardList) {
            SilverCardImpl silverCard = (SilverCardImpl) card1;
            if (silverCard.name().equals("LOOM")) {
                assertEquals(Resouse.SILK, silverCard.getGiveResourse());
            } else if (silverCard.name().equals("GLASSWORKS")) {
                assertEquals(Resouse.GLASS, silverCard.getGiveResourse());
            } else if (silverCard.name().equals("PRESS")) {
                assertEquals(Resouse.PARCHMENT, silverCard.getGiveResourse());

            }
        }
    }
}

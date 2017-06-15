package com.wonder.wonder.service.cards;

import com.wonder.wonder.service.cards.impl.BlueCardImpl;
import com.wonder.wonder.service.cards.impl.GreenCardImpl;
import com.wonder.wonder.service.cards.resouse.Resouse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Creator: bm
 * Date: 15.06.17.
 */
public class BlueCardImplTest {

    @Test
    public void getAllCards_3Players_1age() {
        Card card = BlueCardImpl.ALTAR;
        List<Card> cardList = card.getAllCard(3, 1);
        int size = cardList.size();
        assertEquals(3, size);
    }

    @Test
    public void getAllCards_4Players_1age() {
        Card card = BlueCardImpl.ALTAR;
        List<Card> cardList = card.getAllCard(4, 1);
        int size = cardList.size();
        assertEquals(4, size);
    }

    @Test
    public void getAllCards_5Players_1age() {
        Card card = BlueCardImpl.ALTAR;
        List<Card> cardList = card.getAllCard(5, 1);
        int size = cardList.size();
        assertEquals(5, size);
    }

    @Test
    public void getAllCards_6Players_1age() {
        Card card = BlueCardImpl.ALTAR;
        List<Card> cardList = card.getAllCard(6, 1);
        int size = cardList.size();
        assertEquals(6, size);
    }

    @Test
    public void getAllCards_7Players_1age() {
        Card card = BlueCardImpl.ALTAR;
        List<Card> cardList = card.getAllCard(7, 1);
        int size = cardList.size();
        assertEquals(8, size);
    }

    @Test
    public void getAllCards_3Players_2age() {
        Card card = BlueCardImpl.ALTAR;
        List<Card> cardList = card.getAllCard(3, 2);
        int size = cardList.size();
        assertEquals(4, size);
    }

    @Test
    public void getAllCards_5Players_2age() {
        Card card = BlueCardImpl.ALTAR;
        List<Card> cardList = card.getAllCard(5, 2);
        int size = cardList.size();
        assertEquals(5, size);
    }

    @Test
    public void getAllCards_6Players_2age() {
        Card card = BlueCardImpl.ALTAR;
        List<Card> cardList = card.getAllCard(6, 2);
        int size = cardList.size();
        assertEquals(6, size);
    }

    @Test
    public void getAllCards_7Players_2age() {
        Card card = BlueCardImpl.ALTAR;
        List<Card> cardList = card.getAllCard(7, 2);
        int size = cardList.size();
        assertEquals(8, size);
    }

    @Test
    public void getAllCards_3Players_3age() {
        Card card = BlueCardImpl.ALTAR;
        List<Card> cardList = card.getAllCard(3, 3);
        int size = cardList.size();
        assertEquals(5, size);
    }

    @Test
    public void getAllCards_4Players_3age() {
        Card card = BlueCardImpl.ALTAR;
        List<Card> cardList = card.getAllCard(4, 3);
        int size = cardList.size();
        assertEquals(6, size);
    }

    @Test
    public void getAllCards_5Players_3age() {
        Card card = BlueCardImpl.ALTAR;
        List<Card> cardList = card.getAllCard(5, 3);
        int size = cardList.size();
        assertEquals(9, size);
    }

    @Test
    public void getAllCards_6Players_3age() {
        Card card = BlueCardImpl.ALTAR;
        List<Card> cardList = card.getAllCard(6, 3);
        int size = cardList.size();
        assertEquals(11, size);
    }

    @Test
    public void getAllCards_7Players_3age() {
        Card card = BlueCardImpl.ALTAR;
        List<Card> cardList = card.getAllCard(7, 3);
        int size = cardList.size();
        assertEquals(11, size);
    }


    @Test
    public void getAll_Cards_BlueCard_Resouce_Need_To_Build_1Age() {
        Card card = BlueCardImpl.ALTAR;
        List<Card> cardList = card.getAllCard(7, 1);
        int size = 0;
        for (Card card1 : cardList) {
            List<Resouse> resouses = new ArrayList<>();
            BlueCardImpl blueCard = (BlueCardImpl) card1;
            if (blueCard.equals(BlueCardImpl.BATHS)) {
                resouses.add(Resouse.STONE);
                assertEquals(resouses, ((BlueCardImpl) card1).getResourseNeededForConstruction());
                size++;
            }
        }
        assertEquals(2, size);
    }

    @Test
    public void getAll_Cards_BlueCard_Resouce_Need_To_Build_2Age() {
        Card card = BlueCardImpl.ALTAR;
        List<Card> cardList = card.getAllCard(7, 2);
        int size = 0;
        for (Card card1 : cardList) {
            List<Resouse> resouses = new ArrayList<>();
            BlueCardImpl blueCard = (BlueCardImpl) card1;
            if (blueCard.equals(BlueCardImpl.AQUEDUCT)) {
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.STONE);
                assertEquals(resouses, ((BlueCardImpl) card1).getResourseNeededForConstruction());
                size++;
            } else if (blueCard.equals(BlueCardImpl.TEMPLE)) {
                resouses.add(Resouse.WOOD);
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.GLASS);
                assertEquals(resouses, ((BlueCardImpl) card1).getResourseNeededForConstruction());
                size++;
            } else if (blueCard.equals(BlueCardImpl.STATUE)) {
                resouses.add(Resouse.WOOD);
                resouses.add(Resouse.IRON);
                resouses.add(Resouse.IRON);
                assertEquals(resouses, ((BlueCardImpl) card1).getResourseNeededForConstruction());
                size++;
            } else if (blueCard.equals(BlueCardImpl.COURTHOUSE)) {
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.SILK);
                assertEquals(resouses, ((BlueCardImpl) card1).getResourseNeededForConstruction());
                size++;
            }
        }
        assertEquals(8, size);
    }

    @Test
    public void getAll_Cards_BlueCard_Resouce_Need_To_Build_3Age() {
        Card card = BlueCardImpl.ALTAR;
        List<Card> cardList = card.getAllCard(7, 3);
        int size = 0;
        for (Card card1 : cardList) {
            List<Resouse> resouses = new ArrayList<>();
            BlueCardImpl blueCard = (BlueCardImpl) card1;
            if (blueCard.equals(BlueCardImpl.PANTHEON)) {
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.IRON);
                resouses.add(Resouse.SILK);
                resouses.add(Resouse.GLASS);
                resouses.add(Resouse.PARCHMENT);
                assertEquals(resouses, ((BlueCardImpl) card1).getResourseNeededForConstruction());
                size++;
            } else if (blueCard.equals(BlueCardImpl.GARDENS)) {
                resouses.add(Resouse.WOOD);
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.CLAY);
                assertEquals(resouses, ((BlueCardImpl) card1).getResourseNeededForConstruction());
                size++;
            } else if (blueCard.equals(BlueCardImpl.TOWN_HALL)) {
                resouses.add(Resouse.GLASS);
                resouses.add(Resouse.IRON);
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.STONE);
                assertEquals(resouses, ((BlueCardImpl) card1).getResourseNeededForConstruction());
                size++;
            } else if (blueCard.equals(BlueCardImpl.PALACE)) {
                resouses.add(Resouse.GLASS);
                resouses.add(Resouse.PARCHMENT);
                resouses.add(Resouse.SILK);
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.WOOD);
                resouses.add(Resouse.IRON);
                resouses.add(Resouse.STONE);
                assertEquals(resouses, ((BlueCardImpl) card1).getResourseNeededForConstruction());
                size++;
            } else if (blueCard.equals(BlueCardImpl.SENATE)) {
                resouses.add(Resouse.IRON);
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.WOOD);
                assertEquals(resouses, ((BlueCardImpl) card1).getResourseNeededForConstruction());
                size++;
            }
        }
        assertEquals(11, size);
    }

    @Test
    public void getAll_Cards_BlueCard_Chain_2Age() {
        Card card = BlueCardImpl.ALTAR;
        List<Card> cardList = card.getAllCard(7, 2);
        int size = 0;
        for (Card card1 : cardList) {
            BlueCardImpl blueCard = (BlueCardImpl) card1;
            if (blueCard.equals(BlueCardImpl.AQUEDUCT)) {
                assertEquals(BlueCardImpl.BATHS, blueCard.getChain());
                size++;
            } else if (blueCard.equals(BlueCardImpl.TEMPLE)) {
                assertEquals(BlueCardImpl.ALTAR, blueCard.getChain());
                size++;
            } else if (blueCard.equals(BlueCardImpl.STATUE)) {
                assertEquals(BlueCardImpl.THEATER, blueCard.getChain());
                size++;
            } else if (blueCard.equals(BlueCardImpl.COURTHOUSE)) {
                assertEquals(GreenCardImpl.SCRIPTORIUM, blueCard.getChain());
                size++;
            }
        }
        assertEquals(8, size);
    }

    @Test
    public void getAll_Cards_BlueCard_Chain_3Age() {
        Card card = BlueCardImpl.ALTAR;
        List<Card> cardList = card.getAllCard(7, 3);
        int size = 0;
        for (Card card1 : cardList) {
            BlueCardImpl blueCard = (BlueCardImpl) card1;
            if (blueCard.equals(BlueCardImpl.PANTHEON)) {
                assertEquals(BlueCardImpl.TEMPLE, blueCard.getChain());
                size++;
            } else if (blueCard.equals(BlueCardImpl.GARDENS)) {
                assertEquals(BlueCardImpl.STATUE, blueCard.getChain());
                size++;
            } else if (blueCard.equals(BlueCardImpl.TOWN_HALL)) {
                assertEquals(BlueCardImpl.THEATER, blueCard.getChain());
                size++;
            } else if (blueCard.equals(BlueCardImpl.SENATE)) {
                assertEquals(GreenCardImpl.LIBRARY, blueCard.getChain());
                size++;
            }
            assertEquals(4, size);
        }
    }
}

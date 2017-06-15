package com.wonder.wonder.service.cards;

import com.wonder.wonder.service.cards.impl.BlueCardImpl;
import com.wonder.wonder.service.cards.impl.BrownCardImpl;
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
        List<Card> cardList = card.getAllCard(3, 1);
        int size = cardList.size();
        assertEquals(3, size);
    }

    @Test
    public void getAllCards_4Players_2age() {
        Card card = BlueCardImpl.ALTAR;
        List<Card> cardList = card.getAllCard(4, 1);
        int size = cardList.size();
        assertEquals(4, size);
    }

    @Test
    public void getAllCards_5Players_2age() {
        Card card = BlueCardImpl.ALTAR;
        List<Card> cardList = card.getAllCard(5, 1);
        int size = cardList.size();
        assertEquals(5, size);
    }

    @Test
    public void getAllCards_6Players_2age() {
        Card card = BlueCardImpl.ALTAR;
        List<Card> cardList = card.getAllCard(6, 1);
        int size = cardList.size();
        assertEquals(6, size);
    }

    @Test
    public void getAllCards_7Players_2age() {
        Card card = BlueCardImpl.ALTAR;
        List<Card> cardList = card.getAllCard(7, 1);
        int size = cardList.size();
        assertEquals(8, size);
    }


    @Test
    public void getAllCards_Resouce_Give_1Age_OneTypeResouce() {
        Card card = BlueCardImpl.ALTAR;
        List<Card> cardList = card.getAllCard(7, 1);
        int size = 0;
        for (Card card1 : cardList) {
            List<Resouse> resouses = new ArrayList<>();
            BrownCardImpl brownCard = (BrownCardImpl) card1;
            switch (brownCard.name()) {
                case "LUMBER_YARD":
                    resouses.add(Resouse.WOOD);
                    assertEquals(resouses, brownCard.getGiveResourse());
                    size++;
                    break;
                case "STONE_PIT":
                    resouses.add(Resouse.STONE);
                    assertEquals(resouses, brownCard.getGiveResourse());
                    size++;
                    break;
                case "CLAY_POOL":
                    resouses.add(Resouse.CLAY);
                    assertEquals(resouses, brownCard.getGiveResourse());
                    size++;
                    break;
                case "ORE_VEIN":
                    resouses.add(Resouse.IRON);
                    assertEquals(resouses, brownCard.getGiveResourse());
                    size++;
                    break;
            }
        }
        assertEquals(8, size);
    }

    @Test
    public void getAllCards_Resouce_Give_2Age_OneTypeResouce() {
        Card card = BlueCardImpl.ALTAR;
        List<Card> cardList = card.getAllCard(7, 2);
        int size = 0;
        for (Card card1 : cardList) {
            List<Resouse> resouses = new ArrayList<>();
            BrownCardImpl brownCard = (BrownCardImpl) card1;
            switch (brownCard.name()) {
                case "SAWMILL":
                    resouses.add(Resouse.WOOD);
                    resouses.add(Resouse.WOOD);
                    assertEquals(resouses, brownCard.getGiveResourse());
                    size++;
                    break;
                case "QUARRY":
                    resouses.add(Resouse.STONE);
                    resouses.add(Resouse.STONE);
                    assertEquals(resouses, brownCard.getGiveResourse());
                    size++;
                    break;
                case "BRICKYARD":
                    resouses.add(Resouse.CLAY);
                    resouses.add(Resouse.CLAY);
                    assertEquals(resouses, brownCard.getGiveResourse());
                    size++;
                    break;
                case "FOUNDRY":
                    resouses.add(Resouse.IRON);
                    resouses.add(Resouse.IRON);
                    assertEquals(resouses, brownCard.getGiveResourse());
                    size++;
                    break;

            }
        }

        assertEquals(8, size);
    }

    @Test
    public void getAllCards_Resouce_Two_Type() {
        Card card = BlueCardImpl.ALTAR;
        List<Card> cardList = card.getAllCard(7, 1);
        int size = 0;
        for (Card card1 : cardList) {
            List<Resouse> resouses = new ArrayList<>();
            BrownCardImpl brownCard = (BrownCardImpl) card1;
            switch (brownCard) {
                case TREE_FARM:
                    resouses.add(Resouse.WOOD);
                    resouses.add(Resouse.CLAY);
                    assertEquals(resouses, brownCard.getGiveResourse());
                    size++;
                    break;
                case EXCAVATION:
                    resouses.add(Resouse.STONE);
                    resouses.add(Resouse.CLAY);
                    assertEquals(resouses, brownCard.getGiveResourse());
                    size++;
                    break;
                case CLAY_PIT:
                    resouses.add(Resouse.IRON);
                    resouses.add(Resouse.CLAY);
                    assertEquals(resouses, brownCard.getGiveResourse());
                    size++;
                    break;
                case TIMBER_YARD:
                    resouses.add(Resouse.STONE);
                    resouses.add(Resouse.WOOD);
                    assertEquals(resouses, brownCard.getGiveResourse());
                    size++;
                    break;
                case FOREST_CAVE:
                    resouses.add(Resouse.WOOD);
                    resouses.add(Resouse.IRON);
                    assertEquals(resouses, brownCard.getGiveResourse());
                    size++;
                    break;
                case MINE:
                    resouses.add(Resouse.STONE);
                    resouses.add(Resouse.IRON);
                    assertEquals(resouses, brownCard.getGiveResourse());
                    size++;
                    break;
            }
        }
        assertEquals(6, size);
    }
}

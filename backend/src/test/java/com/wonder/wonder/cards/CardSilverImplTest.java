package com.wonder.wonder.cards;

/**
 * Creator: bm
 * Date: 15.06.17.
 */
//public class CardSilverImplTest {
//
//    @Test
//    public void getAllCards_3Players_1age() {
//        Card card = SilverCardImpl.LOOM;
//        List<Card> cardList = card.getAllCard(3, 1);
//        int size = cardList.size();
//        assertEquals(3, size);
//    }
//
//    @Test
//    public void getAllCards_Resouce_Give() {
//        Card card = SilverCardImpl.LOOM;
//        List<Card> cardList = card.getAllCard(3, 1);
//        for (Card card1 : cardList) {
//            SilverCardImpl silverCard = (SilverCardImpl) card1;
//            switch (silverCard.name()) {
//                case "LOOM":
//                    assertEquals(GameResource.SILK, silverCard.getGiveResourse());
//                    break;
//                case "GLASSWORKS":
//                    assertEquals(GameResource.GLASS, silverCard.getGiveResourse());
//                    break;
//                case "PRESS":
//                    assertEquals(GameResource.PARCHMENT, silverCard.getGiveResourse());
//                    break;
//            }
//        }
//    }
//
//    @Test
//    public void getAllCards_6Players_1age() {
//        Card card = SilverCardImpl.LOOM;
//        int size = card.getAllCard(6, 1).size();
//        assertEquals(6, size);
//
//    }
//
//    @Test
//    public void getAllCards_3Players_2age() {
//        Card card = SilverCardImpl.LOOM;
//        int size = card.getAllCard(3, 2).size();
//        assertEquals(3, size);
//    }
//
//    @Test
//    public void getAllCards_5Players_2age() {
//        Card card = SilverCardImpl.LOOM;
//        int size = card.getAllCard(5, 2).size();
//        assertEquals(6, size);
//
//    }
//
//    @Test
//    public void getAllCards_Resouce_Give_2Age() {
//        Card card = SilverCardImpl.LOOM;
//        List<Card> cardList = card.getAllCard(3, 1);
//        for (Card card1 : cardList) {
//            SilverCardImpl silverCard = (SilverCardImpl) card1;
//            if (silverCard.name().equals("LOOM")) {
//                assertEquals(GameResource.SILK, silverCard.getGiveResourse());
//            } else if (silverCard.name().equals("GLASSWORKS")) {
//                assertEquals(GameResource.GLASS, silverCard.getGiveResourse());
//            } else if (silverCard.name().equals("PRESS")) {
//                assertEquals(GameResource.PARCHMENT, silverCard.getGiveResourse());
//
//            }
//        }
//    }
//}

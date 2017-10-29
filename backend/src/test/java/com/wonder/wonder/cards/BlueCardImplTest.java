package com.wonder.wonder.cards;

/**
 * Creator: bm
 * Date: 15.06.17.
 */
//public class BlueCardImplTest {
//
//    @Test
//    public void getAllCards_3Players_1age() {
//        Card card = BlueCardImpl.ALTAR;
//        List<Card> cardList = card.getAllCard(3, 1);
//        int size = cardList.size();
//        assertEquals(3, size);
//    }
//
//    @Test
//    public void getAllCards_4Players_1age() {
//        Card card = BlueCardImpl.ALTAR;
//        List<Card> cardList = card.getAllCard(4, 1);
//        int size = cardList.size();
//        assertEquals(4, size);
//    }
//
//    @Test
//    public void getAllCards_5Players_1age() {
//        Card card = BlueCardImpl.ALTAR;
//        List<Card> cardList = card.getAllCard(5, 1);
//        int size = cardList.size();
//        assertEquals(5, size);
//    }
////
//    @Test
//    public void getAllCards_6Players_1age() {
//        Card card = BlueCardImpl.ALTAR;
//        List<Card> cardList = card.getAllCard(6, 1);
//        int size = cardList.size();
//        assertEquals(6, size);
//    }
//
//    @Test
//    public void getAllCards_7Players_1age() {
//        Card card = BlueCardImpl.ALTAR;
//        List<Card> cardList = card.getAllCard(7, 1);
//        int size = cardList.size();
//        assertEquals(8, size);
//    }
//
//    @Test
//    public void getAllCards_3Players_2age() {
//        Card card = BlueCardImpl.ALTAR;
//        List<Card> cardList = card.getAllCard(3, 2);
//        int size = cardList.size();
//        assertEquals(4, size);
//    }
//
//    @Test
//    public void getAllCards_5Players_2age() {
//        Card card = BlueCardImpl.ALTAR;
//        List<Card> cardList = card.getAllCard(5, 2);
//        int size = cardList.size();
//        assertEquals(5, size);
//    }
//
//    @Test
//    public void getAllCards_6Players_2age() {
//        Card card = BlueCardImpl.ALTAR;
//        List<Card> cardList = card.getAllCard(6, 2);
//        int size = cardList.size();
//        assertEquals(6, size);
//    }
//
//    @Test
//    public void getAllCards_7Players_2age() {
//        Card card = BlueCardImpl.ALTAR;
//        List<Card> cardList = card.getAllCard(7, 2);
//        int size = cardList.size();
//        assertEquals(8, size);
//    }
//
//    @Test
//    public void getAllCards_3Players_3age() {
//        Card card = BlueCardImpl.ALTAR;
//        List<Card> cardList = card.getAllCard(3, 3);
//        int size = cardList.size();
//        assertEquals(5, size);
//    }
//
//    @Test
//    public void getAllCards_4Players_3age() {
//        Card card = BlueCardImpl.ALTAR;
//        List<Card> cardList = card.getAllCard(4, 3);
//        int size = cardList.size();
//        assertEquals(6, size);
//    }
//
//    @Test
//    public void getAllCards_5Players_3age() {
//        Card card = BlueCardImpl.ALTAR;
//        List<Card> cardList = card.getAllCard(5, 3);
//        int size = cardList.size();
//        assertEquals(9, size);
//    }
//
//    @Test
//    public void getAllCards_6Players_3age() {
//        Card card = BlueCardImpl.ALTAR;
//        List<Card> cardList = card.getAllCard(6, 3);
//        int size = cardList.size();
//        assertEquals(11, size);
//    }
//
//    @Test
//    public void getAllCards_7Players_3age() {
//        Card card = BlueCardImpl.ALTAR;
//        List<Card> cardList = card.getAllCard(7, 3);
//        int size = cardList.size();
//        assertEquals(11, size);
//    }
//
//
//    @Test
//    public void getAll_Cards_BlueCard_Resouce_Need_To_Build_1Age() {
//        Card card = BlueCardImpl.ALTAR;
//        List<Card> cardList = card.getAllCard(7, 1);
//        int size = 0;
//        for (Card card1 : cardList) {
//            List<GameResource> gameResours = new ArrayList<>();
//            BlueCardImpl blueCard = (BlueCardImpl) card1;
//            if (blueCard.equals(BlueCardImpl.BATHS)) {
//                gameResours.add(GameResource.STONE);
//                assertEquals(gameResours, ((BlueCardImpl) card1).getResourseNeededForConstruction());
//                size++;
//            }
//        }
//        assertEquals(2, size);
//    }
//
//    @Test
//    public void getAll_Cards_BlueCard_Resouce_Need_To_Build_2Age() {
//        Card card = BlueCardImpl.ALTAR;
//        List<Card> cardList = card.getAllCard(7, 2);
//        int size = 0;
//        for (Card card1 : cardList) {
//            List<GameResource> gameResours = new ArrayList<>();
//            BlueCardImpl blueCard = (BlueCardImpl) card1;
//            if (blueCard.equals(BlueCardImpl.AQUEDUCT)) {
//                gameResours.add(GameResource.STONE);
//                gameResours.add(GameResource.STONE);
//                gameResours.add(GameResource.STONE);
//                assertEquals(gameResours, ((BlueCardImpl) card1).getResourseNeededForConstruction());
//                size++;
//            } else if (blueCard.equals(BlueCardImpl.TEMPLE)) {
//                gameResours.add(GameResource.WOOD);
//                gameResours.add(GameResource.CLAY);
//                gameResours.add(GameResource.GLASS);
//                assertEquals(gameResours, ((BlueCardImpl) card1).getResourseNeededForConstruction());
//                size++;
//            } else if (blueCard.equals(BlueCardImpl.STATUE)) {
//                gameResours.add(GameResource.WOOD);
//                gameResours.add(GameResource.IRON);
//                gameResours.add(GameResource.IRON);
//                assertEquals(gameResours, ((BlueCardImpl) card1).getResourseNeededForConstruction());
//                size++;
//            } else if (blueCard.equals(BlueCardImpl.COURTHOUSE)) {
//                gameResours.add(GameResource.CLAY);
//                gameResours.add(GameResource.CLAY);
//                gameResours.add(GameResource.SILK);
//                assertEquals(gameResours, ((BlueCardImpl) card1).getResourseNeededForConstruction());
//                size++;
//            }
//        }
//        assertEquals(8, size);
//    }
//
//    @Test
//    public void getAll_Cards_BlueCard_Resouce_Need_To_Build_3Age() {
//        Card card = BlueCardImpl.ALTAR;
//        List<Card> cardList = card.getAllCard(7, 3);
//        int size = 0;
//        for (Card card1 : cardList) {
//            List<GameResource> gameResours = new ArrayList<>();
//            BlueCardImpl blueCard = (BlueCardImpl) card1;
//            if (blueCard.equals(BlueCardImpl.PANTHEON)) {
//                gameResours.add(GameResource.CLAY);
//                gameResours.add(GameResource.CLAY);
//                gameResours.add(GameResource.IRON);
//                gameResours.add(GameResource.SILK);
//                gameResours.add(GameResource.GLASS);
//                gameResours.add(GameResource.PARCHMENT);
//                assertEquals(gameResours, ((BlueCardImpl) card1).getResourseNeededForConstruction());
//                size++;
//            } else if (blueCard.equals(BlueCardImpl.GARDENS)) {
//                gameResours.add(GameResource.WOOD);
//                gameResours.add(GameResource.CLAY);
//                gameResours.add(GameResource.CLAY);
//                assertEquals(gameResours, ((BlueCardImpl) card1).getResourseNeededForConstruction());
//                size++;
//            } else if (blueCard.equals(BlueCardImpl.TOWN_HALL)) {
//                gameResours.add(GameResource.GLASS);
//                gameResours.add(GameResource.IRON);
//                gameResours.add(GameResource.STONE);
//                gameResours.add(GameResource.STONE);
//                assertEquals(gameResours, ((BlueCardImpl) card1).getResourseNeededForConstruction());
//                size++;
//            } else if (blueCard.equals(BlueCardImpl.PALACE)) {
//                gameResours.add(GameResource.GLASS);
//                gameResours.add(GameResource.PARCHMENT);
//                gameResours.add(GameResource.SILK);
//                gameResours.add(GameResource.CLAY);
//                gameResours.add(GameResource.WOOD);
//                gameResours.add(GameResource.IRON);
//                gameResours.add(GameResource.STONE);
//                assertEquals(gameResours, ((BlueCardImpl) card1).getResourseNeededForConstruction());
//                size++;
//            } else if (blueCard.equals(BlueCardImpl.SENATE)) {
//                gameResours.add(GameResource.IRON);
//                gameResours.add(GameResource.STONE);
//                gameResours.add(GameResource.WOOD);
//                assertEquals(gameResours, ((BlueCardImpl) card1).getResourseNeededForConstruction());
//                size++;
//            }
//        }
//        assertEquals(11, size);
//    }
//
//    @Test
//    public void getAll_Cards_BlueCard_Chain_2Age() {
//        Card card = BlueCardImpl.ALTAR;
//        List<Card> cardList = card.getAllCard(7, 2);
//        int size = 0;
//        for (Card card1 : cardList) {
//            BlueCardImpl blueCard = (BlueCardImpl) card1;
//            if (blueCard.equals(BlueCardImpl.AQUEDUCT)) {
//                assertEquals(BlueCardImpl.BATHS, blueCard.getChain());
//                size++;
//            } else if (blueCard.equals(BlueCardImpl.TEMPLE)) {
//                assertEquals(BlueCardImpl.ALTAR, blueCard.getChain());
//                size++;
//            } else if (blueCard.equals(BlueCardImpl.STATUE)) {
//                assertEquals(BlueCardImpl.THEATER, blueCard.getChain());
//                size++;
//            } else if (blueCard.equals(BlueCardImpl.COURTHOUSE)) {
//                assertEquals(GreenCardImpl.SCRIPTORIUM, blueCard.getChain());
//                size++;
//            }
//        }
//        assertEquals(8, size);
//    }
//
//    @Test
//    public void getAll_Cards_BlueCard_Chain_3Age() {
//        Card card = BlueCardImpl.ALTAR;
//        List<Card> cardList = card.getAllCard(7, 3);
//        int size = 0;
//        for (Card card1 : cardList) {
//            BlueCardImpl blueCard = (BlueCardImpl) card1;
//            if (blueCard.equals(BlueCardImpl.PANTHEON)) {
//                assertEquals(BlueCardImpl.TEMPLE, blueCard.getChain());
//                size++;
//            } else if (blueCard.equals(BlueCardImpl.GARDENS)) {
//                assertEquals(BlueCardImpl.STATUE, blueCard.getChain());
//                size++;
//            } else if (blueCard.equals(BlueCardImpl.TOWN_HALL)) {
//                assertEquals(BlueCardImpl.THEATER, blueCard.getChain());
//                size++;
//            } else if (blueCard.equals(BlueCardImpl.SENATE)) {
//                assertEquals(GreenCardImpl.LIBRARY, blueCard.getChain());
//                size++;
//            }
//            assertEquals(4, size);
//        }
//    }
//}

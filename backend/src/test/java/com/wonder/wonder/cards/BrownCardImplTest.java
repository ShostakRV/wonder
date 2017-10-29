package com.wonder.wonder.cards;

/**
 * Creator: bm
 * Date: 15.06.17.
 */
//public class BrownCardImplTest {
//
//
//    @Test
//    public void getAllCards_3Players_1age() {
//        Card card = BrownCardImpl.BRICKYARD;
//        List<Card> cardList = card.getAllCard(3, 1);
//        int size = cardList.size();
//        assertEquals(6, size);
//    }
//
//    @Test
//    public void getAllCards_4Players_1age() {
//        Card card = BrownCardImpl.BRICKYARD;
//        List<Card> cardList = card.getAllCard(4, 1);
//        int size = cardList.size();
//        assertEquals(9, size);
//    }
//
//    @Test
//    public void getAllCards_5Players_1age() {
//        Card card = BrownCardImpl.BRICKYARD;
//        List<Card> cardList = card.getAllCard(5, 1);
//        int size = cardList.size();
//        assertEquals(12, size);
//    }
//
//    @Test
//    public void getAllCards_6Players_1age() {
//        Card card = BrownCardImpl.BRICKYARD;
//        List<Card> cardList = card.getAllCard(6, 1);
//        int size = cardList.size();
//        assertEquals(14, size);
//    }
//
//    @Test
//    public void getAllCards_Resouce_Give_1Age_OneTypeResouce() {
//        Card card = BrownCardImpl.BRICKYARD;
//        List<Card> cardList = card.getAllCard(7, 1);
//        int size = 0;
//        for (Card card1 : cardList) {
//            List<GameResource> gameResours = new ArrayList<>();
//            BrownCardImpl brownCard = (BrownCardImpl) card1;
//            switch (brownCard.name()) {
//                case "LUMBER_YARD":
//                    gameResours.add(GameResource.WOOD);
//                    assertEquals(gameResours, brownCard.getGiveResourse());
//                    size++;
//                    break;
//                case "STONE_PIT":
//                    gameResours.add(GameResource.STONE);
//                    assertEquals(gameResours, brownCard.getGiveResourse());
//                    size++;
//                    break;
//                case "CLAY_POOL":
//                    gameResours.add(GameResource.CLAY);
//                    assertEquals(gameResours, brownCard.getGiveResourse());
//                    size++;
//                    break;
//                case "ORE_VEIN":
//                    gameResours.add(GameResource.IRON);
//                    assertEquals(gameResours, brownCard.getGiveResourse());
//                    size++;
//                    break;
//            }
//        }
//        assertEquals(8, size);
//    }
//
//    @Test
//    public void getAllCards_3Players_2age() {
//        Card card = BrownCardImpl.BRICKYARD;
//        List<Card> cardList = card.getAllCard(3, 2);
//        int size = cardList.size();
//        assertEquals(4, size);
//    }
//
//    @Test
//    public void getAllCards_4Players_2age() {
//        Card card = BrownCardImpl.BRICKYARD;
//        List<Card> cardList = card.getAllCard(4, 2);
//        int size = cardList.size();
//        assertEquals(8, size);
//    }
//
//    @Test
//    public void getAllCards_Resouce_Give_2Age_OneTypeResouce() {
//        Card card = BrownCardImpl.BRICKYARD;
//        List<Card> cardList = card.getAllCard(7, 2);
//        int size = 0;
//        for (Card card1 : cardList) {
//            List<GameResource> gameResours = new ArrayList<>();
//            BrownCardImpl brownCard = (BrownCardImpl) card1;
//            switch (brownCard.name()) {
//                case "SAWMILL":
//                    gameResours.add(GameResource.WOOD);
//                    gameResours.add(GameResource.WOOD);
//                    assertEquals(gameResours, brownCard.getGiveResourse());
//                    size++;
//                    break;
//                case "QUARRY":
//                    gameResours.add(GameResource.STONE);
//                    gameResours.add(GameResource.STONE);
//                    assertEquals(gameResours, brownCard.getGiveResourse());
//                    size++;
//                    break;
//                case "BRICKYARD":
//                    gameResours.add(GameResource.CLAY);
//                    gameResours.add(GameResource.CLAY);
//                    assertEquals(gameResours, brownCard.getGiveResourse());
//                    size++;
//                    break;
//                case "FOUNDRY":
//                    gameResours.add(GameResource.IRON);
//                    gameResours.add(GameResource.IRON);
//                    assertEquals(gameResours, brownCard.getGiveResourse());
//                    size++;
//                    break;
//
//            }
//        }
//
//        assertEquals(8, size);
//    }
//
//    @Test
//    public void getAllCards_Resouce_Two_Type() {
//        Card card = BrownCardImpl.BRICKYARD;
//        List<Card> cardList = card.getAllCard(7, 1);
//        int size = 0;
//        for (Card card1 : cardList) {
//            List<GameResource> gameResours = new ArrayList<>();
//            BrownCardImpl brownCard = (BrownCardImpl) card1;
//            switch (brownCard) {
//                case TREE_FARM:
//                    gameResours.add(GameResource.WOOD);
//                    gameResours.add(GameResource.CLAY);
//                    assertEquals(gameResours, brownCard.getGiveResourse());
//                    size++;
//                    break;
//                case EXCAVATION:
//                    gameResours.add(GameResource.STONE);
//                    gameResours.add(GameResource.CLAY);
//                    assertEquals(gameResours, brownCard.getGiveResourse());
//                    size++;
//                    break;
//                case CLAY_PIT:
//                    gameResours.add(GameResource.IRON);
//                    gameResours.add(GameResource.CLAY);
//                    assertEquals(gameResours, brownCard.getGiveResourse());
//                    size++;
//                    break;
//                case TIMBER_YARD:
//                    gameResours.add(GameResource.STONE);
//                    gameResours.add(GameResource.WOOD);
//                    assertEquals(gameResours, brownCard.getGiveResourse());
//                    size++;
//                    break;
//                case FOREST_CAVE:
//                    gameResours.add(GameResource.WOOD);
//                    gameResours.add(GameResource.IRON);
//                    assertEquals(gameResours, brownCard.getGiveResourse());
//                    size++;
//                    break;
//                case MINE:
//                    gameResours.add(GameResource.STONE);
//                    gameResours.add(GameResource.IRON);
//                    assertEquals(gameResours, brownCard.getGiveResourse());
//                    size++;
//                    break;
//            }
//        }
//        assertEquals(6, size);
//    }
//
//    @Test
//    public void chooseOneResouceTest_() {
//        BrownCardImpl brownCard = BrownCardImpl.TREE_FARM;
//        List<GameResource> gameResours = new ArrayList<>();
//        brownCard.getAllCard(7,1);
//        brownCard.chooseOneResouce(brownCard, GameResource.WOOD);
//        gameResours.add(GameResource.WOOD);
//        assertEquals(gameResours, brownCard.getGiveResourse());
//        brownCard = BrownCardImpl.MINE;
//        brownCard.chooseOneResouce(brownCard, GameResource.STONE);
//        gameResours = new ArrayList<>();
//        gameResours.add(GameResource.STONE);
//        assertEquals(gameResours, brownCard.getGiveResourse());
//        brownCard.chooseOneResouce(brownCard, GameResource.IRON);
//        gameResours = new ArrayList<>();
//        gameResours.add(GameResource.IRON);
//        assertEquals(gameResours, brownCard.getGiveResourse());
//
//    }
//}

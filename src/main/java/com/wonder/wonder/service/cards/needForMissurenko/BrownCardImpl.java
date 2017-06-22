package com.wonder.wonder.service.cards.needForMissurenko;

/**
 * Creator: bm
 * Date: 13.06.17.
 */

// need add count cards +3 +4 +5 +6 +7 people
    // do now
//public enum BrownCardImpl implements Card {
//    // brown first age // one resourse
//    LUMBER_YARD,
//    STONE_PIT,
//    CLAY_POOL,
//    ORE_VEIN,
//    // brown second age
//    SAWMILL(1),
//    QUARRY(1),
//    BRICKYARD(1),
//    FOUNDRY(1),
//
//    //brown half
//    TREE_FARM(1),
//    EXCAVATION(1),
//    CLAY_PIT(1),
//    TIMBER_YARD(1),
//    FOREST_CAVE(1),
//    MINE(1);
//
//
//    private int goldNeededForConstruction;
//    private List<GameResource> giveResourse;
//
//    BrownCardImpl() {
//    }
//
//    BrownCardImpl(int goldNeededForConstruction) {
//        this.goldNeededForConstruction = goldNeededForConstruction;
//    }
//
//    @Override
//    public List<Card> getAllCard(int numberPlayer, int age) {
//        List<Card> cards = new ArrayList<>();
//        if (numberPlayer >= 3 & age == 1) {
//            cards.add(BrownCardImpl.LUMBER_YARD);
//            cards.add(BrownCardImpl.STONE_PIT);
//            cards.add(BrownCardImpl.CLAY_POOL);
//            cards.add(BrownCardImpl.ORE_VEIN);
//            cards.add(BrownCardImpl.CLAY_PIT);
//            cards.add(BrownCardImpl.TIMBER_YARD);
//            if (numberPlayer >= 4) {
//                cards.add(BrownCardImpl.LUMBER_YARD);
//                cards.add(BrownCardImpl.ORE_VEIN);
//                cards.add(BrownCardImpl.EXCAVATION);
//                if (numberPlayer >= 5) {
//                    cards.add(BrownCardImpl.STONE_PIT);
//                    cards.add(BrownCardImpl.CLAY_POOL);
//                    cards.add(BrownCardImpl.FOREST_CAVE);
//                    if (numberPlayer >= 6) {
//                        cards.add(BrownCardImpl.MINE);
//                        cards.add(BrownCardImpl.TREE_FARM);
//                    }
//                }
//
//            }
//        }
//
//        if (numberPlayer >= 3 & age == 2) {
//            cards.add(BrownCardImpl.SAWMILL);
//            cards.add(BrownCardImpl.QUARRY);
//            cards.add(BrownCardImpl.BRICKYARD);
//            cards.add(BrownCardImpl.FOUNDRY);
//            if (numberPlayer >= 4) {
//                cards.add(BrownCardImpl.SAWMILL);
//                cards.add(BrownCardImpl.QUARRY);
//                cards.add(BrownCardImpl.BRICKYARD);
//                cards.add(BrownCardImpl.FOUNDRY);
//            }
//        }
//        setField(cards);
//        return cards;
//    }
//
//
//
//    @Override
//    public void setField(List<Card> cards) {
//        for (Card card1 : cards) {
//            List<GameResource> gameResours = new ArrayList<>();
//            BrownCardImpl brownCard = (BrownCardImpl) card1;
//            switch (brownCard) {
//                case LUMBER_YARD:
//                    gameResours.add(GameResource.WOOD);
//                    brownCard.setGiveResourse(gameResours);
//                    break;
//                case STONE_PIT:
//                    gameResours.add(GameResource.STONE);
//                    brownCard.setGiveResourse(gameResours);
//                    break;
//                case CLAY_POOL:
//                    gameResours.add(GameResource.CLAY);
//                    brownCard.setGiveResourse(gameResours);
//                    break;
//                case ORE_VEIN:
//                    gameResours.add(GameResource.IRON);
//                    brownCard.setGiveResourse(gameResours);
//                    break;
//                case SAWMILL:
//                    gameResours.add(GameResource.WOOD);
//                    gameResours.add(GameResource.WOOD);
//                    brownCard.setGiveResourse(gameResours);
//                    break;
//                case QUARRY:
//                    gameResours.add(GameResource.STONE);
//                    gameResours.add(GameResource.STONE);
//                    brownCard.setGiveResourse(gameResours);
//                    break;
//                case BRICKYARD:
//                    gameResours.add(GameResource.CLAY);
//                    gameResours.add(GameResource.CLAY);
//                    brownCard.setGiveResourse(gameResours);
//                    break;
//                case FOUNDRY:
//                    gameResours.add(GameResource.IRON);
//                    gameResours.add(GameResource.IRON);
//                    brownCard.setGiveResourse(gameResours);
//                    break;
//                case TREE_FARM:
//                    gameResours.add(GameResource.WOOD);
//                    gameResours.add(GameResource.CLAY);
//                    brownCard.setGiveResourse(gameResours);
//                    break;
//                case EXCAVATION:
//                    gameResours.add(GameResource.STONE);
//                    gameResours.add(GameResource.CLAY);
//                    brownCard.setGiveResourse(gameResours);
//                    break;
//                case CLAY_PIT:
//                    gameResours.add(GameResource.IRON);
//                    gameResours.add(GameResource.CLAY);
//                    brownCard.setGiveResourse(gameResours);
//                    break;
//                case TIMBER_YARD:
//                    gameResours.add(GameResource.STONE);
//                    gameResours.add(GameResource.WOOD);
//                    brownCard.setGiveResourse(gameResours);
//                    break;
//                case FOREST_CAVE:
//                    gameResours.add(GameResource.WOOD);
//                    gameResours.add(GameResource.IRON);
//                    brownCard.setGiveResourse(gameResours);
//                    break;
//                case MINE:
//                    gameResours.add(GameResource.STONE);
//                    gameResours.add(GameResource.IRON);
//                    brownCard.setGiveResourse(gameResours);
//                    break;
//            }
//        }
//    }
//
//    @Override
//    public boolean isResourceOf(GameCardColor color) {
//        return false;
//    }
//
//    private void metodSupportsetField(List<GameResource> gameResours, GameResource gameResourceChoose, BrownCardImpl card) {
//        gameResours.add(gameResourceChoose);
//        card.setGiveResourse(gameResours);
//    }
//
//
//    private void setFieldForTwoType(BrownCardImpl card, GameResource gameResource) {
//        List<GameResource> gameResours = new ArrayList<>();
//        if ((card.getGiveResourse().size()) < 2) {
//            card.getAllCard(7, 1);
//        }
//        if (card.getGiveResourse().contains(gameResource)) {
//            gameResours.add(gameResource);
//            card.setGiveResourse(gameResours);
//        }
//    }
//
//    public void chooseOneResouce(Card card, GameResource gameResourceChoose) {
//        BrownCardImpl brownCard = (BrownCardImpl) card;
//        if (gameResourceChoose == GameResource.WOOD |
//                gameResourceChoose == GameResource.IRON |
//                gameResourceChoose == GameResource.STONE |
//                gameResourceChoose == GameResource.CLAY) {
//            setFieldForTwoType(brownCard, gameResourceChoose);
//        }
//
//    }
//
//    public int getGoldNeededForConstruction() {
//        return goldNeededForConstruction;
//    }
//
//    public List<GameResource> getGiveResourse() {
//        return giveResourse;
//    }
//
//    private void setGiveResourse(List<GameResource> giveResourse) {
//        this.giveResourse = giveResourse;
//    }
//}
//

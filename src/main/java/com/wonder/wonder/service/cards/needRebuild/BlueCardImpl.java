package com.wonder.wonder.service.cards.needRebuild;

/**
 * Creator: bm
 * Date: 13.06.17.
 */
//// need add count cards +3 +4 +5 +6 +7 people
//public enum BlueCardImpl implements Card {
//    //  first age blue
//    PAWNSHOP(3),
//    BATHS(3),
//    ALTAR(2),
//    THEATER(2),
//    // second age  blue
//    AQUEDUCT(5),
//    TEMPLE(3),
//    STATUE(4),
//    COURTHOUSE(4),
//    //blue thierd age
//    PANTHEON(7),
//    GARDENS(5),
//    TOWN_HALL(6),
//    PALACE(8),
//    SENATE(6);
//
//    private int takeBluePoint;
//
//    private List<GameResource> resourseNeededForConstruction;
//
//    private Card chain;
//
//    BlueCardImpl(int takeBluePoint) {
//        this.takeBluePoint = takeBluePoint;
//    }
//
//    @Override
//    public List<Card> getAllCard(int numberPlayer, int age) {
//        List<Card> cards = new ArrayList<>();
//        if (numberPlayer >= 3 & age == 1) {
//            cards.add(BlueCardImpl.BATHS);
//            cards.add(BlueCardImpl.ALTAR);
//            cards.add(BlueCardImpl.THEATER);
//            if (numberPlayer >= 4) {
//                cards.add(BlueCardImpl.PAWNSHOP);
//                if (numberPlayer >= 5) {
//                    cards.add(BlueCardImpl.ALTAR);
//                    if (numberPlayer >= 6) {
//                        cards.add(BlueCardImpl.THEATER);
//                        if (numberPlayer >= 7) {
//                            cards.add(BlueCardImpl.BATHS);
//                            cards.add(BlueCardImpl.PAWNSHOP);
//                        }
//                    }
//                }
//            }
//        }
//        if (numberPlayer >= 3 & age == 2) {
//            cards.add(BlueCardImpl.AQUEDUCT);
//            cards.add(BlueCardImpl.TEMPLE);
//            cards.add(BlueCardImpl.STATUE);
//            cards.add(BlueCardImpl.COURTHOUSE);
//            if (numberPlayer >= 5) {
//                cards.add(BlueCardImpl.COURTHOUSE);
//                if (numberPlayer >= 6) {
//                    cards.add(BlueCardImpl.TEMPLE);
//                    if (numberPlayer >= 7) {
//                        cards.add(BlueCardImpl.AQUEDUCT);
//                        cards.add(BlueCardImpl.STATUE);
//                    }
//                }
//            }
//        }
//        if (numberPlayer >= 3 & age == 3) {
//            cards.add(BlueCardImpl.PANTHEON);
//            cards.add(BlueCardImpl.GARDENS);
//            cards.add(BlueCardImpl.TOWN_HALL);
//            cards.add(BlueCardImpl.PALACE);
//            cards.add(BlueCardImpl.SENATE);
//            if (numberPlayer >= 4) {
//                cards.add(BlueCardImpl.GARDENS);
//                if (numberPlayer >= 5) {
//                    cards.add(BlueCardImpl.SENATE);
//                    cards.add(BlueCardImpl.TOWN_HALL);
//                    if (numberPlayer >= 6) {
//                        cards.add(BlueCardImpl.TOWN_HALL);
//                        cards.add(BlueCardImpl.PANTHEON);
//                        if (numberPlayer >= 7) {
//                            cards.add(BlueCardImpl.PALACE);
//
//                        }
//                    }
//                }
//            }
//        }
//        setField(cards);
//        return cards;
//    }
//
//    @Override
//    public void setField(List<Card> cards) {
//        for (Card card : cards) {
//            List<GameResource> gameResours = new ArrayList<>();
//            BlueCardImpl blueCard = (BlueCardImpl) card;
//            if (blueCard.equals(BlueCardImpl.BATHS)) {
//                gameResours.add(GameResource.STONE);
//            } else if (blueCard.equals(BlueCardImpl.AQUEDUCT)) {
//                blueCard.setChain(BlueCardImpl.BATHS);
//                gameResours.add(GameResource.STONE);
//                gameResours.add(GameResource.STONE);
//                gameResours.add(GameResource.STONE);
//            } else if (blueCard.equals(BlueCardImpl.TEMPLE)) {
//                blueCard.setChain(BlueCardImpl.ALTAR);
//                gameResours.add(GameResource.WOOD);
//                gameResours.add(GameResource.CLAY);
//                gameResours.add(GameResource.GLASS);
//            } else if (blueCard.equals(BlueCardImpl.STATUE)) {
//                blueCard.setChain(BlueCardImpl.THEATER);
//                gameResours.add(GameResource.WOOD);
//                gameResours.add(GameResource.IRON);
//                gameResours.add(GameResource.IRON);
//            } else if (blueCard.equals(BlueCardImpl.COURTHOUSE)) {
//                blueCard.setChain(GreenCardImpl.SCRIPTORIUM);
//                gameResours.add(GameResource.CLAY);
//                gameResours.add(GameResource.CLAY);
//                gameResours.add(GameResource.SILK);
//            } else if (blueCard.equals(BlueCardImpl.PANTHEON)) {
//                blueCard.setChain(BlueCardImpl.TEMPLE);
//                gameResours.add(GameResource.CLAY);
//                gameResours.add(GameResource.CLAY);
//                gameResours.add(GameResource.IRON);
//                gameResours.add(GameResource.SILK);
//                gameResours.add(GameResource.GLASS);
//                gameResours.add(GameResource.PARCHMENT);
//            } else if (blueCard.equals(BlueCardImpl.GARDENS)) {
//                blueCard.setChain(BlueCardImpl.STATUE);
//                gameResours.add(GameResource.WOOD);
//                gameResours.add(GameResource.CLAY);
//                gameResours.add(GameResource.CLAY);
//            } else if (blueCard.equals(BlueCardImpl.TOWN_HALL)) {
//                blueCard.setChain(BlueCardImpl.THEATER);
//                gameResours.add(GameResource.GLASS);
//                gameResours.add(GameResource.IRON);
//                gameResours.add(GameResource.STONE);
//                gameResours.add(GameResource.STONE);
//            } else if (blueCard.equals(BlueCardImpl.PALACE)) {
//                gameResours.add(GameResource.GLASS);
//                gameResours.add(GameResource.PARCHMENT);
//                gameResours.add(GameResource.SILK);
//                gameResours.add(GameResource.CLAY);
//                gameResours.add(GameResource.WOOD);
//                gameResours.add(GameResource.IRON);
//                gameResours.add(GameResource.STONE);
//            } else if (blueCard.equals(BlueCardImpl.SENATE)) {
//                blueCard.setChain(GreenCardImpl.LIBRARY);
//                gameResours.add(GameResource.IRON);
//                gameResours.add(GameResource.STONE);
//                gameResours.add(GameResource.WOOD);
//
//            }
//            blueCard.setResourseNeededForConstruction(gameResours);
//        }
//    }
//
//    public int getTakeBluePoint() {
//        return takeBluePoint;
//    }
//
//    public List<GameResource> getResourseNeededForConstruction() {
//        return resourseNeededForConstruction;
//    }
//
//    private void setResourseNeededForConstruction(List<GameResource> resourseNeededForConstruction) {
//        this.resourseNeededForConstruction = resourseNeededForConstruction;
//    }
//
//    public Card getChain() {
//        return chain;
//    }
//
//    private void setChain(Card chain) {
//        this.chain = chain;
//    }
//}

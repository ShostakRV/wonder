package com.wonder.wonder.service.cards.needRebuild;

/**
 * Creator: bm
 * Date: 13.06.17.
// */
//public enum RedCardImpl implements Card {
//
////      first age    //red
//    STOCKADE(1),
//    BARRACKS(1),
//    GUARD_TOWER(1),
//
//    //red  second age
//    WALLS(2),
//    TRAINING_GROUND(2),
//    STABLES(2),// GreenCardImpl.APOTHECARY
//    ARCHERY_RANGE(2),//GreenCardImpl.WORKSHOP
//
//    //red thierd age
//    FORTIFICATIONS(3),
//    CIRCUS(3),
//    ARSENAL(3),
//    SIEGE_WORKSHOP(3)
//;
//
//    private int armyPower;
//
//    private List<GameResource> resourseNeededForConstruction;
//    private RedCardImpl redChain; // need think
//    private GreenCardImpl greenChain; // need think
//
//    RedCardImpl(int armyPower) {
//        this.armyPower = armyPower;
//    }
//
//
//    @Override
//    public List<Card> getAllCard(int numberPlayer,int age) {
//        List<Card> cards = new ArrayList<>();
//        cards.add(RedCardImpl.STOCKADE);
//        cards.add(RedCardImpl.BARRACKS);
//        cards.add(RedCardImpl.GUARD_TOWER);
//        cards.add(RedCardImpl.WALLS);
//        cards.add(RedCardImpl.TRAINING_GROUND);
//        cards.add(RedCardImpl.STABLES);
//        cards.add(RedCardImpl.ARCHERY_RANGE);
//        cards.add(RedCardImpl.FORTIFICATIONS);
//        cards.add(RedCardImpl.CIRCUS);
//        cards.add(RedCardImpl.ARSENAL);
//        cards.add(RedCardImpl.SIEGE_WORKSHOP);
//                return cards;
//    }
//    @Override
//    public void setField(List<Card> cards) {}
//
//
//
//    //    STOCKADE(1, null, null),;
////    BARRACKS(1, RedCardImpl.BARRACKS, null),
////    GUARD_TOWER(1, RedCardImpl.GUARD_TOWER, null),
////
////    //red  second age
////    WALLS(2, RedCardImpl.WALLS, null),
////    TRAINING_GROUND(2, RedCardImpl.TRAINING_GROUND, null),
////    STABLES(RedCardImpl.STABLES, GreenCardImpl.APOTHECARY, 2),// GreenCardImpl.APOTHECARY
////    ARCHERY_RANGE(RedCardImpl.ARCHERY_RANGE, GreenCardImpl.WORKSHOP, 2),//GreenCardImpl.WORKSHOP
////
////    //red thierd age
////    FORTIFICATIONS(3, RedCardImpl.FORTIFICATIONS, WALLS),
////    CIRCUS(3, RedCardImpl.CIRCUS, TRAINING_GROUND),
////    ARSENAL(3, RedCardImpl.ARSENAL, null),
////    SIEGE_WORKSHOP(RedCardImpl.SIEGE_WORKSHOP, GreenCardImpl.LABORATORY, 3),; //
//
//
//
////        List<GameResource> resouses = new ArrayList<>();
////        switch (redCard) {
////            case STOCKADE:
////                resouses.add(GameResource.WOOD);
////                return resouses;
////            case BARRACKS:
////                resouses.add(GameResource.IRON);
////                return resouses;
////            case GUARD_TOWER:
////                resouses.add(GameResource.CLAY);
////                return resouses;
////            case WALLS:
////                resouses.add(GameResource.STONE);
////                resouses.add(GameResource.STONE);
////                resouses.add(GameResource.STONE);
////                return resouses;
////            case TRAINING_GROUND:
////                resouses.add(GameResource.WOOD);
////                resouses.add(GameResource.IRON);
////                resouses.add(GameResource.IRON);
////                return resouses;
////            case STABLES:
////                resouses.add(GameResource.IRON);
////                resouses.add(GameResource.CLAY);
////                resouses.add(GameResource.WOOD);
////                return resouses;
////            case ARCHERY_RANGE:
////                resouses.add(GameResource.WOOD);
////                resouses.add(GameResource.WOOD);
////                resouses.add(GameResource.IRON);
////                return resouses;
////            case FORTIFICATIONS:
////                resouses.add(GameResource.STONE);
////                resouses.add(GameResource.IRON);
////                resouses.add(GameResource.IRON);
////                resouses.add(GameResource.IRON);
////            case CIRCUS:
////                resouses.add(GameResource.STONE);
////                resouses.add(GameResource.STONE);
////                resouses.add(GameResource.STONE);
////                resouses.add(GameResource.IRON);
////            case ARSENAL:
////                resouses.add(GameResource.IRON);
////                resouses.add(GameResource.WOOD);
////                resouses.add(GameResource.WOOD);
////                resouses.add(GameResource.SILK);
////            case SIEGE_WORKSHOP:
////
////                resouses.add(GameResource.WOOD);
////                resouses.add(GameResource.CLAY);
////                resouses.add(GameResource.CLAY);
////                resouses.add(GameResource.CLAY);
////        }
////
////        return null;
////    }
//
//    public int getArmyPower() {
//        return armyPower;
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
//    public RedCardImpl getRedChain() {
//        return redChain;
//    }
//
//    private void setRedChain(RedCardImpl redChain) {
//        this.redChain = redChain;
//    }
//
//    public GreenCardImpl getGreenChain() {
//        return greenChain;
//    }
//
//    private void setGreenChain(GreenCardImpl greenChain) {
//        this.greenChain = greenChain;
//    }
//}

package com.wonder.wonder.service.cards.needRebuild;

/**
 * Creator: bm
 * Date: 13.06.17.
 */
// need add count cards +3 +4 +5 +6 +7 people
//
//public enum SilverCardImpl implements Card {
//
//    LOOM(GameResource.SILK),
//    GLASSWORKS(GameResource.GLASS),
//    PRESS(GameResource.PARCHMENT);
//
//    GameResource giveResourse;
//
//    int age;
//
//    SilverCardImpl(GameResource giveResourse) {
//        this.giveResourse = giveResourse;
//    }
//
//    private void setAge(int age) {
//        this.age = age;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public GameResource getGiveResourse() {
//        return giveResourse;
//    }
//
//    @Override
//    public List<Card> getAllCard(int numberPlayer, int age) {
//        List<Card> cards = new ArrayList<>();
//        if (numberPlayer >= 3 & age == 1) {
//            SilverCardImpl.LOOM.setAge(1);
//            cards.add(SilverCardImpl.LOOM);
//            SilverCardImpl.GLASSWORKS.setAge(1);
//            cards.add(SilverCardImpl.GLASSWORKS);
//            SilverCardImpl.PRESS.setAge(1);
//            cards.add(SilverCardImpl.PRESS);
//            if (numberPlayer >= 6) {
//                SilverCardImpl.LOOM.setAge(1);
//                cards.add(SilverCardImpl.LOOM);
//                SilverCardImpl.GLASSWORKS.setAge(1);
//                cards.add(SilverCardImpl.GLASSWORKS);
//                SilverCardImpl.PRESS.setAge(1);
//                cards.add(SilverCardImpl.PRESS);
//            }
//        }
//        if (numberPlayer >= 3 & age == 2) {
//            SilverCardImpl.LOOM.setAge(2);
//            cards.add(SilverCardImpl.LOOM);
//            SilverCardImpl.GLASSWORKS.setAge(2);
//            cards.add(SilverCardImpl.GLASSWORKS);
//            SilverCardImpl.PRESS.setAge(2);
//            cards.add(SilverCardImpl.PRESS);
//            if (numberPlayer >= 5) {
//                SilverCardImpl.LOOM.setAge(2);
//                cards.add(SilverCardImpl.LOOM);
//                SilverCardImpl.GLASSWORKS.setAge(2);
//                cards.add(SilverCardImpl.GLASSWORKS);
//                SilverCardImpl.PRESS.setAge(2);
//                cards.add(SilverCardImpl.PRESS);
//            }
//        }
//
//        return cards;
//    }
//
//    @Override
//    public void setField(List<Card> cards) {
//    }
//
//}
//
//
//
//

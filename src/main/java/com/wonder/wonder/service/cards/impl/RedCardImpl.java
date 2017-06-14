package com.wonder.wonder.service.cards.impl;

import com.wonder.wonder.service.cards.Card;
import com.wonder.wonder.service.cards.resouse.Resouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Creator: bm
 * Date: 13.06.17.
 */
public enum RedCardImpl implements Card {

//      first age    //red
    STOCKADE(1),
    BARRACKS(1),
    GUARD_TOWER(1),

    //red  second age
    WALLS(2),
    TRAINING_GROUND(2),
    STABLES(2),// GreenCardImpl.APOTHECARY
    ARCHERY_RANGE(2),//GreenCardImpl.WORKSHOP

    //red thierd age
    FORTIFICATIONS(3),
    CIRCUS(3),
    ARSENAL(3),
    SIEGE_WORKSHOP(3)
;

    private int armyPower;

    private List<Resouse> resourseNeededForConstruction;
    private RedCardImpl redChain; // need think
    private GreenCardImpl greenChain; // need think

    RedCardImpl(int armyPower) {
        this.armyPower = armyPower;
    }


    @Override
    public List<Card> getAllCard() {
        List<Card> cards = new ArrayList<>();
        cards.add(RedCardImpl.STOCKADE);
        cards.add(RedCardImpl.BARRACKS);
        cards.add(RedCardImpl.GUARD_TOWER);
        cards.add(RedCardImpl.WALLS);
        cards.add(RedCardImpl.TRAINING_GROUND);
        cards.add(RedCardImpl.STABLES);
        cards.add(RedCardImpl.ARCHERY_RANGE);
        cards.add(RedCardImpl.FORTIFICATIONS);
        cards.add(RedCardImpl.CIRCUS);
        cards.add(RedCardImpl.ARSENAL);
        cards.add(RedCardImpl.SIEGE_WORKSHOP);
                return cards;
    }
    @Override
    public void setField() {}

//    private List<Resouse> resourseNeededForConstruction(RedCardImpl redCard) {

    //    STOCKADE(1, null, null),;
//    BARRACKS(1, RedCardImpl.BARRACKS, null),
//    GUARD_TOWER(1, RedCardImpl.GUARD_TOWER, null),
//
//    //red  second age
//    WALLS(2, RedCardImpl.WALLS, null),
//    TRAINING_GROUND(2, RedCardImpl.TRAINING_GROUND, null),
//    STABLES(RedCardImpl.STABLES, GreenCardImpl.APOTHECARY, 2),// GreenCardImpl.APOTHECARY
//    ARCHERY_RANGE(RedCardImpl.ARCHERY_RANGE, GreenCardImpl.WORKSHOP, 2),//GreenCardImpl.WORKSHOP
//
//    //red thierd age
//    FORTIFICATIONS(3, RedCardImpl.FORTIFICATIONS, WALLS),
//    CIRCUS(3, RedCardImpl.CIRCUS, TRAINING_GROUND),
//    ARSENAL(3, RedCardImpl.ARSENAL, null),
//    SIEGE_WORKSHOP(RedCardImpl.SIEGE_WORKSHOP, GreenCardImpl.LABORATORY, 3),; //



//        List<Resouse> resouses = new ArrayList<>();
//        switch (redCard) {
//            case STOCKADE:
//                resouses.add(Resouse.WOOD);
//                return resouses;
//            case BARRACKS:
//                resouses.add(Resouse.IRON);
//                return resouses;
//            case GUARD_TOWER:
//                resouses.add(Resouse.CLAY);
//                return resouses;
//            case WALLS:
//                resouses.add(Resouse.STONE);
//                resouses.add(Resouse.STONE);
//                resouses.add(Resouse.STONE);
//                return resouses;
//            case TRAINING_GROUND:
//                resouses.add(Resouse.WOOD);
//                resouses.add(Resouse.IRON);
//                resouses.add(Resouse.IRON);
//                return resouses;
//            case STABLES:
//                resouses.add(Resouse.IRON);
//                resouses.add(Resouse.CLAY);
//                resouses.add(Resouse.WOOD);
//                return resouses;
//            case ARCHERY_RANGE:
//                resouses.add(Resouse.WOOD);
//                resouses.add(Resouse.WOOD);
//                resouses.add(Resouse.IRON);
//                return resouses;
//            case FORTIFICATIONS:
//                resouses.add(Resouse.STONE);
//                resouses.add(Resouse.IRON);
//                resouses.add(Resouse.IRON);
//                resouses.add(Resouse.IRON);
//            case CIRCUS:
//                resouses.add(Resouse.STONE);
//                resouses.add(Resouse.STONE);
//                resouses.add(Resouse.STONE);
//                resouses.add(Resouse.IRON);
//            case ARSENAL:
//                resouses.add(Resouse.IRON);
//                resouses.add(Resouse.WOOD);
//                resouses.add(Resouse.WOOD);
//                resouses.add(Resouse.SILK);
//            case SIEGE_WORKSHOP:
//
//                resouses.add(Resouse.WOOD);
//                resouses.add(Resouse.CLAY);
//                resouses.add(Resouse.CLAY);
//                resouses.add(Resouse.CLAY);
//        }
//
//        return null;
//    }

    public int getArmyPower() {
        return armyPower;
    }

    public void setArmyPower(int armyPower) {
        this.armyPower = armyPower;
    }

    public List<Resouse> getResourseNeededForConstruction() {
        return resourseNeededForConstruction;
    }

    public void setResourseNeededForConstruction(List<Resouse> resourseNeededForConstruction) {
        this.resourseNeededForConstruction = resourseNeededForConstruction;
    }

    public RedCardImpl getRedChain() {
        return redChain;
    }

    public void setRedChain(RedCardImpl redChain) {
        this.redChain = redChain;
    }

    public GreenCardImpl getGreenChain() {
        return greenChain;
    }

    public void setGreenChain(GreenCardImpl greenChain) {
        this.greenChain = greenChain;
    }
}

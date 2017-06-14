package com.wonder.wonder.service.cards.impl;

import com.wonder.wonder.service.cards.Card;
import com.wonder.wonder.service.cards.resouse.Resouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Creator: bm
 * Date: 13.06.17.
 */
// need add count cards +3 +4 +5 +6 +7 people
public enum BlueCardImpl implements Card {
    //  first age blue
    PAWNSHOP(3),
    BATHS(3),
    ALTAR(2),
    THEATER(2),
    // second age  blue
    AQUEDUCT(5),
    TEMPLE(3),
    STATUE(4),
    COURTHOUSE(4),
    //blue thierd age
    PANTHEON(7),
    GARDENS(5),
    TOWN_HALL(6),
    PALACE(8),
    SENATE(6)
 ;


    private int takeBluePoint;

    private List<Resouse> resourseNeededForConstruction;
    private BlueCardImpl bluChain; // need think
    private GreenCardImpl greenChain;

    BlueCardImpl(int takeBluePoint) {
        this.takeBluePoint = takeBluePoint;
    }

    @Override
    public List<Card> getAllCard() {
        List<Card> cards = new ArrayList<>();
        cards.add(BlueCardImpl.PAWNSHOP);
        cards.add(BlueCardImpl.BATHS);
        cards.add(BlueCardImpl.ALTAR);
        cards.add(BlueCardImpl.THEATER);
        cards.add(BlueCardImpl.AQUEDUCT);
        cards.add(BlueCardImpl.TEMPLE);
        cards.add(BlueCardImpl.STATUE);
        cards.add(BlueCardImpl.COURTHOUSE);
        cards.add(BlueCardImpl.PANTHEON);
        cards.add(BlueCardImpl.GARDENS);
        cards.add(BlueCardImpl.TOWN_HALL);
        cards.add(BlueCardImpl.PALACE);
        cards.add(BlueCardImpl.SENATE);
        return cards;
    }
    @Override
    public void setField() {}


//    PAWNSHOP(3, null, null),
//    BATHS(3, BlueCardImpl.BATHS, null),
//    ALTAR(2, null, null),
//    THEATER(2, null, null),
//    // second age  blue
//    AQUEDUCT(5, BlueCardImpl.AQUEDUCT, BlueCardImpl.BATHS),
//    TEMPLE(3, BlueCardImpl.TEMPLE, BlueCardImpl.ALTAR),
//    STATUE(4, BlueCardImpl.STATUE, BlueCardImpl.THEATER),
//    COURTHOUSE(GreenCardImpl.SCRIPTORIUM, 4, BlueCardImpl.COURTHOUSE),
//    //blue thierd age
//    PANTHEON(7, BlueCardImpl.PANTHEON, BlueCardImpl.TEMPLE),
//    GARDENS(5, BlueCardImpl.GARDENS, BlueCardImpl.THEATER),
//    TOWN_HALL(6, BlueCardImpl.TOWN_HALL, null),
//    PALACE(8, BlueCardImpl.PALACE, null),
//    SENATE(GreenCardImpl.LIBRARY, 6, BlueCardImpl.SENATE)




//    private List<Resouse> resourseNeededForConstruction(BlueCardImpl blueCardImpl) {
//        List<Resouse> resouses = new ArrayList<>();
//        switch (blueCardImpl) {
//            case BATHS:
//                resouses.add(Resouse.STONE);
//                return resouses;
//            case AQUEDUCT:
//                resouses.add(Resouse.STONE);
//                resouses.add(Resouse.STONE);
//                resouses.add(Resouse.STONE);
//                return resouses;
//            case TEMPLE:
//                resouses.add(Resouse.WOOD);
//                resouses.add(Resouse.CLAY);
//                resouses.add(Resouse.GLASS);
//                return resouses;
//            case STATUE:
//                resouses.add(Resouse.WOOD);
//                resouses.add(Resouse.IRON);
//                resouses.add(Resouse.IRON);
//                return resouses;
//            case COURTHOUSE:
//                resouses.add(Resouse.CLAY);
//                resouses.add(Resouse.CLAY);
//                resouses.add(Resouse.SILK);
//                return resouses;
//            case PANTHEON:
//                resouses.add(Resouse.CLAY);
//                resouses.add(Resouse.CLAY);
//                resouses.add(Resouse.IRON);
//                resouses.add(Resouse.SILK);
//                resouses.add(Resouse.GLASS);
//                resouses.add(Resouse.PARCHMENT);
//                return resouses;
//            case GARDENS:
//                resouses.add(Resouse.WOOD);
//                resouses.add(Resouse.CLAY);
//                resouses.add(Resouse.CLAY);
//                return resouses;
//            case TOWN_HALL:
//                resouses.add(Resouse.GLASS);
//                resouses.add(Resouse.IRON);
//                resouses.add(Resouse.STONE);
//                resouses.add(Resouse.STONE);
//            case PALACE:
//                resouses.add(Resouse.GLASS);
//                resouses.add(Resouse.PARCHMENT);
//                resouses.add(Resouse.SILK);
//                resouses.add(Resouse.CLAY);
//                resouses.add(Resouse.WOOD);
//                resouses.add(Resouse.IRON);
//                resouses.add(Resouse.STONE);
//        }
//
//        return null;
//    }
//



    public int getTakeBluePoint() {
        return takeBluePoint;
    }

    public void setTakeBluePoint(int takeBluePoint) {
        this.takeBluePoint = takeBluePoint;
    }

    public List<Resouse> getResourseNeededForConstruction() {
        return resourseNeededForConstruction;
    }

    public void setResourseNeededForConstruction(List<Resouse> resourseNeededForConstruction) {
        this.resourseNeededForConstruction = resourseNeededForConstruction;
    }

    public BlueCardImpl getBluChain() {
        return bluChain;
    }

    public void setBluChain(BlueCardImpl bluChain) {
        this.bluChain = bluChain;
    }

    public GreenCardImpl getGreenChain() {
        return greenChain;
    }

    public void setGreenChain(GreenCardImpl greenChain) {
        this.greenChain = greenChain;
    }
}

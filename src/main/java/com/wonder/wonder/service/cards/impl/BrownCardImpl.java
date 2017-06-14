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
public enum BrownCardImpl implements Card {
    // brown first age // one resourse
    LUMBER_YARD,
    STONE_PIT,
    CLAY_POOL,
    ORE_VEIN,
    // brown second age
    SAWMILL(1),
    QUARRY(1),
    BRICKYARD(1),
    FOUNDRY(1),

    //brown half
    TREE_FARM(1),
    EXCAVATION(1),
    CLAY_PIT(1),
    TIMBER_YARD(1),
    FOREST_CAVE(1),
    MINE(1);


    private int goldNeededForConstruction;
    private List<Resouse> giveResourse;

    BrownCardImpl() {
    }

    BrownCardImpl(int goldNeededForConstruction) {
        this.goldNeededForConstruction = goldNeededForConstruction;
    }

    @Override
    public List<Card> getAllCard() {
        List<Card> cards = new ArrayList<>();
        cards.add(BrownCardImpl.LUMBER_YARD);
        cards.add(BrownCardImpl.STONE_PIT);
        cards.add(BrownCardImpl.CLAY_POOL);
        cards.add(BrownCardImpl.ORE_VEIN);
        cards.add(BrownCardImpl.SAWMILL);
        cards.add(BrownCardImpl.QUARRY);
        cards.add(BrownCardImpl.BRICKYARD);
        cards.add(BrownCardImpl.FOUNDRY);
        cards.add(BrownCardImpl.TREE_FARM);
        cards.add(BrownCardImpl.EXCAVATION);
        cards.add(BrownCardImpl.CLAY_PIT);
        cards.add(BrownCardImpl.TIMBER_YARD);
        cards.add(BrownCardImpl.FOREST_CAVE);
        cards.add(BrownCardImpl.MINE);
        return cards;
    }

    @Override
    public void setField() {
//        List Cards = getAllCard();
//        for( Cards)
//        switch (brownCard) {
//            case LUMBER_YARD:
//                resouses.add(Resouse.WOOD);
//                return resouses;
//            case STONE_PIT:
//                resouses.add(Resouse.STONE);
//                return resouses;
//            case CLAY_POOL:
//                resouses.add(Resouse.CLAY);
//                return resouses;
//            case ORE_VEIN:
//                resouses.add(Resouse.IRON);
//                return resouses;
//            case SAWMILL:
//                resouses.add(Resouse.WOOD);
//                resouses.add(Resouse.WOOD);
//                return resouses;
//            case QUARRY:
//                resouses.add(Resouse.STONE);
//                resouses.add(Resouse.STONE);
//                return resouses;
//            case BRICKYARD:
//                resouses.add(Resouse.CLAY);
//                resouses.add(Resouse.CLAY);
//                return resouses;
//            case FOUNDRY:
//                resouses.add(Resouse.IRON);
//                resouses.add(Resouse.IRON);
//                return resouses;
//
//            // need  add logic for normal work
//            case TREE_FARM:
//                resouses.add(Resouse.WOOD);
//                resouses.add(Resouse.CLAY);
//                return resouses;
//            case EXCAVATION:
//                resouses.add(Resouse.STONE);
//                resouses.add(Resouse.CLAY);
//                return resouses;
//            case CLAY_PIT:
//                resouses.add(Resouse.IRON);
//                resouses.add(Resouse.CLAY);
//                return resouses;
//            case TIMBER_YARD:
//                resouses.add(Resouse.STONE);
//                resouses.add(Resouse.WOOD);
//                return resouses;
//            case FOREST_CAVE:
//                resouses.add(Resouse.WOOD);
//                resouses.add(Resouse.IRON);
//                return resouses;
//            case MINE:
//                resouses.add(Resouse.STONE);
//                resouses.add(Resouse.IRON);
//                return resouses;
        }


    public int getGoldNeededForConstruction() {
        return goldNeededForConstruction;
    }

    public List<Resouse> getGiveResourse() {
        return giveResourse;
    }

    private void setGiveResourse(List<Resouse> giveResourse) {
        this.giveResourse = giveResourse;
    }
}


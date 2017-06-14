package com.wonder.wonder.service.cards.resouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Creator: bm
 * Date: 13.06.17.
 */

// need add count cards +3 +4 +5 +6 +7 people
public enum BrownCard {
    // brown first age // one resourse
    LUMBER_YARD(0, BrownCard.LUMBER_YARD),
    STONE_PIT(0, BrownCard.STONE_PIT),
    CLAY_POOL(0, BrownCard.CLAY_POOL),
    ORE_VEIN(0, BrownCard.ORE_VEIN),
    // brown second age
    SAWMILL(1, BrownCard.SAWMILL),
    QUARRY(1, BrownCard.QUARRY),
    BRICKYARD(1, BrownCard.BRICKYARD),
    FOUNDRY(1, BrownCard.FOUNDRY),

    //brown half
    TREE_FARM(1, BrownCard.TREE_FARM),
    EXCAVATION(1, BrownCard.EXCAVATION),
    CLAY_PIT(1, BrownCard.CLAY_PIT),
    TIMBER_YARD(1, BrownCard.TIMBER_YARD),
    FOREST_CAVE(1, BrownCard.FOREST_CAVE),
    MINE(1, BrownCard.MINE);


    private int goldNeededForConstruction;
    private List<Resouse> giveResourse;


    BrownCard(int goldNeededForConstruction, BrownCard brownCard) {
        this.goldNeededForConstruction = goldNeededForConstruction;

        this.giveResourse = staffresource(brownCard);
    }

    // need  add logic for normal work
    private List<Resouse> staffresource(BrownCard brownCard) {
        List<Resouse> resouses = new ArrayList<>();
        switch (brownCard) {
            case LUMBER_YARD:
                resouses.add(Resouse.WOOD);
                return resouses;
            case STONE_PIT:
                resouses.add(Resouse.STONE);
                return resouses;
            case CLAY_POOL:
                resouses.add(Resouse.CLAY);
                return resouses;
            case ORE_VEIN:
                resouses.add(Resouse.IRON);
                return resouses;
            case SAWMILL:
                resouses.add(Resouse.WOOD);
                resouses.add(Resouse.WOOD);
                return resouses;
            case QUARRY:
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.STONE);
                return resouses;
            case BRICKYARD:
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.CLAY);
                return resouses;
            case FOUNDRY:
                resouses.add(Resouse.IRON);
                resouses.add(Resouse.IRON);
                return resouses;

                // need  add logic for normal work
            case TREE_FARM:
                resouses.add(Resouse.WOOD);
                resouses.add(Resouse.CLAY);
                return resouses;
            case EXCAVATION:
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.CLAY);
                return resouses;
            case CLAY_PIT:
                resouses.add(Resouse.IRON);
                resouses.add(Resouse.CLAY);
                return resouses;
            case TIMBER_YARD:
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.WOOD);
                return resouses;
            case FOREST_CAVE:
                resouses.add(Resouse.WOOD);
                resouses.add(Resouse.IRON);
                return resouses;
            case MINE:
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.IRON);
                return resouses;
        }
        return null; // maybe can better
    }

    public int getGoldNeededForConstruction() {
        return goldNeededForConstruction;
    }

    public void setGoldNeededForConstruction(int goldNeededForConstruction) {
        this.goldNeededForConstruction = goldNeededForConstruction;
    }

    public List<Resouse> getGiveResourse() {
        return giveResourse;
    }

    public void setGiveResourse(List<Resouse> giveResourse) {
        this.giveResourse = giveResourse;
    }
}


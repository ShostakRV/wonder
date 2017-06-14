package com.wonder.wonder.service.cards.war;

import com.wonder.wonder.service.cards.resouse.Resouse;
import com.wonder.wonder.service.cards.scientists.GreenCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Creator: bm
 * Date: 13.06.17.
 */
public enum RedCard {
    //  first age    //red
    STOCKADE(1, RedCard.STOCKADE, null),
    BARRACKS(1, RedCard.BARRACKS, null),
    GUARD_TOWER(1, RedCard.GUARD_TOWER, null),

    //red  second age
    WALLS(2, RedCard.WALLS, null),
    TRAINING_GROUND(2, RedCard.TRAINING_GROUND, null),
    STABLES(RedCard.STABLES, GreenCard.APOTHECARY, 2),// GreenCard.APOTHECARY
    ARCHERY_RANGE(RedCard.ARCHERY_RANGE, GreenCard.WORKSHOP, 2),//GreenCard.WORKSHOP

    //red thierd age
    FORTIFICATIONS(3, RedCard.FORTIFICATIONS, WALLS),
    CIRCUS(3, RedCard.CIRCUS, TRAINING_GROUND),
    ARSENAL(3, RedCard.ARSENAL, null),
    SIEGE_WORKSHOP(RedCard.SIEGE_WORKSHOP, GreenCard.LABORATORY, 3),; //

    private int armyPower;

    private List<Resouse> resourseNeededForConstruction;
    private RedCard redChain; // need think
    private GreenCard greenChain; // need think


    RedCard(int armyPower, RedCard redCard, RedCard redChain) {
        this.armyPower = armyPower;
        this.resourseNeededForConstruction = resourseNeededForConstruction(redCard);
        this.redChain = redChain;
    }

    RedCard(RedCard redCard, GreenCard greenChain, int armyPower) {
        this.armyPower = armyPower;
        this.resourseNeededForConstruction = resourseNeededForConstruction(redCard);
        this.greenChain = greenChain;
    }

    private List<Resouse> resourseNeededForConstruction(RedCard redCard) {
        List<Resouse> resouses = new ArrayList<>();
        switch (redCard) {
            case STOCKADE:
                resouses.add(Resouse.WOOD);
                return resouses;
            case BARRACKS:
                resouses.add(Resouse.IRON);
                return resouses;
            case GUARD_TOWER:
                resouses.add(Resouse.CLAY);
                return resouses;
            case WALLS:
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.STONE);
                return resouses;
            case TRAINING_GROUND:
                resouses.add(Resouse.WOOD);
                resouses.add(Resouse.IRON);
                resouses.add(Resouse.IRON);
                return resouses;
            case STABLES:
                resouses.add(Resouse.IRON);
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.WOOD);
                return resouses;
            case ARCHERY_RANGE:
                resouses.add(Resouse.WOOD);
                resouses.add(Resouse.WOOD);
                resouses.add(Resouse.IRON);
                return resouses;
            case FORTIFICATIONS:
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.IRON);
                resouses.add(Resouse.IRON);
                resouses.add(Resouse.IRON);
            case CIRCUS:
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.IRON);
            case ARSENAL:
                resouses.add(Resouse.IRON);
                resouses.add(Resouse.WOOD);
                resouses.add(Resouse.WOOD);
                resouses.add(Resouse.SILK);
            case SIEGE_WORKSHOP:

                resouses.add(Resouse.WOOD);
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.CLAY);
        }

        return null;
    }

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

    public RedCard getRedChain() {
        return redChain;
    }

    public void setRedChain(RedCard redChain) {
        this.redChain = redChain;
    }

    public GreenCard getGreenChain() {
        return greenChain;
    }

    public void setGreenChain(GreenCard greenChain) {
        this.greenChain = greenChain;
    }
}

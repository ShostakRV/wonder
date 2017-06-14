package com.wonder.wonder.service.cards;

import com.wonder.wonder.service.cards.resouse.Resouse;
import com.wonder.wonder.service.cards.scientists.GreenCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Creator: bm
 * Date: 13.06.17.
 */
// need add count cards +3 +4 +5 +6 +7 people
public enum BluCard {
    //  first age blue
    PAWNSHOP(3, null, null),
    BATHS(3, BluCard.BATHS, null),
    ALTAR(2, null, null),
    THEATER(2, null, null),
    // second age  blue
    AQUEDUCT(5, BluCard.AQUEDUCT, BluCard.BATHS),
    TEMPLE(3, BluCard.TEMPLE, BluCard.ALTAR),
    STATUE(4, BluCard.STATUE, BluCard.THEATER),
    COURTHOUSE(GreenCard.SCRIPTORIUM, 4, BluCard.COURTHOUSE),
    //blue thierd age
    PANTHEON(7, BluCard.PANTHEON, BluCard.TEMPLE),
    GARDENS(5, BluCard.GARDENS, BluCard.THEATER),
    TOWN_HALL(6, BluCard.TOWN_HALL, null),
    PALACE(8, BluCard.PALACE, null),
    SENATE(GreenCard.LIBRARY, 6, BluCard.SENATE);//

    private int takeBluePoint;

    private List<Resouse> resourseNeededForConstruction;
    private BluCard bluChain; // need think
    private GreenCard greenChain;

    BluCard(int takeBluePoint, BluCard bluCard, BluCard bluChain) {
        this.takeBluePoint = takeBluePoint;
        this.resourseNeededForConstruction = resourseNeededForConstruction(bluCard);
        this.bluChain = bluChain;
    }

    BluCard(GreenCard greenChain, int takeBluePoint, BluCard bluCard) {
        this.takeBluePoint = takeBluePoint;
        this.resourseNeededForConstruction = resourseNeededForConstruction(bluCard);
        this.greenChain = greenChain;
    }

    private List<Resouse> resourseNeededForConstruction(BluCard bluCard) {
        List<Resouse> resouses = new ArrayList<>();
        switch (bluCard) {
            case BATHS:
                resouses.add(Resouse.STONE);
                return resouses;
            case AQUEDUCT:
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.STONE);
                return resouses;
            case TEMPLE:
                resouses.add(Resouse.WOOD);
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.GLASS);
                return resouses;
            case STATUE:
                resouses.add(Resouse.WOOD);
                resouses.add(Resouse.IRON);
                resouses.add(Resouse.IRON);
                return resouses;
            case COURTHOUSE:
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.SILK);
                return resouses;
            case PANTHEON:
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.IRON);
                resouses.add(Resouse.SILK);
                resouses.add(Resouse.GLASS);
                resouses.add(Resouse.PARCHMENT);
                return resouses;
            case GARDENS:
                resouses.add(Resouse.WOOD);
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.CLAY);
                return resouses;
            case TOWN_HALL:
                resouses.add(Resouse.GLASS);
                resouses.add(Resouse.IRON);
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.STONE);
            case PALACE:
                resouses.add(Resouse.GLASS);
                resouses.add(Resouse.PARCHMENT);
                resouses.add(Resouse.SILK);
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.WOOD);
                resouses.add(Resouse.IRON);
                resouses.add(Resouse.STONE);
        }

        return null;
    }

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

    public BluCard getBluChain() {
        return bluChain;
    }

    public void setBluChain(BluCard bluChain) {
        this.bluChain = bluChain;
    }

    public GreenCard getGreenChain() {
        return greenChain;
    }

    public void setGreenChain(GreenCard greenChain) {
        this.greenChain = greenChain;
    }
}

package com.wonder.wonder.service.cards.scientists;

import com.wonder.wonder.service.cards.resouse.Resouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Creator: bm
 * Date: 13.06.17.
 */
public enum GreenCard {
    // green irst age
    WORKSHOP(GreenCard.WORKSHOP, null, ScientistGuild.GEAR),
    SCRIPTORIUM(GreenCard.SCRIPTORIUM, null, ScientistGuild.NAMEPLATE),
    APOTHECARY(GreenCard.APOTHECARY, null, ScientistGuild.COMPASSE),
    //green  second age
    DISPENSARY(GreenCard.DISPENSARY, GreenCard.APOTHECARY, ScientistGuild.COMPASSE),
    LABORATORY(GreenCard.LABORATORY, GreenCard.WORKSHOP, ScientistGuild.GEAR),
    LIBRARY(GreenCard.LIBRARY, GreenCard.SCRIPTORIUM, ScientistGuild.NAMEPLATE),
    SCHOOL(GreenCard.SCHOOL, null, ScientistGuild.NAMEPLATE),
    //green thierd age
    LODGE(GreenCard.LODGE, GreenCard.DISPENSARY, ScientistGuild.COMPASSE),
    OBSERVATORY(GreenCard.OBSERVATORY, GreenCard.LABORATORY, ScientistGuild.GEAR),
    UNIVERSITY(GreenCard.UNIVERSITY, GreenCard.LIBRARY, ScientistGuild.NAMEPLATE),
    ACADEMY(GreenCard.ACADEMY, GreenCard.SCHOOL, ScientistGuild.COMPASSE),
    STUDY(GreenCard.STUDY, GreenCard.SCHOOL, ScientistGuild.GEAR);

    private List<Resouse> resourseNeededForConstruction;
    private GreenCard chain; // need think
    private ScientistGuild scientistGuild;

    GreenCard(GreenCard greenCard, GreenCard chain, ScientistGuild scientistGuild) {
        this.resourseNeededForConstruction = resourseNeededForConstruction(greenCard);
        this.chain = chain;
        this.scientistGuild = scientistGuild;
    }

    private List<Resouse> resourseNeededForConstruction(GreenCard greenCard) {
        List<Resouse> resouses = new ArrayList<>();
        switch (greenCard) {
            case WORKSHOP:
                resouses.add(Resouse.GLASS);
                return resouses;
            case APOTHECARY:
                resouses.add(Resouse.SILK);
                return resouses;
            case SCRIPTORIUM:
                resouses.add(Resouse.PARCHMENT);
                return resouses;
            case DISPENSARY:
                resouses.add(Resouse.IRON);
                resouses.add(Resouse.IRON);
                resouses.add(Resouse.GLASS);
                return resouses;
            case LABORATORY:
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.PARCHMENT);
                return resouses;
            case LIBRARY:
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.SILK);
                return resouses;
            case LODGE:

                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.SILK);
                resouses.add(Resouse.PARCHMENT);
                return resouses;
            case OBSERVATORY:
                resouses.add(Resouse.IRON);
                resouses.add(Resouse.IRON);
                resouses.add(Resouse.GLASS);
                resouses.add(Resouse.SILK);
                return resouses;
            case UNIVERSITY:
                resouses.add(Resouse.WOOD);
                resouses.add(Resouse.WOOD);
                resouses.add(Resouse.PARCHMENT);
                resouses.add(Resouse.SILK);
                return resouses;
            case ACADEMY:
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.GLASS);
                return resouses;
            case STUDY:
                resouses.add(Resouse.WOOD);
                resouses.add(Resouse.PARCHMENT);
                resouses.add(Resouse.SILK);
                return resouses;

        }

        return null;
    }

    public List<Resouse> getResourseNeededForConstruction() {
        return resourseNeededForConstruction;
    }

    public void setResourseNeededForConstruction(List<Resouse> resourseNeededForConstruction) {
        this.resourseNeededForConstruction = resourseNeededForConstruction;
    }

    public GreenCard getChain() {
        return chain;
    }

    public void setChain(GreenCard chain) {
        this.chain = chain;
    }

    public ScientistGuild getScientistGuild() {
        return scientistGuild;
    }

    public void setScientistGuild(ScientistGuild scientistGuild) {
        this.scientistGuild = scientistGuild;
    }
}

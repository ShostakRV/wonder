package com.wonder.wonder.service.cards.needRebuild;

/**
 * Creator: bm
 * Date: 13.06.17.
 */
// I upgrate to friday 15.06.2017
//
//public enum GreenCardImpl implements Card {
//    // green irst age
//    WORKSHOP(ScientistGuild.GEAR),
//    SCRIPTORIUM(ScientistGuild.NAMEPLATE),
//    APOTHECARY(ScientistGuild.COMPASSE),
//    //green  second age
//    DISPENSARY(ScientistGuild.COMPASSE),
//    LABORATORY(ScientistGuild.GEAR),
//    LIBRARY(ScientistGuild.NAMEPLATE),
//    SCHOOL(ScientistGuild.NAMEPLATE),
//    //green thierd age
//    LODGE(ScientistGuild.COMPASSE),
//    OBSERVATORY(ScientistGuild.GEAR),
//    UNIVERSITY(ScientistGuild.NAMEPLATE),
//    ACADEMY(ScientistGuild.COMPASSE),
//    STUDY(ScientistGuild.GEAR);
//
//    private List<GameResource> resourseNeededForConstruction;
//    private GreenCardImpl chain; // need think
//    private ScientistGuild scientistGuild;
//
//    GreenCardImpl(ScientistGuild scientistGuild) {
//        this.scientistGuild = scientistGuild;
//    }
//
//    @Override
//    public List<Card> getAllCard(int numberPlayer,int age) {
//        List<Card> cards = new ArrayList<>();
//        cards.add(GreenCardImpl.WORKSHOP);
//        cards.add(GreenCardImpl.SCRIPTORIUM);
//        cards.add(GreenCardImpl.APOTHECARY);
//        cards.add(GreenCardImpl.DISPENSARY);
//        cards.add(GreenCardImpl.LABORATORY);
//        cards.add(GreenCardImpl.LIBRARY);
//        cards.add(GreenCardImpl.SCHOOL);
//        cards.add(GreenCardImpl.LODGE);
//        cards.add(GreenCardImpl.OBSERVATORY);
//        cards.add(GreenCardImpl.UNIVERSITY);
//        cards.add(GreenCardImpl.ACADEMY);
//        cards.add(GreenCardImpl.STUDY);
//
//        return cards;
//    }
//
//    @Override
//    public void setField(List<Card> cards) {
//    }
//
//
////    SCRIPTORIUM(GreenCardImpl.SCRIPTORIUM, null, ScientistGuild.NAMEPLATE),
////    APOTHECARY(GreenCardImpl.APOTHECARY, null, ScientistGuild.COMPASSE),
////    //green  second age
////    DISPENSARY(GreenCardImpl.DISPENSARY, GreenCardImpl.APOTHECARY, ScientistGuild.COMPASSE),
////    LABORATORY(GreenCardImpl.LABORATORY, GreenCardImpl.WORKSHOP, ScientistGuild.GEAR),
////    LIBRARY(GreenCardImpl.LIBRARY, GreenCardImpl.SCRIPTORIUM, ScientistGuild.NAMEPLATE),
////    SCHOOL(GreenCardImpl.SCHOOL, null, ScientistGuild.NAMEPLATE),
////    //green thierd age
////    LODGE(GreenCardImpl.LODGE, GreenCardImpl.DISPENSARY, ScientistGuild.COMPASSE),
////    OBSERVATORY(GreenCardImpl.OBSERVATORY, GreenCardImpl.LABORATORY, ScientistGuild.GEAR),
////    UNIVERSITY(GreenCardImpl.UNIVERSITY, GreenCardImpl.LIBRARY, ScientistGuild.NAMEPLATE),
////    ACADEMY(GreenCardImpl.ACADEMY, GreenCardImpl.SCHOOL, ScientistGuild.COMPASSE),
////    STUDY(GreenCardImpl.STUDY, GreenCardImpl.SCHOOL, ScientistGuild.GEAR)
//
//
////    private List<GameResource> resourseNeededForConstruction(GreenCardImpl greenCard) {
////        List<GameResource> resouses = new ArrayList<>();
////        switch (greenCard) {
////            case WORKSHOP:
////                resouses.add(GameResource.GLASS);
////                return resouses;
////            case APOTHECARY:
////                resouses.add(GameResource.SILK);
////                return resouses;
////            case SCRIPTORIUM:
////                resouses.add(GameResource.PARCHMENT);
////                return resouses;
////            case DISPENSARY:
////                resouses.add(GameResource.IRON);
////                resouses.add(GameResource.IRON);
////                resouses.add(GameResource.GLASS);
////                return resouses;
////            case LABORATORY:
////                resouses.add(GameResource.CLAY);
////                resouses.add(GameResource.CLAY);
////                resouses.add(GameResource.PARCHMENT);
////                return resouses;
////            case LIBRARY:
////                resouses.add(GameResource.STONE);
////                resouses.add(GameResource.STONE);
////                resouses.add(GameResource.SILK);
////                return resouses;
////            case LODGE:
////
////                resouses.add(GameResource.CLAY);
////                resouses.add(GameResource.CLAY);
////                resouses.add(GameResource.SILK);
////                resouses.add(GameResource.PARCHMENT);
////                return resouses;
////            case OBSERVATORY:
////                resouses.add(GameResource.IRON);
////                resouses.add(GameResource.IRON);
////                resouses.add(GameResource.GLASS);
////                resouses.add(GameResource.SILK);
////                return resouses;
////            case UNIVERSITY:
////                resouses.add(GameResource.WOOD);
////                resouses.add(GameResource.WOOD);
////                resouses.add(GameResource.PARCHMENT);
////                resouses.add(GameResource.SILK);
////                return resouses;
////            case ACADEMY:
////                resouses.add(GameResource.STONE);
////                resouses.add(GameResource.STONE);
////                resouses.add(GameResource.GLASS);
////                return resouses;
////            case STUDY:
////                resouses.add(GameResource.WOOD);
////                resouses.add(GameResource.PARCHMENT);
////                resouses.add(GameResource.SILK);
////                return resouses;
////
////        }
////
////        return null;
////    }
//
//    public List<GameResource> getResourseNeededForConstruction() {
//        return resourseNeededForConstruction;
//    }
//
//    public void setResourseNeededForConstruction(List<GameResource> resourseNeededForConstruction) {
//        this.resourseNeededForConstruction = resourseNeededForConstruction;
//    }
//
//    public GreenCardImpl getChain() {
//        return chain;
//    }
//
//    public void setChain(GreenCardImpl chain) {
//        this.chain = chain;
//    }
//
//    public ScientistGuild getScientistGuild() {
//        return scientistGuild;
//    }
//
//    public void setScientistGuild(ScientistGuild scientistGuild) {
//        this.scientistGuild = scientistGuild;
//    }
//}

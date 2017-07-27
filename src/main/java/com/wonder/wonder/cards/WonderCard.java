package com.wonder.wonder.cards;

/**
 * Creator: bm
 * Date: 13.06.17.
 */
public enum WonderCard {
// need do wonder class


    THE_COLOSSUS_OF_RHODES_SIDE_A(WonderSide.A, 3),
    THE_LIGHTHOUSE_OF_ALEXANDRIA_SIDE_A(WonderSide.A, 3),
    THE_TEMPLE_OF_ARTEMIS_IN_EPHESUS_SIDE_A(WonderSide.A, 3),
    THE_HANGING_GARDENS_OF_BABYLON_SIDE_A(WonderSide.A, 3),
    THE_STATUE_OF_ZEUS_IN_OLYMPIA_SIDE_A(WonderSide.A, 3),
    THE_MAUSOLEUM_OF_HALICARNASSUS_SIDE_A(WonderSide.A, 3),
    THE_PYRAMIDS_OF_GIZA_SIDE_A(WonderSide.A, 3),
    THE_COLOSSUS_OF_RHODES_SIDE_B(WonderSide.B, 3),
    THE_LIGHTHOUSE_OF_ALEXANDRIA_SIDE_B(WonderSide.B, 3),
    THE_TEMPLE_OF_ARTEMIS_IN_EPHESUS_SIDE_B(WonderSide.B, 3),
    THE_HANGING_GARDENS_OF_BABYLON_SIDE_B(WonderSide.B, 3),
    THE_STATUE_OF_ZEUS_IN_OLYMPIA_SIDE_B(WonderSide.B, 3),
    THE_MAUSOLEUM_OF_HALICARNASSUS_SIDE_B(WonderSide.B, 3),
    THE_PYRAMIDS_OF_GIZA_SIDE_B(WonderSide.B, 3);


    private final WonderSide wonderSide;
    private final int maxlevelBuild;

    WonderCard(WonderSide wonderSide, int maxlevelBuild) {
        this.wonderSide = wonderSide;
        this.maxlevelBuild = maxlevelBuild;
    }

}

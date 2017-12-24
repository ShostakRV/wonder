package com.wonder.wonder.cards;

import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Creator: bm
 * Date: 13.06.17.
 */
@Getter
public enum WonderCard {
// need do wonder class


    THE_COLOSSUS_OF_RHODES_SIDE_A(WonderSide.A, WonderLevelCard.COLOSSUS_MAIN, WonderLevelCard.COLOSSUS_FIRST_A, WonderLevelCard.COLOSSUS_SECOND_A, WonderLevelCard.COLOSSUS_THIRD_A),
    THE_LIGHTHOUSE_OF_ALEXANDRIA_SIDE_A(WonderSide.A, WonderLevelCard.ALEXANDRIA_MAIN, WonderLevelCard.ALEXANDRIA_FIRST_A, WonderLevelCard.ALEXANDRIA_SECOND_A, WonderLevelCard.ALEXANDRIA_THIRD_A),
    THE_TEMPLE_OF_ARTEMIS_IN_EPHESUS_SIDE_A(WonderSide.A, WonderLevelCard.ARTEMIS_MAIN, WonderLevelCard.ARTEMIS_FIRST_A, WonderLevelCard.ARTEMIS_SECOND_A, WonderLevelCard.ARTEMIS_THIRD_A),
    THE_HANGING_GARDENS_OF_BABYLON_SIDE_A(WonderSide.A, WonderLevelCard.GARDENS_MAIN, WonderLevelCard.GARDENS_FIRST_A, WonderLevelCard.GARDENS_SECOND_A, WonderLevelCard.GARDENS_THIRD_A),
    THE_STATUE_OF_ZEUS_IN_OLYMPIA_SIDE_A(WonderSide.A, WonderLevelCard.STATUE_MAIN, WonderLevelCard.STATUE_FIRST_A, WonderLevelCard.STATUE_SECOND_A, WonderLevelCard.STATUE_THIRD_A),
    THE_MAUSOLEUM_OF_HALICARNASSUS_SIDE_A(WonderSide.A, WonderLevelCard.MAUSOLEUM_MAIN, WonderLevelCard.MAUSOLEUM_FIRST_A, WonderLevelCard.MAUSOLEUM_SECOND_A, WonderLevelCard.MAUSOLEUM_THIRD_A),
    THE_PYRAMIDS_OF_GIZA_SIDE_A(WonderSide.A, WonderLevelCard.GIZA_MAIN, WonderLevelCard.GIZA_FIRST_A, WonderLevelCard.GIZA_SECOND_A, WonderLevelCard.GIZA_THIRD_A),

    THE_COLOSSUS_OF_RHODES_SIDE_B(WonderSide.B, WonderLevelCard.COLOSSUS_MAIN, WonderLevelCard.COLOSSUS_FIRST_B, WonderLevelCard.COLOSSUS_SECOND_B),
    THE_LIGHTHOUSE_OF_ALEXANDRIA_SIDE_B(WonderSide.B, WonderLevelCard.ALEXANDRIA_MAIN, WonderLevelCard.ALEXANDRIA_FIRST_B, WonderLevelCard.ALEXANDRIA_SECOND_B, WonderLevelCard.ALEXANDRIA_THIRD_B),
    THE_TEMPLE_OF_ARTEMIS_IN_EPHESUS_SIDE_B(WonderSide.B, WonderLevelCard.ARTEMIS_MAIN, WonderLevelCard.ARTEMIS_FIRST_B, WonderLevelCard.ARTEMIS_SECOND_B, WonderLevelCard.ARTEMIS_THIRD_B),
    THE_HANGING_GARDENS_OF_BABYLON_SIDE_B(WonderSide.B, WonderLevelCard.GARDENS_MAIN, WonderLevelCard.GARDENS_FIRST_B, WonderLevelCard.GARDENS_SECOND_B, WonderLevelCard.GARDENS_THIRD_B),
    THE_STATUE_OF_ZEUS_IN_OLYMPIA_SIDE_B(WonderSide.B, WonderLevelCard.STATUE_MAIN, WonderLevelCard.STATUE_FIRST_B, WonderLevelCard.STATUE_SECOND_B, WonderLevelCard.STATUE_THIRD_B),
    THE_MAUSOLEUM_OF_HALICARNASSUS_SIDE_B(WonderSide.B, WonderLevelCard.MAUSOLEUM_MAIN, WonderLevelCard.MAUSOLEUM_FIRST_B, WonderLevelCard.MAUSOLEUM_SECOND_B, WonderLevelCard.MAUSOLEUM_THIRD_B),
    THE_PYRAMIDS_OF_GIZA_SIDE_B(WonderSide.A, WonderLevelCard.GIZA_MAIN, WonderLevelCard.GIZA_FIRST_B, WonderLevelCard.GIZA_SECOND_B, WonderLevelCard.GIZA_THIRD_B),;
    private final WonderSide wonderSide;
    private final List<WonderLevelCard> wonderLevelCard;

    WonderCard(WonderSide wonderSide, WonderLevelCard... wonderLevelCard) {
        this.wonderSide = wonderSide;
        this.wonderLevelCard = Collections.unmodifiableList(Arrays.asList(wonderLevelCard));
    }
}

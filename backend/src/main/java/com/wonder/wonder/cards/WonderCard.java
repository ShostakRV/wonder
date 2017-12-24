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


    THE_COLOSSUS_OF_RHODES_SIDE_A(WonderSide.A, GameCard.COLOSSUS_MAIN, GameCard.COLOSSUS_FIRST_A, GameCard.COLOSSUS_SECOND_A, GameCard.COLOSSUS_THIRD_A),
    THE_LIGHTHOUSE_OF_ALEXANDRIA_SIDE_A(WonderSide.A, GameCard.ALEXANDRIA_MAIN, GameCard.ALEXANDRIA_FIRST_A, GameCard.ALEXANDRIA_SECOND_A, GameCard.ALEXANDRIA_THIRD_A),
    THE_TEMPLE_OF_ARTEMIS_IN_EPHESUS_SIDE_A(WonderSide.A, GameCard.ARTEMIS_MAIN, GameCard.ARTEMIS_FIRST_A, GameCard.ARTEMIS_SECOND_A, GameCard.ARTEMIS_THIRD_A),
    THE_HANGING_GARDENS_OF_BABYLON_SIDE_A(WonderSide.A, GameCard.GARDENS_MAIN, GameCard.GARDENS_FIRST_A, GameCard.GARDENS_SECOND_A, GameCard.GARDENS_THIRD_A),
    THE_STATUE_OF_ZEUS_IN_OLYMPIA_SIDE_A(WonderSide.A, GameCard.STATUE_MAIN, GameCard.STATUE_FIRST_A, GameCard.STATUE_SECOND_A, GameCard.STATUE_THIRD_A),
    THE_MAUSOLEUM_OF_HALICARNASSUS_SIDE_A(WonderSide.A, GameCard.MAUSOLEUM_MAIN, GameCard.MAUSOLEUM_FIRST_A, GameCard.MAUSOLEUM_SECOND_A, GameCard.MAUSOLEUM_THIRD_A),
    THE_PYRAMIDS_OF_GIZA_SIDE_A(WonderSide.A, GameCard.GIZA_MAIN, GameCard.GIZA_FIRST_A, GameCard.GIZA_SECOND_A, GameCard.GIZA_THIRD_A),

    THE_COLOSSUS_OF_RHODES_SIDE_B(WonderSide.B, GameCard.COLOSSUS_MAIN, GameCard.COLOSSUS_FIRST_B, GameCard.COLOSSUS_SECOND_B),
    THE_LIGHTHOUSE_OF_ALEXANDRIA_SIDE_B(WonderSide.B, GameCard.ALEXANDRIA_MAIN, GameCard.ALEXANDRIA_FIRST_B, GameCard.ALEXANDRIA_SECOND_B, GameCard.ALEXANDRIA_THIRD_B),
    THE_TEMPLE_OF_ARTEMIS_IN_EPHESUS_SIDE_B(WonderSide.B, GameCard.ARTEMIS_MAIN, GameCard.ARTEMIS_FIRST_B, GameCard.ARTEMIS_SECOND_B, GameCard.ARTEMIS_THIRD_B),
    THE_HANGING_GARDENS_OF_BABYLON_SIDE_B(WonderSide.B, GameCard.GARDENS_MAIN, GameCard.GARDENS_FIRST_B, GameCard.GARDENS_SECOND_B, GameCard.GARDENS_THIRD_B),
    THE_STATUE_OF_ZEUS_IN_OLYMPIA_SIDE_B(WonderSide.B, GameCard.STATUE_MAIN, GameCard.STATUE_FIRST_B, GameCard.STATUE_SECOND_B, GameCard.STATUE_THIRD_B),
    THE_MAUSOLEUM_OF_HALICARNASSUS_SIDE_B(WonderSide.B, GameCard.MAUSOLEUM_MAIN, GameCard.MAUSOLEUM_FIRST_B, GameCard.MAUSOLEUM_SECOND_B, GameCard.MAUSOLEUM_THIRD_B),
    THE_PYRAMIDS_OF_GIZA_SIDE_B(WonderSide.B, GameCard.GIZA_MAIN, GameCard.GIZA_FIRST_B, GameCard.GIZA_SECOND_B, GameCard.GIZA_THIRD_B),;

    private final WonderSide wonderSide;
    private final List<GameCard> wonderLevelCard;

    WonderCard(WonderSide wonderSide, GameCard... wonderLevelCard) {
        this.wonderSide = wonderSide;
        this.wonderLevelCard = Collections.unmodifiableList(Arrays.asList(wonderLevelCard));
    }
}

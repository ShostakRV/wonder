package com.wonder.wonder.cards;

import lombok.Getter;

/**
 * Creator: bm
 * Date: 15.06.17.
 */
@Getter
public enum GameCardColor {

    // color card

    BROWN(false), BLUE(false), SILVER(false), RED(false), GREEN(false), YELLOW(false), PURPLE(true), NO_COLOR(false);
    private final boolean cardNeedWeedAndMix;

    GameCardColor(boolean cardNeedWeedAndMix) {
        this.cardNeedWeedAndMix = cardNeedWeedAndMix;
    }
}

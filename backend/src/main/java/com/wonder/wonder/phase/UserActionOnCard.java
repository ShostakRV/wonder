package com.wonder.wonder.phase;

/**
 * Created by bm on 13.07.17.
 */
public enum UserActionOnCard {

    BUILD,
    BUILD_ZEUS,
    SELL_CARD,
    BUILD_WONDER,
    RESURRECT_CARD,
    CHOOSE_PURPURE_ZEUS;

    public boolean isBuildZeus() {
        return this == BUILD_ZEUS;
    }
    public boolean isBuild() {
        return this == BUILD;
    }
    public boolean isSellCard() {
        return this == SELL_CARD;
    }
    public boolean isRessurectCard() {
        return this == RESURRECT_CARD;
    }
    public boolean isBuildWonder() {
        return this == BUILD_WONDER;
    }
}

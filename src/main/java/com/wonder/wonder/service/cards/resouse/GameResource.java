package com.wonder.wonder.service.cards.resouse;

import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Creator: bm
 * Date: 13.06.17.
 */
@Getter
public enum GameResource {
    NO_RESOURCE(false, 1, BaseResource.WOOD),
    WOOD(false, 1, BaseResource.WOOD), STONE(false, 1, BaseResource.STONE), IRON(false, 1, null), CLAY(false, 1, null),
    PARCHMENT(false, 1, null), GLASS(false, 1, null), SILK(false, 1, null),
    WOOD_OR_STONE(true, 1, BaseResource.WOOD, BaseResource.STONE);

    private final Boolean shouldBeChosen;
    private final int count;
    private final List<BaseResource> resources;


    GameResource(Boolean shouldBeChosen, int count, BaseResource... resources) {
        this.shouldBeChosen = shouldBeChosen;
        this.count = count;
        this.resources = Collections.unmodifiableList(Arrays.asList(resources));
    }
}

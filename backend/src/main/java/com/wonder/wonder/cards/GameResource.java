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
// All resouce player can take and their combinations
public enum GameResource {

    NO_RESOURCE(false, 1, BaseResource.NONE),
    WOOD(false, 1, BaseResource.WOOD), // ok
    STONE(false, 1, BaseResource.STONE), // ok
    IRON(false, 1, BaseResource.IRON), // ok
    CLAY(false, 1, BaseResource.CLAY), // ok
    PARCHMENT(false, 1, BaseResource.PARCHMENT), // ok
    GLASS(false, 1, BaseResource.GLASS), // ok
    SILK(false, 1, BaseResource.SILK), // ok

    WOOD_OR_CLAY(true, 1, BaseResource.WOOD, BaseResource.CLAY), // ok
    STONE_OR_CLAY(true, 1, BaseResource.STONE, BaseResource.CLAY), // ok
    IRON_OR_CLAY(true, 1, BaseResource.IRON, BaseResource.CLAY), // ok
    STONE_OR_WOOD(true, 1, BaseResource.STONE, BaseResource.WOOD), // ok
    WOOD_OR_IRON(true, 1, BaseResource.WOOD, BaseResource.IRON), // ok
    STONE_OR_IRON(true, 1, BaseResource.STONE, BaseResource.IRON), // ok

    STONE_OR_IRON_OR_CLAY_OR_WOOD(true, 1, BaseResource.STONE, BaseResource.IRON, BaseResource.STONE, BaseResource.WOOD), // ok
    SILK_OR_GLASS_OR_PARCHMENT(true, 1, BaseResource.SILK,BaseResource.GLASS,BaseResource.PARCHMENT), // ok

    DOUBLE_STONE(false, 2, BaseResource.WOOD, BaseResource.WOOD), // ok)
    DOUBLE_IRON(false, 2, BaseResource.IRON, BaseResource.IRON), // ok)
    DOUBLE_WOOD(false, 2, BaseResource.STONE, BaseResource.STONE), // ok)
    DOUBLE_CLAY(false, 2, BaseResource.CLAY, BaseResource.CLAY), // ok)
    ;


    private final Boolean shouldBeChosen;
    private final int count;
    private final List<BaseResource> resources;


    GameResource(Boolean shouldBeChosen, int count, BaseResource... resources) {
        this.shouldBeChosen = shouldBeChosen;
        this.count = count;
        this.resources = Collections.unmodifiableList(Arrays.asList(resources));
    }
}

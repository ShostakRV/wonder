package com.wonder.wonder.service.cards.resouse;

import com.wonder.wonder.service.cards.Card;

import java.util.List;

/**
 * Creator: bm
 * Date: 15.06.17.
 */
public enum GameCard implements Card {
    LUMBER_YARD(GameCardColor.BROWN, true, GameResource.IRON),
    STONE_PIT(GameCardColor.BROWN, true, GameResource.IRON),
    CLAY_POOL(GameCardColor.BROWN, true, GameResource.IRON),
    ORE_VEIN(GameCardColor.BROWN, true, GameResource.IRON),
    // brown second age
    SAWMILL(GameCardColor.BROWN, true, GameResource.IRON),
    QUARRY(GameCardColor.BROWN, true, GameResource.IRON),
    BRICKYARD(GameCardColor.BROWN, true, GameResource.IRON),
    FOUNDRY(GameCardColor.BROWN, true, GameResource.IRON),

    //brown half
    TREE_FARM(GameCardColor.BROWN, true, GameResource.IRON),
    EXCAVATION(GameCardColor.BROWN, true, GameResource.IRON),
    CLAY_PIT(GameCardColor.BROWN, true, GameResource.IRON),
    TIMBER_YARD(GameCardColor.BROWN, true, GameResource.IRON),
    FOREST_CAVE(GameCardColor.BROWN, true, GameResource.IRON),
    MINE(GameCardColor.BROWN, true, GameResource.IRON);

    private final GameCardColor gameCardColor;
    private final GameResource resource;
    final boolean resourceCard;


    GameCard(GameCardColor gameCardColor, boolean resourceCard, GameResource resource) {

        this.gameCardColor = gameCardColor;

        this.resourceCard = resourceCard;
        this.resource = resource;
    }

    @Override
    public List<Card> getAllCard(int numberPlayer, int age) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public void setField(List<Card> cards) {
        throw new RuntimeException("Not Implemented");
    }

    @Override
    public boolean isResourceOf(GameCardColor color) {
        return color == gameCardColor;
    }

    @Override
    public boolean isResourceCard() {
        return resourceCard;
    }
    @Override
    public GameResource getResource() {
        return resource;
    }
}

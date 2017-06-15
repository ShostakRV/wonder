package com.wonder.wonder.service.cards.impl;

import com.wonder.wonder.service.cards.Card;
import com.wonder.wonder.service.cards.resouse.Resouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Creator: bm
 * Date: 13.06.17.
 */

// need add count cards +3 +4 +5 +6 +7 people
public enum BrownCardImpl implements Card {
    // brown first age // one resourse
    LUMBER_YARD,
    STONE_PIT,
    CLAY_POOL,
    ORE_VEIN,
    // brown second age
    SAWMILL(1),
    QUARRY(1),
    BRICKYARD(1),
    FOUNDRY(1),

    //brown half
    TREE_FARM(1),
    EXCAVATION(1),
    CLAY_PIT(1),
    TIMBER_YARD(1),
    FOREST_CAVE(1),
    MINE(1);


    private int goldNeededForConstruction;
    private List<Resouse> giveResourse;

    BrownCardImpl() {
    }

    BrownCardImpl(int goldNeededForConstruction) {
        this.goldNeededForConstruction = goldNeededForConstruction;
    }

    @Override
    public List<Card> getAllCard(int numberPlayer, int age) {
        List<Card> cards = new ArrayList<>();
        if (numberPlayer >= 3 & age == 1) {
            cards.add(BrownCardImpl.LUMBER_YARD);
            cards.add(BrownCardImpl.STONE_PIT);
            cards.add(BrownCardImpl.CLAY_POOL);
            cards.add(BrownCardImpl.ORE_VEIN);
            cards.add(BrownCardImpl.CLAY_PIT);
            cards.add(BrownCardImpl.TIMBER_YARD);
            if (numberPlayer >= 4) {
                cards.add(BrownCardImpl.LUMBER_YARD);
                cards.add(BrownCardImpl.ORE_VEIN);
                cards.add(BrownCardImpl.EXCAVATION);
                if (numberPlayer >= 5) {
                    cards.add(BrownCardImpl.STONE_PIT);
                    cards.add(BrownCardImpl.CLAY_POOL);
                    cards.add(BrownCardImpl.FOREST_CAVE);
                    if (numberPlayer >= 6) {
                        cards.add(BrownCardImpl.MINE);
                        cards.add(BrownCardImpl.TREE_FARM);
                    }
                }

            }
        }

        if (numberPlayer >= 3 & age == 2) {
            cards.add(BrownCardImpl.SAWMILL);
            cards.add(BrownCardImpl.QUARRY);
            cards.add(BrownCardImpl.BRICKYARD);
            cards.add(BrownCardImpl.FOUNDRY);
            if (numberPlayer >= 4) {
                cards.add(BrownCardImpl.SAWMILL);
                cards.add(BrownCardImpl.QUARRY);
                cards.add(BrownCardImpl.BRICKYARD);
                cards.add(BrownCardImpl.FOUNDRY);
            }
        }
        setField(cards);
        return cards;
    }

    @Override
    public void setField(List<Card> cards) {
        for (Card card1 : cards) {
            List<Resouse> resouses = new ArrayList<>();
            BrownCardImpl brownCard = (BrownCardImpl) card1;
            switch (brownCard) {
                case LUMBER_YARD:
                    resouses.add(Resouse.WOOD);
                    brownCard.setGiveResourse(resouses);
                    break;
                case STONE_PIT:
                    resouses.add(Resouse.STONE);
                    brownCard.setGiveResourse(resouses);
                    break;
                case CLAY_POOL:
                    resouses.add(Resouse.CLAY);
                    brownCard.setGiveResourse(resouses);
                    break;
                case ORE_VEIN:
                    resouses.add(Resouse.IRON);
                    brownCard.setGiveResourse(resouses);
                    break;
                case SAWMILL:
                    resouses.add(Resouse.WOOD);
                    resouses.add(Resouse.WOOD);
                    brownCard.setGiveResourse(resouses);
                    break;
                case QUARRY:
                    resouses.add(Resouse.STONE);
                    resouses.add(Resouse.STONE);
                    brownCard.setGiveResourse(resouses);
                    break;
                case BRICKYARD:
                    resouses.add(Resouse.CLAY);
                    resouses.add(Resouse.CLAY);
                    brownCard.setGiveResourse(resouses);
                    break;
                case FOUNDRY:
                    resouses.add(Resouse.IRON);
                    resouses.add(Resouse.IRON);
                    brownCard.setGiveResourse(resouses);
                    break;
                case TREE_FARM:
                    resouses.add(Resouse.WOOD);
                    resouses.add(Resouse.CLAY);
                    break;
                case EXCAVATION:
                    resouses.add(Resouse.STONE);
                    resouses.add(Resouse.CLAY);
                    break;
                case CLAY_PIT:
                    resouses.add(Resouse.IRON);
                    resouses.add(Resouse.CLAY);
                    break;
                case TIMBER_YARD:
                    resouses.add(Resouse.STONE);
                    resouses.add(Resouse.WOOD);
                    break;
                case FOREST_CAVE:
                    resouses.add(Resouse.WOOD);
                    resouses.add(Resouse.IRON);
                    break;
                case MINE:
                    resouses.add(Resouse.STONE);
                    resouses.add(Resouse.IRON);
                    break;
            }
        }
    }

    private void metodSupportsetField(List<Resouse> resouses, Resouse resouseChoose, BrownCardImpl card) {
        resouses.add(resouseChoose);
        card.setGiveResourse(resouses);
    }


    private void setFieldForTwoType(BrownCardImpl card, Resouse resouse, boolean allOrOne) {
        List<Resouse> resouses = new ArrayList<>();
        switch (card) {
            case TREE_FARM:
                if (allOrOne) {
                    resouses.add(Resouse.WOOD);
                    resouses.add(Resouse.CLAY);
                } else {
                    metodSupportsetField(resouses, resouse, card);
                }

            case EXCAVATION:
                if (allOrOne) {
                    resouses.add(Resouse.STONE);
                    resouses.add(Resouse.CLAY);
                } else {
                    metodSupportsetField(resouses, resouse, card);

                }
            case CLAY_PIT:
                if (allOrOne) {
                    resouses.add(Resouse.IRON);
                    resouses.add(Resouse.CLAY);
                } else {
                    metodSupportsetField(resouses, resouse, card);
                }
            case TIMBER_YARD:
                if (allOrOne) {
                    resouses.add(Resouse.STONE);
                    resouses.add(Resouse.WOOD);
                } else {
                    metodSupportsetField(resouses, resouse, card);
                }
            case FOREST_CAVE:
                if (allOrOne) {
                    resouses.add(Resouse.WOOD);
                    resouses.add(Resouse.IRON);
                } else {
                    metodSupportsetField(resouses, resouse, card);
                }
            case MINE:
                if (allOrOne) {
                    resouses.add(Resouse.STONE);
                    resouses.add(Resouse.IRON);
                } else {
                    metodSupportsetField(resouses, resouse, card);
                }
        }
    }

    public void chooseOneResouce(Card card, Resouse resouseChoose) {
        BrownCardImpl brownCard = (BrownCardImpl) card;
        if (resouseChoose == Resouse.WOOD |
                resouseChoose == Resouse.IRON |
                resouseChoose == Resouse.STONE |
                resouseChoose == Resouse.CLAY) {
            setFieldForTwoType(brownCard, resouseChoose, false);
        }

    }

    public int getGoldNeededForConstruction() {
        return goldNeededForConstruction;
    }

    public List<Resouse> getGiveResourse() {
        return giveResourse;
    }

    private void setGiveResourse(List<Resouse> giveResourse) {
        this.giveResourse = giveResourse;
    }
}


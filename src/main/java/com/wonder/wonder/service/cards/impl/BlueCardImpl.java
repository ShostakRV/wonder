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
public enum BlueCardImpl implements Card {
    //  first age blue
    PAWNSHOP(3),
    BATHS(3),
    ALTAR(2),
    THEATER(2),
    // second age  blue
    AQUEDUCT(5),
    TEMPLE(3),
    STATUE(4),
    COURTHOUSE(4),
    //blue thierd age
    PANTHEON(7),
    GARDENS(5),
    TOWN_HALL(6),
    PALACE(8),
    SENATE(6);


    private int takeBluePoint;

    private List<Resouse> resourseNeededForConstruction;
    private Card chain; // need think


    BlueCardImpl(int takeBluePoint) {
        this.takeBluePoint = takeBluePoint;
    }

    @Override
    public List<Card> getAllCard(int numberPlayer, int age) {
        List<Card> cards = new ArrayList<>();
        if (numberPlayer >= 3 & age == 1) {
            cards.add(BlueCardImpl.BATHS);
            cards.add(BlueCardImpl.ALTAR);
            cards.add(BlueCardImpl.THEATER);
            if (numberPlayer >= 4) {
                cards.add(BlueCardImpl.PAWNSHOP);
                if (numberPlayer >= 5) {
                    cards.add(BlueCardImpl.ALTAR);
                    if (numberPlayer >= 6) {
                        cards.add(BlueCardImpl.THEATER);
                        if (numberPlayer >= 7) {
                            cards.add(BlueCardImpl.BATHS);
                            cards.add(BlueCardImpl.PAWNSHOP);
                        }
                    }
                }
            }
        }
        if (numberPlayer >= 3 & age == 2) {
            cards.add(BlueCardImpl.AQUEDUCT);
            cards.add(BlueCardImpl.TEMPLE);
            cards.add(BlueCardImpl.STATUE);
            if (numberPlayer >= 6) {
                cards.add(BlueCardImpl.TEMPLE);
                if (numberPlayer >= 7) {
                    cards.add(BlueCardImpl.AQUEDUCT);
                    cards.add(BlueCardImpl.STATUE);
                }
            }
        }
        if (numberPlayer >= 3 & age == 3) {
            cards.add(BlueCardImpl.PANTHEON);
            cards.add(BlueCardImpl.GARDENS);
            cards.add(BlueCardImpl.TOWN_HALL);
            cards.add(BlueCardImpl.PALACE);
            cards.add(BlueCardImpl.COURTHOUSE);
            cards.add(BlueCardImpl.SENATE);
            if (numberPlayer >= 4) {
                cards.add(BlueCardImpl.GARDENS);
                if (numberPlayer >= 5) {
                    cards.add(BlueCardImpl.SENATE);
                    cards.add(BlueCardImpl.COURTHOUSE);
                    cards.add(BlueCardImpl.TOWN_HALL);
                    if (numberPlayer >= 6) {
                        cards.add(BlueCardImpl.TOWN_HALL);
                        cards.add(BlueCardImpl.PANTHEON);
                        if (numberPlayer >= 7) {
                            cards.add(BlueCardImpl.PALACE);

                        }
                    }
                }
            }
        }

        for (Card card : cards) {
            List<Resouse> resouses = new ArrayList<>();
            BlueCardImpl blueCard = (BlueCardImpl) card;
            if (blueCard.equals(BlueCardImpl.BATHS)) {
                resouses.add(Resouse.STONE);
            } else if (blueCard.equals(BlueCardImpl.AQUEDUCT)) {
                blueCard.setChain(BlueCardImpl.BATHS);
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.STONE);
            } else if (blueCard.equals(BlueCardImpl.TEMPLE)) {
                blueCard.setChain(BlueCardImpl.ALTAR);
                resouses.add(Resouse.WOOD);
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.GLASS);
            } else if (blueCard.equals(BlueCardImpl.STATUE)) {
                blueCard.setChain(BlueCardImpl.THEATER);
                resouses.add(Resouse.WOOD);
                resouses.add(Resouse.IRON);
                resouses.add(Resouse.IRON);
            } else if (blueCard.equals(BlueCardImpl.COURTHOUSE)) {
                blueCard.setChain(GreenCardImpl.SCRIPTORIUM);
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.SILK);
            } else if (blueCard.equals(BlueCardImpl.PANTHEON)) {
                blueCard.setChain(BlueCardImpl.TEMPLE);
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.IRON);
                resouses.add(Resouse.SILK);
                resouses.add(Resouse.GLASS);
                resouses.add(Resouse.PARCHMENT);
            } else if (blueCard.equals(BlueCardImpl.GARDENS)) {
//                blueCard.setChain(BlueCardImpl.THEATER); //
                resouses.add(Resouse.WOOD);
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.CLAY);
            } else if (blueCard.equals(BlueCardImpl.TOWN_HALL)) {
                blueCard.setChain(BlueCardImpl.THEATER);
                resouses.add(Resouse.GLASS);
                resouses.add(Resouse.IRON);
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.STONE);
            } else if (blueCard.equals(BlueCardImpl.PALACE)) {
                resouses.add(Resouse.GLASS);
                resouses.add(Resouse.PARCHMENT);
                resouses.add(Resouse.SILK);
                resouses.add(Resouse.CLAY);
                resouses.add(Resouse.WOOD);
                resouses.add(Resouse.IRON);
                resouses.add(Resouse.STONE);
            } else if (blueCard.equals(BlueCardImpl.SENATE)) {
                blueCard.setChain(GreenCardImpl.LIBRARY);
                resouses.add(Resouse.IRON);
                resouses.add(Resouse.STONE);
                resouses.add(Resouse.WOOD);

            }
            blueCard.setResourseNeededForConstruction(resouses);
        }


        return cards;
    }

    @Override
    public void setField(List<Card> cards) {
    }

    public int getTakeBluePoint() {
        return takeBluePoint;
    }

    public List<Resouse> getResourseNeededForConstruction() {
        return resourseNeededForConstruction;
    }

    private void setResourseNeededForConstruction(List<Resouse> resourseNeededForConstruction) {
        this.resourseNeededForConstruction = resourseNeededForConstruction;
    }

    public Card getChain() {
        return chain;
    }

    private void setChain(Card chain) {
        this.chain = chain;
    }
}

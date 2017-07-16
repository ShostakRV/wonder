package com.wonder.wonder.dto;

import com.wonder.wonder.cards.CardWonder;
import com.wonder.wonder.cards.GameCard;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 29.06.2017
 */
@Data
public class PlayerDto{
    private long playerId;
    private String playerName;
    private int position; // possition player on board
    private int userSelectedCard;//  1 is turn end

    private CardWonder wonder; // at start give player two card for choose
    private List<GameCard> cardBuilded = new ArrayList<>(); // card what was build
    private int gold;
    private List<Integer> warFlagList = new ArrayList<>();
    private boolean onWar;
}

//    private List<GameCard> cardsOnHand; // todo make separate and point
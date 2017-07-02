package com.wonder.wonder.dto.pb;

import com.wonder.wonder.cards.CardWonder;
import com.wonder.wonder.cards.GameCard;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 29.06.2017
 * Project: wonder
 */
@Data
public class PlayerDtoPb {
    private long playerId;
    private String playerName;
    private int position; // possition player on board
    private int phase;// phase event need rebuild  (or true is 1 and false is 0) or other field

    private CardWonder wonder; // at start give player two card for choose
    private List<GameCard> cardList = new ArrayList<>(); // card what was build
    private int gold;
    private List<Integer> warFlagList = new ArrayList<>();
}

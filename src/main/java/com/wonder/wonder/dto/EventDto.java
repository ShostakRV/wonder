package com.wonder.wonder.dto;

import com.wonder.wonder.cards.GameCard;

import java.util.List;

/**
 * Created by bm
 * DATE 27.06.17.
 */
public class EventDto {

    private String nameEvent; // or enum
    private GameCard gameCard;
    private int goldChange;
    private List<GameCard> rebound;  // OrPurple maybe Left and right players ?? or wt choose best card for player?
    private boolean onWar;




}

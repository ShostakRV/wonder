package com.wonder.wonder.dto;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.cards.WonderCard;
import com.wonder.wonder.cards.WonderSide;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 29.06.2017
 */
@Data
public class PlayerDto {
    // public information
    private long playerId; // userInGameId ???
    private String playerName;
    private int position; // possition player on board
    private int userSelectedCard;//  1 is turn end
// бачу як іф логіку де перебираємо що якщо якщо то хід завершено

    private WonderCard wonder; // at start give player two card for choose
    private WonderSide wonderSide;
    private List<GameCard> cardBuilded = new ArrayList<>(); // card what was build
    private int gold;
    private List<Integer> warFlagList = new ArrayList<>();

    private boolean onWar; // нема такої карти в основах



}


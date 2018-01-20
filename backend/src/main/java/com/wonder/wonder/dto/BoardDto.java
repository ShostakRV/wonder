package com.wonder.wonder.dto;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.phase.GamePhase;
import lombok.Data;

import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 29.06.2017
 * Project: wonder
 */
@Data
public class BoardDto {
    private long gameId;

//    private String name;
    private List<PlayerDto> playerDto;
    private GamePhase gamePhase;
    private int round;
    private int roundPhase; // userSelectedCard схожі

    private List<GameCard> cardsOnHand; // todo make separate and point, private information
}

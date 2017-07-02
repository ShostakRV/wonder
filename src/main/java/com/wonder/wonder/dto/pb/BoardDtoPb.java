package com.wonder.wonder.dto.pb;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.dto.PlayerDto;
import lombok.Data;

import java.util.List;

/**
 * Creator: Pavlenko Bohdan
 * Date: 29.06.2017
 * Project: wonder
 */
@Data
public class BoardDtoPb {
    private long gameId;
    private List<PlayerDto> playerDto;
    private int phase;
    private int userPosition;
    private List<GameCard> cardsOnHand;
}

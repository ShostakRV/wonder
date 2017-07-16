package com.wonder.wonder.dto;

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
    private List<PlayerDto> playerDto;
    private GamePhase phase;

}

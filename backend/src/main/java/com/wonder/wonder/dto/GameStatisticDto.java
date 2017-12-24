package com.wonder.wonder.dto;

import com.wonder.wonder.cards.WonderCard;
import lombok.Data;

/**
 * Created by bm
 * DATE 21.12.17.
 */
@Data
public class GameStatisticDto {

    private Long gameID;
    private Long userId;
    private WonderCard wonderCard;
    private int position;
    private int pointWar;
    private double pointGold;
    private int pointWonder;
    private int pointBlu;
    private int pointYellow;
    private int pointGreen;
    private int pointPurple;
}

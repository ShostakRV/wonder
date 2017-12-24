package com.wonder.wonder.dto;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.phase.UserActionOnCard;
import lombok.Data;

import java.util.List;

/**
 * Created by bm
 * DATE 27.06.17.
 */
@Data
public class EventDto {

    private UserActionOnCard eventUserChoose;
    private GameCard playCard;
    private GameCard chainCard;

    private List<PayDto> payDtoList;
    private List<ResourceChooseDto> resourceChooseDtoList; // TODO HOW CONVERT THIS

    private Long gameId;
    private Long userInGameId; // or you think take user in session


}

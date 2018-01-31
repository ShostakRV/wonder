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

    // WHAT DO THIS CARD
    private UserActionOnCard userActionOnCard;
    // WHAT CARD PLAY USER
    private GameCard playOnCardForEvent;
    //WHAT CARD NEED PUT WHEN BUILD WONDER LEVEL CARD
    private GameCard toPutOnForBuild;
    // WHAT CARD IS PARANT FOR CHAIN
    private GameCard chainCard;
// WHAT USER BUY AND TO WHOM
    private List<PayDto> payDtoList;
    // WHAT USER RESOURSE CHOOSE USER  FOR BUILD
    private List<ResourceChooseDto> resourceChooseDtoList;

    private Long gameId;
    private Long userInGameId;


}

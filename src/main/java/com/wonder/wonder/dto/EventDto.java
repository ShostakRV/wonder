package com.wonder.wonder.dto;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.model.UserInGame;
import com.wonder.wonder.phase.EventPhase;
import lombok.Data;

/**
 * Created by bm
 * DATE 27.06.17.
 */
@Data
public class EventDto {

    private EventPhase eventPhase;
    private GameCard gameCard;



    private Integer userInGameId; // or you think take user in session


}

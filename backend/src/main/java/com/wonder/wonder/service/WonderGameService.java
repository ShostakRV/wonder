package com.wonder.wonder.service;

import com.wonder.wonder.dto.EventDto;
import com.wonder.wonder.model.Game;

/**
 * Created: Shostak Roman
 * Date: 24.06.2017.
 */
public interface WonderGameService  {


    boolean playCard(EventDto eventDto);

    Game getCurrentBoard(Long gameId);
}
// todo end event dto buisness logic wonder game

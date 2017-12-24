package com.wonder.wonder.rest;

import com.wonder.wonder.dto.GameStatisticDto;
import com.wonder.wonder.dto.conerter.GameStatisticByUserInGameDtoConverter;
import com.wonder.wonder.model.UserInGame;
import com.wonder.wonder.service.UserInGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@ReadingConverter
@RequestMapping(name = "/api/game")
public class UserInGameController {
    @Autowired
    private UserInGameService userInGameService;

    @Autowired
    private GameStatisticByUserInGameDtoConverter gameStatisticByUserInGameDtoConverter;

    // all gamer
    @RequestMapping(value = "/{gameId}/statistic", method = RequestMethod.POST)
    public List<GameStatisticDto> gameResult(@PathVariable("gameId") long gameId) {
        // streem
        List<GameStatisticDto> gameStatisticDtos = new ArrayList<>();
        for (UserInGame u : userInGameService.getGameResult(gameId)) {
            GameStatisticDto gs = gameStatisticByUserInGameDtoConverter.convertToDto(u);
            gameStatisticDtos.add(gs);
        }
        return gameStatisticDtos;
    }
}

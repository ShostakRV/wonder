package com.wonder.wonder.rest;

import com.wonder.wonder.dto.GameStatisticDto;
import com.wonder.wonder.dto.conerter.GameStatisticByUserInGameDtoConverter;
import com.wonder.wonder.service.impl.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created b.missurenko
 * Date **.12.17.
 */
@ReadingConverter
@RequestMapping(name = "/api/game")
public class StatisticController {
    @Autowired
    private GameServiceImpl gameService;

    @Autowired
    private GameStatisticByUserInGameDtoConverter gameStatisticByUserInGameDtoConverter;

    // all gamer
    @RequestMapping(value = "/{gameId}/statistic", method = RequestMethod.POST)
    public List<GameStatisticDto> gameResult(@PathVariable("gameId") long gameId) {
        return gameService.getGameResult(gameId).stream().map(u -> gameStatisticByUserInGameDtoConverter.convertToDto(u))
                .collect(Collectors.toList());
    }
}

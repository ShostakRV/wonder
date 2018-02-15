package com.wonder.wonder.rest;


import com.wonder.wonder.Constants;
import com.wonder.wonder.dto.BoardDto;
import com.wonder.wonder.dto.EventDto;
import com.wonder.wonder.dto.GameViewDto;
import com.wonder.wonder.service.GameService;
import com.wonder.wonder.service.WonderGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created b.missurenko
 * Date **.12.17.
 */
@ReadingConverter
@RequestMapping(name = Constants.BASE_GAME_PATH)
public class GameRestController {
    @Autowired
    GameService gameService;
    @Autowired
    private WonderGameService wonderGameService;

    @PostMapping(value = "/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createGame(String gameName) {
        gameService.createGame(gameName);
    }

    @PostMapping(value = "/{gameId}/join")
    public boolean joinGame(@PathVariable("gameId") long gameId) {
        return gameService.joinToGame(gameId);
    }

    @RequestMapping(value = "/lobby", method = RequestMethod.GET)
    public List<GameViewDto> showLobby() {
        return gameService.showGameInJoinPhaseInLobby();
    }

    @PostMapping(value = "/{gameId}/start")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public boolean startGame(@PathVariable("gameId") long gameId) {
        try {
            gameService.startGame(gameId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping(value = "/{gameId}/playCard")
    public BoardDto getBoard(@PathVariable(name = "gameId") Long gameId,
                             @RequestBody EventDto eventDto) {
        wonderGameService.playCard(eventDto);
        return wonderGameService.getCurrentBoard(gameId);
    }

    // metod like i preperefor battle
}

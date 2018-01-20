package com.wonder.wonder.dto.conerter.impl;

import com.wonder.wonder.dto.BoardDto;
import com.wonder.wonder.dto.PlayerDto;
import com.wonder.wonder.dto.conerter.GameBoardDtoConverter;
import com.wonder.wonder.dto.conerter.UserInGamePlayerDtoConverter;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.UserInGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Created b.missurenko
 * Date **.12.17.
 */
@Service
public class GameBoardDtoConverterImpl implements GameBoardDtoConverter {

    @Autowired
    UserInGamePlayerDtoConverter playerConv;

    @Override
    public BoardDto convertToDto(Game game) {
        BoardDto boardDto = new BoardDto();
        boardDto.setGameId(game.getId());
        boardDto.setGamePhase(game.getPhaseGame());
        boardDto.setRound(game.getPhaseRound());
        boardDto.setRoundPhase(game.getPhaseChooseDo());
        List<PlayerDto> result = new ArrayList<>(); // TODO LIKE STREEM
        for (UserInGame userInGame : game.getUserInGames()) {
            result.add(playerConv.convertToDto(userInGame));
        }
        boardDto.setPlayerDto(result);
        return boardDto;
    }

    @Override
    public Game convertToEntity(BoardDto boardDto) {
        Game game = new Game();
        game.setId(boardDto.getGameId());
        game.setPhaseGame(boardDto.getGamePhase());
        game.setPhaseChooseDo(boardDto.getRoundPhase());
        List<UserInGame> result = new ArrayList<>();
        for (PlayerDto playerDto : boardDto.getPlayerDto()) {
            result.add(playerConv.convertToEntity(playerDto));
        }
        game.setUserInGames(result); // TODO LIKE STREEM
        return game;
    }
}

package com.wonder.wonder.dto.conerter.impl;

import com.wonder.wonder.dto.GameStatisticDto;
import com.wonder.wonder.dto.conerter.GameStatisticByUserInGameDtoConverter;
import com.wonder.wonder.model.UserInGame;
/**
 * Created b.missurenko
 * Date **.12.17.
 */
public class GameStatisticByUserInGameDtoConverterImpl implements GameStatisticByUserInGameDtoConverter {
    @Override
    public GameStatisticDto convertToDto(UserInGame userInGame) {
        GameStatisticDto gameStatisticDto = new GameStatisticDto();
        gameStatisticDto.setGameID(userInGame.getGame().getId());
        gameStatisticDto.setUserId(userInGame.getUser().getId());
        gameStatisticDto.setWonderCard(userInGame.getWonder());
        gameStatisticDto.setPosition(userInGame.getPosition());
        gameStatisticDto.setPointBlu(userInGame.getPBlue());
        gameStatisticDto.setPointGold(userInGame.getPGold());
        gameStatisticDto.setPointGreen(userInGame.getPGreen());
        gameStatisticDto.setPointWar(userInGame.getPWars());
        gameStatisticDto.setPointPurple(userInGame.getPPurple());
        return gameStatisticDto;
    }
}

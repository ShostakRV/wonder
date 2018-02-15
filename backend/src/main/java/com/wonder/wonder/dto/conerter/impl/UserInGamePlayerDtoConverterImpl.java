package com.wonder.wonder.dto.conerter.impl;

import com.wonder.wonder.dto.PlayerDto;
import com.wonder.wonder.dto.conerter.UserInGamePlayerDtoConverter;
import com.wonder.wonder.model.CardSetItem;
import com.wonder.wonder.model.UserInGame;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
/**
 * Created b.missurenko
 * Date **.12.17.
 */
@Service
public class UserInGamePlayerDtoConverterImpl implements UserInGamePlayerDtoConverter {
    @Override
    public PlayerDto convertToDto(UserInGame userInGame) {
        PlayerDto playerDto = new PlayerDto();
        playerDto.setPlayerId(userInGame.getId());
        playerDto.setPlayerName(userInGame.getUser().getUsername());
        playerDto.setPosition(userInGame.getPosition());
//        playerDto.setUserSelectedCard();
        playerDto.setWonder(userInGame.getWonder());
        playerDto.setCardBuilded(userInGame.getCardSetItems()
                .stream()
                .map(CardSetItem::getGameCard)
                .collect(Collectors.toList()));
//        playerDto.setGold(); // TODO METOD COUNT GOLD BY EVENT
//        playerDto.getCardsOnHand(); TODO METOD Передачі кард між гравцями
        return playerDto;
    }

    @Override
    public UserInGame convertToEntity(PlayerDto playerDto) {
        UserInGame userInGame = new UserInGame();
        userInGame.setId(playerDto.getPlayerId());
        return userInGame;
    }
}

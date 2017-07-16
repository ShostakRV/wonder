package com.wonder.wonder.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by bm on 16.07.17.
 */
@Getter
@Setter
public class ShowLobbyDto {

    private int playersInGameCount;

    private long gameId;

    private String gameName;

}

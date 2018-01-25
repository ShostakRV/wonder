package com.wonder.wonder.service.util;

import lombok.Data;

@Data
public class TransferEvent {

    long gameId;

    long UserInGameId;

    long EventId;
}

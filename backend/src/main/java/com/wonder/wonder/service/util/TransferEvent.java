package com.wonder.wonder.service.util;

import com.wonder.wonder.phase.GamePhase;
import lombok.Data;

@Data
public class TransferEvent {

    private long gameId;

    private long userInGameId;

    private GamePhase gamePhase;

    private Integer phaseRound;

    private Integer phaseChooseDo;

    public TransferEvent(long id, long userInGameId, GamePhase phaseGame, Integer phaseRound, Integer phaseChooseDo) {
        this.gameId = id;
        this.userInGameId = userInGameId;
        this.gamePhase = phaseGame;
        this.phaseRound = phaseRound;
        this.phaseChooseDo = phaseChooseDo;
    }
}

package com.wonder.wonder.jms;

import com.wonder.wonder.service.EventService;
import com.wonder.wonder.service.GameService;
import com.wonder.wonder.service.util.TransferEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JmsLisnerEvent {

    @Autowired
    private EventService eventService;

    @Autowired
    GameService gameService;

    private List<String> Events = new ArrayList<>();

    @JmsListener(destination = "eventToSave", containerFactory = "myFactory")
    public void receiveMessage(TransferEvent message) {
//
//        Events.add(transferEvent);
//        if (Events.size() == 7) {
//            Game game = transferEvent.getEvent().getGame();
//
//            int phaseChooseDoStart = game.getPhaseChooseDo();
//            int phaseChooseDoNow = 0;
//            for (TransferEvent trEvent : Events) {
//                if (trEvent.getGameUserInfo().getChangeGoldByOnBuildEvent() != 0) {
//                    if (phaseChooseDoNow == phaseChooseDoStart) {
//                        ++phaseChooseDoNow;
//                        game.setPhaseChooseDo(phaseChooseDoNow);
//                        gameService.save(game);
//                    }
//                    eventService.save(createNewEvent(trEvent.getEvent(),
//                            trEvent.getGameUserInfo().getChangeGoldByOnBuildEvent()));
//                } else if (trEvent.getGameUserInfo().isBuildGalicarnas()) {
//                    if (phaseChooseDoNow == phaseChooseDoStart) {
//                        ++phaseChooseDoNow;
//                        game.setPhaseChooseDo(phaseChooseDoNow);
//                        gameService.save(game);
//                    }
//                }
//            }
//            if (game.getPhaseRound() == 7
//                    && transferEvent.getGameUserInfo().isGarderPassiveWonder()) {
//                game.setPhaseChooseDo(0);
//                game.setPhaseRound(game.getPhaseRound() + 1);
//                gameService.save(game);
//            } else if (game.getPhaseRound() < 7) {
//                game.setPhaseChooseDo(0);
//                game.setPhaseRound(game.getPhaseRound() + 1);
//                gameService.save(game);
//            } else {
//                game.setPhaseChooseDo(0);
//                game.setPhaseRound(1);
//                if (game.getPhaseGame().equals(GamePhase.AGE_1)){
//                    game.setPhaseGame(GamePhase.AGE_2);
//                }else if(game.getPhaseGame().equals(GamePhase.AGE_2)){
//                    game.setPhaseGame(GamePhase.AGE_3);
//                }else {
//
//                }

// else if (trEvent.getGameUserInfo().) {
//
//                }
//                if (trEvent.getGameUserInfo().isGarderPassiveWonder()
//                        &&) {
//                    Game game = trEvent.getEvent().getGame();
//                    gameService.
////                }
//            }
//        }

    }

//    protected Event createNewEvent(Event event, int goldOnBuildEvent) {
//        Event newEvent = new Event();
//        newEvent.setGame(event.getGame());
//        newEvent.setUserInGame(event.getUserInGame());
//        newEvent.setGamePhase(event.getGamePhase());
//        newEvent.setPhaseRound(event.getPhaseRound());
//        newEvent.setPhaseChooseDo(event.getPhaseChooseDo() + 1);
//        newEvent.setGoldChange(goldOnBuildEvent);
//        return newEvent;
//    }
}


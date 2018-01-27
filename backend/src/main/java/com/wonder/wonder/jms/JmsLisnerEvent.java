package com.wonder.wonder.jms;

import com.wonder.wonder.model.Event;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.UserInGame;
import com.wonder.wonder.phase.GamePhase;
import com.wonder.wonder.phase.UserActionOnCard;
import com.wonder.wonder.service.EventService;
import com.wonder.wonder.service.GameService;
import com.wonder.wonder.service.UserInGameService;
import com.wonder.wonder.service.util.GameBoardView;
import com.wonder.wonder.service.util.GameUserInfo;
import com.wonder.wonder.service.util.GameUserInfoUtils;
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
    private GameService gameService;

    @Autowired
    private UserInGameService userInGameService;


    protected int getGoldChange(GameBoardView gameBoardView, Event currentEvent) {
        currentEvent.getCard().getOnBuildEvent().doAction(gameBoardView);
        return currentEvent.getGoldChange();
    }

    protected GameBoardView getGameBoardView(long userInGameId) {
        UserInGame userInGame = userInGameService.getUserInGameById(userInGameId);
        Game game = userInGame.getGame();
        List<GameUserInfo> gameUserInfos = new ArrayList<>(GameUserInfoUtils
                .createGameUserInfo(game.getEvents()).values());

        return new GameBoardView(game, userInGameId, gameUserInfos);

    }

    @JmsListener(destination = "transferEvent", containerFactory = "myFactory")
    public void receiveMessage(TransferEvent message) {

        List<Event> allLastEvent = eventService.getAllLastEvent(message.getGameId(), message.getGamePhase()
                , message.getPhaseRound(), message.getPhaseChooseDo());

        Game game = gameService.findGameById(message.getGameId());

        // TODO ASK // WHAT DO THIS NULL
        GameBoardView gameBoardView = null;

        boolean mavzoleumWasBuild = false;
        boolean gargenHavePssive = false;
        if (allLastEvent.size() == game.getUserInGames().size()) {


            for (Event event : allLastEvent) {
                if (GameUserInfoUtils.isBuildMavzoleumGalicarnasResorectionCard(event.getCard())) {
                    game.setPhaseChooseDo(game.getPhaseChooseDo() + 1);
                    mavzoleumWasBuild = true;
                }
            }

            if (message.getPhaseChooseDo().equals(game.getPhaseChooseDo())) {
                game.setPhaseChooseDo(game.getPhaseChooseDo() + 1);
                gameService.save(game);
                gameBoardView = getGameBoardView(message.getUserInGameId());
                for (Event event : allLastEvent) {
                    gameBoardView.setCurrentUser(event.getUserInGame().getId());
                    // GARDEN SECOND_B BUILD
                    if (gameBoardView.getCurrentUserGameInfo().isGarderPassiveWonder()) {
                        gargenHavePssive = gameBoardView.getCurrentUserGameInfo().isGarderPassiveWonder();
                    }

                    int goldChange = getGoldChange(gameBoardView, event);
                    if (goldChange != 0) {
                        Event newEvent = createNewEvent(game, event.getUserInGame(), event.getGamePhase(), event.getPhaseRound());
                        newEvent.setGoldChange(goldChange);
                        newEvent.setPhaseChooseDo(game.getPhaseChooseDo());
                        eventService.save(newEvent);
                    }
                }
            }

        } else if (allLastEvent.size() == 1) {

            for (Event event : allLastEvent) {
                if (event.getUserActionOnCard().equals(UserActionOnCard.RESORECT_CARD)) {
                    List<Event> eventByPhaseBeforeList = eventService.getAllLastEvent(message.getGameId(), message.getGamePhase()
                            , message.getPhaseRound(), message.getPhaseChooseDo() - 1);
                    gameBoardView = getGameBoardView(message.getUserInGameId());

                    for (Event eventByPhaseBefore : eventByPhaseBeforeList) {
                        gameBoardView.setCurrentUser(eventByPhaseBefore.getUserInGame().getId());
                        // GARDEN SECOND_B BUILD
                        if (gameBoardView.getCurrentUserGameInfo().isGarderPassiveWonder()) {
                            gargenHavePssive = gameBoardView.getCurrentUserGameInfo().isGarderPassiveWonder();
                        }

                        int goldChange = getGoldChange(gameBoardView, eventByPhaseBefore);
                        if (goldChange != 0) {
                            Event newEvent = createNewEvent(game, eventByPhaseBefore.getUserInGame(), eventByPhaseBefore.getGamePhase(), eventByPhaseBefore.getPhaseRound());
                            newEvent.setGoldChange(goldChange);
                            newEvent.setPhaseChooseDo(game.getPhaseChooseDo());
                            eventService.save(newEvent);
                        }
                    }
                }
            }

        }
        // GARDEN
        if (isGardenPassive(gargenHavePssive, game.getPhaseRound())) {
            game.setPhaseRound(game.getPhaseRound() + 1);
            game.setPhaseChooseDo(0);

            // SET WAR
        } else if (isOnStartNewBasicWar(gargenHavePssive, game.getPhaseRound())) {
            game.setPhaseRound(0);
            game.setPhaseChooseDo(0);
            game.setPhaseGame(GamePhase.valueOf(getCurrenctGamePhase("WAR", game)));

            // SET +1 ROUND
        } else if (isOnStartNewBasicRound(mavzoleumWasBuild, game.getPhaseRound())) {
            game.setPhaseRound(game.getPhaseRound() + 1);
            game.setPhaseChooseDo(0);
        }
        gameService.save(game);

        String[] gamePhaseNow = splitGamePhase(game);
        if (gamePhaseNow[0].equals("WAR")) {

            for (UserInGame userInGame : game.getUserInGames()) {
                gameBoardView.setCurrentUser(userInGame.getId());
                Event newEventWarLeft = createNewEvent(game, userInGame, game.getPhaseGame(), game.getPhaseRound());
                newEventWarLeft.setPhaseChooseDo(game.getPhaseChooseDo());
                Event newEventWarRight = createNewEvent(game, userInGame, game.getPhaseGame(), game.getPhaseRound());
                newEventWarRight.setPhaseChooseDo(game.getPhaseChooseDo());
                if (gameBoardView.isWinLeftPlayerInWar()) {
                    // TODO ITEM WAR LEFT
                } else {

                }
                if (gameBoardView.isWinRightPlayerInWar()) {
                    // TODO ITEM WAR RIGHT
                } else {

                }
                eventService.save(newEventWarLeft);
                eventService.save(newEventWarRight);
            }

            if (Integer.parseInt(gamePhaseNow[1]) == 3) {
                game.setPhaseGame(GamePhase.FINISHED);
                game.setPhaseChooseDo(0);
                game.setPhaseRound(0);
            } else {
                int ageNow = Integer.parseInt(gamePhaseNow[1]) + 1;
                game.setPhaseGame(GamePhase.valueOf("AGE_" + ageNow));
                game.setPhaseChooseDo(1);
                game.setPhaseRound(1);
            }

            gameService.save(game);
        }

        if (game.getPhaseGame().equals(GamePhase.FINISHED)) {
            for (UserInGame userInGame : game.getUserInGames()) {
                gameBoardView.setCurrentUser(userInGame.getId());
                //TODO CALCULATE POINTS
            }
        }

    }

    // GARDEN Age 8 1
    protected boolean isGardenPassive(boolean gargenHavePssive, int round) {
        return gargenHavePssive && round == 7;
    }

    // WAR 0 0
    protected boolean isOnStartNewBasicWar(boolean gargenHavePssive, int round) {
        return !gargenHavePssive && round == 7 || gargenHavePssive && round == 8;
    }

    // AGE +1 1
    protected boolean isOnStartNewBasicRound(boolean mavzoleumWasBuild, int round) {
        return !mavzoleumWasBuild && round != 7;
    }

    protected String getCurrenctGamePhase(String phaseToSet, Game game) {
        String[] splitGamePhase = splitGamePhase(game);
        int gameAge = Integer.parseInt(splitGamePhase[splitGamePhase.length - 1]);
        return phaseToSet + "_" + gameAge;
    }

    protected String[] splitGamePhase(Game game) {
        return game.getPhaseGame().toString().split("_");

    }

    protected Event createNewEvent(Game game, UserInGame userInGame, GamePhase gamePhase, int phaseRound) {
        Event newEvent = new Event();
        newEvent.setGame(game);
        newEvent.setUserInGame(userInGame);
        newEvent.setGamePhase(gamePhase);
        newEvent.setPhaseRound(phaseRound);
        return newEvent;
    }
}


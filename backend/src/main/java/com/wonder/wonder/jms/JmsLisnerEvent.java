package com.wonder.wonder.jms;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.cards.GameCardColor;
import com.wonder.wonder.cards.ScientistGuild;
import com.wonder.wonder.model.Event;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.UserInGame;
import com.wonder.wonder.phase.GamePhase;
import com.wonder.wonder.phase.UserActionOnCard;
import com.wonder.wonder.service.EventService;
import com.wonder.wonder.service.GameService;
import com.wonder.wonder.service.UserInGameService;
import com.wonder.wonder.service.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.smartcardio.Card;
import java.lang.reflect.Array;
import java.util.*;

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

        long gameId = message.getGameId();
        GamePhase gamePhase = message.getGamePhase();
        Integer phaseRound = message.getPhaseRound();
        Integer phaseChooseDo = message.getPhaseChooseDo();
        List<Event> allLastEvent = eventService.getAllLastEvent(gameId, gamePhase, phaseRound, phaseChooseDo);

        Game game = gameService.findGameById(gameId);

        GameBoardView gameBoardView;

        boolean mausoleumWasBuild = false;
        boolean gardenHavePassive = false;

        List<Event> eventForSave = new ArrayList<>();
        if (allLastEvent.size() == game.getUserInGames().size()) {
//BASIC EVENT ON BUILD
            gameBoardView = getGameBoardView(message.getUserInGameId());

            gardenHavePassive = gameBoardView.isGarbenPassiveBuilt();

            mausoleumWasBuild = gameBoardView.isMavzoleumPowerWasBuilt();

            game.setPhaseChooseDo(game.getPhaseChooseDo() + 1);

            if (!mausoleumWasBuild) {
                eventForSave.addAll(createNewEventsByOnBuildEventForSave(gameBoardView, allLastEvent, game));
            }

        } else if (allLastEvent.size() == 1) {

            if (allLastEvent.get(0).getUserActionOnCard().equals(UserActionOnCard.RESORECT_CARD)) {
//MAVZOLEUM EVENT AND EVENT ON BUILD EVENT ONE CHOOSE DO PFASE BEFORE
                List<Event> eventByPhaseBeforeList = eventService.getAllLastEvent(gameId, gamePhase
                        , phaseRound, phaseChooseDo - 1);

                gameBoardView = getGameBoardView(message.getUserInGameId());

                gardenHavePassive = gameBoardView.isGarbenPassiveBuilt();
// save like round 2 for basic
                eventForSave.addAll(createNewEventsByOnBuildEventForSave(gameBoardView, eventByPhaseBeforeList, game));
// save like round 3
                game.setPhaseChooseDo(game.getPhaseChooseDo() + 1);
                eventForSave.addAll(createNewEventsByOnBuildEventForSave(gameBoardView, allLastEvent, game));
            } else if (game.getPhaseRound().equals(8)) {
// GARDEN EVENT
                gameBoardView = getGameBoardView(message.getUserInGameId());

                game.setPhaseChooseDo(game.getPhaseChooseDo() + 1);

                eventForSave.addAll(createNewEventsByOnBuildEventForSave(gameBoardView, allLastEvent, game));

            }
        }
        gameService.save(game);
        saveEvents(eventForSave);

// AGE AND USER MOVE IS setPhaseChooseDo 1 or more
// WAR is               setPhaseChooseDo 0
        if (isGardenPassive(gardenHavePassive, game.getPhaseRound())) {
// SET GARDEN
            game.setPhaseRound(game.getPhaseRound() + 1);
            game.setPhaseChooseDo(1);

        } else if (isOnStartNewBasicRound(mausoleumWasBuild, game.getPhaseRound())) {
// SET NEW BASIC ROUND
            game.setPhaseRound(game.getPhaseRound() + 1);
            game.setPhaseChooseDo(1);
// SET NEW WAR
        } else if (isOnStartNewBasicWar(gardenHavePassive, game.getPhaseRound())) {

            game.setPhaseRound(0);
            game.setPhaseChooseDo(0);
            game.setPhaseGame(GamePhase.valueOf(getCurrenctGamePhase("WAR", game)));

            String[] gamePhaseNow = splitGamePhase(game);
            int ageNow = Integer.parseInt(gamePhaseNow[1]);
// UPDATE gameBoardView START CALCULATE WAR EVENT
            gameBoardView = getGameBoardView(message.getUserInGameId());

            eventForSave.addAll(createNewEventByWar(gameBoardView, game));

// IS NOW WAR 3 GO TO FINISHED
            if (ageNow == 3) {
                game.setPhaseGame(GamePhase.FINISHED);
                game.setPhaseChooseDo(0);
                game.setPhaseRound(0);
// START NEW ROUND  age +1
            } else {
                ageNow += 1;
                game.setPhaseGame(GamePhase.valueOf("AGE_" + ageNow));
                game.setPhaseChooseDo(1);
                game.setPhaseRound(1);
            }
        }

        gameService.save(game);
        saveEvents(eventForSave);
// START CALCULATE USERS POINTS IN GAME
        if (game.getPhaseGame().equals(GamePhase.FINISHED)) {
            gameBoardView = getGameBoardView(message.getUserInGameId());
            List<UserInGame> userInGameList = new ArrayList<>(game.getUserInGames());
            for (UserInGame userInGame : userInGameList) {
                gameBoardView.setCurrentUser(userInGame.getId());
                GameUserInfo currecntGameUserInfo = gameBoardView.getCurrentUserGameInfo();

                userInGame.setPWars(currecntGameUserInfo.getCountWinWar() - currecntGameUserInfo.getCountLoose());
                Map<ScientistGuild, Integer> scientistMap = new HashMap<>();
                for (GameCard gameCard : currecntGameUserInfo.getUserBuiltCards()) {
                    if (gameCard.getAge() == 0) {
                        userInGame.setPWonder(userInGame.getPWonder()
                                + gameCard.getStrategy().getPoints(gameBoardView));
                    } else {
                        if (gameCard.getGameCardColor().equals(GameCardColor.BLUE)) {
                            userInGame.setPBlue(userInGame.getPBlue() +
                                    gameCard.getStrategy().getPoints(gameBoardView));
                        } else if (gameCard.getGameCardColor().equals(GameCardColor.YELLOW)) {
                            userInGame.setPYellow(userInGame.getPBlue() +
                                    gameCard.getStrategy().getPoints(gameBoardView));
                        } else if (gameCard.getGameCardColor().equals(GameCardColor.PURPLE)) {
                            userInGame.setPPurple(userInGame.getPBlue() +
                                    gameCard.getStrategy().getPoints(gameBoardView));
                        } else if (gameCard.getSignScientistGuild() != ScientistGuild.NONE ||
                                gameCard.getSignScientistGuild() != ScientistGuild.NAMEPLATE_OR_COMPASSE_OR_GEAR) {
                            if (scientistMap.containsKey(gameCard.getSignScientistGuild())) {
                                scientistMap.put(gameCard.getSignScientistGuild()
                                        , scientistMap.get(gameCard.getSignScientistGuild()) + 1);
                            } else {
                                scientistMap.put(gameCard.getSignScientistGuild(), 1);
                            }
                        }
                    }
                }
                List<Integer> allSymvol = new ArrayList<>(scientistMap.values());
                boolean addSevenPoint = false;
                if (allSymvol.size() == 3) {
                    addSevenPoint = true;
                }
                int lowCombination = 0;
                for (int count : allSymvol) {
                    if (addSevenPoint &&
                            lowCombination > count) {
                        lowCombination = count;
                    }
                    userInGame.setPGreen(userInGame.getPGreen() + count * count);
                }
                userInGame.setPGreen(userInGame.getPGreen() + lowCombination * 7);
            }
        }
    }


    protected List<Event> createNewEventByWar(GameBoardView gameBoardView, Game game) {
        List<Event> eventsForSaveList = new ArrayList<>();
        for (UserInGame userInGame : game.getUserInGames()) {
            gameBoardView.setCurrentUser(userInGame.getId());
            Event newEventWarLeft = createNewEvent(game, userInGame, game.getPhaseGame(), game.getPhaseRound(), game.getPhaseChooseDo());

            Event newEventWarRight = createNewEvent(game, userInGame, game.getPhaseGame(), game.getPhaseRound(), game.getPhaseChooseDo());
            String[] phaseGame = game.getPhaseGame().toString().split("_");
            String age = phaseGame[1];
            if (gameBoardView.isWinLeftPlayerInWar()) {
                newEventWarLeft.setItems(Items.valueOf("WAR_WIN_" + age));
            } else {
                newEventWarLeft.setItems(Items.valueOf("WAR_LOOSE_" + age));
            }
            if (gameBoardView.isWinRightPlayerInWar()) {
                newEventWarRight.setItems(Items.valueOf("WAR_WIN_" + age));
            } else {
                newEventWarRight.setItems(Items.valueOf("WAR_LOOSE_" + age));
            }
            eventsForSaveList.add(newEventWarLeft);
            eventsForSaveList.add(newEventWarRight);
        }
        return eventsForSaveList;
    }

    protected void saveEvents(List<Event> eventForSave) {
        for (Event event : eventForSave) {
            eventService.save(event);
        }
    }

    protected List<Event> createNewEventsByOnBuildEventForSave(GameBoardView gameBoardView,
                                                               List<Event> eventByPhaseBeforeList, Game game) {
        List<Event> eventsForSaveList = new ArrayList<>();
        for (Event eventByPhaseBefore : eventByPhaseBeforeList) {
            UserInGame userInGame = eventByPhaseBefore.getUserInGame();
            gameBoardView.setCurrentUser(userInGame.getId());

            int goldChange = getGoldChange(gameBoardView, eventByPhaseBefore);
            if (goldChange != 0) {
                Event eventForSave = createNewEvent(game, userInGame, game.getPhaseGame()
                        , game.getPhaseRound(), game.getPhaseChooseDo());
                eventsForSaveList.add(eventForSave);
            }
        }
        return eventsForSaveList;
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
        return !mavzoleumWasBuild && round < 7;
    }

    protected String getCurrenctGamePhase(String phaseToSet, Game game) {
        String[] splitGamePhase = splitGamePhase(game);
        int gameAge = Integer.parseInt(splitGamePhase[splitGamePhase.length - 1]);
        return phaseToSet + "_" + gameAge;
    }

    protected String[] splitGamePhase(Game game) {
        return game.getPhaseGame().toString().split("_");

    }

    protected Event createNewEvent(Game game, UserInGame userInGame, GamePhase gamePhase, int ageRound, Integer
            round) {
        Event newEvent = new Event();
        newEvent.setGame(game);
        newEvent.setUserInGame(userInGame);
        newEvent.setGamePhase(gamePhase);
        newEvent.setPhaseRound(ageRound);
        newEvent.setPhaseChooseDo(round);
        return newEvent;
    }
}


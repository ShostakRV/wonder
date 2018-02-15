package com.wonder.wonder.jms;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.cards.GameCardColor;
import com.wonder.wonder.cards.ScientistGuild;
import com.wonder.wonder.cards.calc.point.CalcPointStrategy;
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

import java.util.*;

@Component
public class JmsEventLisner {

    @Autowired
    private EventService eventService;
    @Autowired
    private GameService gameService;
    @Autowired
    private UserInGameService userInGameService;

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
        long userInGameId = message.getUserInGameId();
        final GameBoardView gameBoardView = getGameBoardView(userInGameId);
        boolean isPlayOnBuildEvent = false;
        boolean gardenHasPassive = gameBoardView.isGarbenPassiveBuilt();
        boolean cardWasResurected;
        boolean mausoleumWasBuild;
        int playersPlayInGame = game.getUserInGames().size();
        UserActionOnCard userActionOnCard = allLastEvent.get(0).getUserActionOnCard();
        mausoleumWasBuild = gameBoardView.isMavzoleumPowerWasBuilt();
        cardWasResurected = userActionOnCard.equals(UserActionOnCard.RESURRECT_CARD);
        if (mausoleumWasBuild) {
            game.setPhaseChooseDo(game.getPhaseChooseDo() + 1);
            gameService.save(game);
        }
        if (cardWasResurected || allLastEvent.size() == playersPlayInGame && !mausoleumWasBuild || phaseRound.equals(8)) {
            isPlayOnBuildEvent = true;
        }
        boolean checkPossibilityToPlayWar = false;
        if (isPlayOnBuildEvent) {
            List<Event> onBuildEvents = eventService.getAllRaundLastEvent(gameId, gamePhase, phaseRound, phaseChooseDo);
            playOnBuildEvent(gameBoardView, onBuildEvents, phaseChooseDo + 1);
            checkPossibilityToPlayWar = true;
            saveOnBuildEvents(gameBoardView, game);
            gameService.save(game);
        }
        boolean isPlayWar = false;
        if (checkPossibilityToPlayWar) {
            isPlayWar = !gardenHasPassive && phaseRound == 7 || gardenHasPassive && phaseRound == 8;
        }
        boolean changePhase = false;
        if (isPlayWar) {
            playWar(game);
            //TODO THINK ZERO POINTS
            GameBoardView calculatedWarEventBoard = calculateWar(game, userInGameId);
            saveWarEvents(calculatedWarEventBoard, game);
            changePhase = true;
        }
        if (changePhase) {
            int currentAge = Integer.parseInt(splitGamePhase(game)[1]);
            if (currentAge != 3) {
                startNewRound(game, currentAge);
            } else {
                startEndGame(game);
            }
        }
        // TODO THINK NEED OR NOT GamePhase.CALCULATE ^^^???? // CHOOSE PURPLE
        if (game.getPhaseGame().equals(GamePhase.FINISHED)) {
            List<UserInGame> userInGamesCauculatePoints = calculatePointsAndFinishGame(game, userInGameId);
            saveOnBuildEvents(userInGamesCauculatePoints);
        }
    }

    protected void startEndGame(Game game) {
        game.setPhaseGame(GamePhase.FINISHED);
        game.setPhaseChooseDo(0);
        game.setPhaseRound(0);
    }

    protected void saveWarEvents(GameBoardView gameBoardView, Game game) {
        List<UserInGame> userInGameList = game.getUserInGames();
        for (UserInGame u : userInGameList) {
            gameBoardView.setCurrentUser(u.getId());
            GameUserInfo currentUserInfo = gameBoardView.getCurrentUserGameInfo();
            eventService.save(currentUserInfo.getEventToSave());
        }
    }

    protected void saveOnBuildEvents(List<UserInGame> userInGamesCauculatePoints) {
        for (UserInGame u : userInGamesCauculatePoints) {
            userInGameService.save(u);
        }
    }

    protected void saveOnBuildEvents(GameBoardView gameBoardView, Game game) {
        List<UserInGame> userInGameList = game.getUserInGames();
        for (UserInGame u : userInGameList) {
            gameBoardView.setCurrentUser(u.getId());
            GameUserInfo currentUserInfo = gameBoardView.getCurrentUserGameInfo();
            if (currentUserInfo.getEventToSave().getGoldChange() != 0) {
                eventService.save(currentUserInfo.getEventToSave());
            }
        }
    }
    //TODO THINK
    protected List<UserInGame> calculatePointsAndFinishGame(Game game, long userInGameId) {
        GameBoardView gameBoardView = getGameBoardView(userInGameId);
        List<UserInGame> userInGameList = new ArrayList<>(game.getUserInGames());
        for (UserInGame userInGame : userInGameList) {
            gameBoardView.setCurrentUser(userInGame.getId());
            GameUserInfo currentGameUserInfo = gameBoardView.getCurrentUserGameInfo();
            List<GameCard> currentGameUserInfoBuiltCard = currentGameUserInfo.getUserBuiltCards();
            int pRed = currentGameUserInfo.getCountWinWar() - currentGameUserInfo.getCountLoose();
            int pBlue = calculateBluePoints(currentGameUserInfoBuiltCard, gameBoardView);
            int pYellow = calculateYellowPoints(currentGameUserInfoBuiltCard, gameBoardView);
            int pPurple = calculatePurpurePoints(currentGameUserInfoBuiltCard, gameBoardView);
            int pWonder = calculateWonderPoints(currentGameUserInfoBuiltCard, gameBoardView);
            Map<ScientistGuild, Integer> allGreenSymvol = calculateGreenSymvol(currentGameUserInfoBuiltCard, gameBoardView);
            int pGreen = playCalculateGreenPoints(allGreenSymvol);
            userInGame.setPWars(pRed);
            userInGame.setPBlue(pBlue);
            userInGame.setPYellow(pYellow);
            userInGame.setPPurple(pPurple);
            userInGame.setPWonder(pWonder);
            userInGame.setPGreen(pGreen);
        }
        return userInGameList;
    }
    //TODO THINK
    protected int playCalculateGreenPoints(Map<ScientistGuild, Integer> allGreenSymvol) {
        int freeSymvol = allGreenSymvol.get(ScientistGuild.NAMEPLATE_OR_COMPASSE_OR_GEAR);
        boolean isHaveFreeSymvol = false;
        if (freeSymvol > 0) {
            isHaveFreeSymvol = true;
            allGreenSymvol.remove(ScientistGuild.NAMEPLATE_OR_COMPASSE_OR_GEAR);
        }
        List<Integer> greenSymvol = new ArrayList<>(allGreenSymvol.values());
        if (isHaveFreeSymvol) {
// TODO GREEN FREE
            return calculateGreenPoint(greenSymvol);
        } else {
            return calculateGreenPoint(greenSymvol);
        }
    }

    protected int calculateGreenPoint(List<Integer> greenSymvol) {
        boolean plusSevenForThreeSymvol = false;
        if (greenSymvol.size() == 3) {
            plusSevenForThreeSymvol = true;
        }
        int countPoints = 0;
        int minLevel = 0;
        for (Integer symvol : greenSymvol) {
            if (plusSevenForThreeSymvol) {
                if (minLevel == 0) {
                    minLevel = symvol;
                } else if (minLevel > symvol) {
                    minLevel = symvol;
                }
            }
            countPoints += symvol * symvol;
        }
        countPoints += minLevel * 7;
        return countPoints;
    }

    protected Map<ScientistGuild, Integer> calculateGreenSymvol(List<GameCard> currentGameUserInfoBuiltCard, GameBoardView gameBoardView) {
        Map<ScientistGuild, Integer> scientistMap = new HashMap<>();
        for (GameCard gameCard : currentGameUserInfoBuiltCard) {
            ScientistGuild signScientistGuild = gameCard.getSignScientistGuild();
            if (!signScientistGuild.equals(ScientistGuild.NONE)) {
                if (scientistMap.containsKey(signScientistGuild)) {
                    scientistMap.put(signScientistGuild, scientistMap.get(signScientistGuild) + 1);
                } else {
                    scientistMap.put(signScientistGuild, 1);
                }
            }
        }
        return scientistMap;
    }

    protected int calculateWonderPoints(List<GameCard> currentGameUserInfoBuiltCard, GameBoardView gameBoardView) {
        int allWonderPoints = 0;
        for (GameCard gameCard : currentGameUserInfoBuiltCard) {
            if (gameCard.getAge() == 0) {
                allWonderPoints += calculatePointsByStrategy(gameCard, gameBoardView);
            }
        }
        return allWonderPoints;
    }

    protected int calculateBluePoints(List<GameCard> currentGameUserInfoBuiltCard, GameBoardView gameBoardView) {
        int allBluePoints = 0;
        for (GameCard gameCard : currentGameUserInfoBuiltCard) {
            if (gameCard.getGameCardColor().equals(GameCardColor.BLUE)) {
                allBluePoints += calculatePointsByStrategy(gameCard, gameBoardView);
            }
        }
        return allBluePoints;
    }

    protected int calculateYellowPoints(List<GameCard> currentGameUserInfoBuiltCard, GameBoardView gameBoardView) {
        int allYellowPoints = 0;
        for (GameCard gameCard : currentGameUserInfoBuiltCard) {
            if (gameCard.getGameCardColor().equals(GameCardColor.YELLOW)) {
                allYellowPoints += calculatePointsByStrategy(gameCard, gameBoardView);
            }
        }
        return allYellowPoints;
    }

    protected int calculatePurpurePoints(List<GameCard> currentGameUserInfoBuiltCard, GameBoardView gameBoardView) {
        int allPurplePoints = 0;
        for (GameCard gameCard : currentGameUserInfoBuiltCard) {
            if (gameCard.getGameCardColor().equals(GameCardColor.PURPLE)) {
                allPurplePoints += calculatePointsByStrategy(gameCard, gameBoardView);
            }
        }
        return allPurplePoints;
    }

    protected int calculatePointsByStrategy(GameCard gameCard, GameBoardView gameBoardView) {
        CalcPointStrategy strategy = gameCard.getStrategy();
        return strategy.getPoints(gameBoardView);
    }


    protected void playWar(Game game) {
        game.setPhaseRound(0);
        game.setPhaseChooseDo(0);
        String[] gamePhaseNow = splitGamePhase(game);
        int ageNow = Integer.parseInt(gamePhaseNow[1]);
        game.setPhaseGame(GamePhase.valueOf("WAR" + "_" + ageNow));
    }

    protected void startNewRound(Game game, int ageNow) {
        ageNow += 1;
        game.setPhaseGame(GamePhase.valueOf("AGE_" + ageNow));
        game.setPhaseChooseDo(1);
        game.setPhaseRound(1);
    }


    protected GameBoardView calculateWar(Game game, long userInGameId) {
        GameBoardView gameBoardView = getGameBoardView(userInGameId);
        for (UserInGame userInGame : game.getUserInGames()) {
            gameBoardView.setCurrentUser(userInGame.getId());
            String[] phaseGame = splitGamePhase(game);
            String age = phaseGame[1];
            if (gameBoardView.isWinLeftPlayerInWar()) {
                gameBoardView.addItemToNewEvent(Items.valueOf("WAR_WIN_" + age));
            } else {
                gameBoardView.addItemToNewEvent(Items.valueOf("WAR_LOOSE_" + age));
            }
            if (gameBoardView.isWinRightPlayerInWar()) {
                gameBoardView.addItemToNewEvent(Items.valueOf("WAR_WIN_" + age));
            } else {
                gameBoardView.addItemToNewEvent(Items.valueOf("WAR_LOOSE_" + age));
            }
        }
        return gameBoardView;
    }

    protected void playOnBuildEvent(GameBoardView gameBoardView, List<Event> eventByPhaseBeforeList, int phaseRound) {
        for (Event eventByPhaseBefore : eventByPhaseBeforeList) {
            UserInGame userInGame = eventByPhaseBefore.getUserInGame();
            gameBoardView.setCurrentUser(userInGame.getId());
            if (gameBoardView.getCurrentUserGameInfo().getEventToSave().getGoldChange() == 0) {
                eventByPhaseBefore.getCard().getOnBuildEvent().doAction(gameBoardView);
                gameBoardView.getCurrentUserGameInfo().getEventToSave().setPhaseChooseDo(phaseRound);
            }
        }
    }

    protected String[] splitGamePhase(Game game) {
        return game.getPhaseGame().toString().split("_");

    }
}


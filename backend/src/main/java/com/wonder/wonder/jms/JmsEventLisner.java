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
        UserActionOnCard userActionOnCard = allLastEvent.get(0).getUserActionOnCard();
        boolean isPlayOnBuildEvent = false;
        boolean gardenHasPassive = gameBoardView.isGarbenPassiveBuilt();
        int playersPlayInGame = game.getUserInGames().size();
        if (gameBoardView.isMavzoleumPowerWasBuilt()) {
            game.setSubPhaseRound(game.getSubPhaseRound() + 1);
            gameService.save(game);
        }
        if (userActionOnCard.equals(UserActionOnCard.RESURRECT_CARD) //bug check
                || allLastEvent.size() == playersPlayInGame && !gameBoardView.isMavzoleumPowerWasBuilt()
                || phaseRound.equals(8)) {
            isPlayOnBuildEvent = true;
        }

        boolean playWar = false;
        boolean changeAge = false;
        if (isPlayOnBuildEvent) {
            List<Event> onBuildEvents = eventService.getAllRoundLastEvent(gameId, gamePhase, phaseRound, phaseChooseDo);
            playOnBuildEvent(gameBoardView, onBuildEvents, phaseChooseDo + 1);
            saveOnBuildEvents(gameBoardView, game);
            gameService.save(game);
            phaseRound = game.getPhaseRound();
            playWar = !gardenHasPassive && phaseRound == 7 || gardenHasPassive && phaseRound == 8;
        }
        if (playWar) {
            playWar(game);
            GameBoardView calculatedWarEventBoard = getGameBoardView(userInGameId);
            for (UserInGame userInGame : game.getUserInGames()) {
                int resultLeft = gameBoardView.isWinLeftPlayerInWar();
                int resultRight = gameBoardView.isWinRightPlayerInWar();
                calculateResultWar(game, gameBoardView, userInGame, resultLeft);
                calculateResultWar(game, gameBoardView, userInGame, resultRight);
            }
            saveWarEvents(calculatedWarEventBoard, game);
            changeAge = true;
        }
        // todo round and phase
        if (changeAge) {
            int currentAge = Integer.parseInt(splitGamePhase(game)[1]);
            if (currentAge != 3) {
                startNewAge(game, currentAge);
            } else {
                startEndGame(game);
            }
            gameService.save(game);
        }
        gamePhase = game.getPhaseGame();
        if (gamePhase.equals(GamePhase.CALCULATE)) {
            boolean oneOfUserHavePurpleCardChoose = gameBoardView.isPurpleWasBuild();
            boolean userShoosePurpleCardActrion = userActionOnCard.equals(UserActionOnCard.CHOOSE_PURPURE_ZEUS);
            if (!oneOfUserHavePurpleCardChoose || userShoosePurpleCardActrion) {
                List<UserInGame> userInGamesCauculatePoints = calculatePointsAndFinishGame(game, userInGameId);
                saveOnBuildEvents(userInGamesCauculatePoints);
                game.setPhaseGame(GamePhase.FINISHED);
                gameService.save(game);
            }
        }
    }

    protected void calculateResultWar(Game game, GameBoardView gameBoardView, UserInGame userInGame, int resultLeft) {
        gameBoardView.setCurrentUserId(userInGame.getId()); // TODO here I set user IN GAME BUT AT START HAVE USER ID
        String[] phaseGame = splitGamePhase(game);
        String age = phaseGame[1];
        if (resultLeft == 1) {
            gameBoardView.addItemToNewEvent(Items.valueOf("WAR_WIN_" + age));
        } else if (resultLeft == -1) {
            gameBoardView.addItemToNewEvent(Items.valueOf("WAR_LOOSE_" + age));
        } else {
            gameBoardView.addItemToNewEvent(Items.WAR_A_DRAW);
        }
    }

    protected void startEndGame(Game game) {
        game.setPhaseGame(GamePhase.CALCULATE);
        game.setSubPhaseRound(0);
        game.setPhaseRound(0);
    }

    protected void saveWarEvents(GameBoardView gameBoardView, Game game) {
        List<UserInGame> userInGameList = game.getUserInGames();
        for (UserInGame userInGame : userInGameList) {
            gameBoardView.setCurrentUserId(userInGame.getId()); // userINGAME
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
        for (UserInGame userInGame : userInGameList) {
            gameBoardView.setCurrentUserId(userInGame.getId()); // TODO here I set user IN GAME BUT AT START set USER ID   // userINGAME
            GameUserInfo currentUserInfo = gameBoardView.getCurrentUserGameInfo();
            if (currentUserInfo.getEventToSave().getGoldChange() != 0) {
                eventService.save(currentUserInfo.getEventToSave());
            }
        }
    }

       protected List<UserInGame> calculatePointsAndFinishGame(Game game, long userInGameId) {
        GameBoardView gameBoardView = getGameBoardView(userInGameId);
        List<UserInGame> userInGameList = new ArrayList<>(game.getUserInGames());
        for (UserInGame userInGame : userInGameList) {
            gameBoardView.setCurrentUserId(userInGame.getId()); // TODO here I set user IN GAME BUT AT START set USER ID   // userINGAME
            GameUserInfo currentGameUserInfo = gameBoardView.getCurrentUserGameInfo();
            List<GameCard> currentGameUserInfoBuiltCard = currentGameUserInfo.getUserBuiltCards();

            Map<ScientistGuild, Integer> allGreenSymvol = calculateGreenSymvol(currentGameUserInfoBuiltCard);

            userInGame.setPWars(calculateRedPoints(currentGameUserInfo));
            userInGame.setPBlue(calculatePointsByStrategy(currentGameUserInfoBuiltCard, gameBoardView, GameCardColor.BLUE));
            userInGame.setPYellow(calculatePointsByStrategy(currentGameUserInfoBuiltCard, gameBoardView, GameCardColor.YELLOW));
            userInGame.setPPurple(calculatePointsByStrategy(currentGameUserInfoBuiltCard, gameBoardView, GameCardColor.PURPLE));
            userInGame.setPWonder(calculateWonderPoints(currentGameUserInfoBuiltCard, gameBoardView));
            userInGame.setPGreen(playCalculateGreenPoints(allGreenSymvol));
        }
        return userInGameList;
    }

    private int calculateRedPoints(GameUserInfo currentGameUserInfo) {
        return currentGameUserInfo.getCountWinWar() - currentGameUserInfo.getCountLoose();
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
            int maxPoint = 0;
            for (int i = 0; i < allGreenSymvol.size(); i++) {
                Integer countSymvol = greenSymvol.get(i);
                Integer main = countSymvol + freeSymvol;
                greenSymvol.set(i, main);
                int pointsMain = calculateGreenPoint(greenSymvol);

                if (maxPoint < pointsMain) {
                    maxPoint = pointsMain;
                }
                if (freeSymvol > 1 && i < 2) {
                    greenSymvol = new ArrayList<>(allGreenSymvol.values());
                    Integer first = greenSymvol.get(i) + freeSymvol - 1;
                    greenSymvol.set(i, first);
                    Integer second = greenSymvol.get(i + 1) + freeSymvol - 1;
                    greenSymvol.set(i + 1, second);
                    int pointsFirstSecond = calculateGreenPoint(greenSymvol);
                    if (maxPoint < pointsFirstSecond) {
                        maxPoint = pointsFirstSecond;
                    }
                    if (i < 1) {
                        greenSymvol = new ArrayList<>(allGreenSymvol.values());
                        second = greenSymvol.get(i + 1) + freeSymvol - 1;
                        greenSymvol.set(i + 1, second);
                        Integer trierd = greenSymvol.get(i + 2) + freeSymvol - 1;
                        greenSymvol.set(i + 1, trierd);
                        int pointsSecondTrierd = calculateGreenPoint(greenSymvol);

                        if (maxPoint < pointsSecondTrierd) {
                            maxPoint = pointsSecondTrierd;
                        }
                    }
                }
            }
            return maxPoint;
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
        int minLevel = -1;
        for (Integer symvol : greenSymvol) {
                        minLevel = getMinLevel(plusSevenForThreeSymvol, minLevel, symvol);
            countPoints += symvol * symvol;
        }
        countPoints += minLevel * 7;
        return countPoints;
    }

    private int getMinLevel(boolean plusSevenForThreeSymvol, int minLevel, Integer symvol) {
        if (plusSevenForThreeSymvol) {
            if (minLevel == -1) {
                minLevel = symvol;
            } else if (minLevel > symvol) {
                minLevel = symvol;
            }
        }
        return minLevel;
    }

    protected Map<ScientistGuild, Integer> calculateGreenSymvol(List<GameCard> currentGameUserInfoBuiltCard) {
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
                CalcPointStrategy strategy = gameCard.getStrategy();
                allWonderPoints += strategy.getPoints(gameBoardView);
            }
        }
        return allWonderPoints;
    }


    protected int calculatePointsByStrategy(List<GameCard> currentUserBuiltCard, GameBoardView gameBoardView, GameCardColor gameCardColor) {
        int allPoints = 0;
        for (GameCard gameCard : currentUserBuiltCard) {
            if (gameCard.getGameCardColor().equals(gameCardColor)) {
                CalcPointStrategy strategy = gameCard.getStrategy();
                allPoints += strategy.getPoints(gameBoardView);
            }
        }
        return allPoints;
    }

    protected void playWar(Game game) {
        game.setPhaseRound(0);
        game.setSubPhaseRound(0);
        String[] gamePhaseNow = splitGamePhase(game);
        int ageNow = Integer.parseInt(gamePhaseNow[1]);
        game.setPhaseGame(GamePhase.valueOf("WAR" + "_" + ageNow));
    }

    protected void startNewAge(Game game, int ageNow) {
        ageNow += 1;
        game.setPhaseGame(GamePhase.valueOf("AGE_" + ageNow));
        game.setSubPhaseRound(1);
        game.setPhaseRound(1);
    }

    protected void playOnBuildEvent(GameBoardView gameBoardView, List<Event> eventByPhaseBeforeList, int phaseRound) {
        Event eventToSave = gameBoardView.getCurrentUserGameInfo().getEventToSave();
        for (Event eventByPhaseBefore : eventByPhaseBeforeList) {
            UserInGame userInGame = eventByPhaseBefore.getUserInGame();
            gameBoardView.setCurrentUserId(userInGame.getId());
            if (eventToSave.getGoldChange() == 0) {
                eventByPhaseBefore.getCard().getOnBuildEvent().doAction(gameBoardView);
                eventToSave.setSubPhaseRound(phaseRound);
            }
        }
    }

    protected String[] splitGamePhase(Game game) {
        return game.getPhaseGame().toString().split("_");
    }
}


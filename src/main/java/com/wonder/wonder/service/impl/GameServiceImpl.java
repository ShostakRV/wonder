package com.wonder.wonder.service.impl;

import com.wonder.wonder.businessLogic.GamePhase;
import com.wonder.wonder.cards.CardWonder;
import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.cards.GameCardColor;
import com.wonder.wonder.dao.GameDao;
import com.wonder.wonder.dto.GameViewDto;
import com.wonder.wonder.model.*;
import com.wonder.wonder.service.*;
import com.wonder.wonder.util.AuthenticationWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Created by bm
 * DAte 27.06.17.
 */

/**
 * Manage only any game
 */
@Component
public class GameServiceImpl implements GameService {

    private final GameDao gameDao;

    private final UserService userService;

    private final UserInGameService userInGameService;

    private final CardSetService cardSetService;

    private final AuthenticationWrapper authenticationWrapper;

    private CardSetItemService cardSetItemService;

    @Autowired
    public GameServiceImpl(GameDao gameDao, UserService userService, UserInGameService userInGameService, CardSetService cardSetService, AuthenticationWrapper authenticationWrapper, CardSetItemService cardSetItemService) {
        this.gameDao = gameDao;
        this.userService = userService;
        this.userInGameService = userInGameService;
        this.cardSetService = cardSetService;
        this.authenticationWrapper = authenticationWrapper;
        this.cardSetItemService = cardSetItemService;
    }


    @Override
    public void countPoint(Game game) {

    }

    @Override
    public long createGame() {
        Game game = new Game();
        game.setPhase(GamePhase.JOIN_PHASE);
        gameDao.save(game);
        joinToGame(game.getId());
        return game.getId();
    }

    @Override
    public List<GameViewDto> showGameInJoinPhaseInLobby() {
        List<GameViewDto> gameViewDtoList = new ArrayList<>();
        List<Game> gameList = gameDao.findAllByPhase(GamePhase.JOIN_PHASE);
        for (Game game : gameList) {
            GameViewDto gameViewDto = new GameViewDto();
            gameViewDto.setPlayersInGameCount(game.getUserInGames().size());
            gameViewDto.setGameId(game.getId());
            gameViewDto.setGameName(game.getName());
            gameViewDtoList.add(gameViewDto);
        }
        return gameViewDtoList;
    }


    @Override
    public boolean joinToGame(Long gameId) {
        User user = authenticationWrapper.getCurrentUser();
        Game game = gameDao.findById(gameId);

        if (game == null) {
            throw new RuntimeException("No exist Game with this id!!!");
        }

        if (userInGameService.getAllUserInGameByGameId(gameId).size() >= 14) {
            throw new RuntimeException("Game was full!!!");
        }

        if (userService.getUserById(user.getId()) == null) {
            throw new RuntimeException("No exist User with this id!!!");
        }
        if (userInGameService.getUserInGameByGameId(gameId) != null) {
            throw new RuntimeException("User try to join in Game again when user already in this game!!!");
        }
        UserInGame userInGame = new UserInGame();
        userInGame.setUser(user);
        userInGame.setGame(game);
        userInGameService.save(userInGame);
        return true;
    }

    // need change age like String to Integer
    @Override
    public void startGame(long gameId) {
        int age = 1;

        //hibernate
        List<UserInGame> userInGameList = userInGameService.getAllUserInGameByGameId(gameId);
        if (userInGameList.size() < 3) {
            throw new RuntimeException("Need more users for start!!!");
        }
        Game game = gameDao.findById(gameId);
        game.setUserInGames(userInGameList);

        List<CardWonder> cardWonderList = Arrays.asList(CardWonder.values());
        Collections.shuffle(cardWonderList);
        for (int i = 0; i < userInGameList.size(); i++) {
            CardWonder cardWonder = cardWonderList.get(i);
            game.getUserInGames().get(i).setWonder(cardWonder);
            game.getUserInGames().get(i).setPosition(i);
        }


        List<CardSet> cardSetList = new ArrayList<>();
        for (int i = 0; i < userInGameList.size(); i++) {
            CardSet cardSet = new CardSet();
            cardSet.setAge(age);
            cardSet.setSetNumber(i);
            cardSet.setGame(game);
            cardSetService.save(cardSet);
            cardSetList.add(cardSet);
        }
        List<GameCard> gameCardList = getAllCardByAgeAndNumberPlayers(age, userInGameList.size());
        Collections.shuffle(userInGameList);
        int setNumber = 0;
        for (int start = 0; start < gameCardList.size(); start += 7) {
            int end = Math.min(start + 7, gameCardList.size());
            List<GameCard> gameCards = gameCardList.subList(start, end);
            for (GameCard gameCard : gameCards) {
                CardSetItem cardSetItem = new CardSetItem();
                CardSet cardSet = cardSetList.get(setNumber);
                cardSetItem.setCardSet(cardSet);
                cardSetItem.setGameCard(gameCard);
                cardSetItemService.save(cardSetItem);
            }
            setNumber++;
        }

        game.setPhase(GamePhase.STROKE_AGE_1_1_START);
        game.setStart(new Date());
        gameDao.save(game);
// To do check if user has right to start game (get user from spring security context )
    }

    public List<GameCard> getAllCardByAgeAndNumberPlayers(int age, int numberPlayer) {
        List<GameCard> startCards = new ArrayList<>();
        Arrays.stream(GameCard.values())
                .filter(gameCard -> gameCard.getAge() == age)
                .forEach(gameCard ->
                        gameCard.getOnPlayers()
                                .stream()
                                .filter(forPayers -> forPayers <= numberPlayer)
                                .forEach(i -> startCards.add(gameCard))
                );
        List<GameCard> endResult = startCards;
        if (age == 3) {
            List<GameCard> purpurAll = startCards.stream().
                    filter(gameCard -> gameCard.getGameCardColor() == GameCardColor.PURPLE)
                    .collect(Collectors.toList());
            endResult = startCards.stream().filter(gameCard -> gameCard.getGameCardColor() != GameCardColor.PURPLE)
                    .collect(Collectors.toList());
            Collections.shuffle(purpurAll);
            List<GameCard> resultPurpure = new ArrayList<>();
            for (int i = 0; i < numberPlayer + 2; i++) {
                resultPurpure.add(purpurAll.get(i));
            }
            endResult.addAll(resultPurpure);
        }
        if (numberPlayer >= 3 & age == 2) {
            //silver
            endResult.add(GameCard.LOOM);
            endResult.add(GameCard.GLASSWORKS);
            endResult.add(GameCard.PRESS);
            if (numberPlayer >= 5) {
                //silver
                endResult.add(GameCard.LOOM);
                endResult.add(GameCard.GLASSWORKS);
                endResult.add(GameCard.PRESS);
            }
        }
        Collections.shuffle(endResult);
        return endResult;
    }

}

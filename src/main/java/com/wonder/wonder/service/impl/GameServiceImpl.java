package com.wonder.wonder.service.impl;

import com.wonder.wonder.cards.GameCardColor;
import com.wonder.wonder.cards.MainCard;
import com.wonder.wonder.cards.WonderCard;
import com.wonder.wonder.dao.GameDao;
import com.wonder.wonder.dto.GameViewDto;
import com.wonder.wonder.model.*;
import com.wonder.wonder.phase.GamePhase;
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
        game.setPhaseGame(GamePhase.JOIN_PHASE);
        gameDao.save(game);
        joinToGame(game.getId());
        return game.getId();
    }

    @Override
    public List<GameViewDto> showGameInJoinPhaseInLobby() {
        List<GameViewDto> gameViewDtoList = new ArrayList<>();
        List<Game> gameList = gameDao.findAllByPhaseGame(GamePhase.JOIN_PHASE);
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
    public boolean joinToGame(long gameId) {
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
        Game game = gameDao.findById(gameId);
        List<UserInGame> userInGameList = game.getUserInGames(); //
        if (userInGameList.size() < 3) {
            throw new RuntimeException("Need more users for start!!!");
        }

        List<WonderCard> wonderCardList = Arrays.asList(WonderCard.values());
        Collections.shuffle(wonderCardList);
        for (int i = 0; i < userInGameList.size(); i++) {
            WonderCard wonderCard = wonderCardList.get(i);
            game.getUserInGames().get(i).setWonder(wonderCard);
            game.getUserInGames().get(i).setPosition(i);
        }


        List<CardSet> cardSetList = new ArrayList<>();
        for (int i = 0; i < userInGameList.size(); i++) {
            CardSet cardSet = new CardSet();
            cardSet.setSetNumber(i);
            cardSet.setGame(game);
            cardSetService.save(cardSet);
            cardSetList.add(cardSet);
        }
        List<MainCard> mainCardList = getAllCardByAgeAndNumberPlayers(age, userInGameList.size());
        Collections.shuffle(userInGameList);
        int setNumber = 0;
        for (int start = 0; start < mainCardList.size(); start += 7) {
            int end = Math.min(start + 7, mainCardList.size());
            List<MainCard> mainCards = mainCardList.subList(start, end);
            for (MainCard mainCard : mainCards) {
                CardSetItem cardSetItem = new CardSetItem();
                CardSet cardSet = cardSetList.get(setNumber);
                cardSetItem.setCardSet(cardSet);
                cardSetItem.setMainCard(mainCard);
                cardSetItemService.save(cardSetItem);
            }
            setNumber++;
        }

//        game.setPhaseGame(GamePhase.STROKE_AGE_1_1_START); IN_Progress ??
        game.setPhaseGame(GamePhase.AGE_1);
        game.setPhaseRound(1);
        game.setPhaseChooseDo(1);
        game.setStart(new Date());
        gameDao.save(game);
// To do check if user has right to start game (get user from spring security context )
    }

    public List<MainCard> getAllCardByAgeAndNumberPlayers(int age, int numberPlayer) {
        final List<MainCard> startCards = new ArrayList<>();
        Arrays.stream(MainCard.values())
                .filter(gameCard -> gameCard.getAge() == age)
                .forEach(gameCard ->
                        gameCard.getOnPlayers()
                                .stream()
                                .filter(forPayers -> forPayers <= numberPlayer)
                                .forEach(i -> startCards.add(gameCard))
                );
        if (age == 3) {
            List<MainCard> purpurAll = startCards.stream().
                    filter(gameCard -> gameCard.getGameCardColor() == GameCardColor.PURPLE)
                    .collect(Collectors.toList());
            Collections.shuffle(purpurAll);
            for (int i = 0; i < purpurAll.size() - (numberPlayer + 2); i++) {
                startCards.remove(purpurAll.get(i));
            }
        }
        if (numberPlayer >= 3 & age == 2) {
            //silver
            startCards.add(MainCard.LOOM);
            startCards.add(MainCard.GLASSWORKS);
            startCards.add(MainCard.PRESS);
            if (numberPlayer >= 5) {
                //silver
                startCards.add(MainCard.LOOM);
                startCards.add(MainCard.GLASSWORKS);
                startCards.add(MainCard.PRESS);
            }
        }
        Collections.shuffle(startCards);
        return startCards;
    }

    //    void passCardToAnotherUserInGame(Game game);

}

package com.wonder.wonder.service.impl;

import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.cards.GameCardColor;
import com.wonder.wonder.cards.WonderCard;
import com.wonder.wonder.dao.GameDao;
import com.wonder.wonder.dto.GameViewDto;
import com.wonder.wonder.model.*;
import com.wonder.wonder.phase.GamePhase;
import com.wonder.wonder.service.*;
import com.wonder.wonder.util.AuthenticationWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    @Autowired
    private GameDao gameDao;
    @Autowired
    private EventService eventService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserInGameService userInGameService;
    @Autowired
    private CardSetService cardSetService;
    @Autowired
    private AuthenticationWrapper authenticationWrapper;
    @Autowired
    private CardSetItemService cardSetItemService;

    private final Logger LOG = LoggerFactory.getLogger(GameServiceImpl.class);


    @Override
    public void countPoint(Game game) {

    }

    @Override
    public void save(Game game) {
        gameDao.save(game);
    }

    @Override
    public void createGame(String gameName) {
        Game game = new Game();
        game.setPhaseGame(GamePhase.JOIN_PHASE);
        game.setName(gameName);
        LOG.info("Start save game");
        gameDao.save(game);
        LOG.info("Game was save ");
        joinToGame(game.getId());

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
        Game game = findGameById(gameId);

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
        // maybe need  add logic
    }

    // need change age like String to Integer

    @Override
    public void startGame(long gameId) {
        int age = 1;
        //hibernate
        Game game = findGameById(gameId);
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

        List<Event> startGoldSaveEvents = new ArrayList<>();
        for (UserInGame u : userInGameList) {
            Event saveStartGold = createNewEvent(game, u);
            startGoldSaveEvents.add(saveStartGold);
        }

        game.setPhaseGame(GamePhase.AGE_1);
        game.setPhaseRound(1);
        game.setPhaseChooseDo(1);
        game.setStart(new Date());
        gameDao.save(game);
        for (Event e : startGoldSaveEvents) {
            eventService.save(e);
        }

// To do check if user has right to start game (get user from spring security context )

    }

    @Override
    public Game findGameById(long gameId) {
        return gameDao.findById(gameId).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<UserInGame> getGameResult(Long gameId) {
        Game game = findGameById(gameId);
        return game.getUserInGames();
    }

    public List<GameCard> getAllCardByAgeAndNumberPlayers(int age, int numberPlayer) {
        final List<GameCard> startCards = new ArrayList<>();
        Arrays.stream(GameCard.values())
                .filter(gameCard -> gameCard.getAge() == age)
                .forEach(gameCard ->
                        gameCard.getOnPlayers()
                                .stream()
                                .filter(forPayers -> forPayers <= numberPlayer)
                                .forEach(i -> startCards.add(gameCard))
                );
        if (age == 3) {
            List<GameCard> purpurAll = startCards.stream().
                    filter(gameCard -> gameCard.getGameCardColor() == GameCardColor.PURPLE)
                    .collect(Collectors.toList());
            Collections.shuffle(purpurAll);
            for (int i = 0; i < purpurAll.size() - (numberPlayer + 2); i++) {
                startCards.remove(purpurAll.get(i));
            }
        }
        if (numberPlayer >= 3 & age == 2) {
            //silver
            startCards.add(GameCard.LOOM);
            startCards.add(GameCard.GLASSWORKS);
            startCards.add(GameCard.PRESS);
            if (numberPlayer >= 5) {
                //silver
                startCards.add(GameCard.LOOM);
                startCards.add(GameCard.GLASSWORKS);
                startCards.add(GameCard.PRESS);
            }
        }
        Collections.shuffle(startCards);
        return startCards;
    }

    protected Event createNewEvent(Game game, UserInGame userInGame) {
        Event newEvent = new Event();
        newEvent.setGame(game);
        newEvent.setUserInGame(userInGame);
        newEvent.setGamePhase(game.getPhaseGame());
        newEvent.setPhaseRound(game.getPhaseRound());
        newEvent.setPhaseChooseDo(game.getPhaseChooseDo());
        newEvent.setGoldChange(3);
        return newEvent;
    }
    //    void passCardToAnotherUserInGame(Game game);

}

package com.wonder.wonder.service;

import com.wonder.wonder.phase.GamePhase;
import com.wonder.wonder.cards.CardWonder;
import com.wonder.wonder.cards.GameCard;
import com.wonder.wonder.dao.GameDao;
import com.wonder.wonder.dto.GameViewDto;
import com.wonder.wonder.model.*;
import com.wonder.wonder.service.impl.GameServiceImpl;
import com.wonder.wonder.util.AuthenticationWrapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.internal.verification.Times;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

/**
 * Created by bm on 27.06.17.
 */
//
//стаешь на локальный мастер... git checkout master
//        git merge origin/<название свого бранча> --squash --no-commit
@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {

    private static final long GAME_ID = 1L;
    private static final long USER_ID = 1L;
    private static final Long USER_ID_SECOND = 2L;
    private static final String USER_NAME = "Super";
    private static final String USER_PASSWORD = "Super";
    private static final String USER_EMAIL = "AdminWonder@gmail.com";

    @Mock
    private GameDao gameDao;

    @InjectMocks
    @Spy
    private GameServiceImpl gameServiceImpl;

    @Mock
    private UserInGameService userInGameService;

    @Mock
    private UserService userService;

    @Mock
    private AuthenticationWrapper authenticationWrapper;

    @Mock
    private CardSetService cardSetService;

    @Mock
    private CardSetItemService cardSetItemService;

    @Before
    public void setUp() throws Exception {
        System.out.println();
    }


    @Test
    public void createGameSuccessfulTest() {
        doReturn(true).when(gameServiceImpl).joinToGame(anyLong());
        gameServiceImpl.createGame();
        ArgumentCaptor<Game> argumentCaptor = ArgumentCaptor.forClass(Game.class);
        verify(gameDao, new Times(1)).save(argumentCaptor.capture());
        verify(gameServiceImpl, new Times(1)).joinToGame(anyLong());
        Game game = argumentCaptor.getValue();
        assertEquals(GamePhase.JOIN_PHASE, game.getPhase());
    }


    @Test(expected = RuntimeException.class)
    public void createGameValidIdTest() {
        when(authenticationWrapper.getCurrentUser()).thenReturn(currentUserInit());
        try {
            gameServiceImpl.createGame();
        } catch (RuntimeException e) {
            assertEquals("No exist Game with this id!!!", e.getMessage());
            throw e;
        }
    }


    public User currentUserInit() {
        User user = new User();
        user.setId(0L);
        user.setUserName("Super");
        user.setEmail("AdminWonder@gmail.com");
        user.setPassword("Super");
        return user;
    }


    @Test
    public void joinToGameSuccessfulTest() {
        when(authenticationWrapper.getCurrentUser()).thenReturn(currentUserInit());
        User user = authenticationWrapper.getCurrentUser();
        when(userInGameService.getAllUserInGameByGameId(GAME_ID)).thenReturn(listUserInGameInit(1, GAME_ID));
        when(gameDao.findById(GAME_ID)).thenReturn(gameInit(GAME_ID, 1, GamePhase.JOIN_PHASE));
        when(userService.getUserById(user.getId())).thenReturn(currentUserInit());
        boolean result = gameServiceImpl.joinToGame(GAME_ID);

        ArgumentCaptor<UserInGame> userInGameArgumentCaptor = ArgumentCaptor.forClass(UserInGame.class);
        verify(userInGameService, new Times(1)).save(userInGameArgumentCaptor.capture());
        UserInGame userInGame = userInGameArgumentCaptor.getValue();
        assertEquals(userInGame.getUser().getId(), user.getId());

        assertEquals(userInGame.getGame().getId(), GAME_ID);
        assertEquals(userInGame.getGame().getPhase(), GamePhase.JOIN_PHASE);

        assertEquals(true, result);
    }


    @Test(expected = RuntimeException.class)
    public void joinInGameFullGameTest() {
        when(gameDao.findById(GAME_ID)).thenReturn(gameInit(GAME_ID, 14, GamePhase.JOIN_PHASE));
        when(userInGameService.getAllUserInGameByGameId(GAME_ID).size()).thenReturn((14));

        try {
            gameServiceImpl.joinToGame(GAME_ID);
        } catch (RuntimeException e) {
            assertEquals("Game was full!!!", e.getMessage());
            throw e;
        }
    }

    @Test(expected = RuntimeException.class)
    public void joinInNoExistGameTest() {
        when(gameDao.findById(GAME_ID)).thenReturn(null);
        try {
            gameServiceImpl.joinToGame(GAME_ID);
        } catch (RuntimeException e) {
            assertEquals("No exist Game with this id!!!", e.getMessage());
            throw e;
        }
    }

    @Test(expected = RuntimeException.class)
    public void userInGameTryToJoinGameAgainTest() {
        when(userInGameService.getUserInGameByGameId(GAME_ID)).thenReturn(new UserInGame());
        doReturn(true).when(gameDao).findById(anyLong());
        try {
            gameServiceImpl.joinToGame(GAME_ID);
        } catch (RuntimeException e) {
            assertEquals("User try to join in Game again when user already in this game!!!", e.getMessage());
            throw e;
        }
    }


    // called user in game
    public List<UserInGame> listUserInGameInit(Integer usersInGame, Long gameId) {
        Game game = new Game();
        game.setId(gameId);
        List<UserInGame> userInGames = new ArrayList<>();
        if (usersInGame >= 1) {
            userInGames.add(userInGameInit(1L, 1L, game));
            if (usersInGame >= 2) {
                userInGames.add(userInGameInit(2L, 2L, game));
                if (usersInGame >= 3) {
                    userInGames.add(userInGameInit(3L, 3L, game));
                    if (usersInGame >= 4) {
                        userInGames.add(userInGameInit(4L, 4L, game));
                        if (usersInGame >= 5) {
                            userInGames.add(userInGameInit(5L, 5L, game));
                        }
                    }
                }
            }
        }
        return userInGames;
    }

    // here need game no usr id
    public UserInGame userInGameInit(long userId, Long userInGameId, Game game) {
        User user = new User();
        user.setId(userId);
        UserInGame userInGame = new UserInGame();
        userInGame.setUser(user);
        userInGame.setId(userInGameId);
        userInGame.setGame(game);
        return userInGame;
    }

    public Game gameInit(Long gameId, Integer playersInGame, GamePhase gamePhase) {
        Game game = new Game();
        game.setName(gameId.hashCode() + "");
        game.setId(gameId);
        game.setPhase(gamePhase);
        game.setUserInGames(listUserInGameInit(playersInGame, gameId));
        return game;
    }


    public List<Game> gameInitListPhaseJoin_Phase() {
        List<Game> gameList = new ArrayList<>();
        gameList.add(gameInit(1L, 1, GamePhase.JOIN_PHASE));
        gameList.add(gameInit(2L, 2, GamePhase.JOIN_PHASE));
        gameList.add(gameInit(3L, 3, GamePhase.JOIN_PHASE));
        gameList.add(gameInit(4L, 4, GamePhase.JOIN_PHASE));
        gameList.add(gameInit(5L, 5, GamePhase.JOIN_PHASE));
        return gameList;
    }

    // do dto this field which we need
    @Test
    public void getGameforShowInLobbyTest() {
        List<Game> gameList = gameInitListPhaseJoin_Phase();
        doReturn(gameList).when(gameDao).findAllByPhase(GamePhase.JOIN_PHASE);

        List<GameViewDto> gameViewDtoList = gameServiceImpl.showGameInJoinPhaseInLobby();
        for (int i = 0; i < gameList.size(); i++) {
            GameViewDto viewDto = gameViewDtoList.get(i);
            Game game = gameList.get(i);
            assertEquals(game.getId(), viewDto.getGameId());
            assertEquals(game.getName(), viewDto.getGameName());
            assertEquals(game.getUserInGames().size(), viewDto.getPlayersInGameCount());
        }


    }


    public List<GameViewDto> showLobbyDtoListInit() {
        List<Game> gameList = gameInitListPhaseJoin_Phase();
        List<UserInGame> userInGameList = listUserInGameInit(3, 103L);
        List<GameViewDto> gameViewDtoList = new ArrayList<>();
        gameViewDtoList.forEach(gameViewDto -> gameViewDto.setPlayersInGameCount(
                userInGameList.size()));
        return null;
    }


    @Test(expected = RuntimeException.class)
    public void userStartGameNoHaveFourUserTest() {
        Game gameMock = gameInit(GAME_ID, 2, GamePhase.JOIN_PHASE);
        when(gameDao.findById(GAME_ID)).thenReturn(gameMock);
        try {
            gameServiceImpl.startGame(GAME_ID);
        } catch (RuntimeException e) {
            assertEquals("Need more users for start!!!", e.getMessage());
            throw e;
        }
    }

    @Test
    public void userStartGameFullGameSuccsessfulMetodStartGameTest() {
        Game gameMock = gameInit(GAME_ID, 4, GamePhase.JOIN_PHASE);
        List<UserInGame> userInGameList = gameMock.getUserInGames();
        when(gameDao.findById(GAME_ID)).thenReturn(gameMock);

        gameServiceImpl.startGame(GAME_ID);
        ArgumentCaptor<Game> argumentCaptor = ArgumentCaptor.forClass(Game.class);
        verify(gameDao, new Times(1)).save(argumentCaptor.capture());
        Game game = argumentCaptor.getValue();
        assertEquals(GamePhase.STROKE_AGE_1_1_START, game.getPhase());
        assertEquals(userInGameList.size(), game.getUserInGames().size());


    }

    @Test
    public void correctSaveSetCardMetodStartGameTest() {
        Game game = gameInit(GAME_ID, 4, GamePhase.JOIN_PHASE);
        when(userInGameService.getAllUserInGameByGameId(GAME_ID)).thenReturn(listUserInGameInit(4, GAME_ID));
        when(gameDao.findById(GAME_ID)).thenReturn(gameInit(GAME_ID, 4, GamePhase.JOIN_PHASE));
        gameServiceImpl.startGame(GAME_ID);
        ArgumentCaptor<CardSet> argumentCaptor = ArgumentCaptor.forClass(CardSet.class);
        verify(cardSetService, new Times(4)).save(argumentCaptor.capture());
        List<CardSet> cardSetList = argumentCaptor.getAllValues();
        for (int i = 0; i < cardSetList.size(); i++) {
            CardSet cardSet = cardSetList.get(i);
            Game correctGame = cardSet.getGame();
            assertEquals(game.getId(), correctGame.getId());
            assertEquals(new Integer(1), cardSet.getAge());
            assertEquals(new Integer(i), cardSet.getSetNumber());
        }
    }

    @Test
    public void correctSaveSetCardItemMetodStartGameTest() {
        Game game = gameInit(GAME_ID, 4, GamePhase.JOIN_PHASE);
        when(userInGameService.getAllUserInGameByGameId(GAME_ID)).thenReturn(listUserInGameInit(4, GAME_ID));
        when(gameDao.findById(GAME_ID)).thenReturn(gameInit(GAME_ID, 4, GamePhase.JOIN_PHASE));

        gameServiceImpl.startGame(GAME_ID);
        ArgumentCaptor<CardSetItem> argumentCaptor = ArgumentCaptor.forClass(CardSetItem.class);
        verify(cardSetItemService, new Times(28)).save(argumentCaptor.capture());
        List<CardSetItem> cardSetItemList = argumentCaptor.getAllValues();
        assertEquals(28, cardSetItemList.size());
        for (int j = 0; j < cardSetItemList.size(); j++) {
            CardSetItem cardSetItem = cardSetItemList.get(j);

            assertEquals(j ,cardSetItem.getCardSet().getId());
            assertEquals(null, cardSetItem.getPlayerPhase());
            assertNotEquals(null, cardSetItem.getGameCard());
        }

    }

    // do use set like unique
    // check dublicate field UserInGame
    // check null field UserInGame set
    @Test
    public void allUserInGameHaveWonderAndpositionMetodStartGameTest() {
//        when(userInGameService.getAllUserInGameByGameId(GAME_ID)).thenReturn(listUserInGameInit(4, GAME_ID));
        when(gameDao.findById(GAME_ID)).thenReturn(gameInit(GAME_ID, 4, GamePhase.JOIN_PHASE));
        gameServiceImpl.startGame(GAME_ID);
        ArgumentCaptor<Game> argumentCaptor = ArgumentCaptor.forClass(Game.class);
        verify(gameDao, new Times(1)).save(argumentCaptor.capture());
        Game game = argumentCaptor.getValue();
        List<UserInGame> userInGameList = game.getUserInGames();
        Set<CardWonder> correctContWonder = new TreeSet<>();
        Set<Integer> correctCountPosition = new TreeSet<>();
        for (UserInGame userInGame : userInGameList) {
            assertNotEquals(null, userInGame.getWonder());
            assertNotEquals(null, userInGame.getPosition());
            correctContWonder.add(userInGame.getWonder());
            correctCountPosition.add(userInGame.getPosition());
        }
        assertEquals(userInGameList.size(), correctContWonder.size() );
        assertEquals(userInGameList.size(), correctCountPosition.size() );
    }

    @Test
    public void getAllCardByAgeAndNumberPlayersSuccessfulMetodStartGameTest() {
        for (int age = 1; age < 4; age++) {
            for (int playersInGame = 3; playersInGame < 8; playersInGame++) {
                List<GameCard> cards = gameServiceImpl.getAllCardByAgeAndNumberPlayers(age, playersInGame);
                assertEquals(playersInGame * 7, cards.size());
            }
        }


    }


}






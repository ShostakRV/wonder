package com.wonder.wonder.service;

import com.wonder.wonder.businessLogic.GamePhase;
import com.wonder.wonder.dao.GameDao;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.User;
import com.wonder.wonder.model.UserInGame;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
    private static final Long USER_ID = 0L;
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

    @Before
    public void setUp() throws Exception {
        System.out.println();
    }


    @Test
    public void createGameSuccsessful() {
        when(authenticationWrapper.getCurrentUser()).thenReturn(currentUserInit());
        when(userService.getUserById(USER_ID)).thenReturn(currentUserInit());

        doReturn(true).when(gameServiceImpl).joinToGame(anyLong());
        gameServiceImpl.createGame();
        ArgumentCaptor<Game> argumentCaptor = ArgumentCaptor.forClass(Game.class);
        verify(gameDao, new Times(1)).save(argumentCaptor.capture());
        verify(gameServiceImpl, new Times(1)).joinToGame(anyLong());
        Game game = argumentCaptor.getValue();
        assertEquals(GamePhase.JOIN_PHASE, game.getPhase());
    }


    @Test(expected = RuntimeException.class)
    public void createGameValidId() {
        when(authenticationWrapper.getCurrentUser()).thenReturn(currentUserInit());
        try {
            gameServiceImpl.createGame();
        } catch (RuntimeException e) {
            assertEquals("No exist User with this id!!!", e.getMessage());
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
    public void joinToGameSuccsessful() {
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
    public void joinInGameFullGame() {
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
    public void joinInNoExistGame() {
        when(gameDao.findById(GAME_ID)).thenReturn(null);
        try {
            gameServiceImpl.joinToGame(GAME_ID);
        } catch (RuntimeException e) {
            assertEquals("No exist Game with this id!!!", e.getMessage());
            throw e;
        }
    }

    // called user in game
    public List<UserInGame> listUserInGameInit(Integer usersInGame, Long gameId) {
        Game game = new Game();
        game.setId(gameId);
        List<UserInGame> userInGames = new ArrayList<>();
        if (usersInGame >= 1) {
            userInGames.add(userInGameInit(1L, game));
            if (usersInGame >= 2) {
                userInGames.add(userInGameInit(2L, game));
                if (usersInGame >= 3) {
                    userInGames.add(userInGameInit(3L, game));
                    if (usersInGame >= 4) {
                        userInGames.add(userInGameInit(4L, game));
                        if (usersInGame >= 5) {
                            userInGames.add(userInGameInit(5L, game));
                        }
                    }
                }
            }
        }
        return userInGames;
    }

    // here need game no usr id
    public UserInGame userInGameInit(Long userInGameId, Game game) {
        User user = new User();
        user.setId(userInGameId);
        UserInGame userInGame = new UserInGame();
        userInGame.setUser(user);

        userInGame.setGame(game);
        return userInGame;
    }

    public Game gameInit(Long gameId, Integer playersInGame, GamePhase gamePhase) {
        Game game = new Game();
        game.setId(gameId);
        game.setPhase(gamePhase);
        game.setUserInGames(listUserInGameInit(playersInGame, gameId));
        return game;
    }


    public List<Game> gameInitListPhaseKid() {
        List<Game> gameList = new ArrayList<>();
        gameList.add(gameInit(101L, 1, GamePhase.JOIN_PHASE));
        gameList.add(gameInit(102L, 2, GamePhase.JOIN_PHASE));
        gameList.add(gameInit(103L, 3, GamePhase.JOIN_PHASE));
        gameList.add(gameInit(104L, 4, GamePhase.JOIN_PHASE));
        gameList.add(gameInit(105L, 5, GamePhase.JOIN_PHASE));
        return gameList;
    }



    // do dto this field which we need
    @Test
    public void showLobby() {
        List<Game> gameList = gameInitListPhaseKid();
        doReturn(gameList).when(gameDao).findAllByPhase(GamePhase.JOIN_PHASE);
        List<UserInGame> userInGameList = listUserInGameInit(3, 103L);
        doReturn(userInGameList).when(userInGameService).getAllUserInGameByGameId(GAME_ID);
        List<Game> gameListResult = gameServiceImpl.showLobby();
        assertTrue(gameListResult == gameList);
//        assertEquals(userInGameList, gameServiceImpl.showLobby());
//        assertEquals(gameList, gameServiceImpl.showLobby());
    }


    @Test
    public void userStartGameFullGameSuccsessful() {
//        when(gameDao.findById(GAME_ID)).thenReturn(listUserInGameInit(4));
        gameServiceImpl.userStartGameFullGame(GAME_ID);
        ArgumentCaptor<Game> argumentCaptor = ArgumentCaptor.forClass(Game.class);
        verify(gameDao, new Times(1)).save(argumentCaptor.capture());
        Game game = argumentCaptor.getValue();

        assertEquals(GamePhase.STROKE_AGE_1_1_START,game.getPhase());

    }

    @Test(expected = RuntimeException.class)
    public void userStartGameNoHaveFourUser() {
        Game game = new Game();
//        when(gameDao.findById(GAME_ID)).thenReturn(listUserInGameInit(3));
        try {
            gameServiceImpl.userStartGameFullGame(GAME_ID);
        } catch (RuntimeException e) {
            assertEquals("Need more users for start!!!", e.getMessage());
            throw e;
        }


    }


}
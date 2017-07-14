package com.wonder.wonder.service;

import com.wonder.wonder.dao.GameDao;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.User;
import com.wonder.wonder.model.UserInGame;
import com.wonder.wonder.service.impl.GameServiceImpl;
import com.wonder.wonder.service.impl.UserInGameServiceImpl;
import com.wonder.wonder.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by bm on 27.06.17.
 */
//
//стаешь на локальный мастер... git checkout master
//        git merge origin/<название свого бранча> --squash --no-commit
@RunWith(MockitoJUnitRunner.class)
public class GameServiceTest {
    public static final Long USER_ID = 1L;
    public static final Integer PLAYERS = 4;
    public static final Long GAME_ID = 1L;
    public static final String GAME_PHASE_KIT = "KIT";
    public static final String GAME_PHASE_IN_PROGRESS = "IN_PROGRESS";


    @Mock
    GameDao gameDao;

    @InjectMocks
    GameServiceImpl gameServiceImpl;

    @Mock
    UserInGameService userInGameService;

    @Mock
    UserService userService;

    @Mock
    AuthenticationWrapper authenticationWrapper;

    @Before
    public void setUp() throws Exception {
        System.out.println();
    }

    // why we need gameId if id we take when save in bd ?
    @Test
    public void createGameSuccsessful() {
//        User user = new User();
//        user.setId(USER_ID);
//        doReturn(user).when(userDao).findById(USER_ID);
//
//        gameServiceImpl.createGame(USER_ID, PLAYERS);
//        ArgumentCaptor<Game> argumentCaptor = ArgumentCaptor.forClass(Game.class);
//        verify(gameDao, new Times(1)).save(argumentCaptor.capture());
//        Game game = argumentCaptor.getValue();
//
//
//        assertEquals(GAME_PHASE_KIT, game.getPhase());
//        ArgumentCaptor<UserInGame> userInGameArgumentCaptor = ArgumentCaptor.forClass(UserInGame.class);
//        verify(userInGameDao, new Times(1)).save(userInGameArgumentCaptor.capture());
//
//        UserInGame userInGame = userInGameArgumentCaptor.getValue();
//        user = userInGame.getUser();
//        assertEquals(USER_ID, user.getId());
    }// check user in game save


    @Test
    public void joinToGameSuccsessful() {
        when(authenticationWrapper.getAuthenticationInit()).thenReturn(currentUserInit());

        User user = authenticationWrapper.getAuthenticationInit();
        Game game = gameParametrInit(1);
        doReturn(game).when(gameDao).findById(GAME_ID);
        gameServiceImpl.joinToGame(GAME_ID);
        ArgumentCaptor<Game> gameArgumentCaptor = ArgumentCaptor.forClass(Game.class);
        verify(gameDao, new Times(1)).save(gameArgumentCaptor.capture());
        game = gameArgumentCaptor.getValue();

        assertEquals(game.getId(), GAME_ID);
        assertEquals(game.getPhase(), GAME_PHASE_KIT);

        ArgumentCaptor<UserInGame> userInGameArgumentCaptor = ArgumentCaptor.forClass(UserInGame.class);
        verify(userInGameService, new Times(1)).save(userInGameArgumentCaptor.capture());
        UserInGame userInGame = userInGameArgumentCaptor.getValue();

        assertEquals(userInGame.getUser(), user);


        assertEquals(true, gameServiceImpl.joinToGame(GAME_ID));
    }

    class AuthenticationWrapper {
        Authentication authentication;

        public User getAuthenticationInit() {
            return (User) SecurityContextHolder.getContext().getAuthentication();
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


    @Test(expected = RuntimeException.class)
    public void joinInGameFullGame() {

        when(gameDao.findById(GAME_ID)).thenReturn(gameParametrInit(4));

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
    public Game gameParametrInit(Integer usersInGame) {
        Game game = new Game();
        game.setId(GAME_ID);
        game.setPhase(GAME_PHASE_KIT);
        List<UserInGame> userInGames = new ArrayList<>();
        if (usersInGame >= 1) {
            userInGames.add(userInGameInit(1L));
            game.setUserInGames(userInGames);

            if (usersInGame >= 2) {
                userInGames.add(userInGameInit(2L));
                if (usersInGame >= 3) {
                    userInGames.add(userInGameInit(3L));
                    if (usersInGame >= 4) {
                        userInGames.add(userInGameInit(4L));
                    }
                }
            }
        }
        game.setUserInGames(userInGames);
        return game;
    }

    // here need game no usr id
    public UserInGame userInGameInit(Long userId) {
        User user = new User();
        user.setId(userId);
        UserInGame userInGame = new UserInGame();
        userInGame.setUser(user);
        return userInGame;
    }

    @Test
    public void showLobby() {
        List<Game> gameList = Arrays.asList(gameParametrInit(3), gameParametrInit(2),
                gameParametrInit(4), gameParametrInit(1));
        doReturn(gameList).when(gameDao).findAllByPhase(GAME_PHASE_KIT);
        assertEquals(gameList, gameServiceImpl.showLobby());
    }

    @Test
    public void userStartGameFullGameSuccsessful() {
        when(gameDao.findById(GAME_ID)).thenReturn(gameParametrInit(4));
        gameServiceImpl.userStartGameFullGame(GAME_ID);
        ArgumentCaptor<Game> argumentCaptor = ArgumentCaptor.forClass(Game.class);
        verify(gameDao, new Times(1)).save(argumentCaptor.capture());
        Game game = argumentCaptor.getValue();

        assertEquals(GAME_PHASE_IN_PROGRESS, game.getPhase());

    }

    @Test(expected = RuntimeException.class)
    public void userStartGameNoHaveFourUser() {
        when(gameDao.findById(GAME_ID)).thenReturn(gameParametrInit(3));
        try {
            gameServiceImpl.userStartGameFullGame(GAME_ID);
        } catch (RuntimeException e) {
            assertEquals("Need more users for start!!!", e.getMessage());
            throw e;
        }


    }


}
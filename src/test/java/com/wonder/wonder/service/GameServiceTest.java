package com.wonder.wonder.service;

import com.wonder.wonder.dao.GameDao;
import com.wonder.wonder.dao.UserDao;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.User;
import com.wonder.wonder.model.UserInGame;
import com.wonder.wonder.service.impl.GameServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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


    public static final Long USER_WHO_WANT_JOIN_ID = 22L;

    @Mock
    GameDao gameDao;

    @Mock
    UserDao userDao;

    @InjectMocks
    GameServiceImpl gameServiceImpl;


    @Before
    public void setUp() throws Exception {
        System.out.println();
    }


    // why we need gameId if id we take when save in bd ?
    @Test
    public void createGameSuccsessful() {
        User user = new User();
        user.setId(USER_ID);
        doReturn(user).when(userDao).findById(USER_ID);

        gameServiceImpl.createGame(USER_ID, PLAYERS);
        ArgumentCaptor<Game> argumentCaptor = ArgumentCaptor.forClass(Game.class);
        verify(gameDao, new Times(1)).save(argumentCaptor.capture());
        Game game = argumentCaptor.getValue();
        assertEquals(PLAYERS, game.getPlayers());

        assertEquals(GAME_PHASE_KIT, game.getPhase());

        UserInGame userInGame = game.getUserInGames().get(0);
        user = userInGame.getUser();
        assertEquals(USER_ID, user.getId());
    }


    @Test
    public void joinToGameSuccsessful() {
        Game game = gameParametrInit(1);
        doReturn(game).when(gameDao).findById(GAME_ID);
        gameServiceImpl.joinToGame(GAME_ID, USER_WHO_WANT_JOIN_ID);
        ArgumentCaptor<Game> argumentCaptor = ArgumentCaptor.forClass(Game.class);
        verify(gameDao, new Times(1)).save(argumentCaptor.capture());
        game = argumentCaptor.getValue();
        List<UserInGame> userInGames = game.getUserInGames().stream().filter(userInGame1 -> userInGame1.getUser().getId() == USER_WHO_WANT_JOIN_ID).collect(Collectors.toList());
        UserInGame userInGame = userInGames.get(0);
        User user = userInGame.getUser();
        assertEquals(USER_WHO_WANT_JOIN_ID, user.getId());
        assertEquals(true, gameServiceImpl.joinToGame(GAME_ID, USER_WHO_WANT_JOIN_ID));
    }


    @Test(expected = RuntimeException.class)
    public void joinInGameFullGame() {
        when(gameDao.findById(GAME_ID)).thenReturn(gameParametrInit(4));
        try {
            gameServiceImpl.joinToGame(GAME_ID, USER_WHO_WANT_JOIN_ID);
        } catch (RuntimeException e) {
            assertEquals("Game was full!!!", e.getMessage());
            throw e;
        }
    }


    public Game gameParametrInit(Integer players) {
        Game game = new Game();
        game.setId(GAME_ID);
        game.setPhase(GAME_PHASE_KIT);
        List<UserInGame> userInGames = new ArrayList<>();
        if (players == 1) {
            userInGames.add(userInGameInit(1L));
            game.setUserInGames(userInGames);
            game.setPlayers(1);
        } else if (players == 2) {
            userInGames.add(userInGameInit(2L));
            game.setPlayers(2);
        } else if (players == 3) {
            userInGames.add(userInGameInit(3L));
            game.setPlayers(3);
        } else if (players == 4) {
            userInGames.add(userInGameInit(4L));
            game.setPlayers(4);
        }
        return game;
    }

// sss
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
}
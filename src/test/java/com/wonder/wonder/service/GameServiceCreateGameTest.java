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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.method.P;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by bm on 27.06.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class GameServiceCreateGameTest {
    public static final Long PLAYER_ID = 13L;
    public static final Integer PLAYERS = 4;
    public static final String PLAYER_NAME = "DAN";
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
    public void createGameSuccsessful() throws Exception {


        gameServiceImpl.createGame(PLAYER_ID, PLAYERS);
        ArgumentCaptor<Game> argumentCaptor = ArgumentCaptor.forClass(Game.class);
        verify(gameDao, new Times(1)).save(argumentCaptor.capture());

        GameServiceCreateGameTest.GameDaoMockImpl gameDaoMock = new GameServiceCreateGameTest.GameDaoMockImpl();
        Game game = argumentCaptor.getValue();
        when(game.getPlayers()).thenReturn(4);


        UserInGame userInGame = new UserInGame();
        User user = new User();
        user.setId(PLAYER_ID);
        userInGame.setUser(user);

        when(game.getUserInGames()).thenReturn(Arrays.<UserInGame>asList(userInGame));


//        assertEquals();
        gameDaoMock.game.setPlayers(PLAYERS);


//
//        gameDaoMock.game.setUserInGames(Arrays.asList(user));
//        gameDaoMock.save()
        verify(gameDao, new Times(1)).save(argumentCaptor.capture());

//        when(userDao.findById(13)).thenReturn(new User());

//        gameDaoMock.game.setUserInGames();
//        gameDao.save()


//
//
//        GameServiceImpl gameService = new GameServiceImpl(gameDaoMock);
//        gameService.createGame();
//
//        Game game = gameDaoMock.game;
//        assertEquals(WONDER_GAME, game.get());
////
//        assertTrue(user.getEmail().contains("@"));
//        assertTrue(user.getEmail().contains("."));
//        assertEquals("name", user.getUserName());
////            assertEquals("pass",user.getPassword());
////        assertTrue(userService.saveTriger);
//
//        userService.register("name", "dd@ff.com", "pass");
//
//        user = userDaoMock.user;
//
//        assertEquals("dd@ff.com", user.getEmail());

    }


    class GameDaoMockImpl implements GameDao {
        Game game;

        @Override
        public Game save(Game game) {
            this.game = game;
            return game;
        }

        @Override
        public Game findById(long id) {
            return null;
        }

        @Override
        public List<Game> hibernateQuery() {
            return null;
        }

        @Override
        public Iterable<Game> findAll(Sort sort) {
            return null;
        }

        @Override
        public Page<Game> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Game> Iterable<S> save(Iterable<S> entities) {
            return null;
        }

        @Override
        public Game findOne(Long aLong) {
            return null;
        }

        @Override
        public boolean exists(Long aLong) {
            return false;
        }

        @Override
        public Iterable<Game> findAll() {
            return null;
        }

        @Override
        public Iterable<Game> findAll(Iterable<Long> longs) {
            return null;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void delete(Long aLong) {

        }

        @Override
        public void delete(Game entity) {

        }

        @Override
        public void delete(Iterable<? extends Game> entities) {

        }

        @Override
        public void deleteAll() {

        }
    }

}
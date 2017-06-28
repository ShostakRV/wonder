package com.wonder.wonder.service;

import com.wonder.wonder.dao.GameDao;
import com.wonder.wonder.dao.UserDao;
import com.wonder.wonder.model.Game;
import com.wonder.wonder.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by bm on 27.06.17.
 */
public class GameServiceCreateGameTest {
    public static final String WONDER_GAME = "Wonder_Game";

    @Mock
    GameDao gameDao;
    @InjectMocks
    GameService gameService;

    @Before
    public void setUp() throws Exception {
        System.out.println();
    }

    @Test
    public void createGame() throws Exception {

        GameServiceCreateGameTest.GameDaoMockImpl gameDaoMock = new GameServiceCreateGameTest.GameDaoMockImpl();
        GameServiceImpl gameService = new GameServiceImpl(gameDaoMock);
        gameService.createGame("Wonder_Game");

        Game game = gameDaoMock.game;
//        assertEquals(WONDER_GAME, game.get());
//
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
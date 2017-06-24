package com.wonder.wonder.service;

import com.wonder.wonder.dao.UserDao;
import com.wonder.wonder.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created: godex
 * DATE: 24.06.17.
 */

public class UserServiceLegacyTest {
    public static final String EMAIL_GMAIL_COM = "email@gmail.com";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void registerUserSuccessful() throws Exception {
        UserDaoMockImpl userDaoMock = new UserDaoMockImpl();
        UserServiceImpl userService = new UserServiceImpl(userDaoMock);
        userService.register("name", EMAIL_GMAIL_COM, "pass");

        User user = userDaoMock.user;
        assertEquals(EMAIL_GMAIL_COM, user.getEmail());

        assertTrue(user.getEmail().contains("@"));
        assertTrue(user.getEmail().contains("."));
        assertEquals("name", user.getUserName());
//            assertEquals("pass",user.getPassword());
//        assertTrue(userService.saveTriger);

        userService.register("name", "dd@ff.com", "pass");

        user = userDaoMock.user;

        assertEquals("dd@ff.com", user.getEmail());

    }

    @Test(expected = RuntimeException.class)
    public void registerUserWithWrongEmail() throws Exception {
        UserServiceImpl testUser = new UserServiceImpl(null);
        try {
            testUser.register("name", "v@a.s@SDa", "pass");
        } catch (RuntimeException e) {
            assertEquals("Wrong email!!!", e.getMessage());
            throw e;
        }
    }


    class UserDaoMockImpl implements UserDao {
        User user;

        @Override
        public User save(User user) {
            this.user = user;
            return user;
        }

        @Override
        public List<User> findByUserName(String name) {
            return null;
        }

        @Override
        public List<User> hibernateQuery() {
            return null;
        }

        @Override
        public Iterable<User> findAll(Sort sort) {
            return null;
        }

        @Override
        public Page<User> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends User> Iterable<S> save(Iterable<S> entities) {
            return null;
        }

        @Override
        public User findOne(Long aLong) {
            return null;
        }

        @Override
        public boolean exists(Long aLong) {
            return false;
        }

        @Override
        public Iterable<User> findAll() {
            return null;
        }

        @Override
        public Iterable<User> findAll(Iterable<Long> longs) {
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
        public void delete(User entity) {

        }

        @Override
        public void delete(Iterable<? extends User> entities) {

        }

        @Override
        public void deleteAll() {

        }
    }

}
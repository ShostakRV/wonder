package com.wonder.wonder.service;

import com.wonder.wonder.dao.UserDao;
import com.wonder.wonder.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

/**
 * Created: godex
 * DATE: 24.06.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    public static final String EMAIL_GMAIL_COM = "email@gmail.com";
    @Mock
    UserDao userDao;
    @InjectMocks
    UserServiceImpl userService;


    @Before
    public void setUp() throws Exception {
        System.out.println();
    }

    @Test
    public void registerUserSuccessful() throws Exception {

        userService.register("name", EMAIL_GMAIL_COM, "pass");
        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userDao, new Times(1)).save(argumentCaptor.capture());

        User user = argumentCaptor.getValue();
        assertEquals(EMAIL_GMAIL_COM, user.getEmail());

        assertTrue(user.getEmail().contains("@"));
        assertTrue(user.getEmail().contains("."));
        assertEquals("name", user.getUserName());
//            assertEquals("pass",user.getPassword());
//        assertTrue(testUser.saveTriger);

        userService.register("name", "dd@ff.com", "pass");
        argumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userDao, new Times(2)).save(argumentCaptor.capture());
        user = argumentCaptor.getValue();

        assertEquals("dd@ff.com", user.getEmail());

    }

    @Test(expected = RuntimeException.class)
    public void registerUserWithWrongEmail() throws Exception {

        try {
            userService.register("name", "v@a.s@SDa", "pass");
        } catch (RuntimeException e) {
            assertEquals("Wrong email!!!", e.getMessage());
            throw e;
        }
    }


}
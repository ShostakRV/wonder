package com.wonder.wonder.service;

import com.wonder.config.exeption.authorisation.EmailExistsException;
import com.wonder.config.exeption.authorisation.UserByIdNotFoundException;
import com.wonder.wonder.TestData.service.UserFactory;
import com.wonder.wonder.dao.UserDao;
import com.wonder.wonder.model.User;
import com.wonder.wonder.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created: godex
 * DATE: 24.06.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserDao userDao;
    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @InjectMocks
    private UserServiceImpl userService;


    @Test
    public void registerUserSuccessful() throws Exception {
        when(bCryptPasswordEncoder.encode(anyString())).thenReturn("$2a$04$dVGviXNvZ2qHEjGAxHIvSeSnsDw/pDTeBW9IOzYPpV8QubmpS/8fq");
        userService.register(UserFactory.currentUserInit());
        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userDao, new Times(1)).save(argumentCaptor.capture());

        User user = argumentCaptor.getValue();
        assertEquals(UserFactory.currentUserInit().getEmail(), user.getEmail());

        assertTrue(user.getEmail().contains("@"));
        assertTrue(user.getEmail().contains("."));
        assertEquals(UserFactory.currentUserInit().getUsername(), user.getUsername());

        userService.register(UserFactory.currentUserInit());
        argumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userDao, new Times(2)).save(argumentCaptor.capture());
        user = argumentCaptor.getValue();

        assertEquals(UserFactory.currentUserInit().getEmail(), user.getEmail());
    }


    @Test(expected = UserByIdNotFoundException.class)
    public void userByIdNotFound() throws Exception {
        when(userDao.findById(anyLong())).thenReturn(Optional.empty());
        userService.getUserById(6);

    }

    @Test(expected = EmailExistsException.class)
    public void registerUserEmailExist() throws Exception {
        when(userDao.findByEmail(anyString())).thenReturn(Optional.of(new User()));
        userService.register(UserFactory.currentUserInit());

    }


}
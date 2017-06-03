package com.wonder.wonder.service;

import com.wonder.wonder.dao.UserDao;
import com.wonder.wonder.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Creator: bm
 * Date: 03.06.17.
 */
@Component
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return StreamSupport.stream(userDao.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}

package com.wonder.wonder.service.impl;

import com.wonder.config.exeption.authorisation.EmailExistsException;
import com.wonder.config.exeption.authorisation.UserByIdNotFoundException;
import com.wonder.wonder.dao.UserDao;
import com.wonder.wonder.model.User;
import com.wonder.wonder.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Creator: bm
 * Date: 03.06.17.
 */
@Slf4j
@Component
public class UserServiceImpl implements UserService {//,UserDetailsService

    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return userDao.findAll(pageable);
    }

    @Override
    public User getUserById(long userId) {
        log.info("Start getUserById");
        return userDao.findById(userId).orElseThrow(() -> new UserByIdNotFoundException(userId));
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void register(User newUser) {
        userDao.findByEmail(newUser.getEmail())
                .ifPresent(u -> {
                    log.info("User already registered" +
                            " with this email: " + newUser.getEmail());
                    throw new EmailExistsException(newUser.getEmail());
                });
        newUser.isEnabled();
        newUser.isAccountNonExpired();
        newUser.isAccountNonLocked();
        newUser.isCredentialsNonExpired();
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        userDao.save(newUser);
    }
}



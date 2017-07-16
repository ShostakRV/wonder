package com.wonder.wonder.service.impl;

import com.wonder.wonder.dao.UserDao;
import com.wonder.wonder.model.User;
import com.wonder.wonder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Creator: bm
 * Date: 03.06.17.
 */
@Component
public class UserServiceImpl implements UserService {//,UserDetailsService
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

    @Override
    public User getUserById(long userId) {
        return userDao.findById(userId);
    }


    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void register(String name, String email, String pass) {
        if (isValidEmail(email)) {
            if (userDao.findByEmail(email) != null) {
                throw new RuntimeException("User with this email already exits!!!");
            }
            User user = new User();
            user.setUserName(name);
            user.setEmail(email);
            user.setPassword(Arrays.toString(DigestUtils.md5Digest(pass.getBytes())));
            userDao.save(user);
        } else {
            throw new RuntimeException("Wrong email!!!");
        }
    }

    protected boolean isValidEmail(String email) {
        String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
//    }
}

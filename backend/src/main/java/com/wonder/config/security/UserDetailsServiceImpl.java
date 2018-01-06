package com.wonder.config.security;

import com.wonder.wonder.dao.UserDao;
import com.wonder.wonder.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
/**
 * Created b.missurenko
 * Date **.12.17.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    private final Logger LOG = LoggerFactory.getLogger(UserDetailsService.class);

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOG.info("Start find by name in class UserDetailsServiceImpl");
        Optional<User> user = userDao.findByUserName(username);
        return user.orElseThrow(() ->  new UsernameNotFoundException(username));
    }
}

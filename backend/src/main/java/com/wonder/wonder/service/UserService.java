package com.wonder.wonder.service;

import com.wonder.wonder.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Creator: bm
 * Date: 03.06.17.
 */

public interface UserService {



    Page<User> getAllUsers(Pageable pageable);

    User getUserById(long userId);

    void save(User user);

    void register(User newUser);



}

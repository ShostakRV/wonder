package com.wonder.wonder.service;

import com.wonder.wonder.model.User;

import java.util.List;

/**
 * Creator: bm
 * Date: 03.06.17.
 */

public interface UserService {

    List<User> getAllUsers();

    void save(User user);


}

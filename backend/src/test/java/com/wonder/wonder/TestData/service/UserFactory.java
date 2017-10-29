package com.wonder.wonder.TestData.service;

import com.wonder.wonder.model.User;

/**
 * Created by bm on 10.08.17.
 */
public class UserFactory {

    public static User currentUserInit() {
        User user = new User();
        user.setId(0L);
        user.setUserName("Super");
        user.setEmail("AdminWonder@gmail.com");
        user.setPassword("Super");
        return user;
    }
}

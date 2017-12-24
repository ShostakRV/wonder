package com.wonder.config.exeption.authorisation;

/**
 * @author b.Missurenko
 * @version 0.1
 */
public class UserByNameNotFoundException extends RuntimeException {

    public UserByNameNotFoundException(String userName) {
        super(String.format("NOT found User with name %s", userName));
    }
}

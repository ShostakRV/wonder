package com.wonder.config.exeption.authorisation;

/**
 * Created b.missurenko
 * Date **.12.17.
 */
public class UserByNameNotFoundException extends RuntimeException {

    public UserByNameNotFoundException(String userName) {
        super(String.format("NOT found User with name %s", userName));
    }
}

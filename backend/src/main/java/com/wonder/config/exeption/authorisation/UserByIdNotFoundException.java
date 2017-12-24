package com.wonder.config.exeption.authorisation;

/**
 * @author b.Missurenko
 * @version 0.1
 */
public class UserByIdNotFoundException extends RuntimeException {

    public UserByIdNotFoundException(long userId) {
        super(String.format("NOT found User with id %s", userId));
    }
}

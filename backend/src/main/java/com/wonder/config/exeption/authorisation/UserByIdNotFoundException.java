package com.wonder.config.exeption.authorisation;

/**
 * Created b.missurenko
 * Date **.12.17.
 */
public class UserByIdNotFoundException extends RuntimeException {

    public UserByIdNotFoundException(long userId) {
        super(String.format("NOT found User with id %s", userId));
    }
}

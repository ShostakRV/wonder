package com.wonder.config.exeption.authorisation;
/**
 * Created b.missurenko
 * Date **.12.17.
 */
public class EmailExistsException extends RuntimeException {

    public EmailExistsException(String email) {
        super(String.format("User exists %s",email));
    }
}

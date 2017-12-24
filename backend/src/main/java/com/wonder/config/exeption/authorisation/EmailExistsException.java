package com.wonder.config.exeption.authorisation;
/**
 * @author b.Missurenko
 * @version 0.1
 */
public class EmailExistsException extends RuntimeException {

    public EmailExistsException(String email) {
        super(String.format("User exists %s",email));
    }
}

package com.wonder.wonder.util;

import com.wonder.wonder.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by bm on 13.07.17.
 */
@Component
public class AuthenticationWrapperImpl implements AuthenticationWrapper {
    @Override
    public User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication();
    }
}

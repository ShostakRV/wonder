package com.wonder.wonder.rest;

import com.wonder.wonder.model.User;
import com.wonder.wonder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Creator: bm
 * Date: 03.06.17.
 */
@RestController
public class UserRestController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public List<User> list() {
        return userService.getAllUsers();
    }


}

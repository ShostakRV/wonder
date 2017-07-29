package com.wonder.wonder.web;

import com.wonder.wonder.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Creator: Pavlenko Bohdan
 * Date: 25.07.2017
 * Project: wonder
 */
@Controller
public class RegisterController {
    @GetMapping("/register")
    public ModelAndView login() {
        return new ModelAndView("templates/user/register.html");
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@SessionAttribute("user") User user) {

        return new ModelAndView("templates/user/register.html");
    }
}

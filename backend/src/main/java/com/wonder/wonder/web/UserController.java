package com.wonder.wonder.web;

import com.sun.deploy.net.HttpResponse;
import com.wonder.wonder.model.User;
import com.wonder.wonder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

/**
 * Creator: bm
 * Date: 03.06.17.
 */
@Controller                   // controller

public class UserController {

    //    @RequestMapping("/login")
    public String login() {
        return "templates/login.html";
    }

    //        @RequestMapping(value = "/login", method = RequestMethod.GET)
    public User getUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    //    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String printWelcome(ModelMap model, Principal principal) {

        String name = principal.getName(); //get logged in username
        model.addAttribute("username", name);
        return "hello";
    }

    //    @GetMapping("/register")
    public String register() {
        return "templates/user/register.html";
    }

//    @PostMapping("/register")
    public ModelAndView registerUser(@SessionAttribute("user") User user) {
        return new ModelAndView("templates/user/register.html");
    }
}


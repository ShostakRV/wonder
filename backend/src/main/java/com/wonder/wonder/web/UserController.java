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
@RequestMapping("api/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

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

    @PostMapping("/registerNewUser")
    @ResponseBody
    public void registerNewUser(
            HttpServletResponse response,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ) throws IOException {
        try {
            userService.register(name, email, password);
            response.sendError(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST,e.getMessage());
        }
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@SessionAttribute("user") User user) {
        return new ModelAndView("templates/user/register.html");
    }
}


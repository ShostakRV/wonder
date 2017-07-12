package com.wonder.wonder.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Creator: bm
 * Date: 03.06.17.
 */
@Controller                   // controller
public class LoginController {

//    @RequestMapping("/login")
//    public ModelAndView login(){
//        return new ModelAndView("templates/login.html");
//    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String printUser(ModelMap model) {
//
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String name = auth.getName(); //get logged in username
//
//        model.addAttribute("username", name);
//        return "hello";
//
//    }
}


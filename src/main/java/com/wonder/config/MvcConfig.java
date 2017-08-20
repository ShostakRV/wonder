package com.wonder.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Creator: bm
 * Date: 03.06.17.
 */
@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/lobby").setViewName("lobby");
        registry.addViewController("/game").setViewName("game");
        registry.addViewController("/signin").setViewName("/user/signin");
        registry.addViewController("/register").setViewName("/user/register");
//        registry.addViewController("/hello").setViewName("hello");
//        registry.addViewController("/login").setViewName("login");
    }
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String getHomePage(){
        return "home";
    }

}

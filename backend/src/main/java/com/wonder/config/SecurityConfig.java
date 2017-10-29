package com.wonder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Creator: bm
 * Date: 03.06.17.
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("super")
                .password("super")
                .roles("PLAYER,USER");
    }

    /*@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }*/

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/", "/home","/registry").anonymous()
                .antMatchers("/message/hello", "/lobby", "/game").anonymous()
                .antMatchers("/css/**", "/js/**", "/font/**","/**/favicon.ico").permitAll()
                .anyRequest().authenticated()
                .and().anonymous().authorities("USER")
                .and();
//                .formLogin().permitAll()
//                .loginPage("/login")
//                .and()
//                .logout().permitAll();
    }

    @Controller
    static class FaviconController {
        @RequestMapping("favicon.ico")
        String favicon() {
            return "forward:/resources/static/favicon.ico";
        }
    }
}

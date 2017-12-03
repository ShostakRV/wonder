package com.wonder.wonder.rest;

import com.wonder.wonder.dto.UserDto;
import com.wonder.wonder.dto.conerter.UserConverter;
import com.wonder.wonder.model.User;
import com.wonder.wonder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Creator: bm
 * Date: 03.06.17.
 */
@RestController
@RequestMapping("api/user")
public class UserRestController {

    private UserService userService;
    private UserConverter userConverter;

    @Autowired
    public UserRestController(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @RequestMapping("/list")
    public List<UserDto> list() {
        List<UserDto> userDtos = userService.getAllUsers().stream().map(user -> userConverter.convertToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @PostMapping("/register")
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
}

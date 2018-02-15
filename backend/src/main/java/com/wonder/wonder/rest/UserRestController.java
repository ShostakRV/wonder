package com.wonder.wonder.rest;

import com.wonder.wonder.dto.UserDto;
import com.wonder.wonder.dto.conerter.UserConverter;
import com.wonder.wonder.model.User;
import com.wonder.wonder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Creator: bm
 * Date: 03.06.17.
 */
@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserConverter userConverter;

    @GetMapping(value = "/")
    public List<UserDto> list(
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
            @RequestParam(value = "pageSize", defaultValue = "30", required = false) Integer pageSize
    ) {
        Page<User> userPage = userService.getAllUsers(new PageRequest(page, pageSize));
        return userPage.getContent().stream()
                .map(userConverter::convertToDto)
                .collect(Collectors.toList());

    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void registerNewUser(@Valid @RequestBody UserDto userDto) {
        User newUser = userConverter.convertToEntity(userDto);
        userService.register(newUser);
    }


}

package com.orderexecution.authentication.controller;

import com.orderexecution.authentication.domainobjects.User;
import com.orderexecution.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;

/**
 * @author Perestoronin Daniil
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public User registerUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping(value = "/login")
    public String login(@RequestBody User user) throws ServletException {
        return userService.login(user);
    }
}

package com.orderexecution.authentication.controller;

import com.orderexecution.authentication.domainobjects.User;
import com.orderexecution.authentication.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.Date;

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
    public String login(@RequestBody User login) throws ServletException {
        String jwtToken = "";
        if (login.getEmail() == null || login.getPassword() == null) {
            throw new ServletException("Please fill in username and password");
        }
        String email = login.getEmail();
        String password = login.getPassword();
        User user = userService.findByEmail(email);
        if (user == null) {
            throw new ServletException("User email not found.");
        }
        String pwd = user.getPassword();
        if (!password.equals(pwd)) {
            throw new ServletException("Invalid login. Please check your name and password.");
        }
        jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
        return jwtToken;
    }
}

package com.orderexecution.authentication.service.impl;

import com.orderexecution.authentication.domainobjects.User;
import com.orderexecution.authentication.repository.UserRepository;
import com.orderexecution.authentication.service.TokenService;
import com.orderexecution.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;

/**
 * @author Perestoronin Daniil
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserRepository userRepository;


    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public String login(User user) throws ServletException {
        if (user.getEmail() == null || user.getPassword() == null) {
            throw new ServletException("Please fill in username and password");
        }
        String email = user.getEmail();
        String password = user.getPassword();
        User authUser = findByEmail(email);
        if (authUser == null) {
            throw new ServletException("User email not found.");
        }
        if (!password.equals(authUser.getPassword())) {
            throw new ServletException("Invalid login. Please check your name and password.");
        }
        return tokenService.generateToken(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

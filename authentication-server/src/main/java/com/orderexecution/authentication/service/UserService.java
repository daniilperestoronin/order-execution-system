package com.orderexecution.authentication.service;

import com.orderexecution.authentication.domainobjects.User;

import javax.servlet.ServletException;

/**
 * @author Perestoronin Daniil
 */
public interface UserService {

    User save(User user);

    String login(User user) throws ServletException;
    User findByEmail(String email);
}

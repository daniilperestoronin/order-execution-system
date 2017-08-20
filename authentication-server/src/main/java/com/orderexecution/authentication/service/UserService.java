package com.orderexecution.authentication.service;

import com.orderexecution.authentication.domainobjects.User;

/**
 * @author Perestoronin Daniil
 */
public interface UserService {

    User save(User user);

    User findByEmail(String email);
}

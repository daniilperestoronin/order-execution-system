package com.orderexecution.authentication.service;

import com.orderexecution.authentication.domainobjects.User;

/**
 * Created by perestoronin on 29.08.2017.
 */
public interface TokenService {
    boolean checkToken(String token);

    String generateToken(User user);
}

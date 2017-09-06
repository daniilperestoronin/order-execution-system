package com.orderexecution.authentication.repository;

import com.orderexecution.authentication.domainobjects.User;

/**
 * @author Perestoronin Daniil
 */
public interface TokenRepository {

    boolean checkToken(String token);

    void addToken(String token, User user);
}

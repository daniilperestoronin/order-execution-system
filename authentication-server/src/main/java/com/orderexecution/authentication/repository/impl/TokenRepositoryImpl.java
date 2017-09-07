package com.orderexecution.authentication.repository.impl;

import com.orderexecution.authentication.domainobjects.User;
import com.orderexecution.authentication.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/**
 * @author Perestoronin Daniil
 */
@Repository
public class TokenRepositoryImpl implements TokenRepository {

    private static final String KEY = "user";

    private RedisTemplate<String, User> redisTemplate;
    private HashOperations hashOps;

    @Autowired
    private TokenRepositoryImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        this.hashOps = redisTemplate.opsForHash();
    }


    @Override
    public User checkToken(String token) {
        return (User) hashOps.get(KEY, token);
    }

    @Override
    public void addToken(String token, User user) {
        hashOps.put(KEY, token, user);
    }
}

package com.orderexecution.authentication.service.impl;

import com.orderexecution.authentication.domainobjects.User;
import com.orderexecution.authentication.repository.TokenRepository;
import com.orderexecution.authentication.service.TokenService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by perestoronin on 29.08.2017.
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public boolean checkToken(String token) {
        return tokenRepository.checkToken(token) != null ? true : false;
    }

    @Override
    public String generateToken(User user) {
        String token = Jwts.builder().setSubject(user.getEmail()).claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
        tokenRepository.addToken(token, user);
        return token;
    }

}

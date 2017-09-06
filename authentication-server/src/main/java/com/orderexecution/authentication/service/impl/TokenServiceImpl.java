package com.orderexecution.authentication.service.impl;

import com.orderexecution.authentication.domainobjects.User;
import com.orderexecution.authentication.service.TokenService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by perestoronin on 29.08.2017.
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Override
    public boolean checkToken(String token) {
        return false;
    }

    @Override
    public String generateToken(User user) {
        return Jwts.builder().setSubject(user.getEmail()).claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
    }

}

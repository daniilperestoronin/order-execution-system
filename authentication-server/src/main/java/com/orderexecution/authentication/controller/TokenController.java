package com.orderexecution.authentication.controller;

import com.orderexecution.authentication.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by perestoronin on 29.08.2017.
 */
@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @PostMapping(value = "/check")
    public boolean checkToken(@RequestBody String token) {
        return tokenService.checkToken(token);
    }
}

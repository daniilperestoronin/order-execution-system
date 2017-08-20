package com.orderexecution.authentication.service.impl;

import com.orderexecution.authentication.domainobjects.User;
import com.orderexecution.authentication.repository.UserRepository;
import com.orderexecution.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Perestoronin Daniil
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

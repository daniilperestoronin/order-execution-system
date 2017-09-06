package com.orderexecution.authentication.repository;

import com.orderexecution.authentication.domainobjects.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Perestoronin Daniil
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User save(User user);
    User findByEmail(String email);
}

package com.ordersserver.repository.client;

import com.ordersserver.domainobjects.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Perestoronin Daniil
 */
public interface ClientRepository extends JpaRepository<Client,Long> {

    @Query("select case when (count(c) > 0)  then true else false end " +
            "from Client c where c.personalInformation.identifier = :identifier " +
            "and c.personalInformation.password = :password ")
    boolean isClientRegistered(@Param("identifier") String identifier,
                               @Param("password") String password);
}

package com.ordersserver.repository.client;

import com.ordersserver.domainobjects.client.Client;
import com.ordersserver.repository.GenericDao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Perestoronin Daniil
 */
public interface ClientRepository extends JpaRepository<Client,Long> {
//    boolean isClientRegistered(Client client);
}

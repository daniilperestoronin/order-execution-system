package com.ordersserver.repository.client;

import com.ordersserver.domainobjects.client.Client;
import com.ordersserver.repository.GenericDao;

/**
 * @author Perestoronin Daniil
 */
public interface ClientRepository extends GenericDao<Client,Long> {
    boolean isClientRegistered(Client client);
}

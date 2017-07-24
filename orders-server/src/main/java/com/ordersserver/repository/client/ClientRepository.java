package com.ordersserver.repository.client;

import com.ordersserver.domainobjects.client.Client;

/**
 * @author Perestoronin Daniil
 */
public interface ClientRepository{
    boolean isClientRegistered(Client client);
}

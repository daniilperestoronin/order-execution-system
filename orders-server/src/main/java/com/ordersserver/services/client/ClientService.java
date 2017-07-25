package com.ordersserver.services.client;

import com.ordersserver.domainobjects.client.Client;

/**
 * Created by perestoronin on 25.07.2017.
 */
public interface ClientService {

    void create(Client client);
    Client retrieve(Long id);
    void update(Client t);
    void delete(Long id);
    boolean isClientRegistered(Client client);

}

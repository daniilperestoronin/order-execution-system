package com.ordersserver.services.client.impl;

import com.ordersserver.domainobjects.client.Client;
import com.ordersserver.services.client.ClientService;
import org.springframework.stereotype.Service;

/**
 * Created by perestoronin on 25.07.2017.
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Override
    public void create(Client client) {

    }

    @Override
    public Client retrieve(Long id) {
        return null;
    }

    @Override
    public void update(Client t) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public boolean isClientRegistered(Client client) {
        return false;
    }
}

package com.ordersserver.services.client.impl;

import com.ordersserver.domainobjects.client.Client;
import com.ordersserver.repository.client.ClientRepository;
import com.ordersserver.services.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by perestoronin on 25.07.2017.
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public void create(Client client) {
        clientRepository.create(client);
    }

    @Override
    public Client retrieve(Long id) {
        return clientRepository.retrieve(id);
    }

    @Override
    public void update(Client client) {
        clientRepository.update(client);
    }

    @Override
    public void delete(Long id) {
        clientRepository.delete(id);
    }

    @Override
    public boolean isClientRegistered(Client client) {
        return clientRepository.isClientRegistered(client);
    }
}

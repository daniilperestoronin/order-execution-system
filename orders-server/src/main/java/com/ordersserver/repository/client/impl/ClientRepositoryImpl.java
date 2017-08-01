package com.ordersserver.repository.client.impl;

import com.ordersserver.domainobjects.client.Client;
import com.ordersserver.repository.AbstractGenericDao;
import com.ordersserver.repository.client.ClientRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by perestoronin on 25.07.2017.
 */
@Transactional
@Repository
public class ClientRepositoryImpl extends AbstractGenericDao<Client,Long> implements ClientRepository {

    @Override
    public boolean isClientRegistered(Client client) {
        return false;
    }
}

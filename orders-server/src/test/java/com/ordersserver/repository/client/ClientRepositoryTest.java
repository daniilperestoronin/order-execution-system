package com.ordersserver.repository.client;

import com.ordersserver.domainobjects.client.Client;
import com.ordersserver.domainobjects.client.ClientType;
import com.ordersserver.domainobjects.client.PersonalInformation;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by perestoronin on 07.08.2017.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;
    private static Client client;

    @BeforeClass
    public static void setData() {
        client = new Client()
                .setId(1L)
                .setClientType(ClientType.CUSTOMER)
                .setPersonalInformation(new PersonalInformation()
                        .setId(1L)
                        .setFirstName("testFirstName")
                        .setMiddleName("testMiddleName")
                        .setLastName("testLastName")
                        .setIdentifier("testIdentifier")
                        .setPassword("testPassword"));
    }

    @Test
    public void testSaveClient() {
        Client testClient = clientRepository.save(client);
        testClient
                .setId(client.getId());
        testClient
                .getPersonalInformation()
                .setId(client
                        .getPersonalInformation()
                        .getId());
        assertEquals(testClient, client);
    }

    @Test
    public void testFindClient() {
        clientRepository.save(client);
        assertEquals(clientRepository.getOne(client.getId()), client);
    }

    @Test
    public void testDeleteClient() {
        Client testClient = clientRepository.save(client);
        clientRepository.delete(testClient.getId());
    }

    @Test
    public void testisClientRegister() {
        clientRepository.save(client);
        assertTrue(clientRepository.isClientRegistered(client.getPersonalInformation().getIdentifier(),
                client.getPersonalInformation().getPassword()));
    }
}

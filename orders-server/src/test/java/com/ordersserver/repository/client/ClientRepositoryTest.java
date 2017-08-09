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
        assertEquals(clientRepository.save(client), client);
    }

    @Test
    public void testFindClient() {
        clientRepository.save(client);
        assertEquals(clientRepository.getOne(client.getId()), client);
    }

    @Test
    public void testDeleteClient() {
        clientRepository.save(client);
        clientRepository.delete(client.getId());
    }
}

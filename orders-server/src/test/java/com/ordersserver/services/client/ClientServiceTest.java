package com.ordersserver.services.client;

import com.ordersserver.domainobjects.client.Client;
import com.ordersserver.domainobjects.client.ClientType;
import com.ordersserver.domainobjects.client.PersonalInformation;
import com.ordersserver.repository.client.ClientRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

/**
 * Created by perestoronin on 03.08.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTest {

    @Autowired
    ClientService clientService;
    @MockBean
    private ClientRepository clientRepository;
    private Client client;

    @Before
    public void setData() {
        client = new Client()
                .setId(1l)
                .setClientType(ClientType.CUSTOMER)
                .setPersonalInformation(
                        new PersonalInformation()
                                .setId(1l)
                                .setFirstName("test")
                                .setMiddleName("test")
                                .setLastName("test")
                                .setIdentifier("test")
                                .setPassword("test"));
        when(clientRepository
                .findOne(anyLong())).thenReturn(client);
        when(clientRepository
                .save(client)).thenReturn(client);
        when(clientRepository
                .isClientRegistered(client.getPersonalInformation().getIdentifier(),
                        client.getPersonalInformation().getPassword()))
                .thenReturn(true);
        doNothing().when(clientRepository).delete(anyLong());
    }

    @Test
    public void testCreate() {
        clientService.create(client);
    }

    @Test
    public void testRetrieve() {
        clientService.retrieve(1l);
    }

    @Test
    public void testUpdate() {
        clientService.update(client);
    }

    @Test
    public void testDelete() {
        clientService.delete(1l);
    }

    @Test
    public void testIsClientRegistered() {
        clientService.isClientRegistered(client);
    }
}

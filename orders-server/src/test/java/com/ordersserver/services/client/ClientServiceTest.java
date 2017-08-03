package com.ordersserver.services.client;

import com.ordersserver.domainobjects.client.Client;
import com.ordersserver.repository.client.ClientRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Matchers.any;
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
    public void setData(){
        when(clientRepository.findOne(anyLong())).thenReturn(new Client());
        when(clientRepository.save(client)).thenReturn(client);
        doNothing().when(clientRepository).delete(anyLong());

        client = new Client();
    }

    @Test
    public void testCreate() {
        clientService.create(client);
    }

    @Test
    public void testRetrieve() {
        clientService.retrieve(1L);
    }

    @Test
    public void testUpdate() {
        clientService.update(client);
    }

    @Test
    public void testDelete() {
        clientService.delete(1L);
    }

    @Test
    public void testIsClientRegistered() {
        clientService.isClientRegistered(client);
    }

}

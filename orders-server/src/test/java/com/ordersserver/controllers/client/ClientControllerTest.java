package com.ordersserver.controllers.client;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ordersserver.domainobjects.client.Client;
import com.ordersserver.domainobjects.client.ClientType;
import com.ordersserver.domainobjects.client.PersonalInformation;
import com.ordersserver.services.client.ClientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

/**
 * Created by perestoronin on 02.08.2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ClientController.class)
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ClientService clientService;
    private Client client;
    private String clientJSON;
    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Before
    public void setData() throws JsonProcessingException {
        client = new Client()
                .setId(1L)
                .setClientType(ClientType.CUSTOMER)
                .setPersonalInformation(
                        new PersonalInformation()
                                .setId(1L)
                                .setFirstName("test")
                                .setMiddleName("test")
                                .setLastName("test")
                                .setIdentifier("test")
                                .setPassword("test"));
        clientJSON = new ObjectMapper().writeValueAsString(client);
        when(clientService.retrieve(client.getId())).thenReturn(client);
        doNothing().when(clientService).create(client);
        doNothing().when(clientService).update(client);
        doNothing().when(clientService).delete(client.getId());
    }

    @Test
    public void testGeetingClientById() throws Exception {
        this.mockMvc.perform(get("/client/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.clientType", is(client.getClientType().toString())));
    }

    @Test
    public void testCreatingClient() throws Exception {
        this.mockMvc.perform(post("/client/")
                .accept(MediaType.APPLICATION_JSON)
                .content(clientJSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testUpdatingClient() throws Exception {
        this.mockMvc.perform(put("/client/")
                .accept(MediaType.APPLICATION_JSON)
                .content(clientJSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testDeletingClient() throws Exception {
        this.mockMvc.perform(delete("/client/1"))
                .andDo(print()).andExpect(status().isOk());
    }
}

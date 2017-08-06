package com.ordersserver.controllers.client;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.ordersserver.domainobjects.client.Client;
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

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    @Before
    public void setData() {
        when(clientService.retrieve(anyLong())).thenReturn(new Client());
        doNothing().when(clientService).create(new Client());
        doNothing().when(clientService).update(new Client());
        doNothing().when(clientService).delete(anyLong());
    }

    @Test
    public void testGeetingClientById() throws Exception {
        this.mockMvc.perform(get("/client/1"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testCreatingClient() throws Exception {
        this.mockMvc.perform(post("/client/")
                .accept(MediaType.APPLICATION_JSON)
                .content("{}")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testUpdatingClient() throws Exception {
        this.mockMvc.perform(put("/client/")
                .accept(MediaType.APPLICATION_JSON)
                .content("{}")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testDeletingClient() throws Exception {
        this.mockMvc.perform(delete("/client/1"))
                .andDo(print()).andExpect(status().isOk());
    }
}

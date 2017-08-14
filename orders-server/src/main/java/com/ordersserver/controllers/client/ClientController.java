package com.ordersserver.controllers.client;

import com.ordersserver.domainobjects.client.Client;
import com.ordersserver.services.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by perestoronin on 25.07.2017.
 */

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/{id}")
    @ResponseBody
    public Client getClientById(@PathVariable Long id) {
        return clientService.retrieve(id);
    }

    @PostMapping("/")
    @ResponseBody
    public void createClient(@RequestBody Client client) {
        clientService.create(client);
    }

    @PutMapping("/")
    @ResponseBody
    public void updateClientById(@RequestBody Client client) {
        clientService.update(client);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteClient(@PathVariable Long id) {
        clientService.delete(id);
    }
}

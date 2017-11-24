package com.ordersserver.controllers.client;

import com.ordersserver.domainobjects.client.Client;
import com.ordersserver.services.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by perestoronin on 25.07.2017.
 */

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.retrieve(id);
    }

    @PostMapping("/")
    public void createClient(@RequestBody Client client) {
        clientService.create(client);
    }

    @PutMapping("/")
    public void updateClientById(@RequestBody Client client) {
        clientService.update(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.delete(id);
    }
}

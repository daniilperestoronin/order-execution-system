package com.ordersserver.domainobjects.order;

import com.ordersserver.domainobjects.client.Client;
import com.vividsolutions.jts.geom.Geometry;

/**
 * @author Perestoronin Daniil
 */
public class Order {

    private Long id;
    private Client customer;
    private Client executor;
    private Geometry coordinates;
    private String address;
    private String description;

    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public Client getCustomer() {
        return customer;
    }

    public Order setCustomer(Client customer) {
        this.customer = customer;
        return this;
    }

    public Client getExecutor() {
        return executor;
    }

    public Order setExecutor(Client executor) {
        this.executor = executor;
        return this;
    }

    public Geometry getCoordinates() {
        return coordinates;
    }

    public Order setCoordinates(Geometry coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Order setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Order setDescription(String description) {
        this.description = description;
        return this;
    }
}

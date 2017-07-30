package com.ordersserver.domainobjects.order;

import com.ordersserver.domainobjects.client.Client;
import com.vividsolutions.jts.geom.Geometry;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Perestoronin Daniil
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Client customer;
    @ManyToOne
    @JoinColumn(name = "id_executor")
    private Client executor;
    @Column(name = "coordinates")
    private Geometry coordinates;
    @Column(name = "address")
    private String address;
    @Column(name = "description")
    private String description;

    public Order() {
    }

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

package com.ordersserver.domainobjects.order;

import com.ordersserver.domainobjects.client.Client;
import com.vividsolutions.jts.geom.Point;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

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
    @Column(name = "address")
    private String address;
    @Column(name = "description")
    private String description;
    @Column(name = "coordinates")
    private Point coordinates;

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

    public Point getCoordinates() {
        return coordinates;
    }

    public Order setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(customer, order.customer) &&
                Objects.equals(executor, order.executor) &&
                Objects.equals(address, order.address) &&
                Objects.equals(description, order.description) &&
                Objects.equals(coordinates, order.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, executor, address, description, coordinates);
    }
}

package com.ordersserver.domainobjects.client;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Perestoronin Daniil
 */
@Entity
@Table(name = "clients")
public class Client implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "client_type")
    @Enumerated(EnumType.STRING)
    private ClientType clientType;
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PersonalInformation personalInformation;
    @Column(name = "coordinates")
    private Point coordinates;

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public Client setId(Long id) {
        this.id = id;
        return this;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public Client setClientType(ClientType clientType) {
        this.clientType = clientType;
        return this;
    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public Client setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
        return this;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public Client setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                clientType == client.clientType &&
                Objects.equals(personalInformation, client.personalInformation) &&
                Objects.equals(coordinates, client.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientType, personalInformation, coordinates);
    }
}

package com.ordersserver.domainobjects.client;

import com.vividsolutions.jts.geom.Geometry;

/**
 * @author Perestoronin Daniil
 */
public class Client {

    private Long id;
    private ClientType clientType;
    private PersonalInformation personalInformation;
    private Geometry coordinates;

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

    public Geometry getCoordinates() {
        return coordinates;
    }

    public Client setCoordinates(Geometry coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != null ? !id.equals(client.id) : client.id != null) return false;
        if (clientType != client.clientType) return false;
        if (personalInformation != null ? !personalInformation.equals(client.personalInformation) : client.personalInformation != null)
            return false;
        return coordinates != null ? coordinates.equals(client.coordinates) : client.coordinates == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (clientType != null ? clientType.hashCode() : 0);
        result = 31 * result + (personalInformation != null ? personalInformation.hashCode() : 0);
        result = 31 * result + (coordinates != null ? coordinates.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", clientType=" + clientType +
                ", personalInformation=" + personalInformation +
                ", coordinates=" + coordinates +
                '}';
    }
}

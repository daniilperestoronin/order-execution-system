package com.ordersserver.domainobjects.client;

import com.vividsolutions.jts.geom.Geometry;

import javax.persistence.*;
import java.io.Serializable;

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
    @OneToOne
    @JoinColumn(name = "id_personal_information")
    private PersonalInformation personalInformation;
//    @Column(columnDefinition = "coordinates")
//    private Geometry coordinates;

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



}

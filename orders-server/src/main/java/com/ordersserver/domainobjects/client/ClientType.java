package com.ordersserver.domainobjects.client;

import java.io.Serializable;

/**
 * @author Perestoronin Daniil
 */
public enum ClientType implements Serializable {
    CUSTOMER, EXECUTOR, NOTYPE;

    public static ClientType stringParser(String type) {
        switch (type) {
            case "CUSTOMER":
                return CUSTOMER;
            case "EXECUTOR":
                return EXECUTOR;
            default:
                return NOTYPE;
        }
    }
}

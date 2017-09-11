package com.orderexecution.authentication.domainobjects;

import java.io.Serializable;

/**
 * @author Perestoronin Daniil
 */
public enum UserType implements Serializable {
    CUSTOMER, EXECUTOR, ADMINISTRATOR, NOTYPE;

    public static UserType stringParser(String type) {
        switch (type) {
            case "CUSTOMER":
                return CUSTOMER;
            case "EXECUTOR":
                return EXECUTOR;
            case "ADMINISTRATOR":
                return ADMINISTRATOR;
            default:
                return NOTYPE;
        }
    }
}

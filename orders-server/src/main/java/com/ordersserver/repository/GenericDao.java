package com.ordersserver.repository;

import java.io.Serializable;

/**
 * @author Perestoronin Daniil
 */

public interface GenericDao<T, PK extends Serializable> {
    void create(T t);
    T retrieve(PK id);
    void update(T t);
    void delete(PK id);
}
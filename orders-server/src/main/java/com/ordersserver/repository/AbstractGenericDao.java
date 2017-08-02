package com.ordersserver.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * @author Perestoronin Daniil
 */

public class AbstractGenericDao<T, PK extends Serializable>
        implements GenericDao<T, PK> {


    private EntityManager entityManager;
    private Class<T> entityClass;

    public AbstractGenericDao(){
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass
                .getActualTypeArguments()[0];
    }

    public void create(T t){
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
    }

    public T retrieve(PK id){
        return entityManager.find(entityClass, id);
    }

    public void update(T t){
        entityManager.getTransaction().begin();
        entityManager.merge(t);
        entityManager.getTransaction().commit();
    }

    public void delete(PK id){
        entityManager.getTransaction().begin();
        entityManager.remove(retrieve(id));
        entityManager.getTransaction().commit();
    }
}


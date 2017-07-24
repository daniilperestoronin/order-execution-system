package com.ordersserver.repository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * @author Perestoronin Daniil
 */
public class AbstractGenericDao<T, PK extends Serializable>
        implements GenericDao<T, PK> {

    protected EntityManager shopsEntityManager;
    private Class<T> entityClass;

    public AbstractGenericDao(){
        shopsEntityManager = Persistence
                .createEntityManagerFactory("shopsEntityManager")
                .createEntityManager();
        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass
                .getActualTypeArguments()[0];
    }

    public void create(T t){
        shopsEntityManager.getTransaction().begin();
        shopsEntityManager.persist(t);
        shopsEntityManager.getTransaction().commit();
    }

    public T retrieve(PK id){
        return shopsEntityManager.find(entityClass, id);
    }

    public void update(T t){
        shopsEntityManager.getTransaction().begin();
        shopsEntityManager.merge(t);
        shopsEntityManager.getTransaction().commit();
    }

    public void delete(PK id){
        shopsEntityManager.getTransaction().begin();
        shopsEntityManager.remove(retrieve(id));
        shopsEntityManager.getTransaction().commit();
    }
}


package com.demo.razorpay.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstractDAO<T> {

    private static final String PERSISTENCE_UNIT_NAME = "razorpay";
    private static EntityManagerFactory factory;

    private EntityManager entityManager;

    private Class<T> type;

    public AbstractDAO(Class<T> type){
        this.type = type;

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        this.entityManager = factory.createEntityManager();
    }

    protected EntityManager getEntityManager(){
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        if(null == this.entityManager ) {
            this.entityManager = factory.createEntityManager();
        } else {
            if(!this.entityManager.isOpen()){
                this.entityManager = factory.createEntityManager();
            }
        }
        return this.entityManager;
    }

    protected void closeEnityManager(){
        if(null != this.entityManager && this.entityManager.isOpen()) {
            this.entityManager.close();
        }
    }

    public T findBy(String id){
        return this.entityManager.find(this.type, id);
    }

    public T save(T entity){
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();
        return entity;
    }

    public T delete(T entity){
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(entity);
        this.entityManager.getTransaction().commit();
        return entity;
    }

    public T update(T entity){
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(entity);
        this.entityManager.getTransaction().commit();
        return entity;
    }


}

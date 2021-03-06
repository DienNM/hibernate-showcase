package com.dee.hibernate.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author dien.nguyen
 **/

public final class EntityManagerUtil {
    
    private final EntityManagerFactory entityManagerFactory;
    private static EntityManagerUtil instance;
    
    private EntityManagerUtil() {
        entityManagerFactory = Persistence.createEntityManagerFactory("pu-dee");
    }
    
    public synchronized static EntityManagerUtil getInstance() {
        if(instance == null) {
            instance = new EntityManagerUtil();
        }
        return instance;
    }
    
    public static EntityManager getEntityManager() {
        return getInstance().entityManagerFactory.createEntityManager();
    }
    
}

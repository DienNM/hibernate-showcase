package com.dee.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.dee.hibernate.model.UserModel;

/**
 * @author dien.nguyen
 **/

public class Runner2 {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure("/config/mysql-hibernate.cfg.xml");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            
            UserModel userModel = new UserModel();
            
            userModel.setId(System.currentTimeMillis());
            userModel.setEmail("nmdien61@gmail.com");
            userModel.setFirstName("Dien");
            userModel.setLastName("Nguyen");
            
            session.save(userModel);
            
            session.getTransaction().commit();
        } finally {
            session.close();
        }
        
    }

}

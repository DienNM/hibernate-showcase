package com.dee.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author dien.nguyen
 **/

public class Runner1 {

    public static void main(String[] args) {
        Configuration configuration = new Configuration().addResource("/mapping/hibernate.hbm.xml")
                .setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect")
                .setProperty("hibernate.connection.driver_class", "org.h2.Driver")
                .setProperty("hibernate.connection.url", "jdbc:h2:file:~/simple01")
                .setProperty("hibernate.connection.username", "sa")
                .setProperty("hibernate.connection.password", "");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        
    }

}

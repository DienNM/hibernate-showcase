package com.dee.hibernate.model;

import java.util.Date;

import junit.framework.TestCase;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.dee.hibernate.enumeration.Gender;

/**
 * @author dien.nguyen
 **/

public class UserTest extends TestCase{
    
    private SessionFactory sessionFactory;
    
    @Override
    protected void setUp() throws Exception {
        Configuration configuration = new Configuration();
        configuration.configure("/config/mysql-hibernate.cfg.xml");
        
        StandardServiceRegistryBuilder srBuilder = new StandardServiceRegistryBuilder();
        srBuilder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = srBuilder.build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
    
    @Override
    protected void tearDown() throws Exception {
        sessionFactory.close();
    }
    
    public void testSaveUser() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        
        UserModel user = new UserModel();
        user.setEmail("nmdien61@gmail.com");
        user.setUsername("diennm");
        user.setDateOfBirth(new Date(1988, 06, 15));
        user.setEncryptedPassword(false);
        user.setPassword("dien123");
        user.setFirstName("Dien");
        user.setLastName("Nguyen");
        user.setGender(Gender.Male);
        user.setWebsite("https://github.com/DienNM");
        
        session.save(user);
        transaction.commit();
        
        // Find User
        Query query = session.createQuery("from UserModel u where u.username = :uname ");
        query.setParameter("uname", "diennm");
        
        UserModel uniqueUser = (UserModel) query.uniqueResult();
        System.out.println("Loaded user: " + uniqueUser.getEmail());
        
        session.close();
    }
    
}

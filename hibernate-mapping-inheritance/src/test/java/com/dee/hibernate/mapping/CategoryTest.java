package com.dee.hibernate.mapping;

import org.hibernate.Session;
import org.junit.Assert;

import com.dee.hibernate.mapping.tablepersubclass.CustomerModel;
import com.dee.hibernate.mapping.tablepersubclass.EmployeeModel;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 **/

public class CategoryTest extends TestCase{
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    public void testCreateTables() {
        
        Category root = new Category();
        root.setName("root");
        
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        session.save(root);
        
        Category category1 = new Category();
        Category category2 = new Category();
        //session.save(category1);
        //session.save(category2);
        
        root.getChildren().add(category1);
        root.getChildren().add(category2);
        
        category1.setName("category1");
        category2.setName("category2");
        
        category1.setParent(root);
        category2.setParent(root);
        
        session.getTransaction().commit();
        session.close();
    }
}

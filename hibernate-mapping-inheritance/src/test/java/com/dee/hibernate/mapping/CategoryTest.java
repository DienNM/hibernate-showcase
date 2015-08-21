package com.dee.hibernate.mapping;

import junit.framework.TestCase;

import org.hibernate.Session;

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

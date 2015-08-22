package com.dee.hibernate.jpa;

import javax.persistence.EntityManager;

import junit.framework.TestCase;

import com.dee.hibernate.jpa.model.CategoryModel;
import com.dee.hibernate.jpa.model.SubjectModel;

/**
 * @author dien.nguyen
 **/

public class HibernateJPATest extends TestCase{
    
    private Long categoryMath;
    private Long categoryGeo;
    
    @Override
    protected void setUp() throws Exception {
        CategoryModel category1 = new CategoryModel();
        category1.setName("Math");
        CategoryModel category2 = new CategoryModel();
        category2.setName("geography");
        
        SubjectModel subject1 = new SubjectModel();
        subject1.setName("Math Level 1");
        subject1.setLength(15);
        subject1.setCategory(category1);
        SubjectModel subject2 = new SubjectModel();
        subject2.setName("Math Level 2");
        subject2.setLength(20);
        subject2.setCategory(category1);
        SubjectModel subject3 = new SubjectModel();
        subject3.setName("Math Level 3");
        subject3.setLength(50);
        subject3.setCategory(category1);
        SubjectModel subject4 = new SubjectModel();
        subject4.setName("Math Level 4");
        subject4.setLength(26);
        subject4.setCategory(category1);
        SubjectModel subject5 = new SubjectModel();
        subject5.setName("Geography Level 1");
        subject5.setLength(28);
        subject5.setCategory(category2);
        SubjectModel subject6 = new SubjectModel();
        subject6.setName("Geography Level 2");
        subject6.setLength(14);
        subject6.setCategory(category2);
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        
        em.persist(category1);
        em.persist(category2);
        
        categoryMath = category1.getId();
        categoryGeo = category2.getId();
        
        em.persist(subject1);
        em.persist(subject2);
        em.persist(subject3);
        em.persist(subject4);
        em.persist(subject5);
        em.persist(subject6);
        
        em.getTransaction().commit();
        em.close();
    }

    public void testHidernateJPA() {
        
    }
    
}

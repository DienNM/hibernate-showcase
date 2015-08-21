package com.dee.hibernate.hql;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.junit.Assert;

import com.dee.hibernate.hql.model.CategoryModel;
import com.dee.hibernate.hql.model.SubjectModel;

/**
 * @author dien.nguyen
 **/

public class HqlNamedQueryTest extends TestCase{
    
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
        
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        categoryMath = (Long) session.save(category1);
        categoryGeo = (Long) session.save(category2);
        session.save(subject1);
        session.save(subject2);
        session.save(subject3);
        session.save(subject4);
        session.save(subject5);
        session.save(subject6);
        
        session.getTransaction().commit();
        session.close();
    }

    public void testHQL() {
        List<Long> ids = new ArrayList<Long>();
        ids.add(categoryMath);
        ids.add(categoryGeo);
        
        // Using NamedQuery
        List<CategoryModel> categoryModels = NameQueryUtil.queryByIds(ids);
        Assert.assertEquals(2, categoryModels.size());
        
        System.out.println("Success...");
    }
    
}

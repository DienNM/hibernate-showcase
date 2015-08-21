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

public class HqlTest extends TestCase{
    
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
        List<SubjectModel> subjects = QueryUtil.queryByCateggoryId(categoryMath);
        Assert.assertEquals(4, subjects.size());
        subjects = QueryUtil.queryByCateggoryId(categoryGeo);
        Assert.assertEquals(2, subjects.size());
        
        List<Long> ids = new ArrayList<Long>();
        ids.add(categoryMath);
        ids.add(categoryGeo);
        
        subjects = QueryUtil.queryByCateggoryIds(ids);
        Assert.assertEquals(6, subjects.size());
        
        subjects = QueryUtil.queryPaging(0, 2);
        Assert.assertEquals(2, subjects.size());
        subjects = QueryUtil.queryPaging(1, 2);
        Assert.assertEquals(2, subjects.size());
        subjects = QueryUtil.queryPaging(2, 2);
        Assert.assertEquals(2, subjects.size());
        subjects = QueryUtil.queryPaging(3, 2);
        Assert.assertEquals(0, subjects.size());
        
        subjects = QueryUtil.queryByCateggoryName("Math");
        Assert.assertEquals(4, subjects.size());
        subjects = QueryUtil.queryByCateggoryName("Geography");
        Assert.assertEquals(2, subjects.size());
        
        Integer[] minmax = QueryUtil.queryAggregationMinMaxSubjectLength();
        Assert.assertEquals(14, minmax[0].intValue());
        Assert.assertEquals(50, minmax[1].intValue());
        
        Long count = QueryUtil.queryAggregationCount();
        Assert.assertEquals(6, count.longValue());
        
        Object column = QueryUtil.queryProjectionSingleColumnBySubjectName("Math Level 1");
        Assert.assertEquals("Math Level 1", column.toString());
        
        Object[] columns = QueryUtil.queryProjectionMultiColumnBySubjectName("Math Level 1");
        Assert.assertEquals("Math Level 1", columns[0]);
        Assert.assertEquals(15, columns[1]);
        
        System.out.println("Success...");
    }
    
}

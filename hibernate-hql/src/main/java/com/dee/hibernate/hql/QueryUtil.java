package com.dee.hibernate.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dee.hibernate.hql.model.SubjectModel;

/**
 * @author dien.nguyen
 **/

public final class QueryUtil {
    
    public static List<SubjectModel> queryPaging(int page, int pageSize) {
        Session session = SessionUtil.getSession();
        try {
            Query query = session.createQuery("FROM subject_hql");
            query.setFirstResult(page * pageSize);
            query.setMaxResults(pageSize);
            return query.list();
        } finally {
            session.close();
        }
    }
    
    public static List<SubjectModel> queryByCateggoryIds(List<Long> ids) {
        Session session = SessionUtil.getSession();
        try {
            Query query = session.createQuery("FROM subject_hql s WHERE s.category.id in (:ids)");
            query.setParameterList("ids", ids);
            return query.list();
        } finally {
            session.close();
        }
    }
    
    public static List<SubjectModel> queryByCateggoryName(String categoryName) {
        Session session = SessionUtil.getSession();
        try {
            Query query = session.createQuery("FROM subject_hql s WHERE s.category.name = :cname");
            query.setParameter("cname", categoryName);
            return query.list();
        } finally {
            session.close();
        }
    }
    
    public static List<SubjectModel> queryByCateggoryId(Long categoryId) {
        Session session = SessionUtil.getSession();
        try {
            Query query = session.createQuery("FROM subject_hql s WHERE s.category.id = :cID");
            query.setParameter("cID", categoryId);
            return query.list();
        } finally {
            session.close();
        }
    }
    
    public static Long queryAggregationCount() {
        Session session = SessionUtil.getSession();
        try {
            Query query = session.createQuery("SELECT count(*) FROM subject_hql");
            return (Long) query.uniqueResult();
        } finally {
            session.close();
        }
    }
    
    public static Integer[] queryAggregationMinMaxSubjectLength() {
        Session session = SessionUtil.getSession();
        try {
            Query query = session.createQuery("SELECT min(length), max(length) FROM subject_hql");
            Object[] minmaxObj = (Object[]) query.uniqueResult();
            Integer[] minmax = new Integer[2];
            minmax[0] = (Integer) minmaxObj[0];
            minmax[1] = (Integer) minmaxObj[1];
            
            return minmax;
        } finally {
            session.close();
        }
    }
    
    public static Object queryProjectionSingleColumnBySubjectName(String subjectName) {
        Session session = SessionUtil.getSession();
        try {
            Query query = session.createQuery("SELECT name FROM subject_hql where name = :name");
            query.setParameter("name", subjectName);
            Object column = (Object) query.uniqueResult();
            return column;
        } finally {
            session.close();
        }
    }
    
    public static Object[] queryProjectionMultiColumnBySubjectName(String subjectName) {
        Session session = SessionUtil.getSession();
        try {
            Query query = session.createQuery("SELECT name, length FROM subject_hql where name = :name");
            query.setParameter("name", subjectName);
            Object[] columns = (Object[]) query.uniqueResult();
            return columns;
        } finally {
            session.close();
        }
    }
}

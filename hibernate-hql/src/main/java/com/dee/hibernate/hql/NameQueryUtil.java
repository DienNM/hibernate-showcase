package com.dee.hibernate.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dee.hibernate.hql.model.CategoryModel;

/**
 * @author dien.nguyen
 **/

public final class NameQueryUtil {
    
    public static List<CategoryModel> queryByIds(List<Long> ids) {
        Session session = SessionUtil.getSession();
        try {
            Query query = session.getNamedQuery("queryByIds");
            query.setParameterList("ids", ids);
            return query.list();
        } finally {
            session.close();
        }
    }
   
}

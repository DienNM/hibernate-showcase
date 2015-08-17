package com.dee.hibernate.dao.impl;

import com.dee.hibernate.dao.CategoryDao;
import com.dee.hibernate.model.CategoryModel;

/**
 * @author dien.nguyen
 **/

public class DefaultCategoryDao extends DefaultGenericDao<CategoryModel, Long> implements CategoryDao {

    public DefaultCategoryDao() {
        super(CategoryModel.class);
    }

}

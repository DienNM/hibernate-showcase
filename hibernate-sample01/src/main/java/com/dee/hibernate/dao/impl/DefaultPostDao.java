package com.dee.hibernate.dao.impl;

import com.dee.hibernate.dao.PostDao;
import com.dee.hibernate.model.PostModel;

/**
 * @author dien.nguyen
 **/

public class DefaultPostDao extends DefaultGenericDao<PostModel, Long> implements PostDao {

    public DefaultPostDao() {
        super(PostModel.class);
    }

}

package com.dee.hibernate.dao.impl;

import com.dee.hibernate.dao.TagDao;
import com.dee.hibernate.model.TagModel;

/**
 * @author dien.nguyen
 **/

public class DefaultTagDao extends DefaultGenericDao<TagModel, Long> implements TagDao {

    public DefaultTagDao() {
        super(TagModel.class);
    }

}

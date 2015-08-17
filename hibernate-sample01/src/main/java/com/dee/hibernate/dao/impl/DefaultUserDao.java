package com.dee.hibernate.dao.impl;

import com.dee.hibernate.dao.UserDao;
import com.dee.hibernate.model.UserModel;

/**
 * @author dien.nguyen
 **/

public class DefaultUserDao extends DefaultGenericDao<UserModel, String> implements UserDao {

    public DefaultUserDao() {
        super(UserModel.class);
    }
    
}

package com.dee.hibernate;

import com.dee.hibernate.dao.impl.DefaultCategoryDao;
import com.dee.hibernate.dao.impl.DefaultPostDao;
import com.dee.hibernate.dao.impl.DefaultTagDao;
import com.dee.hibernate.dao.impl.DefaultUserDao;

/**
 * @author dien.nguyen
 **/

public class Main {
    
    public static void main(String[] args) {
        
        ExampleRunner runner = new ExampleRunner();
        
        // Set Dependencies
        runner.setCategoryDao(new DefaultCategoryDao());
        runner.setPostDao(new DefaultPostDao());
        runner.setTagDao(new DefaultTagDao());
        runner.setUserDao(new DefaultUserDao());
        
        // Initialize Data
        runner.initData();
    }
}

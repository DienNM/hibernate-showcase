package com.dee.hibernate;


import java.util.Date;

import org.junit.Assert;

import com.dee.hibernate.dao.CategoryDao;
import com.dee.hibernate.dao.PostDao;
import com.dee.hibernate.dao.TagDao;
import com.dee.hibernate.dao.UserDao;
import com.dee.hibernate.enumeration.Gender;
import com.dee.hibernate.model.CategoryModel;
import com.dee.hibernate.model.UserModel;

/**
 * @author dien.nguyen
 **/

public class ExampleRunner {
    
    private UserDao userDao;
    private CategoryDao categoryDao;
    private TagDao tagDao;
    private PostDao postDao;
    
    public ExampleRunner() {
    }
    
    public void initData() {
        createUser();
        createCategories();
    }
    
    private void createUser() {
        UserModel user = new UserModel();
        user.setEmail("nmdien61@gmail.com");
        user.setUsername("diennm");
        user.setDateOfBirth(new Date(1988, 06, 15));
        user.setEncryptedPassword(false);
        user.setPassword("dien123");
        user.setFirstName("Dien");
        user.setLastName("Nguyen");
        user.setGender(Gender.Male);
        user.setWebsite("https://github.com/DienNM");
        
        user = userDao.save(user);
        Assert.assertNotNull(user);
    }
    
    private void createCategories() {
        CategoryModel root = new CategoryModel();
        root.setDescription("Root Category");
        root.setKey("root");
        root.setName("Root");
        root.setParent(null);
        
        categoryDao.save(root);
        
        CategoryModel category1 = new CategoryModel();
        category1.setDescription("Category 1");
        category1.setKey("category-1");
        category1.setName("Category 1");
        category1.setParent(root);
        
        categoryDao.save(category1);
        
        CategoryModel category2 = new CategoryModel();
        category2.setDescription("Category 2");
        category2.setKey("category-2");
        category2.setName("Category 2");
        category2.setParent(root);
        
        categoryDao.save(category2);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }

    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public TagDao getTagDao() {
        return tagDao;
    }

    public void setTagDao(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }
    
}

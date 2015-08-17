package com.dee.hibernate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.dee.hibernate.enumeration.BaseStatus;
import com.dee.hibernate.enumeration.Gender;
import com.dee.hibernate.model.CategoryModel;
import com.dee.hibernate.model.PostModel;
import com.dee.hibernate.model.TagModel;
import com.dee.hibernate.model.UserModel;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 **/

public class ModelTest extends TestCase{
    
    @SuppressWarnings("deprecation")
    public void testCreateModel() {
        
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
        
        CategoryModel root = new CategoryModel();
        root.setDescription("Root Category");
        root.setKey("root");
        root.setName("Root");
        root.setParent(null);
        
        CategoryModel category1 = new CategoryModel();
        category1.setDescription("Category 1");
        category1.setKey("category-1");
        category1.setName("Category 1");
        category1.setParent(root);
        
        CategoryModel category2 = new CategoryModel();
        category2.setDescription("Category 2");
        category2.setKey("category-2");
        category2.setName("Category 2");
        category2.setParent(root);
        
        TagModel tag1 = new TagModel();
        tag1.setName("Hibernate");
        
        TagModel tag2 = new TagModel();
        tag2.setName("Java");
        
        TagModel tag3 = new TagModel();
        tag3.setName("Database");
        
        PostModel post1 = new PostModel();
        post1.setKey("hibernate-example01");
        post1.setCategory(category1);
        post1.setContent("Showing example of hibernate.");
        post1.setOwner(user);
        post1.setStatus(BaseStatus.Online);
        post1.setTitle("Hibernate Example");
        
        Set<TagModel> tags = new HashSet<TagModel>();
        tags.add(tag1);
        tags.add(tag2);
        
        post1.setTags(tags);
        
    }
    
}

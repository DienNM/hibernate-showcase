package com.dee.hibernate.dao.collection;

import org.hibernate.Session;
import org.junit.Assert;

import com.dee.hibernate.SessionUtil;
import com.dee.hibernate.model.collection.ImageModel;
import com.dee.hibernate.model.collection.ImageType;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 **/

// Create 3 tables: Address, Customer and Address_Customer

public class CollectionMappingTest extends TestCase {
    
    public void testCollectionMapping_1() {
        
        ImageModel image = new ImageModel();
        image.setUrl("/image/ava");
        image.getSupportedExts().add("jpg");
        image.getSupportedExts().add("png");
        image.getSupportedExts().add("gif");
        image.getTypes().add(new ImageType("avatar", "AV"));
        image.getTypes().add(new ImageType("profile", "PRF"));
        
        ImageModel image1 = new ImageModel();
        image1.setUrl("/image/ava1");
        image1.getTypes().add(new ImageType("avatar"));
        
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        session.save(image);
        session.save(image1);
        session.getTransaction().commit();
        session.close();
        session = SessionUtil.getSession();
        
        ImageModel pImage = (ImageModel) session.get(ImageModel.class, image.getId());
        ImageModel pImage1 = (ImageModel) session.get(ImageModel.class, image1.getId());
        
        Assert.assertNotNull(pImage);
        Assert.assertNotNull(pImage1);
        

        Assert.assertEquals(3, pImage.getSupportedExts().size());
        Assert.assertNotNull(pImage.getSupportedExts().iterator().next());
        Assert.assertEquals(0, pImage1.getSupportedExts().size());
        
        session.close();
    }
    
}

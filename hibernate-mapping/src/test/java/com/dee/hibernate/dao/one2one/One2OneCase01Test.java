package com.dee.hibernate.dao.one2one;

import org.hibernate.Session;
import org.junit.Assert;

import com.dee.hibernate.SessionUtil;
import com.dee.hibernate.model.one2one.case01.UserModel;
import com.dee.hibernate.model.one2one.case01.UserInfoModel;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 **/

public class One2OneCase01Test extends TestCase {
    
    /**
     * UserInfo did not set User to it's User
     * Hibernate created a foreign key between User and UserInfo
     */
    public void testOne2OneCase01_1() {
        UserModel user = new UserModel();
        user.setEmail("nmdien61@gmail.com");
        user.setFirstName("Dien");
        user.setLastName("Nguyen");
        
        UserInfoModel userInfo = new UserInfoModel();
        userInfo.setGender((short) 1);
        userInfo.setHomephone(null);
        userInfo.setMobile("01659677657");
        userInfo.setWebsite("https://github.com/DienNM");
        
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        Long userId = (Long) session.save(user);
        Long userInfoId = (Long) session.save(userInfo);
        session.getTransaction().commit();
        
        UserModel pUser = (UserModel) session.get(UserModel.class, userId);
        UserInfoModel pUserInfo = (UserInfoModel) session.get(UserInfoModel.class, userInfoId);
        
        Assert.assertNotNull(pUser);
        Assert.assertNotNull(pUserInfo);
        
        Assert.assertNull(pUser.getUserInfo());
    }
    
    /**
     * UserInfo sets User to it's User
     * Hibernate created a foreign key between User and UserInfo
     */
    public void testOne2OneCase01_2() {
        UserModel user = new UserModel();
        user.setEmail("nmdien61@gmail.com");
        user.setFirstName("Dien");
        user.setLastName("Nguyen");
        

        UserInfoModel userInfo = new UserInfoModel();
        userInfo.setGender((short) 1);
        userInfo.setHomephone(null);
        userInfo.setMobile("01659677657");
        userInfo.setWebsite("https://github.com/DienNM");
        
        user.setUserInfo(userInfo);
        
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        Long userId = (Long) session.save(user);
        Long userInfoId = (Long) session.save(userInfo);
        session.getTransaction().commit();
        session.close();
        
        session = SessionUtil.getSession();
        
        UserModel pUser = (UserModel) session.get(UserModel.class, userId);
        UserInfoModel pUserInfo = (UserInfoModel) session.get(UserInfoModel.class, userInfoId);
        
        Assert.assertNotNull(pUser);
        Assert.assertNotNull(pUserInfo);
        
        Assert.assertNotNull(pUser.getUserInfo());
    }
    
}

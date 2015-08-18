package com.dee.hibernate.dao.one2one;

import org.hibernate.Session;
import org.junit.Assert;

import com.dee.hibernate.SessionUtil;
import com.dee.hibernate.model.one2one.case03.UserModel;
import com.dee.hibernate.model.one2one.case03.UserInfoModel;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 **/

// Example of make the owner of relationship

public class One2OneCase03Test extends TestCase {
    
    public void testOne2OneCase03_1() {
        UserModel user = new UserModel();
        user.setEmail("nmdien61@gmail.com");
        user.setFirstName("Dien");
        user.setLastName("Nguyen");

        UserInfoModel userInfo = new UserInfoModel();
        userInfo.setGender((short) 1);
        userInfo.setHomephone(null);
        userInfo.setMobile("01659677657");
        userInfo.setWebsite("https://github.com/DienNM");
        
        userInfo.setUser(user);
        
        Session session = SessionUtil.getSession();
        session.getTransaction().begin();
        Long userInfoId = (Long) session.save(userInfo);
        Long userId = (Long) session.save(user);
        
        session.getTransaction().commit();
        session.close();
        
        session = SessionUtil.getSession();
        UserModel pUser = (UserModel) session.get(UserModel.class, userId);
        UserInfoModel pUserInfo = (UserInfoModel) session.get(UserInfoModel.class, userInfoId);
        session.close();
        
        Assert.assertNotNull(pUser);
        Assert.assertNotNull(pUserInfo);
        
        Assert.assertNotNull(pUser.getUserInfo());
        Assert.assertNotNull(pUserInfo.getUser());
    }
    
}

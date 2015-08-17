package com.dee.hibernate;

import java.util.Date;

import com.dee.hibernate.enumeration.Gender;
import com.dee.hibernate.model.UserModel;

/**
 * @author dien.nguyen
 **/

public final class DataPreparation {

    public static UserModel createUserModel() {
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
        return user;
    }
    
}

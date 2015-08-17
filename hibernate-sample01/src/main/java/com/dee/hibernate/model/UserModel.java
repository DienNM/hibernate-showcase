package com.dee.hibernate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import com.dee.hibernate.enumeration.Gender;

/**
 * @author dien.nguyen
 **/

@Entity
public class UserModel implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String username;
    
    private String email;
    
    private String firstName;
    
    private String lastName;
    
    private Date dateOfBirth;
    
    private boolean encryptedPassword = false;
    
    private String password;
    
    private Gender gender;
    
    private String website;
    
    private String avatar;
    
    public UserModel() {
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(boolean encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
}

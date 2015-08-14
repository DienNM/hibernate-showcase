package com.dee.hibernate.model;

import java.io.Serializable;

/**
 * @author dien.nguyen
 **/

public class UserModel implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Long id;
    
    private String email;
    
    private String firstName;
    
    private String lastName;
    
    private String dateOfBirth;
    
    public UserModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
}

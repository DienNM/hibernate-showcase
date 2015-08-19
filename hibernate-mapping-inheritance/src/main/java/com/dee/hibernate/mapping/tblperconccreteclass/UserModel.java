package com.dee.hibernate.mapping.tblperconccreteclass;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author dien.nguyen
 **/

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class UserModel {
    
    private long id;
    
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}

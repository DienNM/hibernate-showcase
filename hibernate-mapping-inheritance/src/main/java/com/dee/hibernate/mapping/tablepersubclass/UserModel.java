package com.dee.hibernate.mapping.tablepersubclass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author dien.nguyen
 **/

@Entity(name = "user_parent")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

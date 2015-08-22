package com.dee.hibernate.jpa.componentmapping.collection;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

import org.hibernate.annotations.Parent;

/**
 * @author dien.nguyen
 */
@Embeddable
@Table(name = "phone_case_02")
public class PhoneCase02Model implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "phone_number")
    private String number;
    
    @Column(name = "ext")
    private String ext;
    
    @Parent
    private UserCase02Model user;
    
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getExt() {
        return ext;
    }
    public void setExt(String ext) {
        this.ext = ext;
    }
    public UserCase02Model getUser() {
        return user;
    }
    public void setUser(UserCase02Model user) {
        this.user = user;
    }
    
}

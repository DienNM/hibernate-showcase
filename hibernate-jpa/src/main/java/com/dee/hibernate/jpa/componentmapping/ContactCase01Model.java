package com.dee.hibernate.jpa.componentmapping;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author dien.nguyen
 */
@Embeddable
public class ContactCase01Model implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String name;
    
    private String address;
    
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}

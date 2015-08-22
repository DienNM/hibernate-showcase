package com.dee.hibernate.jpa.componentmapping;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * @author dien.nguyen
 */
@Embeddable
public class ContactCase02Model implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String name;
    
    private String address;
    
    @Embedded
    private PhoneCase02Model phone;

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
    
    public PhoneCase02Model getPhone() {
        return phone;
    }
    
    public void setPhone(PhoneCase02Model phone) {
        this.phone = phone;
    }
    
}

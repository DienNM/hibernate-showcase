package com.dee.hibernate.mapping.tblperhierarchy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author dien.nguyen
 **/

@Entity(name = "customer_02")
@DiscriminatorValue("cus")
public class CustomerModel extends UserModel{
    
    private String type;
    
    private String phone;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}

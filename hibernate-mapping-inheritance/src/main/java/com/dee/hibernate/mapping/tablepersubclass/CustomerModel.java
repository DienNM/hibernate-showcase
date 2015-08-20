package com.dee.hibernate.mapping.tablepersubclass;

import javax.persistence.Entity;

/**
 * @author dien.nguyen
 **/

@Entity(name = "customer_03")
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

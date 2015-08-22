package com.dee.hibernate.jpa.compositeid;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author dien.nguyen
 */

@Entity(name = "order_detail_03")
public class OrderDetailCase03Model implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    private OrderDetailId03 id;
    
    private int amount;

    public OrderDetailId03 getId() {
        return id;
    }
    
    public void setId(OrderDetailId03 id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
}

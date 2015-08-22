package com.dee.hibernate.jpa.compositeid;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 * @author dien.nguyen
 */

@Entity(name = "order_detail_02")
@IdClass(OrderDetailId02.class)
public class OrderDetailCase02Model implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    private String orderId;
    
    @Id
    private String itemId;
    
    private int amount;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
}

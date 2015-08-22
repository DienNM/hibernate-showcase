package com.dee.hibernate.jpa.compositeid;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author dien.nguyen
 */

@Embeddable
public class OrderDetailId03 implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "order_id")
    private String orderId;
    
    @Column(name = "item_id")
    private String itemId;

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
}

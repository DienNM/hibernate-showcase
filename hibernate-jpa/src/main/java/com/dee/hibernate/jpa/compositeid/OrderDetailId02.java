package com.dee.hibernate.jpa.compositeid;

import java.io.Serializable;

/**
 * @author dien.nguyen
 */

public class OrderDetailId02 implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String orderId;
    
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

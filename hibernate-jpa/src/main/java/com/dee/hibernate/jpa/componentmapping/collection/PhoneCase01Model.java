package com.dee.hibernate.jpa.componentmapping.collection;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author dien.nguyen
 */
@Embeddable
public class PhoneCase01Model implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "phone_number")
    private String number;
    
    @Column(name = "ext")
    private String ext;
    
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
    
}

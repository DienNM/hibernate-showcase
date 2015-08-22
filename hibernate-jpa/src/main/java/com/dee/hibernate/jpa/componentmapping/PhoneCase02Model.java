package com.dee.hibernate.jpa.componentmapping;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author dien.nguyen
 */
@Embeddable
public class PhoneCase02Model implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String number;
    
    private String ext;

    private boolean internal;
    
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

    public boolean isInternal() {
        return internal;
    }

    public void setInternal(boolean internal) {
        this.internal = internal;
    }

}

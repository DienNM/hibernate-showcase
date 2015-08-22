package com.dee.hibernate.jpa.componentmapping;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author dien.nguyen
 */
@Entity(name = "order_cpn_mapping_02")
public class OrderCase02Model implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private double total;
    
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "home_ct_name")),
        @AttributeOverride(name = "address", column = @Column(name = "home_ct_address")),
        @AttributeOverride(name = "phone.ext", column = @Column(name = "home_ct_phone_ext")),
        @AttributeOverride(name = "phone.number", column = @Column(name = "home_ct_phone_number")),
        @AttributeOverride(name = "phone.internal", column = @Column(name = "home_ct_phone_internal"))
    })
    private ContactCase02Model homeContact;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "office_ct_name")),
        @AttributeOverride(name = "address", column = @Column(name = "office_ct_address")),
        @AttributeOverride(name = "phone.ext", column = @Column(name = "office_ct_phone_ext")),
        @AttributeOverride(name = "phone.number", column = @Column(name = "office_ct_phone_number")),
        @AttributeOverride(name = "phone.internal", column = @Column(name = "office_ct_phone_internal"))
    })
    private ContactCase02Model officeContact;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ContactCase02Model getHomeContact() {
        return homeContact;
    }

    public void setHomeContact(ContactCase02Model homeContact) {
        this.homeContact = homeContact;
    }

    public ContactCase02Model getOfficeContact() {
        return officeContact;
    }

    public void setOfficeContact(ContactCase02Model officeContact) {
        this.officeContact = officeContact;
    }
    
}

package com.dee.hibernate.model.one2many.case01;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * @author dien.nguyen
 **/

@Entity(name = "customer_case01")
public class CustomerModel implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "email")
    private String email;
    
    @OneToMany
    private List<AddressModel> addresses;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<AddressModel> getAddresses() {
        return addresses;
    }
    public void setAddresses(List<AddressModel> addresses) {
        this.addresses = addresses;
    }
    
}

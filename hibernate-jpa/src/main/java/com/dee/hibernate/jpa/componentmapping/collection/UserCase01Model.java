package com.dee.hibernate.jpa.componentmapping.collection;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

/**
 * @author dien.nguyen
 */
@Entity(name = "user_cpn_map_col_case01")
public class UserCase01Model implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String username;

    @ElementCollection
    @JoinTable(name = "user_phone", joinColumns = {@JoinColumn(name = "user_id")})
    private Set<PhoneCase01Model> phones;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<PhoneCase01Model> getPhones() {
        return phones;
    }

    public void setPhones(Set<PhoneCase01Model> phones) {
        this.phones = phones;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

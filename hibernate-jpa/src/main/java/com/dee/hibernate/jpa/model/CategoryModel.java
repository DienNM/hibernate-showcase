package com.dee.hibernate.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author dien.nguyen
 **/

@Entity(name = "category_jpa")
public class CategoryModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof CategoryModel)) {
            return false;
        }
        
        CategoryModel ctg = (CategoryModel) obj;
        if(ctg.getId() != this.getId()) {
            return false;
        }
        if(ctg.getName() == null && !ctg.getName().equals(this.getName())) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}

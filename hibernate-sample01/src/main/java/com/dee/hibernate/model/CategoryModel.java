package com.dee.hibernate.model;

/**
 * @author dien.nguyen
 **/

public class CategoryModel {
    
    private Long id;
    
    private String key;
    
    private String name;
    
    private String description;
    
    private CategoryModel parent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryModel getParent() {
        return parent;
    }

    public void setParent(CategoryModel parent) {
        this.parent = parent;
    }
    
    
    
}

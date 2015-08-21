package com.dee.hibernate.model.collection;

import javax.persistence.Embeddable;

/**
 * @author dien.nguyen
 **/

@Embeddable
public class ImageType {
    
    public ImageType() {
    }
    
    public ImageType(String type) {
        this.type = type;
    }
    
    public ImageType(String type, String description) {
        this.type = type;
        this.description = description;
    }
    
    private String description;
    
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}

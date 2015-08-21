package com.dee.hibernate.model.collection;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

/**
 * @author dien.nguyen
 **/

@Entity(name = "image")
public class ImageModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String url;
    
    @ElementCollection
    @CollectionTable(name = "image_type",  joinColumns = {@JoinColumn(name = "image_id")})
    private Set<ImageType> types = new HashSet<ImageType>();
    
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "image_ext",  joinColumns = {@JoinColumn(name = "image_id")})
    @Column(name = "ext")
    private Set<String> supportedExts = new HashSet<String>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<String> getSupportedExts() {
        return supportedExts;
    }

    public void setSupportedExts(Set<String> supportedExts) {
        this.supportedExts = supportedExts;
    }

    public Set<ImageType> getTypes() {
        return types;
    }

    public void setTypes(Set<ImageType> types) {
        this.types = types;
    }
    
}

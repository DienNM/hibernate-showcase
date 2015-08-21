package com.dee.hibernate.model.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;

import org.hibernate.annotations.IndexColumn;

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
    
    @ElementCollection
    @CollectionTable(name = "image_loc",  joinColumns = {@JoinColumn(name = "image_id")})
    @Column(name = "location")
    @OrderColumn(name = "position")
    private List<String> locations = new ArrayList<String>();
    
    @ElementCollection
    @CollectionTable(name = "image_size",  joinColumns = {@JoinColumn(name = "image_id")})
    @Column(name = "size")
    @MapKeyColumn(name = "file_type")
    private Map<String, Integer> sizes = new HashMap<String, Integer>();

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

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    public Map<String, Integer> getSizes() {
        return sizes;
    }

    public void setSizes(Map<String, Integer> sizes) {
        this.sizes = sizes;
    }
    
}

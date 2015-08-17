package com.dee.hibernate.model;

import java.util.Date;
import java.util.Set;

import com.dee.hibernate.enumeration.BaseStatus;

/**
 * @author dien.nguyen
 **/

public class PostModel {
    
    private Long id;
    
    private String key;
    
    private String title;
    
    private String description;
    
    private String content;
    
    private BaseStatus status = BaseStatus.Online;
    
    private UserModel owner;
    
    private Set<TagModel> tags;
    
    private CategoryModel category;
    
    private Date createdAt;
    
    private Date updatedAt;
    
    private String createdBy;
    
    private String updatedBy;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BaseStatus getStatus() {
        return status;
    }

    public void setStatus(BaseStatus status) {
        this.status = status;
    }

    public UserModel getOwner() {
        return owner;
    }

    public void setOwner(UserModel owner) {
        this.owner = owner;
    }

    public Set<TagModel> getTags() {
        return tags;
    }

    public void setTags(Set<TagModel> tags) {
        this.tags = tags;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    
}

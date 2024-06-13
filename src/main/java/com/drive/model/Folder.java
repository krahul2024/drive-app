package com.drive.model;

import java.sql.Timestamp; 

public class Folder {
    private Long id; 
    private String name; 
    private String description; 
    private String path; 
    private String thumbnailUrl; 
    private Long size; 

    private Long ownerId; 
    private Long parentId; 

    private Timestamp createdAt; 
    private Timestamp updatedAt;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Folder(){ }  

    public Folder(Long id, String name, String description, String path, String thumbnailUrl, Long size, 
            Long ownerId, Long parentId, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.path = path;
        this.thumbnailUrl = thumbnailUrl;
        this.size = size;
        this.ownerId = ownerId;
        this.parentId = parentId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Folder [id=" + id + ", name=" + name + ", description=" + description + ", path=" + path
                + ", thumbnailUrl=" + thumbnailUrl + ", size=" + size + ", ownerId=" + ownerId + ", parentId="
                + parentId + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }

    
}
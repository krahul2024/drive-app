package com.drive.model;

import java.sql.Timestamp;

public class FileType {
    private Long id; 
    private String name; 
    private String extension; 
    private String iconUrl; 
    private Timestamp createdAt; 
    private Timestamp updatedAt;

    public FileType(){ }

    public FileType(Long id, String name, String extension, String iconUrl, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.extension = extension;
        this.iconUrl = iconUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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
    public String getExtension() {
        return extension;
    }
    public void setExtension(String extension) {
        this.extension = extension;
    }
    public String getIconUrl() {
        return iconUrl;
    }
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
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

    @Override
    public String toString() {
        return "FileType [id=" + id + ", name=" + name + ", extension=" + extension + ", iconUrl=" + iconUrl
                + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }


}
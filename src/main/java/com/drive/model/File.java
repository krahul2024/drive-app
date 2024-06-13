package com.drive.model;

import java.sql.Timestamp; 

import org.springframework.util.MimeType;

public class File {
    private Long id; 
    private String name; 
    private String description; 
    private Long size; 
    private MimeType mimeType;
    private String extension; 
    private String checksum;
    private String fileUrl; 
    private String path; 
    private String thumbnailUrl; 
    private Boolean isTrashed; 

    private Long fileTypeId;
    private Long ownerId; 
    private Long folderId; 
    
    private Timestamp createdAt; 
    private Timestamp updatedAt;

    public File(){ }

    public File(Long id, String name, String description, Long size, MimeType mimeType, String extension,
            String checksum, String fileUrl, String thumbnailUrl, Boolean isTrashed, Long sharedStatusId,
            Long permissionId, Long fileTypeId, Long ownerId, Long folderId, Timestamp createdAt, String path, 
            Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.size = size;
        this.mimeType = mimeType;
        this.extension = extension;
        this.checksum = checksum;
        this.fileUrl = fileUrl;
        this.thumbnailUrl = thumbnailUrl;
        this.isTrashed = isTrashed;
        this.fileTypeId = fileTypeId;
        this.ownerId = ownerId;
        this.folderId = folderId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.path = path; 
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Long getSize() {
        return size;
    }
    public void setSize(Long size) {
        this.size = size;
    }
    public MimeType getMimeType() {
        return mimeType;
    }
    public void setMimeType(MimeType mimeType) {
        this.mimeType = mimeType;
    }
    public String getExtension() {
        return extension;
    }

    public String getPath(){
        return this.path; 
    }
    public void setExtension(String extension) {
        this.extension = extension;
    }
    public String getChecksum() {
        return checksum;
    }
    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }
    public String getFileUrl() {
        return fileUrl;
    }
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
    public Boolean getIsTrashed() {
        return isTrashed;
    }
    public void setIsTrashed(Boolean isTrashed) {
        this.isTrashed = isTrashed;
    }
    public Long getFileTypeIconId() {
        return fileTypeId;
    }
    public void setFileTypeIconId(Long fileTypeId) {
        this.fileTypeId = fileTypeId;
    }
    public Long getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
    public Long getFolderId() {
        return folderId;
    }
    public void setFolderId(Long folderId) {
        this.folderId = folderId;
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

    public void setPath(String path){
        this.path = path; 
    }

    @Override
    public String toString() {
        return "File [id=" + id + ", name=" + name + ", description=" + description + ", size=" + size + ", mimeType="
                + mimeType + ", extension=" + extension + ", checksum=" + checksum + ", fileUrl=" + fileUrl + ", path=" + path
                + ", thumbnailUrl=" + thumbnailUrl + ", isTrashed=" + isTrashed + ", fileTypeId=" + fileTypeId + ", ownerId=" + ownerId
                + ", folderId=" + folderId + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
    }


}

// Need to add various types of logs, versions, history of changes, who accessed the file etc. 

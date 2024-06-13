package com.drive.model;

import java.sql.Timestamp;

public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String imageUrl;
    private Timestamp joinedAt;
    private Timestamp updatedAt;
    private Timestamp lastSeen;
    private Double usedStorage;
    private Long planId;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public Timestamp getJoinedAt() {
        return joinedAt;
    }
    public void setJoinedAt(java.sql.Timestamp timestamp) {
        this.joinedAt = timestamp;
    }
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(java.sql.Timestamp timestamp) {
        this.updatedAt = timestamp;
    }
    public Timestamp getLastSeen() {
        return lastSeen;
    }
    public void setLastSeen(java.sql.Timestamp timestamp) {
        this.lastSeen = timestamp;
    }
    public Double getUsedStorage() {
        return usedStorage;
    }
    public void setUsedStorage(Double usedStorage) {
        this.usedStorage = usedStorage;
    }
    public Long getPlanId() {
        return planId;
    }
    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public User(){ }

    public User(Long id, String name, String email, String password, String imageUrl, Timestamp joinedAt, Timestamp updatedAt, Timestamp lastSeen, Double usedStorage, Long planId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.imageUrl = imageUrl;
        this.joinedAt = joinedAt;
        this.updatedAt = updatedAt;
        this.lastSeen = lastSeen;
        this.usedStorage = usedStorage;
        this.planId = planId;
    }
}

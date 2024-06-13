package com.drive.model;

public class Plan {
    private Long id; 
    private String name; 
    private Integer storageQuota; 
    private Integer price; 
    private Integer maxFileSize; 
    private Integer numUsers;
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
    public Integer getStorageQuota() {
        return storageQuota;
    }
    public void setStorageQuota(Integer storageQuota) {
        this.storageQuota = storageQuota;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public Integer getMaxFileSize() {
        return maxFileSize;
    }
    public void setMaxFileSize(Integer maxFileSize) {
        this.maxFileSize = maxFileSize;
    }
    public Integer getNumUsers() {
        return numUsers;
    }
    public void setNumUsers(Integer numUsers) {
        this.numUsers = numUsers;
    } 

    public String toString(){
        return "Plan [id=" + id + ", name=" + name + ", storageQuota=" + storageQuota + ", price=" + price + ", maxFileSize=" + maxFileSize + ", numUsers=" + numUsers + "]";
    }
}

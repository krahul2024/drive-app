package com.drive.utils.response;

import com.drive.model.User;
import com.drive.utils.Status;

public class LoginResponse {
    private Status.LoginStatus status; 
    private User user; 

    public LoginResponse(Status.LoginStatus status, User user){
        this.status = status; 
        this.user = user; 
    }

    public Status.LoginStatus getStatus() {
        return status;
    }           

    public void setStatus(Status.LoginStatus status) {
        this.status = status;
    }   

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
package com.drive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drive.dao.UserDao;
import com.drive.model.User;
import com.drive.utils.Status;

@Service
public class UserService {
    private UserDao userDao; 
    
    @Autowired
    public UserService(UserDao userDao){
        this.userDao = userDao; 
    }

    public Status.RegisterStatus register(User user){
        User existingUser = userDao.getUserByEmail(user.getEmail()); 
        if(existingUser != null){
            return Status.RegisterStatus.USER_EXISTS;
        }
        int userId = userDao.addUser(user);
        if(userId == 0){
            return Status.RegisterStatus.REGISTRATION_FAILED;
        }
        return Status.RegisterStatus.SUCCESS;
    }

    public Status.LoginStatus login(String email, String password){
        User existingUser = userDao.getUserByEmail(email); 
        if(existingUser == null){
            return Status.LoginStatus.USER_NOT_FOUND;
        }
        if(!existingUser.getPassword().equals(password)){
            return Status.LoginStatus.INVALID_CREDENTIALS;
        }
        return Status.LoginStatus.SUCCESS;
    }

    // public User getUserByEmail
}

class LoginResponse {
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

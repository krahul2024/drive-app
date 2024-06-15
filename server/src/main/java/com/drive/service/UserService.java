package com.drive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drive.dao.UserDao;
import com.drive.model.User;
import com.drive.utils.Status;
import com.drive.utils.response.LoginResponse;

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

    public LoginResponse login(String email, String password){
        User existingUser = userDao.getUserByEmail(email); 
        if(existingUser == null){
            return new LoginResponse(Status.LoginStatus.USER_NOT_FOUND, null);
        }
        if(!existingUser.getPassword().equals(password)){
            return new LoginResponse(Status.LoginStatus.INVALID_CREDENTIALS, null);
        }
        existingUser.setPassword("");
        return new LoginResponse(Status.LoginStatus.SUCCESS, existingUser); 
    }
}


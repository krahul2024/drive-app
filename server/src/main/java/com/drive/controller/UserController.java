package com.drive.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drive.model.User;
import com.drive.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService; 

    @Autowired
    public UserController(UserService userService){
        this.userService = userService; 
    }

    @GetMapping("")
    public ResponseEntity<Object> getUser(@CookieValue(name="authToken", required = false) String authToken, HttpServletRequest request){
        Enumeration<String> headerNames = request.getHeaderNames();
        StringBuilder headersInfo = new StringBuilder("Headers from client:\n");

        // Iterate over the header names and append to StringBuilder
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            headersInfo.append(headerName).append(": ").append(headerValue).append("\n");
        }

        // Log or print the headers (for demonstration)
        System.out.println(headersInfo.toString());
        Map<String, Object> response = new HashMap<>(); 
        if(authToken == null){
            response.put("message", "User not logged in!"); 
            response.put("user", null); 
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
        // the authToken is currently an email 
        User user = userService.getUserByEmail(authToken); 
        user.setPassword("");
        response.put("message", "successfully retrieved user");
        response.put("user", user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

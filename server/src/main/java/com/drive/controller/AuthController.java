package com.drive.controller;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drive.model.User;
import com.drive.service.UserService;
import com.drive.utils.Status;
import com.drive.utils.response.LoginResponse;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController 
@RequestMapping("/auth")
public class AuthController {
    private UserService userService; 

    @Autowired
    public AuthController(UserService userService){
        this.userService = userService; 
    }

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody User user){
        Status.RegisterStatus registered = userService.register(user); 
        Map<String, Object> response = new HashMap<>(); 
        response.put("status", registered.getMessage());
        return new ResponseEntity<>(response, registered.getStatusCode());
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginCreds loginCreds, HttpServletResponse response){
        LoginResponse loggedIn = userService.login(loginCreds.getEmail(), loginCreds.getPassword()); 
        Map<String, Object> responseBody = new HashMap<>(); 
        responseBody.put("status", loggedIn.getStatus().getMessage()); 
        responseBody.put("user", loggedIn.getUser());
        if(loggedIn.getStatus() == Status.LoginStatus.SUCCESS){
            Cookie cookie = new Cookie("auth_token", loginCreds.getEmail());
            cookie.setMaxAge(3600 * 24 * 7);
            cookie.setPath("/"); 
            cookie.setSecure(false);
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
        }
        return new ResponseEntity<>(responseBody, loggedIn.getStatus().getStatusCode());
    }

    @GetMapping("/logout")
    public ResponseEntity<Object> logout(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("auth_token")){
                    cookie.setValue("");
                    cookie.setMaxAge(0);
                    cookie.setPath("/"); 
                    cookie.setSecure(false);
                    cookie.setHttpOnly(true);
                    response.addCookie(cookie);
                    break; 
                }
            }
        }
        return ResponseEntity.ok().build();
    }
}

class LoginCreds {
    private String email; 
    private String password; 

    public LoginCreds(String email, String password){
        this.email = email; 
        this.password = password; 
    }

    public String getEmail(){
        return this.email; 
    }

    public String getPassword(){
        return this.password; 
    }
}


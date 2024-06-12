package com.drive.controller;

import java.util.HashMap; 
import java.util.Map;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class IndexController {
    @GetMapping("/health-check")
    public ResponseEntity<Object> healthCheck(){
        Map<String, Object> response = new HashMap<>(); 
        response.put("status", "success"); 
        response.put("message", "The server is running!"); 
        return ResponseEntity.ok(response);
    }
    
}

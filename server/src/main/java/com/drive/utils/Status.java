package com.drive.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

public class Status {

    public enum RegisterStatus {
        SUCCESS(HttpStatus.CREATED, "Registration Successful"),
        USER_EXISTS(HttpStatus.BAD_REQUEST, "User already exists"),
        REGISTRATION_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "Registration failed");

        private final String message;
        private final HttpStatusCode statusCode;

        RegisterStatus(HttpStatusCode statusCode, String message) {
            this.message = message;
            this.statusCode = statusCode; 
        }

        public String getMessage() {
            return this.message;
        }

        public HttpStatusCode getStatusCode(){
            return this.statusCode; 
        }
    }

    public enum LoginStatus {
        SUCCESS("Login Successful", HttpStatus.ACCEPTED),
        USER_NOT_FOUND("User not found", HttpStatus.NOT_FOUND),
        INVALID_CREDENTIALS("Invalid credentials", HttpStatus.BAD_REQUEST);

        private final String message;
        private final HttpStatusCode statusCode; 

        LoginStatus(String message, HttpStatusCode statusCode) {
            this.message = message;
            this.statusCode = statusCode; 
        }

        public String getMessage() {
            return this.message;
        }

        public HttpStatusCode getStatusCode(){
            return this.statusCode; 
        }
    }
}

package com.sanjay.response;

public class AuthResponse {

    private String jwt;
    private String message;



    public AuthResponse(String jwt, String message) {
        this.jwt = jwt;
        this.message = message;
    }
}

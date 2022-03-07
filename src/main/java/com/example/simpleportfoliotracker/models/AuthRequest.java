package com.example.simpleportfoliotracker.models;

public class AuthRequest {
    private String loginUsername;
    private String loginPassword;

    public AuthRequest() {
    }

    public AuthRequest(String loginUsername, String loginPassword) {
        this.loginUsername = loginUsername;
        this.loginPassword = loginPassword;
    }

    public String getLoginUsername() {
        return loginUsername;
    }
    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }
    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
}

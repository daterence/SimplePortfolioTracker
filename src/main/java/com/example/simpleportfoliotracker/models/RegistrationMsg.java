package com.example.simpleportfoliotracker.models;

public class RegistrationMsg {
    private String message;

    public RegistrationMsg() {
    }

    public RegistrationMsg(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

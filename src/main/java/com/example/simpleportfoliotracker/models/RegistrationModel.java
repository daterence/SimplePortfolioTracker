package com.example.simpleportfoliotracker.models;

public class RegistrationModel {
    private String registerEmail;
    private String registerUsername;
    private String registerPassword;


    public String getRegisterEmail() {
        return registerEmail;
    }
    public void setRegisterEmail(String registerEmail) {
        this.registerEmail = registerEmail;
    }

    public String getRegisterUsername() {
        return registerUsername;
    }
    public void setRegisterUsername(String registerUsername) {
        this.registerUsername = registerUsername;
    }

    public String getRegisterPassword() {
        return registerPassword;
    }
    public void setRegisterPassword(String registerPassword) {
        this.registerPassword = registerPassword;
    }
    public RegistrationModel() {
    }

    public RegistrationModel(String registerEmail, String registerUsername, String registerPassword, String first_name, String last_name) {
        this.registerEmail = registerEmail;
        this.registerUsername = registerUsername;
        this.registerPassword = registerPassword;
    }

    @Override
    public String toString() {
        return "RegistrationModel{" +
                "email='" + registerEmail + '\'' +
                ", username='" + registerUsername + '\'' +
                ", password='" + registerPassword + '\'' +
                '}';
    }
}

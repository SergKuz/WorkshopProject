package com.example.sergei.workshopproject.model;

public class User {


    private String username = "User";
    private String company = "Google";
    public boolean isContact;

    public User(int i, boolean isContact) {
        this.username = this.username.concat(String.valueOf(i));
        this.isContact = isContact;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}

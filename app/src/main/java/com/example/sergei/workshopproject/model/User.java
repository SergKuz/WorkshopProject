package com.example.sergei.workshopproject.model;

public class User {

    private String username;
    private String company;
    public boolean isContact;

    public User(String username, String company, boolean isContact) {
        this.username = username;
        this.company = company;
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

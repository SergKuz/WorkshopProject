package com.example.sergei.workshopproject.model;

public class Rooms {

    private String username;
    private String company;

    public Rooms(String username, String company) {
        this.username = username;
        this.company = company;
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

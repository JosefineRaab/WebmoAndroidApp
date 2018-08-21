package com.example.josieraab.webmoandroidapp;

public class User {

    private String username;
    private String password;
    private boolean isAdmin = false;

    public User(String username, String password) {
        this.username = username;
        this.password= password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

}

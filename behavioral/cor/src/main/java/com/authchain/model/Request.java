package com.authchain.model;

public class Request {
    public String email;
    public String password;
    public boolean userExists;
    public boolean hasAdminRole;

    public Request(String email, String password, boolean userExists, boolean hasAdminRole) {
        this.email = email;
        this.password = password;
        this.userExists = userExists;
        this.hasAdminRole = hasAdminRole;
    }
}
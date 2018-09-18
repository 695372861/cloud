package com.lsx.myoauth2.entity;

public class Account {
    private String name;
    private String password;
    private String Roles;

    public Account() {
    }

    public Account(String name, String password, String roles) {
        this.name = name;
        this.password = password;
        Roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return Roles;
    }

    public void setRoles(String roles) {
        Roles = roles;
    }
}

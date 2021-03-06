package com.rateThatFramework.model;

import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by hanne_000 on 26.04.2016.
 */
public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private int admin;

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.domain;

import java.util.UUID;
import se.nackademin.session.IPersistable;

/**
 *
 * Created by Grupp 7
 */
public class User implements IPersistable {

    private String id;
    private String userName;
    private String password;
    private String email;
    private boolean active;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String getId() {
        return id;
    }

    public User() {
        id = UUID.randomUUID().toString();
    }
    

    // Getters and setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String newUserName) {
        this.userName = newUserName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
}

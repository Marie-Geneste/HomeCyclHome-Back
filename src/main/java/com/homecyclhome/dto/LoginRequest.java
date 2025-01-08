package com.homecyclhome.dto;


public class LoginRequest {
    private String mail;
    private String password;

    // Getter pour mail
    public String getMail() {
        return mail;
    }

    // Setter pour mail
    public void setMail(String mail) {
        this.mail = mail;
    }

    // Getter pour password
    public String getPassword() {
        return password;
    }

    // Setter pour password
    public void setPassword(String password) {
        this.password = password;
    }
}

package com.demo181108.userdemo.domain;

public class User {

    private String id;
    private String username;
    private String password;
    private String email;
    private int authority;

    public User() {
    }

    public User(String id, String username, String password, String email, int authority) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.authority = authority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    @Override
    public String
    toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", authority=" + authority +
                '}';
    }
}

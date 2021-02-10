package com.frja.wifilocation.model;

public class User {
    private String userId;

    private String userName;

    private Integer userAuthority;

    private String userPassword;

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getUserAuthority() {
        return userAuthority;
    }

    public void setUserAuthority(Integer userAuthority) {
        this.userAuthority = userAuthority;
    }
}
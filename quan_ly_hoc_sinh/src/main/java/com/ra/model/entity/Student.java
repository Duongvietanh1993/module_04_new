package com.ra.model.entity;

import java.util.Date;

public class Student {
    private int userId;
    private String userName;
    private String userEmail;
    private java.sql.Date userBirthday;
    private String userAddress;

    public Student() {
    }

    public Student(int userId, String userName, String userEmail, java.sql.Date userBirthday, String userAddress) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userBirthday = userBirthday;
        this.userAddress = userAddress;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public java.sql.Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(java.sql.Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}

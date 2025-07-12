package com.rm.useraccount.Models;

public class User {
    private int UserId;
    private String UserName;
    private String Address;
    private Account account;

    public User() {
    }

    public User(int UserId, String UserName, String Address, Account account) {
        this.UserId = UserId;
        this.UserName = UserName;
        this.Address = Address;
        this.account = account;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", UserName='" + UserName + '\'' +
                ", Address='" + Address + '\'' +
                ", account=" + account.toString() +
                '}';
    }
}

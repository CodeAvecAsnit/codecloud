package com.labwork.jspjava.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private int userId;
    private String firstName;
    private String lastname;
    private double balance;

    public User(int userId, String firstName, String lastname, double balance) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastname = lastname;
        this.balance = balance;
    }

    public User(){}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static User mapFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastname(rs.getString("last_name"));
        user.setBalance(rs.getFloat("balance"));
        return user;
    }
}

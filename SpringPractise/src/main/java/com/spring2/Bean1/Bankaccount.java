package com.spring2.Bean1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Component
@Scope("prototype")
public class Bankaccount {

    @Value("23081031")
    private String accountNumber;
    @Value("45000.09")
    private double balance;
    @Value("Asnit Bakhati")
    private String UserName;

    @Autowired
    private Vehicle vehicle;

    public Bankaccount() {}

    public Bankaccount(String accountNumber, double balance, String UserName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.UserName = UserName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Bankaccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", UserName='" + UserName + '\'' +
                ", vehicle=" + vehicle.toString() +
                '}';
    }
}

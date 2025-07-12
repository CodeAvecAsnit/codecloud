package com.rm.useraccount.Models;

public class Account {
    private int AccountId;
    private int EncodedPassCode;
    private String EmailAddress;

    public Account() {
    }

    public Account(int accountId, int encodedPassCode, String emailAddress) {
        this.AccountId = accountId;
        this.EncodedPassCode = encodedPassCode;
        this.EmailAddress = emailAddress;
    }

    public int getAccountId() {
        return AccountId;
    }

    public void setAccountId(int accountId) {
        AccountId = accountId;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public int getEncodedPassCode() {
        return EncodedPassCode;
    }

    public void setEncodedPassCode(int encodedPassCode) {
        EncodedPassCode = encodedPassCode;
    }

    @Override
    public String toString() {
        return "Account{" + "AccountId=" + AccountId + ", EncodedPassCode=" + EncodedPassCode;
    }
}

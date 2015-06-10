package com.softwareengineering.accountmanager.model.data;

/**
 * Created by kehanyang on 15/6/7.
 */
public class Balance {

    private String accountName;

    private double balance;

    public Balance() {

    }

    public Balance(String accountName, double balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

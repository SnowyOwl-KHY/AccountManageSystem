package com.softwareengineering.accountmanager.model.data;

/**
 * Created by kehanyang on 15/6/15.
 */
public class InactiveUser {

    String accountName = "";

    String password = "";

    String registerId = "";

    public InactiveUser() {
    }

    public InactiveUser(String accountName, String password, String registerId) {
        this.accountName = accountName;
        this.password = password;
        this.registerId = registerId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }
}

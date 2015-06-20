package com.softwareengineering.accountmanager.model.data;

/**
 * Created by kehanyang on 15/6/20.
 */
public class ResetPassword {

    private String accountName = "";

    private String registerId = "";

    public ResetPassword() {
    }

    public ResetPassword(String accountName, String registerId) {
        this.accountName = accountName;
        this.registerId = registerId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }
}

package com.softwareengineering.accountmanager.model.data;

/**
 * Created by kehanyang on 15/6/7.
 */
public class SecurityInformation {

    private String accountName;

    private String password;

    private String payPassword;

    public SecurityInformation() {

    }

    public SecurityInformation(String accountName, String password, String payPassword) {
        this.accountName = accountName;
        this.password = password;
        this.payPassword = payPassword;
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

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }
}

package com.softwareengineering.accountmanager.model.data;

/**
 * Created by kehanyang on 15/5/31.
 */
public class CommonInformation {

    private String accountName;

    private String name;

    private String telephone;

    public CommonInformation(String accountName, String name, String telephone) {
        this.accountName = accountName;
        this.name = name;
        this.telephone = telephone;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}

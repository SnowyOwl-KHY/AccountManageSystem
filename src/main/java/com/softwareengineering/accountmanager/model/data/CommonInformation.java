package com.softwareengineering.accountmanager.model.data;

/**
 * Created by kehanyang on 15/5/31.
 */
public class CommonInformation {

    private String accountName = "";

    private String realName = "";

    private String telephone = "";

    public CommonInformation() {
    }

    public CommonInformation(String accountName) {
        this.accountName = accountName;
    }

    public CommonInformation(String accountName, String realName, String telephone) {
        this.accountName = accountName;
        this.realName = realName;
        this.telephone = telephone;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}

package com.softwareengineering.accountmanager.model.data;

/**
 * Created by kehanyang on 15/5/31.
 */
public class CommonInformation {

    private String accountName = "";

    private String nickname = "";

    private String realName = "";

    private String country = "";

    private String birthday = "";

    private String phone = "";

    private String address = "";

    private String text = "";

    private String postcode = "";

    private String gender = "";

    private boolean isDirty = false;

    public boolean isDirty() {
        return isDirty;
    }

    public CommonInformation() {
    }

    public CommonInformation(String accountName) {
        this.accountName = accountName;
    }

    public CommonInformation(String accountName, String nickname, String realName, String country, String birthday, String phone, String address, String text, String postcode, String gender) {
        this.accountName = accountName;
        this.nickname = nickname;
        this.realName = realName;
        this.country = country;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
        this.text = text;
        this.postcode = postcode;
        this.gender = gender;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
        this.isDirty = true;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
        this.isDirty = true;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
        this.isDirty = true;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
        this.isDirty = true;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        this.isDirty = true;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        this.isDirty = true;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        this.isDirty = true;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
        this.isDirty = true;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        this.isDirty = true;
    }
}

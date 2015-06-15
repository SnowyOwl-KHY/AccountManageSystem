package com.softwareengineering.accountmanager.model.data;

import java.util.List;

/**
 * Created by kehanyang on 15/5/31.
 */
public class Account {

    private String accountName = null;

    private CommonInformation commonInformation = null;

    private Balance balance = null;

    // 暂时不用
    private List<PurchaseRecord> purchaseRecordList = null;

    private Account() {
    }

    public Account(String accountName) {
        this.accountName = accountName;
    }

    public Account(String accountName, CommonInformation commonInformation, Balance balance, List<PurchaseRecord> purchaseRecordList) {
        this.accountName = accountName;
        this.commonInformation = commonInformation;
        this.balance = balance;
        this.purchaseRecordList = purchaseRecordList;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public CommonInformation getCommonInformation() {
        return commonInformation;
    }

    public void setCommonInformation(CommonInformation commonInformation) {
        this.commonInformation = commonInformation;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public List<PurchaseRecord> getPurchaseRecordList() {
        return purchaseRecordList;
    }

    public void setPurchaseRecordList(List<PurchaseRecord> purchaseRecordList) {
        this.purchaseRecordList = purchaseRecordList;
    }

    public void addNewPurchaseRecord(PurchaseRecord purchaseRecord) {
        this.purchaseRecordList.add(purchaseRecord);
    }
}

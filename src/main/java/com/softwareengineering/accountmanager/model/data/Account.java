package com.softwareengineering.accountmanager.model.data;

import java.util.Set;

/**
 * Created by kehanyang on 15/5/31.
 */
public class Account {

    private String accountName = null;

    private CommonInformation commonInformation = null;

    private Balance balance;

    private Set<PurchaseRecord> purchaseRecordSet;

    private Account() {
    }

    public Account(String accountName) {
        this.accountName = accountName;
    }

    public Account(String accountName, CommonInformation commonInformation, Balance balance, Set<PurchaseRecord> purchaseRecordSet) {
        this.accountName = accountName;
        this.commonInformation = commonInformation;
        this.balance = balance;
        this.purchaseRecordSet = purchaseRecordSet;
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

    public Set<PurchaseRecord> getPurchaseRecordSet() {
        return purchaseRecordSet;
    }

    public void setPurchaseRecordSet(Set<PurchaseRecord> purchaseRecordSet) {
        this.purchaseRecordSet = purchaseRecordSet;
    }

    public void addNewPurchaseRecord(PurchaseRecord purchaseRecord) {
        this.purchaseRecordSet.add(purchaseRecord);
    }
}

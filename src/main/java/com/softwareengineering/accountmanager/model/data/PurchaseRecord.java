package com.softwareengineering.accountmanager.model.data;

import java.util.Date;

/**
 * Created by kehanyang on 15/5/31.
 */
public class PurchaseRecord implements Comparable {

    private long id;

    private String accountName;

    private Date purchaseDate;

    private long merchandiseId;

    private double money;

    public PurchaseRecord() {
    }

    public PurchaseRecord(String accountName, Date purchaseDate, long merchandiseId, double money) {
        this.accountName = accountName;
        this.purchaseDate = purchaseDate;
        this.merchandiseId = merchandiseId;
        this.money = money;
    }

    public PurchaseRecord(long id, String accountName, Date purchaseDate, long merchandiseId, double money) {
        this.id = id;
        this.accountName = accountName;
        this.purchaseDate = purchaseDate;
        this.merchandiseId = merchandiseId;
        this.money = money;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public long getMerchandiseId() {
        return merchandiseId;
    }

    public void setMerchandiseId(long merchandiseId) {
        this.merchandiseId = merchandiseId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int compareTo(Object o) {
        PurchaseRecord another = (PurchaseRecord)o;
        if (another.purchaseDate.equals(this.purchaseDate)) {
            return (int)(this.id - another.id);
        }
        else {
            return this.purchaseDate.compareTo(another.purchaseDate);
        }
    }

    @Override
    public String toString() {
        return "[id: " + id
                + ", accountName: " + accountName
                + ", purchaseDate: " + purchaseDate
                + ", merchandiseId: " + merchandiseId
                + ", money:" + money + "]";
    }
}

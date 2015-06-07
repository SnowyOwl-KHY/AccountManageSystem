package model.data;

import java.util.Date;

/**
 * Created by kehanyang on 15/5/31.
 */
public class PurchaseRecord implements Comparable {

    private int id;

    private Date date;

    private String merchandise = "";

    private double money;

    public PurchaseRecord(int id, Date date, String merchandise, double money) {
        this.id = id;
        this.date = date;
        this.merchandise = merchandise;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMerchandise() {
        return merchandise;
    }

    public void setMerchandise(String merchandise) {
        this.merchandise = merchandise;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int compareTo(Object o) {
        PurchaseRecord another = (PurchaseRecord)o;
        if (another.date.equals(this.date)) {
            return this.id - another.id;
        }
        else {
            return this.date.compareTo(another.date);
        }
    }
}

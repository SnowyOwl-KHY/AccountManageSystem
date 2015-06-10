package com.softwareengineering.accountmanager.model.tablemanager;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.softwareengineering.accountmanager.model.data.PurchaseRecord;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by kehanyang on 15/6/9.
 */
public class PurchaseRecordManager {

    private SqlMapClient sqlMapClient;

    public PurchaseRecordManager(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public boolean add(PurchaseRecord purchaseRecord) {
        try {
            sqlMapClient.insert("insertPurchaseRecord", purchaseRecord);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public PurchaseRecord queryById(long id) {
        try {
            return (PurchaseRecord)sqlMapClient.queryForObject("selectPurchaseRecordById", id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<PurchaseRecord> queryByAccountName(String accountName) {
        try {
            return (List<PurchaseRecord>)sqlMapClient.queryForList("selectPurchaseRecordByAccountName", accountName);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean update(PurchaseRecord purchaseRecord) {
        try {
            sqlMapClient.update("updatePurchaseRecord", purchaseRecord);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteById(long id) {
        try {
            sqlMapClient.delete("deletePurchaseRecordById", id);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteByAccountName(String accountName) {
        try {
            sqlMapClient.delete("deletePurchaseRecordByAccountName", accountName);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

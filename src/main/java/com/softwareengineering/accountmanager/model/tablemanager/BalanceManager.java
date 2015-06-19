package com.softwareengineering.accountmanager.model.tablemanager;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.softwareengineering.accountmanager.model.data.Balance;

import java.sql.SQLException;

/**
 * Created by kehanyang on 15/6/7.
 */
public class BalanceManager {

    private SqlMapClient sqlMapClient;

    public BalanceManager(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public boolean addBalance(String accountName) {
        try {
            sqlMapClient.insert("insertBalance", new Balance(accountName, 0));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public double queryBalance(String accountName) {
        try {
            return (Double)sqlMapClient.queryForObject("selectBalance", accountName);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean updateBalance(Balance balance) {
        try {
            sqlMapClient.update("updateBalance", balance);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean recharge(String accountName, double money) {
        try {
            sqlMapClient.update("rechargeBalance", new Balance(accountName, money));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteBalance(String accountName) {
        try {
            sqlMapClient.delete("deleteBalance", accountName);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

package com.softwareengineering.accountmanager.model.tablemanager;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.softwareengineering.accountmanager.model.data.Balance;
import com.softwareengineering.accountmanager.model.data.ResetPassword;

import java.sql.SQLException;

/**
 * Created by kehanyang on 15/6/20.
 */
public class ResetPasswordManager {

    private SqlMapClient sqlMapClient;

    public ResetPasswordManager(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    private boolean add(ResetPassword resetPassword) {
        try {
            sqlMapClient.insert("insertResetPassword", resetPassword);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean add(String accountName, String registerId) {
        return add(new ResetPassword(accountName, registerId));
    }

    public boolean remove(String accountName) {
        try {
            sqlMapClient.delete("deleteResetPassword", accountName);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkRegisterId(String accountName, String registerId) {
        try {
            Object result =  sqlMapClient.queryForObject("selectResetPassword", new ResetPassword(accountName, registerId));
            return result != null;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

package com.softwareengineering.accountmanager.model.tablemanager;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.softwareengineering.accountmanager.model.data.InactiveUser;

import java.sql.SQLException;

/**
 * Created by kehanyang on 15/6/15.
 */
public class InactiveUserManager {

    private SqlMapClient sqlMapClient;

    public InactiveUserManager(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public boolean addUser(String accountName, String password, String registerId) {
        try {
            sqlMapClient.insert("insertInactiveUser", new InactiveUser(accountName, password, registerId));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeUser(String accountName) {
        try {
            sqlMapClient.delete("deleteInactiveUser", accountName);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public InactiveUser checkRegisterId(String accountName, String registerId) {
        try {
            InactiveUser queryResult = (InactiveUser)sqlMapClient.queryForObject("selectInactiveUserByAccountNameAndRegisterId", new InactiveUser(accountName, "", registerId));
            return queryResult;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean exitUser(String accountName) {
        try {
            Object queryResult = sqlMapClient.queryForObject("selectInactiveUserByAccountName", accountName);
            return queryResult != null;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

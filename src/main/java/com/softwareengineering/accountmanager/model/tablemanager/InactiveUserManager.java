package com.softwareengineering.accountmanager.model.tablemanager;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.softwareengineering.accountmanager.model.data.InactiveUser;

import java.sql.SQLException;
import java.util.List;

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

    public List<InactiveUser> checkRegisterId(String accountName, String registerId) {
        try {
            List<InactiveUser> queryResult = (List<InactiveUser>)sqlMapClient.queryForList("selectInactiveUserByAccountNameAndRegisterId", new InactiveUser(accountName, "", registerId));
            return queryResult;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

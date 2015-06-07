package com.softwareengineering.accountmanager.model.tablemanager;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.softwareengineering.accountmanager.model.data.SecurityInformation;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by kehanyang on 15/6/7.
 */
public class SecurityInformationManager {

    private SqlMapClient sqlMapClient;

    public SecurityInformationManager(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public boolean existUser(String accountName) {
        try {
            List<SecurityInformation> queryResult = sqlMapClient.queryForList("selectSecurityInformation", new SecurityInformation(accountName, "%", "%"));
            return queryResult.size() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    public boolean checkPassword(String accountName, String passwordCipher) {
        try {
            List<SecurityInformation> queryResult = sqlMapClient.queryForList("selectSecurityInformation", new SecurityInformation(accountName, passwordCipher, "%"));
            return queryResult.size() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkPayPassword(String accountName, String payPasswordCipher) {
        try {
            List<SecurityInformation> queryResult = sqlMapClient.queryForList("selectSecurityInformation", new SecurityInformation(accountName, "%", payPasswordCipher));
            return queryResult.size() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addSecurityInformation(String accountName, String passwordCipher, String payPasswordCipher) {
        try {
            sqlMapClient.insert("insertSecurityInformation", new SecurityInformation(accountName, passwordCipher, payPasswordCipher));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean changePassword(String accountName, String passwordCipher) {
        try {
            sqlMapClient.update("updatePassword", new SecurityInformation(accountName, passwordCipher, ""));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean changePayPassword(String accountName, String payPasswordCipher) {
        try {
            sqlMapClient.update("updatePayPassword", new SecurityInformation(accountName, "", payPasswordCipher));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteSecurityInformation(String accountName) {
        try {
            sqlMapClient.update("deleteSecurityInformation", accountName);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}

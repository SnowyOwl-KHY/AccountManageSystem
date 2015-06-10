package com.softwareengineering.accountmanager.model.tablemanager;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.softwareengineering.accountmanager.model.data.CommonInformation;

import java.sql.SQLException;

/**
 * Created by kehanyang on 15/6/9.
 */
public class CommonInformationManager {

    private SqlMapClient sqlMapClient;

    public CommonInformationManager(SqlMapClient sqlMapClient) {
        this.sqlMapClient = sqlMapClient;
    }

    public CommonInformation query(String accountName) {
        try {
            return (CommonInformation)sqlMapClient.queryForObject("selectCommonInformation", accountName);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean add(String accountName) {
        return add(new CommonInformation(accountName));
    }

    public boolean add(CommonInformation commonInformation) {
        try {
            sqlMapClient.insert("insertCommonInformation", commonInformation);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(CommonInformation commonInformation) {
        try {
            sqlMapClient.update("updateCommonInformation", commonInformation);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String accountName) {
        try {
            sqlMapClient.delete("deleteCommonInformation", accountName);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

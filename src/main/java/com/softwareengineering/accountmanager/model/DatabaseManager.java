package com.softwareengineering.accountmanager.model;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.softwareengineering.accountmanager.model.data.*;
import com.softwareengineering.accountmanager.model.tablemanager.*;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.Reader;
import java.sql.*;
import java.util.List;

/**
 * Created by kehanyang on 15/5/31.
 */
public class DatabaseManager {

    private SqlMapClient sqlMapClient;

    private SecurityInformationManager securityInformationManager;

    private BalanceManager balanceManager;

    private CommonInformationManager commonInformationManager;

    private PurchaseRecordManager purchaseRecordManager;

    private InactiveUserManager inactiveUserManager;

    public DatabaseManager() {
        super();
        try {
            Reader reader = Resources.getResourceAsReader("mybatis/config.xml");
            sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
            reader.close();
            securityInformationManager = new SecurityInformationManager(sqlMapClient);
            balanceManager = new BalanceManager(sqlMapClient);
            commonInformationManager = new CommonInformationManager(sqlMapClient);
            purchaseRecordManager = new PurchaseRecordManager(sqlMapClient);
            inactiveUserManager = new InactiveUserManager(sqlMapClient);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean existUser(String accountName) {
        return securityInformationManager.existUser(accountName) || inactiveUserManager.exitUser(accountName);
    }

    public boolean checkRegisterId(String accountName, String registerId) {
        return inactiveUserManager.checkRegisterId(accountName, registerId) != null;
    }

    public boolean checkPassword(String accountName, String password) {
        return securityInformationManager.checkPassword(accountName, password);
    }

    public boolean checkPayPassword(String accountName, String payPassword) {
        return securityInformationManager.checkPayPassword(accountName, payPassword);
    }

    public boolean addUser(String accountName, String password, String registerId) {
        return inactiveUserManager.addUser(accountName, password, registerId);
    }

    public boolean activateUser(String accountName, String registerId) {
        InactiveUser inactiveUser = inactiveUserManager.checkRegisterId(accountName, registerId);
        if (inactiveUser == null) {
            return false;
        }
        if (inactiveUserManager.removeUser(accountName) == false) {
            return false;
        }
        String password = inactiveUser.getPassword();
        if (securityInformationManager.addSecurityInformation(accountName, password, password) == false) {
            return false;
        }
        if (balanceManager.addBalance(accountName) == false) {
            return false;
        }
        if (commonInformationManager.add(accountName) == false) {
            return false;
        }
        return true;
    }

    public boolean changePassword(String accountName, String password) {
        return securityInformationManager.changePassword(accountName, password);
    }

    public boolean changePayPassword(String accountName, String payPassword) {
        return securityInformationManager.changePayPassword(accountName, payPassword);
    }

    public boolean deleteUser(String accountName) {
        boolean result = true;
        result = result && securityInformationManager.deleteSecurityInformation(accountName);
        result = result && balanceManager.deleteBalance(accountName);
        result = result && commonInformationManager.delete(accountName);
        result = result && purchaseRecordManager.deleteByAccountName(accountName);
        return result;
    }

    public double queryBalance(String accountName) {
        return balanceManager.queryBalance(accountName);
    }

    public boolean updateBalance(String accountName, double balance) {
        return this.updateBalance(new Balance(accountName, balance));
    }

    public boolean updateBalance(Balance balance) {
        return balanceManager.updateBalance(balance);
    }

    public boolean recharge(String accountName, double money) {
        return balanceManager.recharge(accountName, money);
    }

    public CommonInformation queryCommonInformation(String accountName) {
        return commonInformationManager.query(accountName);
    }

    public boolean updateCommonInformation(CommonInformation commonInformation) {
        return commonInformationManager.update(commonInformation);
    }

    public boolean addPurchaseRecord(PurchaseRecord purchaseRecord) {
        return purchaseRecordManager.add(purchaseRecord);
    }

    public boolean updatePurchaseRecord(PurchaseRecord purchaseRecord) {
        return purchaseRecordManager.update(purchaseRecord);
    }

    public PurchaseRecord queryPurchaseRecordById(long id) {
        return purchaseRecordManager.queryById(id);
    }

    public List<PurchaseRecord> queryPurchaseRecordByAccountName(String accountName) {
        return purchaseRecordManager.queryByAccountName(accountName);
    }

    public boolean deletePurchaseRecordById(long id) {
        return purchaseRecordManager.deleteById(id);
    }

    public static void main(String[] args) {
        String out = "";
        CommonInformation info = new CommonInformation("root");
        info.setNickname("test");
        out += " " + new DatabaseManager().existUser("user2");
        System.out.println(out);
//        out += " " + new DatabaseManager().purchaseRecordManager.deleteByAccountName("root");
//        System.out.println(out);
//        List<PurchaseRecord> purchaseRecords = new DatabaseManager().purchaseRecordManager.queryByAccountName("root");
//        System.out.println(purchaseRecords);
    }
}
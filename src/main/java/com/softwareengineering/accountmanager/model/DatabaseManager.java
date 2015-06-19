package com.softwareengineering.accountmanager.model;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.softwareengineering.accountmanager.model.data.Balance;
import com.softwareengineering.accountmanager.model.data.CommonInformation;
import com.softwareengineering.accountmanager.model.data.PurchaseRecord;
import com.softwareengineering.accountmanager.model.data.SecurityInformation;
import com.softwareengineering.accountmanager.model.tablemanager.BalanceManager;
import com.softwareengineering.accountmanager.model.tablemanager.CommonInformationManager;
import com.softwareengineering.accountmanager.model.tablemanager.PurchaseRecordManager;
import com.softwareengineering.accountmanager.model.tablemanager.SecurityInformationManager;
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean existUser(String accountName) {
        return securityInformationManager.existUser(accountName);
    }

    public boolean checkPassword(String accountName, String password) {
        return securityInformationManager.checkPassword(accountName, password);
    }

    public boolean checkPayPassword(String accountName, String payPassword) {
        return securityInformationManager.checkPayPassword(accountName, payPassword);
    }

    public boolean addUser(String accountName, String password, String payPassword) {
        boolean result = true;
        result = result && securityInformationManager.addSecurityInformation(accountName, password, payPassword);
        result = result && balanceManager.addBalance(accountName);
        result = result && commonInformationManager.add(accountName);
        return result;
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
        out += " " + new DatabaseManager().commonInformationManager.update(info);
        System.out.println(out);
//        out += " " + new DatabaseManager().purchaseRecordManager.deleteByAccountName("root");
//        System.out.println(out);
//        List<PurchaseRecord> purchaseRecords = new DatabaseManager().purchaseRecordManager.queryByAccountName("root");
//        System.out.println(purchaseRecords);
    }
}
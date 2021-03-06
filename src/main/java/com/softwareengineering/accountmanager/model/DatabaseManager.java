package com.softwareengineering.accountmanager.model;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.softwareengineering.accountmanager.model.cache.LRUCache;
import com.softwareengineering.accountmanager.model.data.Balance;
import com.softwareengineering.accountmanager.model.data.CommonInformation;
import com.softwareengineering.accountmanager.model.data.InactiveUser;
import com.softwareengineering.accountmanager.model.data.PurchaseRecord;
import com.softwareengineering.accountmanager.model.tablemanager.*;
import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
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

    private ResetPasswordManager resetPasswordManager;

    private LRUCache cache;

    private static boolean initialFlag = false;

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
            resetPasswordManager = new ResetPasswordManager(sqlMapClient);
            cache = LRUCache.getLRUCache();
            if (initialFlag == false) {
                sqlMapClient.update("createSecurityInformation");
                sqlMapClient.update("createBalance");
                sqlMapClient.update("createCommonInformation");
                sqlMapClient.update("createPurchaseRecord");
                sqlMapClient.update("createInactiveUser");
                sqlMapClient.update("createResetPassword");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean existUser(String accountName) {
        return securityInformationManager.existUser(accountName);
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
        if (existUser(accountName)) {
            return false;
        }
        return inactiveUserManager.addUser(accountName, password, registerId);
    }

    public boolean activateUser(String accountName, String registerId) {
        List<InactiveUser> inactiveUsers = inactiveUserManager.checkRegisterId(accountName, registerId);
        if (inactiveUsers == null || inactiveUsers.size() == 0) {
            return false;
        }
        if (inactiveUserManager.removeUser(accountName) == false) {
            return false;
        }
        String password = inactiveUsers.get(0).getPassword();
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
        if (securityInformationManager.deleteSecurityInformation(accountName) == false) {
            return false;
        }
        if (balanceManager.deleteBalance(accountName) == false) {
            return false;
        }
        if (commonInformationManager.delete(accountName) == false) {
            return false;
        }
        if (purchaseRecordManager.deleteByAccountName(accountName) == false) {
            return false;
        }
        return true;
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

    public boolean prepareResetPassword(String accountName, String registerId) {
        if (!existUser(accountName)) {
            return false;
        }
        return resetPasswordManager.add(accountName, registerId);
    }

    public boolean resetPassword(String accountName, String registerId, String newPassword) {
        if (resetPasswordManager.checkRegisterId(accountName, registerId) == false) {
            return false;
        } else {
            if (resetPasswordManager.remove(accountName) == false) {
                return false;
            }
            if (securityInformationManager.changePassword(accountName, newPassword) == false) {
                return false;
            }
            if (securityInformationManager.changePayPassword(accountName, newPassword) == false) {
                return false;
            }
            return true;
        }
    }

//    public static void main(String[] args) {
//        String out = "";
//        DatabaseManager databaseManager = new DatabaseManager();
//        out += databaseManager.prepareResetPassword("user1", "1");
//        out += databaseManager.resetPassword("user1", "1", "1234");
//        System.out.println(out);
//        out += " " + new DatabaseManager().purchaseRecordManager.deleteByAccountName("root");
//        System.out.println(out);
//        List<PurchaseRecord> purchaseRecords = new DatabaseManager().purchaseRecordManager.queryByAccountName("root");
//        System.out.println(purchaseRecords);
//    }
}
package model;

import java.sql.*;

/**
 * Created by kehanyang on 15/5/31.
 */
public class DatabaseManager {

    private static DatabaseManager databaseManager = null;

    private Connection connection;

    // 单例模式
    public static DatabaseManager getDatabaseManager() {
        if (databaseManager == null) {
            databaseManager = new DatabaseManager();
        }
        return databaseManager;
    }

    private DatabaseManager() {
        super();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/account_development", "development", "123");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void release() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        databaseManager = null;
    }

    public boolean existUser(String accountName) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM security_information WHERE account_name = ?");
            preparedStatement.setString(1, accountName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkPassword(String accountName, String passwordCipher) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM security_information WHERE account_name = ? AND password = ?");
            preparedStatement.setString(1, accountName);
            preparedStatement.setString(2, passwordCipher);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkPayPassword(String accountName, String payPasswordCipher) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM security_information WHERE account_name = ? AND pay_password = ?");
            preparedStatement.setString(1, accountName);
            preparedStatement.setString(2, payPasswordCipher);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addUser(String accountName, String passwordCipher, String payPasswordCipher) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO security_information(account_name, password, pay_password) VALUES (?, ?, ?)");
            preparedStatement.setString(1, accountName);
            preparedStatement.setString(2, passwordCipher);
            preparedStatement.setString(3, payPasswordCipher);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteUser(String accountName) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM security_information WHERE account_name = ?");
            preparedStatement.setString(1, accountName);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
package com.mycompany.app.database;

import java.sql.*;

public class JDBCNative {
    Connection c = null;

    public JDBCNative(){
        try{
            c = createConnection();
//            insertBankAccount("Saipul", "3123123");
            selectBankAccount();
            updateBankAccount("Jihan Pahira", "3123123");
            System.out.println("After update");
            selectBankAccount();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private Connection createConnection() throws SQLException{
        String dbName = "javatest";
        String username = "root";
        String password = "";
        int port = 3306;

        //jdbc:mysql://<host>:<port>/<dbName>
        StringBuffer sb = new StringBuffer("jdbc:mysql://localhost:")
                .append(port)
                .append("/")
                .append(dbName)
                .append("?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

        return DriverManager.getConnection(sb.toString(), username, password);
    }

    private int insertBankAccount(String ownerName, String accountNumber) throws SQLException {
        Statement stat = c.createStatement();
        StringBuffer sb = new StringBuffer("INSERT INTO bank_account (account_number, owner_name, saldo) VALUES ")
                .append("(")
                .append("'").append(accountNumber).append("'")
                .append(",")
                .append("'").append(ownerName).append("'")
                .append(",")
                .append("'").append(ownerName).append("'")
                .append(")");
        return stat.executeUpdate(sb.toString());
    }

    private void selectBankAccount() throws SQLException {
        Statement stat = c.createStatement();
        ResultSet resultSet = stat.executeQuery("SELECT id, account_number, owner_name FROM bank_account");
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String accountNumber = resultSet.getString("account_number");
            String ownerName = resultSet.getString("owner_name");

            System.out.printf("%d - %s - %s \n", id, accountNumber, ownerName);
        }
    }

    private int updateBankAccount(String ownerName, String accountNumber) throws SQLException {
        Statement stat = c.createStatement();
        StringBuffer sb = new StringBuffer("UPDATE bank_account SET ")
                .append("owner_name = '").append(ownerName).append("'")
                .append("where account_number = '").append(accountNumber).append("'");
        return stat.executeUpdate(sb.toString());
    }

    private String createTransferSQL(String accountNumber, double amount, boolean from){
        StringBuffer sb = new StringBuffer("UPDATE bank_account SET ")
                .append("saldo = saldo ").append(from ? "-" : "+").append(amount)
                .append("where account_number = '").append(accountNumber).append("'");
        return sb.toString();
    }

    private boolean transfer(String from, String to, double amount) throws SQLException {
        c.setAutoCommit(false);
        Statement stat = c.createStatement();
        String fromStr = createTransferSQL(from, amount, true);
        String toStr = createTransferSQL(to, amount, false);
        stat.executeUpdate(fromStr);
        stat.executeUpdate(toStr);
        c.commit();
        return true;
    }

    public static void main(String[] args){
        new JDBCNative();
    }
}

package com.mycompany.app.database;

import java.sql.*;

public class JDBCNative {
    Connection c = null;

    public JDBCNative(){
        try{
            c = createConnection();
//            insertBankAccount("kuhaku", "3123123");
//            selectBankAccount();
            updateBankAccount("Kuhaku", "3123123");
            System.out.println("After update");
            selectBankAccount();

              //add saldo
//            addSaldoAccount("3123124", 50000);
//            System.out.println("After update saldo");
//            selectBankAccount();

            //transfer
            transfer("3123124", "3123123", 4000);
            System.out.println("After transfer");
            selectBankAccount();

//            deleteInvalidAccountNumber();
//            System.out.println("After Delete");
//            selectBankAccount();

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
        StringBuffer sb = new StringBuffer("INSERT INTO bank_account (account_number, owner_name) VALUES ")
                .append("(")
                .append("'").append(accountNumber).append("'")
                .append(",")
                .append("'").append(ownerName).append("'")
                .append(")");
        return stat.executeUpdate(sb.toString());
    }

    private void selectBankAccount() throws SQLException {
        Statement stat = c.createStatement();
        ResultSet resultSet = stat.executeQuery("SELECT id, account_number, owner_name, saldo FROM bank_account");
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String accountNumber = resultSet.getString("account_number");
            String ownerName = resultSet.getString("owner_name");
            double saldo = resultSet.getDouble("saldo");

            System.out.printf("%d - %s - %s - %f \n", id, accountNumber, ownerName, saldo);
        }
    }

    private int updateBankAccount(String ownerName, String accountNumber) throws SQLException {
        Statement stat = c.createStatement();
        StringBuffer sb = new StringBuffer("UPDATE bank_account SET ")
                .append("owner_name = '").append(ownerName).append("'")
                .append("where account_number = '").append(accountNumber).append("'");
        return stat.executeUpdate(sb.toString());
    }

    private int deleteInvalidAccountNumber() throws SQLException {
        Statement stat = c.createStatement();
        StringBuffer sb = new StringBuffer("DELETE FROM bank_account WHERE account_number = 'null' ");
        return stat.executeUpdate(sb.toString());
    }

    private int addSaldoAccount(String accountNumber, double saldo) throws SQLException {
        Statement stat = c.createStatement();
        StringBuffer sb = new StringBuffer("UPDATE bank_account SET")
                .append(" saldo = '").append(saldo).append("'")
                .append(" WHERE account_number = '").append(accountNumber).append("'");
        System.out.println(sb);
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

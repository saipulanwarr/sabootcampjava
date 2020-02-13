package com.mycompany.app.database.exercise;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.sql.*;

public class Exercise {

    Connection c = null;

    public Exercise(){
        try{
            c = createConnection();
            mainMenu();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    private Connection createConnection() throws SQLException {
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
                .append("'").append(0).append("'")
                .append(")");
        return stat.executeUpdate(sb.toString());
    }

    private String insertHistory(String AccountNumber, String TransactionName, String TransactionDate, double Amount, String Note) throws SQLException{
        StringBuffer sb = new StringBuffer("INSERT INTO account_transaction (account_number, transaction_name, transaction_date, amount, note) VALUES ")
                .append("(")
                .append("'").append(AccountNumber).append("'")
                .append(",")
                .append("'").append(TransactionName).append("'")
                .append(",")
                .append("'").append(TransactionDate).append("'")
                .append(",")
                .append("'").append(Amount).append("'")
                .append(",")
                .append("'").append(Note).append("'")
                .append(")");
        return sb.toString();
    }

    private int addSaldoAccount(String accountNumber, double saldo) throws SQLException {
        Statement stat = c.createStatement();
        StringBuffer sb = new StringBuffer("UPDATE bank_account SET")
                .append(" saldo = '").append(saldo).append("'")
                .append(" WHERE account_number = '").append(accountNumber).append("'");
        return stat.executeUpdate(sb.toString());
    }

    private boolean getBankAccountByAccountNumber(String accountNumber) throws SQLException {
        Statement stat = c.createStatement();
        StringBuffer sb = new StringBuffer("SELECT * FROM bank_account")
                .append(" WHERE account_number = '").append(accountNumber).append("'");
        ResultSet resultSet = stat.executeQuery(String.valueOf(sb));
        if(!resultSet.next()){
            return true;
        }

        return false;
    }

    private String createTransferSQL(String accountNumber, double amount, boolean from){
        StringBuffer sb = new StringBuffer("UPDATE bank_account SET ")
                .append("saldo = saldo ").append(from ? "-" : "+").append(amount)
                .append("where account_number = '").append(accountNumber).append("'");
        return sb.toString();
    }

    private void selectBankAccount() throws SQLException {
        Statement stat = c.createStatement();
        ResultSet resultSet = stat.executeQuery("SELECT * FROM bank_account ORDER BY id DESC");
        System.out.println("No - Account Number - Owner Name - Saldo");
        int no = 1;
        while (resultSet.next()){
            String accountNumber = resultSet.getString("account_number");
            String ownerName = resultSet.getString("owner_name");
            double saldo = resultSet.getDouble("saldo");
            System.out.printf("%d - %s - %s - %f \n", no, accountNumber, ownerName, saldo);
            no++;
        }

        selectTransaction();
    }

    private void selectTransaction() throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.print("Do you want to see the transaction for the above account number ? ");
        String transaction = in.nextLine();
        System.out.print("Put Account Number : ");
        String accountNumber = in.nextLine();
        getBankAccountByAccountNumber(accountNumber);

        boolean checkAccount = getBankAccountByAccountNumber(accountNumber);
        if(!checkAccount){
            Statement stat = c.createStatement();
            StringBuffer sb = new StringBuffer("SELECT * FROM account_transaction")
                    .append(" WHERE account_number = '").append(accountNumber).append("'");
            ResultSet resultSet = stat.executeQuery(String.valueOf(sb));

            System.out.println("No - Date - Transaction - Note - Amount");
            int no = 1;
            while(resultSet.next()){
                String dateHistory = resultSet.getString("transaction_date");
                String transactionHistory = resultSet.getString("transaction_name");
                String note = resultSet.getString("note");
                double amount = resultSet.getDouble("amount");
                System.out.printf("%d - %s - %s - %s - %f \n", no, dateHistory, transactionHistory, note, amount);
                no++;
            }
        }
    }

    private boolean transfer(String from, String to, double amount) throws SQLException {
        String dateTime = getDateTime();
        c.setAutoCommit(false);
        Statement stat = c.createStatement();
        String fromStr = createTransferSQL(from, amount, true);
        String toStr = createTransferSQL(to, amount, false);
        stat.executeUpdate(fromStr);
        stat.executeUpdate(toStr);
        String addHistoryFrom = insertHistory(from, "S_TRANSFER", dateTime, amount, to);
        String addHistoryTo = insertHistory(to, "R_TRANSFER", dateTime, amount, from);
        stat.executeUpdate(addHistoryFrom);
        stat.executeUpdate(addHistoryTo);
        c.commit();
        return true;
    }

    private void registerBankAccount() throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.print("Owner Name : ");
        String ownerName = in.nextLine();
        System.out.print("Account Number : ");
        String accountNumber = in.nextLine();
        boolean checkAccount = getBankAccountByAccountNumber(accountNumber);
        if(checkAccount){
            insertBankAccount(ownerName, accountNumber);
            System.out.println("new "+accountNumber+" account has been created");
        }
    }

    private void putSaldo() throws SQLException {
        String dateTime = getDateTime();
        Statement stat = c.createStatement();
        Scanner in = new Scanner(System.in);
        System.out.print("Account Number : ");
        String accountNumber = in.nextLine();
        System.out.print("Amount : ");
        double amount = in.nextDouble();
        boolean checkAccount = getBankAccountByAccountNumber(accountNumber);
        if(!checkAccount){
            addSaldoAccount(accountNumber, amount);
            String addHistory = insertHistory(accountNumber, "KREDIT", dateTime, amount, "-");
            stat.executeUpdate(addHistory);
            System.out.println("Saldo "+accountNumber+" Amount = "+amount);
        }
    }

    private String getDateTime(){
        LocalDateTime dateHistory = LocalDateTime.now();
        DateTimeFormatter dateHistoryFormat = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");
        String formattedDate = dateHistory.format(dateHistoryFormat);
        return formattedDate;
    }

    private void mainTransfer() throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.print("Sender : ");
        String sender = in.nextLine();
        System.out.print("Receiver : ");
        String receiver = in.nextLine();
        System.out.print("Amount : ");
        double amount = in.nextDouble();
        transfer(sender, receiver, amount);
        System.out.println("Transfer Success");
    }

    private void mainMenu() throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.println("Please Select Command:");
        System.out.println("0 = exit");
        System.out.println("1 = register new bank account");
        System.out.println("2 = put saldo");
        System.out.println("3 = transfer");
        System.out.println("4 = show all bank account");
        System.out.print("Answer : ");
        int answer = in.nextInt();

        if(answer == 1){
            registerBankAccount();
        }else if(answer == 2){
            putSaldo();
        }else if(answer == 3){
            mainTransfer();
        }else if(answer == 4){
            selectBankAccount();
        }
    };

    public static void main(String[] args){
        new Exercise();
    }
}

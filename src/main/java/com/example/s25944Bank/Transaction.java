package com.example.s25944Bank;

public class Transaction {

    private int transactionID;
    private int userID;
    private TransactionStatus transactionStatus;
    private double amount;

    public Transaction(int transactionID, int userID, TransactionStatus transactionStatus, double amount) {
        this.transactionID = transactionID;
        this.userID = userID;
        this.transactionStatus = transactionStatus;
        this.amount = amount;
    }

    public int getUserID() {
        return userID;
    }

    public TransactionStatus getTransactionService() {
        return transactionStatus;
    }

    public double getAmount() {
        return amount;
    }

    public int getTransactionID() {
        return transactionID;
    }
}

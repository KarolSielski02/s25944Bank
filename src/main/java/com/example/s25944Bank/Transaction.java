package com.example.s25944Bank;

public class Transaction {

    private int transactionID;
    private int userID;
    private TransactionStatus transactionStatus;
    private double amount;
    private double saldoAfter;

    public Transaction(int transactionID, int userID, TransactionStatus transactionStatus, double amount, double saldoAfter) {
        this.transactionID = transactionID;
        this.userID = userID;
        this.transactionStatus = transactionStatus;
        this.amount = amount;
        this.saldoAfter = saldoAfter;
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

    public double getSaldoAfter() {
        return saldoAfter;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionID=" + transactionID +
                ", userID=" + userID +
                ", transactionStatus=" + transactionStatus +
                ", amount=" + amount +
                ", saldoAfter=" + saldoAfter +
                '}';
    }
}

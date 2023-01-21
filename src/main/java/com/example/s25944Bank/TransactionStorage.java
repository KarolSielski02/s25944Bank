package com.example.s25944Bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionStorage {

    List<Transaction> transactionList = new ArrayList<>();

    public TransactionStorage() {
        transactionList.add(new Transaction(0,0, TransactionStatus.ACCEPTED, 10, 110));
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }
}

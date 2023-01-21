package com.example.s25944Bank;

import org.springframework.stereotype.Component;

@Component
public class BankService {

    private final UserStorage userStorage;
    private final TransactionStorage transactionStorage;

    public BankService(UserStorage userStorage, TransactionStorage transactionStorage) {
        this.userStorage = userStorage;
        this.transactionStorage = transactionStorage;
    }

    public User createNewUser(int id, double saldo) {
        if (id <= 0 || saldo < 0) {
            return null;
        }
        if (findUserById(id) != null) {
            return null;
        }
        User user = new User(id, saldo);
        userStorage.getUserList().add(user);
        return user;
    }

    public User findUserById(int id) {
        for (User user : userStorage.getUserList()) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public Transaction transfer(int idOfUser, double amount) {
        if (idOfUser <= 0 || amount <= 0) {
            return null;
        }
        if (findUserById(idOfUser) == null) {
            return null;
        }
        User user = findUserById(idOfUser);
        amount *= -1;
        TransactionStatus transactionStatus = TransactionStatus.ACCEPTED;
        if (user.getSaldo() + amount < 0) {
            transactionStatus = TransactionStatus.DECLINED;
        }
        double saldoAfter = user.getSaldo() + amount;
        Transaction transaction = new Transaction(10, idOfUser, transactionStatus, amount, saldoAfter);
        transactionStorage.getTransactionList().add(transaction);
        return transaction;
    }

    public Transaction deposit(int idOfUser, double amount) {
        if (idOfUser <= 0 || amount <= 0) {
            return null;
        }
        if (findUserById(idOfUser) == null) {
            return null;
        }
        User user = findUserById(idOfUser);
        TransactionStatus transactionStatus = TransactionStatus.ACCEPTED;
        double saldoAfter = user.getSaldo() + amount;

        Transaction transaction = new Transaction(11, idOfUser, transactionStatus, amount, saldoAfter);
        transactionStorage.getTransactionList().add(transaction);
        return transaction;
    }

    public String getUserInfo(int idOfUser){
        if (findUserById(idOfUser) == null){
            return null;
        }
        return findUserById(idOfUser).toString();
    }
}

package com.example.s25944Bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BankServiceTests {

    private UserStorage userStorage;
    private TransactionStorage transactionStorage;
    private BankService bankService;

    @BeforeEach
    void setup(){
        this.userStorage = new UserStorage();
        this.transactionStorage = new TransactionStorage();
        this.bankService = new BankService(userStorage, transactionStorage);
    }

    @Test
    void WhatIf_createNewUser_idIsLessThanZero(){
        var result = bankService.createNewUser(-19, 100);
        assertThat(result).isEqualTo(null);
    }

    @Test
    void WhatIf_createNewUser_idAlreadyExists(){
        var result = bankService.createNewUser(1, 100);
        assertThat(result).isEqualTo(null);
    }

    @Test
    void CreatingNewUser_createNewUser(){
        var result = bankService.createNewUser(3,100).toString();
        String userTest = new User(3, 100).toString();
        assertThat(result).isEqualTo(userTest);
    }

    @Test
    void CreatingTransaction_transfer(){
        var result = bankService.transfer(1, 10).toString();
        String testTransaction = new Transaction(10, 1, TransactionStatus.ACCEPTED, -10, 490).toString();
        assertThat(result).isEqualTo(testTransaction);
    }

    @Test
    void CreatingTransaction_deposit(){
        var result = bankService.deposit(1, 10).toString();
        String testTransaction = new Transaction(11, 1, TransactionStatus.ACCEPTED, 10, 510).toString();
        assertThat(result).isEqualTo(testTransaction);
    }


}

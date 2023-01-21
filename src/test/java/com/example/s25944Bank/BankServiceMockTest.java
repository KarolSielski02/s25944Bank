package com.example.s25944Bank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BankServiceMockTest {

    @Mock
    private UserStorage userStorage;

    @Mock
    private TransactionStorage transactionStorage;

    @InjectMocks
    private BankService bankService;

    @Test
    void BankService_shouldNotCreateUserWhenIdTaken(){
        when(userStorage.getUserList()).thenReturn(List.of(new User(1, 100)));

        User result = bankService.createNewUser(1,100);
        assertThat(result).isNull();
    }
    @Test
    void BankService_shouldNotCreateUserWhenIdIsLessThan0(){
        when(userStorage.getUserList()).thenReturn(List.of(new User(1, 100)));

        User result = bankService.createNewUser(-10,100);
        assertThat(result).isNull();
    }
    @Test
    void CreatingUser_createNewUser(){
        List<User> mockList = new ArrayList<>();
        mockList.add(new User(1, 100));
        when(userStorage.getUserList()).thenReturn(mockList);
        var result = bankService.createNewUser(2, 100).toString();
        String mockUser = new User(2,100).toString();
        assertThat(result).isEqualTo(mockUser);
    }

    @Test
    void CreatingTransaction_transfer(){
        List<Transaction> mockList = new ArrayList<>();
        when(userStorage.getUserList()).thenReturn(List.of(new User(1, 100)));
        when(transactionStorage.getTransactionList()).thenReturn(mockList);
        var result = bankService.transfer(1, 10).toString();
        String testTransaction = new Transaction(10, 1, TransactionStatus.ACCEPTED, -10, 90).toString();
        assertThat(result).isEqualTo(testTransaction);
    }

    @Test
    void CreatingTransaction_deposit(){
        List<Transaction> mockList = new ArrayList<>();
        when(userStorage.getUserList()).thenReturn(List.of(new User(1, 100)));
        when(transactionStorage.getTransactionList()).thenReturn(mockList);
        var result = bankService.deposit(1, 10).toString();
        String testTransaction = new Transaction(11, 1, TransactionStatus.ACCEPTED, 10, 110).toString();
        assertThat(result).isEqualTo(testTransaction);
    }

    @Test
    void WhatIf_idIsZero_transfer(){
        List<Transaction> mockList = new ArrayList<>();
        when(userStorage.getUserList()).thenReturn(List.of(new User(0, 100)));
        when(transactionStorage.getTransactionList()).thenReturn(mockList);
        var result = bankService.transfer(1, 10);
//        String testTransaction = new Transaction(10, 1, TransactionStatus.ACCEPTED, -10, 90).toString();
        assertThat(result).isEqualTo(null);
    }

    @Test
    void WhatIf_idIsZero_deposit(){
        List<Transaction> mockList = new ArrayList<>();
        when(userStorage.getUserList()).thenReturn(List.of(new User(1, 100)));
        when(transactionStorage.getTransactionList()).thenReturn(mockList);
        var result = bankService.deposit(0, 10);
//        String testTransaction = new Transaction(10, 1, TransactionStatus.ACCEPTED, -10, 90).toString();
        assertThat(result).isEqualTo(null);
    }


}

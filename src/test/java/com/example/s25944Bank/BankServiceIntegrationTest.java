package com.example.s25944Bank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BankServiceIntegrationTest {
    @MockBean
    private UserStorage userStorage;
    @MockBean
    private TransactionStorage transactionStorage;
    @Autowired
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
}

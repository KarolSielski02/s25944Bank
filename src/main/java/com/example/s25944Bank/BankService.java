package com.example.s25944Bank;

import org.springframework.stereotype.Component;

@Component
public class BankService {

    UserStorage userStorage;

    public User createNewUser(int id, double saldo){
        if (id <= 0 || saldo < 0){
            return null;
        }
        if (findUserById(id) != null){
            return null;
        }
        User user = new User(id, saldo);
        userStorage.getUserList().add(user);
        return user;
    }

    public User findUserById(int id){
        for (User user : userStorage.getUserList()){
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public TransactionStatus
}

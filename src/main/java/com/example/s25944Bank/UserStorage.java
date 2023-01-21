package com.example.s25944Bank;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserStorage {

    private List<User> userList = new ArrayList<>();

    public UserStorage() {
        userList.add(new User(1, 500.00));
        userList.add(new User(2, 500000.00));
    }

    public List<User> getUserList() {
        return userList;
    }
}

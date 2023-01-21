package com.example.s25944Bank;

public class User {

    private int id;
    private double saldo;

    public User(int id, double saldo) {
        this.id = id;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", saldo=" + saldo +
                '}';
    }
}

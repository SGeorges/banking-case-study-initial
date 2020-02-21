package com.example.banking.models;

public class NewAutoLoan {
    private int clientId;
    private String name;
    private double balance;

    public NewAutoLoan() {
    }

    public NewAutoLoan(int clientId, String name, double balance) {
        this.clientId = clientId;
        this.name = name;
        this.balance = balance;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "NewAutoLoan{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}

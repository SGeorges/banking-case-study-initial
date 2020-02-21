package com.example.banking.models;

public class NewDepositAccount {
    private int clientId;
    private String name;
    private double initialBalance;

    public NewDepositAccount() {
    }

    public NewDepositAccount(int clientId, String name, double initialBalance) {
        this.clientId = clientId;
        this.name = name;
        this.initialBalance = initialBalance;
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

    public double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(double initialBalance) {
        this.initialBalance = initialBalance;
    }

    @Override
    public String toString() {
        return "NewDepositAccount{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                ", initialBalance=" + initialBalance +
                '}';
    }
}

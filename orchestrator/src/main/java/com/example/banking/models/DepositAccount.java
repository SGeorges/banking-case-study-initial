package com.example.banking.models;

public class DepositAccount {
    private Integer id;
    private int clientId;
    private String accountNumber;
    private String name;
    private double balance;

    public DepositAccount() {
    }

    public DepositAccount(Integer id, int clientId, String accountNumber, String name, double balance) {
        this.id = id;
        this.clientId = clientId;
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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
        return "DepositAccount{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}

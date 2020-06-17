package com.example.banking.models;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepositAccount {
    private String id;
    private String clientId;
    private String accountNumber;
    private String name;
    private String balance;

    private String defaultMessage;

    public DepositAccount() {
    }

    public DepositAccount(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public DepositAccount(String id, String clientId, String accountNumber, String name, String balance) {
        this.id = id;
        this.clientId = clientId;
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
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

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    @Override
    public String toString() {
        return "DepositAccount{" +
                "id='" + id + '\'' +
                ", clientId='" + clientId + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}

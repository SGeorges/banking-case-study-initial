package com.example.banking.models;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AutoLoanAccount {

    private String id;
    private String clientId;
    private String name;
    private String balance;

    private String defaultMessage;

    public AutoLoanAccount() {
    }

    public AutoLoanAccount(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public AutoLoanAccount(String id, String clientId, String name, String balance) {
        this.id = id;
        this.clientId = clientId;
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
        return "AutoLoanAccount{" +
                "id='" + id + '\'' +
                ", clientId='" + clientId + '\'' +
                ", name='" + name + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}

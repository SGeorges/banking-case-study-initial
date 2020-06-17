package com.example.banking.models;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditAccount {

    private String id;
    private String clientId;
    private String number;
    private String name;
    private String balance;

    private String defaultMessage;

    public CreditAccount() {
    }

    public CreditAccount(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public CreditAccount(String id, String clientId, String number, String name, String balance) {
        this.id = id;
        this.clientId = clientId;
        this.number = number;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
        return "CreditAccount{" +
                "id='" + id + '\'' +
                ", clientId='" + clientId + '\'' +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}

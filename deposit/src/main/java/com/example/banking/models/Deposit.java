package com.example.banking.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Deposit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int clientId;
    private String accountNumber;
    private String name;
    private double balance;

    public Deposit() {
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

    public void setAccountNumber() {
        StringBuilder newAccountNumber = new StringBuilder();

        for(int i = 0; i < 9; i++) {
            int value = (int) (Math.random() * 10);
            newAccountNumber.append(value);
        }

        this.accountNumber = String.valueOf(newAccountNumber);
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
        return "Deposit{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    //Bank Account builder
    public static DepositAccountBuilder builder() { return new DepositAccountBuilder(); }

    public static final class DepositAccountBuilder {
        private Deposit deposit;

        public DepositAccountBuilder() {
            deposit = new Deposit();
        }

        public DepositAccountBuilder newAccountNumber () {
            StringBuilder newAccountNumber = new StringBuilder();

            for(int i = 0; i < 9; i++) {
                int value = (int) (Math.random() * 10);
                newAccountNumber.append(value);
            }
            System.out.println(String.valueOf(newAccountNumber));
            deposit.setAccountNumber(String.valueOf(newAccountNumber));

            return this;
        }
    }
}

package com.example.banking.models;


import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class AutoLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int clientId;
    private String name;
    private double balance;

    public AutoLoan() {
    }

    public AutoLoan( Integer id, int clientId, String name, double balance) {
        super();
        this.id = id;
        this.clientId = clientId;
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
        return "AutoLoan{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}

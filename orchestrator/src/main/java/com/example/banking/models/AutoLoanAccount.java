package com.example.banking.models;

public class AutoLoanAccount {

    private Integer id;
    private int clientId;
    private String name;
    private double balanace;

    public AutoLoanAccount() {
    }

    public AutoLoanAccount(Integer id, int clientId, String name, double balanace) {
        this.id = id;
        this.clientId = clientId;
        this.name = name;
        this.balanace = balanace;
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

    public double getBalanace() {
        return balanace;
    }

    public void setBalanace(double balanace) {
        this.balanace = balanace;
    }

    @Override
    public String toString() {
        return "AutoLoanAccount{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", name='" + name + '\'' +
                ", balanace=" + balanace +
                '}';
    }
}

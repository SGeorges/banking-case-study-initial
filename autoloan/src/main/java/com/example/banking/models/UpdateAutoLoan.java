package com.example.banking.models;

public class UpdateAutoLoan {

    private int clientId;
    private String name;

    public UpdateAutoLoan() {
    }

    public UpdateAutoLoan(int clientId, String name) {
        this.clientId = clientId;
        this.name = name;
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

    @Override
    public String toString() {
        return "UpdateAutoLoan{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                '}';
    }
}

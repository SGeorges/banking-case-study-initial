package com.example.banking.models;

public class ReturnObject {

    private AccountSummary accountSummary;

    public ReturnObject() { }

    public ReturnObject(AccountSummary accountSummary) {
        this.accountSummary = accountSummary;
    }

    public AccountSummary getAccountSummary() {
        return accountSummary;
    }

    public void setAccountSummary(AccountSummary accountSummary) {
        this.accountSummary = accountSummary;
    }

    @Override
    public String toString() {
        return "returnObject{" +
                "accountSummary=" + accountSummary +
                '}';
    }
}

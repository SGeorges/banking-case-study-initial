package com.example.banking.models;

import java.util.List;

public class AccountSummary {

    private List<DepositAccount> depositAccounts;

    private List<CreditAccount> creditAccounts;

    private List<AutoLoanAccount> autoLoanAccounts;

    public AccountSummary() {
    }

    public AccountSummary(List<DepositAccount> depositAccounts, List<CreditAccount> creditAccounts, List<AutoLoanAccount> autoLoanAccounts) {
        this.depositAccounts = depositAccounts;
        this.creditAccounts = creditAccounts;
        this.autoLoanAccounts = autoLoanAccounts;
    }

    public List<DepositAccount> getDepositAccounts() {
        return depositAccounts;
    }

    public void setDepositAccounts(List<DepositAccount> depositAccounts) {
        this.depositAccounts = depositAccounts;
    }

    public List<CreditAccount> getCreditAccounts() {
        return creditAccounts;
    }

    public void setCreditAccounts(List<CreditAccount> creditAccounts) {
        this.creditAccounts = creditAccounts;
    }

    public List<AutoLoanAccount> getAutoLoanAccounts() {
        return autoLoanAccounts;
    }

    public void setAutoLoanAccounts(List<AutoLoanAccount> autoLoanAccounts) {
        this.autoLoanAccounts = autoLoanAccounts;
    }

    @Override
    public String toString() {
        return "AccountSummary{" +
                "depositAccounts=" + depositAccounts +
                ", creditAccounts=" + creditAccounts +
                ", autoLoanAccounts=" + autoLoanAccounts +
                '}';
    }
}

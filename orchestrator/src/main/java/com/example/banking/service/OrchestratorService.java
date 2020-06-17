package com.example.banking.service;

import com.example.banking.OrchestratorRestClient;
import com.example.banking.models.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrchestratorService {

    private OrchestratorRestClient orchestratorRestClient;

    public OrchestratorService (OrchestratorRestClient orchestratorRestClient) {
        this.orchestratorRestClient = orchestratorRestClient;
    }

    public ReturnObject getAccountSummaryByClientId(int clientId) {
        AccountSummary accountSummary = new AccountSummary();
            accountSummary.setAutoLoanAccounts(orchestratorRestClient.getAutoLoanAccounts(clientId));
            accountSummary.setCreditAccounts(orchestratorRestClient.getCreditAccounts(clientId));
            accountSummary.setDepositAccounts(orchestratorRestClient.getDepositAccounts(clientId));

        // Check if any of the Account types are empty and attaches a single object with a default message in its place.
        {
            if (accountSummary.getAutoLoanAccounts().isEmpty()) {
                List<AutoLoanAccount> emptyList = new ArrayList<>();
                emptyList.add(new AutoLoanAccount("No accounts available to show currently."));
                accountSummary.setAutoLoanAccounts(emptyList);
            }

            if (accountSummary.getCreditAccounts().isEmpty()) {
                List<CreditAccount> emptyList = new ArrayList<>();
                emptyList.add(new CreditAccount("No accounts available to show currently."));
                accountSummary.setCreditAccounts(emptyList);
            }

            if (accountSummary.getDepositAccounts().isEmpty()) {
                List<DepositAccount> emptyList = new ArrayList<>();
                emptyList.add(new DepositAccount("No accounts available to show currently."));
                accountSummary.setDepositAccounts(emptyList);
            }
        }

        ReturnObject returnObject = new ReturnObject(accountSummary);

        return returnObject;
    }

}

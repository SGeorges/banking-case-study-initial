package com.example.banking;

import com.example.banking.models.AutoLoanAccount;
import com.example.banking.models.CreditAccount;
import com.example.banking.models.DepositAccount;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class OrchestratorRestClient {

    RestTemplate restTemplate;

    public OrchestratorRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "autoLoanHystrix")
    public List<AutoLoanAccount> getAutoLoanAccounts(int clientId) {

        StringBuilder uri = new StringBuilder("http://localhost:9091/autoloan/getLoansByClientId/");
                      uri.append(clientId);

        ResponseEntity<AutoLoanAccount[]> response = restTemplate.getForEntity(String.valueOf(uri), AutoLoanAccount[].class);

        return Arrays.asList(response.getBody());
    }

    @HystrixCommand(fallbackMethod = "creditAccountHystrix")
    public List<CreditAccount> getCreditAccounts(int clientId) {
        StringBuilder uri = new StringBuilder("http://localhost:9092/creditcard/getCreditCardsByClientId/");
                      uri.append(clientId);

        ResponseEntity<CreditAccount[]> response = restTemplate.getForEntity(String.valueOf(uri), CreditAccount[].class);

        return Arrays.asList(response.getBody());
    }

    @HystrixCommand(fallbackMethod = "depositAccountHystrix")
    public List<DepositAccount> getDepositAccounts(int clientId) {
        StringBuilder uri = new StringBuilder("http://localhost:9093/deposit/getDepositAccountsByClientId/");
                      uri.append(clientId);

        ResponseEntity<DepositAccount[]> response = restTemplate.getForEntity(String.valueOf(uri), DepositAccount[].class);

        return Arrays.asList(response.getBody());
    }

    // Circuit-Breaker Methods
    // Returns default message if either the server is not running or the database is inaccessible/empty.
    public List<AutoLoanAccount> autoLoanHystrix(int clientId) {
        List<AutoLoanAccount> serverDownResponse = new ArrayList<>();
        serverDownResponse.add(new AutoLoanAccount("The Autoloan Account Server is currently unavailable."));

        return serverDownResponse;
    }

    public List<CreditAccount> creditAccountHystrix(int clientId) {
        List<CreditAccount> serverDownResponse = new ArrayList<>();
        serverDownResponse.add(new CreditAccount("The Credit Account Server is currently unavailable."));

        return serverDownResponse;
    }

    public List<DepositAccount> depositAccountHystrix(int cleintId) {
        List<DepositAccount> serverDownResponse = new ArrayList<>();
        serverDownResponse.add(new DepositAccount("The Deposit Account Server is currently unavailable."));

        return serverDownResponse;
    }
}

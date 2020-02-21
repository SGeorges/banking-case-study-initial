package com.example.banking;

import com.example.banking.models.AutoLoanAccount;
import com.example.banking.models.CreditAccount;
import com.example.banking.models.DepositAccount;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class OrchestratorRestClient {

    RestTemplate restTemplate;

    public OrchestratorRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<AutoLoanAccount> getAutoLoanAccounts(int clientId) {

        StringBuilder uri = new StringBuilder("http://localhost:9091/autoloan/getLoansByClientId/");
                      uri.append(clientId);

        ResponseEntity<AutoLoanAccount[]> response = restTemplate.getForEntity(String.valueOf(uri), AutoLoanAccount[].class);

        return Arrays.asList(response.getBody());
    }

    public List<CreditAccount> getCreditAccounts(int clientId) {
        StringBuilder uri = new StringBuilder("http://localhost:9092/creditcard/getCreditCardsByClientId/");
                      uri.append(clientId);

        ResponseEntity<CreditAccount[]> response = restTemplate.getForEntity(String.valueOf(uri), CreditAccount[].class);

        return Arrays.asList(response.getBody());
    }

    public List<DepositAccount> getDepositAccounts(int clientId) {
        StringBuilder uri = new StringBuilder("http://localhost:9093/deposit/getDepositAccountsByClientId/");
                      uri.append(clientId);

        ResponseEntity<DepositAccount[]> response = restTemplate.getForEntity(String.valueOf(uri), DepositAccount[].class);

        return Arrays.asList(response.getBody());
    }
}

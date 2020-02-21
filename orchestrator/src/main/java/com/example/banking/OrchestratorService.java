package com.example.banking;

import org.springframework.stereotype.Service;

@Service
public class OrchestratorService {

        public OrchestratorRestClient restClient;

    public OrchestratorService(OrchestratorRestClient restClient) {
        this.restClient = restClient;
    }
}

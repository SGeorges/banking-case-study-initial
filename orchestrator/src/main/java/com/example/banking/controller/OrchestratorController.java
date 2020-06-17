package com.example.banking.controller;

import com.example.banking.models.ReturnObject;
import com.example.banking.service.OrchestratorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrchestratorController {

    private OrchestratorService service;

    public OrchestratorController(OrchestratorService service) { this.service = service; }

    // Get
    @GetMapping(value = "getAccountSummaryByClientId/{clientId}", produces = "application/json")
    public ResponseEntity<ReturnObject> getAccountSummaryByClientId(@PathVariable("clientId") int clientId) {
        return new ResponseEntity<ReturnObject>(this.service.getAccountSummaryByClientId(clientId), HttpStatus.valueOf(200));
    }
}

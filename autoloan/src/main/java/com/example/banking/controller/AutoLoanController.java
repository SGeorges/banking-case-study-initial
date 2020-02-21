package com.example.banking.controller;

import com.example.banking.service.AutoLoanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autoloan")
public class AutoLoanController {

    private AutoLoanService service;

    public AutoLoanController(AutoLoanService service) {
        this.service = service;
    }

    // Create
    @PostMapping(value = "/createLoan", produces = "application/json")
    public String createLoan(@RequestBody String information) {
        return "CreateLoan successful.";
    }

    // Read
    @GetMapping(value = "/getLoansByClientId/{clientId}", produces = "application/json")
    public String getLoansByClientId(@PathVariable("clientId") int clientId) {
        return "GetLoansByClientId successful " + clientId;
    }

    // Read All
    @GetMapping(value = "/getAllLoans", produces = "application/json")
    public String getAllLoans() {
        return "GetAllLoans successful";
    }

    // Update
    @PostMapping(value = "/updateLoan/{id}", produces = "application/json")
    public String updateLoan(@PathVariable("id") int id) {
        return "UpdateLoan successful " + id;
    }

    // Delete
    @DeleteMapping(value = "/deleteLoan/{id}", produces = "application/json")
    public String deleteLoan(@PathVariable("id") int id) {
        return "DeleteLoan successful " + id;
    }
}

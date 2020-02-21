package com.example.banking.controller;

import com.example.banking.models.AutoLoan;
import com.example.banking.service.AutoLoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autoloan")
public class AutoLoanController {

    private AutoLoanService service;

    public AutoLoanController(AutoLoanService service) {
        this.service = service;
    }

    // Create
    @PostMapping(value = "/createLoan", produces = "application/json")
    public ResponseEntity<AutoLoan> createLoan(@RequestBody AutoLoan newAutoLoan) {
        return new ResponseEntity(this.service.add(newAutoLoan), HttpStatus.valueOf(200));
    }

    // Read
    @GetMapping(value = "/getLoansByClientId/{clientId}", produces = "application/json")
    public ResponseEntity<List<AutoLoan>> getLoansByClientId(@PathVariable("clientId") int clientId) {
        return new ResponseEntity(this.service.getLoansByClientId(clientId), HttpStatus.valueOf(200));
    }

    // Read All
    @GetMapping(value = "/getAllLoans", produces = "application/json")
    public ResponseEntity<List<AutoLoan>> getAllLoans() {
        return new ResponseEntity(this.service.getAllLoans(), HttpStatus.valueOf(200));
    }

    // Update
    @PutMapping(value = "/updateLoan/{id}", produces = "application/json")
    public ResponseEntity<AutoLoan> updateLoan(@PathVariable("id") int id, @RequestBody AutoLoan updateAutoLoan) {
        return new ResponseEntity(this.service.updateLoan(id, updateAutoLoan), HttpStatus.valueOf(200));
    }

    // Delete
    @DeleteMapping(value = "/deleteLoan/{id}", produces = "application/json")
    public ResponseEntity<Boolean> deleteLoan(@PathVariable("id") int id) {
        if(this.service.delete(id)) {
            return new ResponseEntity(HttpStatus.valueOf(200));
        } else {
            return new ResponseEntity("Record not deleted", HttpStatus.valueOf(404));
        }
    }
}

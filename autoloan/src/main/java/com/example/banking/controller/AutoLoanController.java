package com.example.banking.controller;

import com.example.banking.dtos.AutoLoanDTO;
import com.example.banking.models.AutoLoan;
import com.example.banking.models.DefaultMessage;
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
    public ResponseEntity<AutoLoanDTO> createLoan(@RequestBody AutoLoan newAutoLoan) {
        return new ResponseEntity<AutoLoanDTO>(this.service.add(newAutoLoan), HttpStatus.valueOf(200));
    }

    // Read
    @GetMapping(value = "/getLoansByClientId/{clientId}", produces = "application/json")
    public ResponseEntity<List<AutoLoanDTO>> getLoansByClientId(@PathVariable("clientId") int clientId) {
        if (this.service.databaseCheck()) { return new ResponseEntity(new DefaultMessage(), HttpStatus.NOT_FOUND); }
        return new ResponseEntity<List<AutoLoanDTO>>(this.service.getLoansByClientId(clientId), HttpStatus.valueOf(200));
    }

    // Read All
    @GetMapping(value = "/getAllLoans", produces = "application/json")
    public ResponseEntity<List<AutoLoanDTO>> getAllLoans() {
        if (this.service.databaseCheck()) { return new ResponseEntity(new DefaultMessage(), HttpStatus.NOT_FOUND); }
        return new ResponseEntity<List<AutoLoanDTO>>(this.service.getAllLoans(), HttpStatus.valueOf(200));
    }

    // Update
    @PutMapping(value = "/updateLoan/{id}", produces = "application/json")
    public ResponseEntity<AutoLoanDTO> updateLoan(@PathVariable("id") int id, @RequestBody AutoLoan updateAutoLoan) {
        if (this.service.databaseCheck()) { return new ResponseEntity(new DefaultMessage(), HttpStatus.NOT_FOUND); }
        return new ResponseEntity<AutoLoanDTO>(this.service.updateLoan(id, updateAutoLoan), HttpStatus.valueOf(200));
    }

    // Delete
    @DeleteMapping(value = "/deleteLoan/{id}", produces = "application/json")
    public ResponseEntity<Boolean> deleteLoan(@PathVariable("id") int id) {
        if (this.service.databaseCheck()) { return new ResponseEntity(new DefaultMessage(), HttpStatus.NOT_FOUND); }
        if(this.service.delete(id)) {
            return new ResponseEntity(HttpStatus.valueOf(204));
        } else {
            return new ResponseEntity("Record not deleted", HttpStatus.valueOf(404));
        }
    }
}

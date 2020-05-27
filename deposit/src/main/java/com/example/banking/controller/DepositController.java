package com.example.banking.controller;

import com.example.banking.dtos.DepositDTO;
import com.example.banking.models.DefaultMessage;
import com.example.banking.models.Deposit;
import com.example.banking.models.NewDepositAccount;
import com.example.banking.service.DepositService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deposit")
public class DepositController {

    private DepositService service;

    public DepositController(DepositService service) {
        this.service = service;
    }

    // Create
    @PostMapping(value = "/createDepositAccount", produces = "application/json")
    public ResponseEntity<DepositDTO> createDepositAccount(@RequestBody NewDepositAccount newDeposit) {
        return new ResponseEntity<DepositDTO>(this.service.add(newDeposit), HttpStatus.valueOf(200));
    }

    // Read
    @GetMapping(value = "/getDepositAccountsByClientId/{clientId}", produces = "application/json")
    public ResponseEntity<List<DepositDTO>> getDepositAccountsByClientId(@PathVariable("clientId") int clientId) {
        if (this.service.databaseCheck()) { return new ResponseEntity(new DefaultMessage(), HttpStatus.NOT_FOUND); }
        return new ResponseEntity<List<DepositDTO>>(this.service.getDepositAccountsByClientId(clientId), HttpStatus.valueOf(200));
    }

    // Read All
    @GetMapping(value = "/getAllDepositAccounts", produces = "application/json")
    public ResponseEntity<List<DepositDTO>> getAllDepositAccounts() {
        if (this.service.databaseCheck()) { return new ResponseEntity(new DefaultMessage(), HttpStatus.NOT_FOUND); }
        return new ResponseEntity<List<DepositDTO>>(this.service.getAllDepositAccounts(), HttpStatus.valueOf(200));
    }

    // Update
    @PutMapping(value = "/updateDepositAccount/{id}", produces = "application/json")
    public ResponseEntity<Deposit> updateLoan(@PathVariable("id") int id, @RequestBody Deposit updateDeposit) {
        if (this.service.databaseCheck()) { return new ResponseEntity(new DefaultMessage(), HttpStatus.NOT_FOUND); }
        return new ResponseEntity(this.service.updateDeposit(id, updateDeposit), HttpStatus.valueOf(200));
    }

    // Delete
    @DeleteMapping(value = "/deleteDepositAccount/{id}", produces = "application/json")
    public ResponseEntity<Boolean> deleteDepositAccount(@PathVariable("id") int id) {
        if (this.service.databaseCheck()) { return new ResponseEntity(new DefaultMessage(), HttpStatus.NOT_FOUND); }
        if(this.service.delete(id)) {
            return new ResponseEntity(HttpStatus.valueOf(204));
        } else {
            return new ResponseEntity("Record not deleted", HttpStatus.valueOf(404));
        }
    }

}

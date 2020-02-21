package com.example.banking.controller;

import com.example.banking.models.CreditCard;
import com.example.banking.models.DefaultMessage;
import com.example.banking.service.CreditCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/creditcard")
public class CreditCardController {

    private CreditCardService service;

    public CreditCardController(CreditCardService service) {
        this.service = service;
    }

    // Create
    @PostMapping(value = "/createCreditCard", produces = "application/json")
    public ResponseEntity<CreditCard> createCreditCard(@RequestBody CreditCard newCreditCard) {
        return new ResponseEntity(this.service.add(newCreditCard), HttpStatus.valueOf(200));
    }

    // Read
    @GetMapping(value = "/getCreditCardsByClientId/{clientId}", produces = "application/json")
    public ResponseEntity<List<CreditCard>> getCreditCardsByClientId(@PathVariable("clientId") int clientId) {
        if (this.service.databaseCheck()) { return new ResponseEntity(new DefaultMessage(), HttpStatus.NOT_FOUND); }
        return new ResponseEntity(this.service.getCreditCardsByClientId(clientId), HttpStatus.valueOf(200));
    }

    // Read All
    @GetMapping(value = "/getAllCreditCards", produces = "application/json")
    public ResponseEntity<List<CreditCard>> getAllCreditCards() {
        if (this.service.databaseCheck()) { return new ResponseEntity(new DefaultMessage(), HttpStatus.NOT_FOUND); }
        return new ResponseEntity(this.service.getAllCreditCards(), HttpStatus.valueOf(200));
    }

    // Update
    @PutMapping(value = "/updateCreditCard/{id}", produces = "application/json")
    public ResponseEntity<CreditCard> updateCreditCard(@PathVariable("id") int id, @RequestBody CreditCard updateCreditCard) {
        if (this.service.databaseCheck()) { return new ResponseEntity(new DefaultMessage(), HttpStatus.NOT_FOUND); }
        return new ResponseEntity(this.service.updateCreditCard(id, updateCreditCard), HttpStatus.valueOf(200));
    }

    // Delete
    @DeleteMapping(value = "/deleteCreditCard/{id}", produces = "application/json")
    public ResponseEntity<Boolean> deleteCreditCard(@PathVariable("id") int id) {
        if (this.service.databaseCheck()) { return new ResponseEntity(new DefaultMessage(), HttpStatus.NOT_FOUND); }
        if(this.service.delete(id)) {
            return new ResponseEntity(HttpStatus.valueOf(200));
        } else {
            return new ResponseEntity("Record not deleted", HttpStatus.valueOf(404));
        }
    }
}

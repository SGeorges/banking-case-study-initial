package com.example.banking.service;

import com.example.banking.dtos.CreditCardDTO;
import com.example.banking.models.CreditCard;
import com.example.banking.repository.CreditCardRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditCardService {

    private CreditCardRepository repository;

    public CreditCardService(CreditCardRepository repository) {
        this.repository = repository;
    }

    // Create
    public CreditCardDTO add(CreditCard newCreditCard) {
        CreditCard creditCard = this.repository.save(newCreditCard);

        return CreditCardDTO.builder().withId(creditCard.getId()).withClientId(creditCard.getClientId()).withNumber(creditCard.getNumber()).withName(creditCard.getName()).withBalance(creditCard.getBalance()).build();
    }

    // Read
    public List<CreditCardDTO> getCreditCardsByClientId(int clientId) {
        List<CreditCard> creditCardList = this.repository.findCreditCardByClientId(clientId);
        List<CreditCardDTO> returnList = new ArrayList<>();

        for(CreditCard creditCard : creditCardList)
            returnList.add(CreditCardDTO.builder().withId(creditCard.getId()).withClientId(creditCard.getClientId()).withNumber(creditCard.getNumber()).withName(creditCard.getName()).withBalance(creditCard.getBalance()).build());

        return returnList;
    }

    // Read All
    public List<CreditCardDTO> getAllCreditCards() {
        List<CreditCard> creditCardList = this.repository.findAll();
        List<CreditCardDTO> returnList = new ArrayList<>();

        for(CreditCard creditCard : creditCardList)
            returnList.add(CreditCardDTO.builder().withId(creditCard.getId()).withClientId(creditCard.getClientId()).withNumber(creditCard.getNumber()).withName(creditCard.getName()).withBalance(creditCard.getBalance()).build());

        return returnList;
    }

    // Update
    public CreditCardDTO updateCreditCard(int id, CreditCard updateCreditCard) {
        CreditCard creditCard = repository.findById(id).get();
                   creditCard.setClientId(updateCreditCard.getClientId());
                   creditCard.setNumber(updateCreditCard.getNumber());
                   creditCard.setName(updateCreditCard.getName());

        this.repository.save(creditCard);

        return CreditCardDTO.builder().withId(creditCard.getId()).withClientId(creditCard.getClientId()).withNumber(creditCard.getNumber()).withName(creditCard.getName()).withBalance(creditCard.getBalance()).build();
    }

    // Delete
    public boolean delete(int id) {
        try {
            this.repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean databaseCheck() {
        return this.repository.findAll().isEmpty();
    }
}

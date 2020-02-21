package com.example.banking.service;

import com.example.banking.models.CreditCard;
import com.example.banking.repository.CreditCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {

    private CreditCardRepository repository;

    public CreditCardService(CreditCardRepository repository) {
        this.repository = repository;
    }

    public CreditCard add(CreditCard newCreditCard) {
        return this.repository.save(newCreditCard);
    }

    public List<CreditCard> getCreditCardsByClientId(int clientId) {
        return this.repository.findCreditCardByClientId(clientId);
    }

    public List<CreditCard> getAllCreditCards() {
        return this.repository.findAll();
    }

    public CreditCard updateCreditCard(int id, CreditCard updateCreditCard) {

        CreditCard creditCard = repository.findById(id).get();
                   creditCard.setClientId(updateCreditCard.getClientId());
                   creditCard.setNumber(updateCreditCard.getNumber());
                   creditCard.setName(updateCreditCard.getName());

        return this.repository.save(creditCard);
    }

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

package com.example.banking.repository;

import com.example.banking.models.CreditCard;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CreditCardRepository extends CrudRepository<CreditCard, Integer> {

    List<CreditCard> findCreditCardByClientId(int clientId);

    List<CreditCard> findAll();
}

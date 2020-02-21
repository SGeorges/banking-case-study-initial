package com.example.banking.repository;

import com.example.banking.models.Deposit;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepositRepository extends CrudRepository<Deposit, Integer> {

    List<Deposit> findDepositByClientId(int clientId);

    List<Deposit> findAll();
}

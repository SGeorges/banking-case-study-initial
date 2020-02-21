package com.example.banking.repository;

import com.example.banking.models.AutoLoan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AutoLoanRepository extends CrudRepository<AutoLoan, Integer> {

    List<AutoLoan> findAutoLoanByClientId(int clientId);

    List<AutoLoan> findAll();
}

package com.example.banking.repository;

import com.example.banking.models.AutoLoan;
import org.springframework.data.repository.CrudRepository;

public interface AutoLoanRepository extends CrudRepository<AutoLoan, Integer> {
}

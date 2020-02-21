package com.example.banking.service;

import com.example.banking.models.AutoLoan;
import com.example.banking.repository.AutoLoanRepository;
import org.springframework.stereotype.Service;

@Service
public class AutoLoanService {

    private AutoLoanRepository repository;

    public AutoLoanService(AutoLoanRepository repository) {
        this.repository = repository;
    }

    public AutoLoan add(AutoLoan newAutoLoan) {
        return this.repository.save(newAutoLoan);
    }
}

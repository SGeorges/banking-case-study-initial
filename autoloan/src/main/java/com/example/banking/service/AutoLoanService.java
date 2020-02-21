package com.example.banking.service;

import com.example.banking.models.AutoLoan;
import com.example.banking.repository.AutoLoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoLoanService {

    private AutoLoanRepository repository;

    public AutoLoanService(AutoLoanRepository repository) {
        this.repository = repository;
    }

    public AutoLoan add(AutoLoan newAutoLoan) {
        return this.repository.save(newAutoLoan);
    }

    public List<AutoLoan> getLoansByClientId(int clientId) {
        return this.repository.findAutoLoanByClientId(clientId);
    }

    public List<AutoLoan> getAllLoans() {
        return this.repository.findAll();
    }

    public AutoLoan updateLoan(int id, AutoLoan updateAutoLoan) {

        AutoLoan autoLoan = repository.findById(id).get();
                 autoLoan.setClientId(updateAutoLoan.getClientId());
                 autoLoan.setName(updateAutoLoan.getName());

        return this.repository.save(autoLoan);

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

package com.example.banking.service;

import com.example.banking.dtos.AutoLoanDTO;
import com.example.banking.models.AutoLoan;
import com.example.banking.repository.AutoLoanRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutoLoanService {

    private AutoLoanRepository repository;

    public AutoLoanService(AutoLoanRepository repository) {
        this.repository = repository;
    }

    public AutoLoanDTO add(AutoLoan newAutoLoan) {
        AutoLoan autoLoan = this.repository.save(newAutoLoan);

        return AutoLoanDTO.builder().withId(autoLoan.getId()).withClientId(autoLoan.getClientId()).withName(autoLoan.getName()).withBalance(autoLoan.getBalance()).build();
    }

    public List<AutoLoanDTO> getLoansByClientId(int clientId) {
        List<AutoLoan> autoLoanList = this.repository.findAutoLoanByClientId(clientId);
        List<AutoLoanDTO> returnList = new ArrayList<AutoLoanDTO>();

        for(AutoLoan autoLoan : autoLoanList)
            returnList.add(AutoLoanDTO.builder().withId(autoLoan.getId()).withClientId(autoLoan.getClientId()).withName(autoLoan.getName()).withBalance(autoLoan.getBalance()).build());

        return returnList;
    }

    public List<AutoLoanDTO> getAllLoans() {
        List<AutoLoan> autoLoanList = this.repository.findAll();
        List<AutoLoanDTO> returnList = new ArrayList<AutoLoanDTO>();

        for(AutoLoan autoLoan : autoLoanList)
            returnList.add(AutoLoanDTO.builder().withId(autoLoan.getId()).withClientId(autoLoan.getClientId()).withName(autoLoan.getName()).withBalance(autoLoan.getBalance()).build());

        return returnList;
    }

    public AutoLoanDTO updateLoan(int id, AutoLoan updateAutoLoan) {

        AutoLoan autoLoan = repository.findById(id).get();
                 autoLoan.setClientId(updateAutoLoan.getClientId());
                 autoLoan.setName(updateAutoLoan.getName());

        this.repository.save(autoLoan);

        return AutoLoanDTO.builder().withId(autoLoan.getId()).withClientId(autoLoan.getClientId()).withName(autoLoan.getName()).withBalance(autoLoan.getBalance()).build();
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

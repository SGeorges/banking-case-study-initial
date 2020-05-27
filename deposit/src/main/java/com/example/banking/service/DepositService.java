package com.example.banking.service;

import com.example.banking.dtos.DepositDTO;
import com.example.banking.models.Deposit;
import com.example.banking.models.NewDepositAccount;
import com.example.banking.repository.DepositRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepositService {

    private DepositRepository repository;

    public DepositService(DepositRepository repository) {

        this.repository = repository;
    }

    public DepositDTO add(NewDepositAccount newDeposit) {
        Deposit deposit = new Deposit();
                deposit.setClientId(newDeposit.getClientId());
                deposit.setName(newDeposit.getName());
                deposit.setBalance(newDeposit.getInitialBalance());
                deposit.setAccountNumber();

                deposit = this.repository.save(deposit);

        return DepositDTO.builder().withId(deposit.getId()).withClientId(deposit.getClientId()).withAccountNumber(deposit.getAccountNumber()).withName(deposit.getName()).withBalance(deposit.getBalance()).build();
    }

    public List<DepositDTO> getDepositAccountsByClientId(int clientId) {
        List<Deposit> depositList = this.repository.findDepositByClientId(clientId);
        List<DepositDTO> returnList = new ArrayList<>();

        for(Deposit deposit : depositList)
            returnList.add(DepositDTO.builder().withId(deposit.getId()).withClientId(deposit.getClientId()).withAccountNumber(deposit.getAccountNumber()).withName(deposit.getName()).withBalance(deposit.getBalance()).build());

        return returnList;
    }

    public List<DepositDTO> getAllDepositAccounts() {
        List<Deposit> depositList = this.repository.findAll();
        List<DepositDTO> returnList = new ArrayList<>();

        for(Deposit deposit : depositList)
            returnList.add(DepositDTO.builder().withId(deposit.getId()).withClientId(deposit.getClientId()).withAccountNumber(deposit.getAccountNumber()).withName(deposit.getName()).withBalance(deposit.getBalance()).build());

        return returnList;
    }

    public DepositDTO updateDeposit(int id, Deposit updateDeposit) {

        Deposit deposit = repository.findById(id).get();
                deposit.setClientId(updateDeposit.getClientId());
                deposit.setAccountNumber(updateDeposit.getAccountNumber());
                deposit.setName(updateDeposit.getName());

                this.repository.save(deposit);

        return DepositDTO.builder().withId(deposit.getId()).withClientId(deposit.getClientId()).withAccountNumber(deposit.getAccountNumber()).withName(deposit.getName()).withBalance(deposit.getBalance()).build();
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

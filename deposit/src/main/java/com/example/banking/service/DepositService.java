package com.example.banking.service;

import com.example.banking.models.Deposit;
import com.example.banking.models.NewDepositAccount;
import com.example.banking.repository.DepositRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepositService {

    private DepositRepository repository;

    public DepositService(DepositRepository repository) {

        this.repository = repository;
    }

    public Deposit add(NewDepositAccount newDeposit) {
        Deposit deposit = new Deposit();
            deposit.setClientId(newDeposit.getClientId());
            deposit.setName(newDeposit.getName());
            deposit.setBalance(newDeposit.getInitialBalance());
            deposit.setAccountNumber();

        return this.repository.save(deposit);
    }

    public List<Deposit> getDepositAccountsByClientId(int clientId) {
        return this.repository.findDepositByClientId(clientId);
    }

    public List<Deposit> getAllDepositAccounts() {
        return this.repository.findAll();
    }

    public Deposit updateDeposit(int id, Deposit updateDeposit) {

        Deposit deposit = repository.findById(id).get();
                deposit.setClientId(updateDeposit.getClientId());
                deposit.setAccountNumber(updateDeposit.getAccountNumber());
                deposit.setName(updateDeposit.getName());

        return this.repository.save(deposit);
    }

    public boolean delete(int id) {
        try {
            this.repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

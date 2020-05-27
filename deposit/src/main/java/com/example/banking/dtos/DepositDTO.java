package com.example.banking.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepositDTO {

    private String id;
    private String clientId;
    private String accountNumber;
    private String name;
    private String balance;

    public DepositDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public DepositDTO(String id, String clientId, String accountNumber, String name, String balance) {
        this.id = id;
        this.clientId = clientId;
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "DepositDTO{" +
                "id='" + id + '\'' +
                ", clientId='" + clientId + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }

    public static DepositDTOBuilder builder() { return new DepositDTOBuilder(); }

    public static final class DepositDTOBuilder {
        private DepositDTO depositDTO;

        private DepositDTOBuilder() { depositDTO = new DepositDTO(); }

        public DepositDTOBuilder withId (Integer id) {
            depositDTO.setId(String.valueOf(id));
            return this;
        }

        public DepositDTOBuilder withClientId (Integer clientId) {
            depositDTO.setClientId(String.format("%03d", clientId));
            return this;
        }

        public DepositDTOBuilder withAccountNumber (String accountNumber) {
            depositDTO.setAccountNumber(String.valueOf(accountNumber));
            return this;
        }

        public DepositDTOBuilder withName (String name) {
            depositDTO.setName(String.valueOf(name));
            return this;
        }

        public DepositDTOBuilder withBalance (double balance) {
            depositDTO.setBalance(String.valueOf(balance));
            return this;
        }

        public DepositDTO build() { return depositDTO; }
    }
}

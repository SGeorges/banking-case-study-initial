package com.example.banking.dtos;

public class CreditCardDTO {

    private String id;
    private String clientId;
    private String number;
    private String name;
    private String balance;

    public CreditCardDTO() {
        super();
        // TODO Auto-genereated constructor stub
    }

    public CreditCardDTO(String id, String clientId, String number, String name, String balance) {
        this.id = id;
        this.clientId = clientId;
        this.number = number;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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
        return "CreditCardDTO{" +
                "id='" + id + '\'' +
                ", clientId='" + clientId + '\'' +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }

    public static CreditCardDTOBuilder builder() { return new CreditCardDTOBuilder(); }

    public static final class CreditCardDTOBuilder {
        private CreditCardDTO creditCardDTO;

        private CreditCardDTOBuilder() { creditCardDTO = new CreditCardDTO(); }

        public CreditCardDTOBuilder withId (Integer id) {
            creditCardDTO.setId(String.valueOf(id));
            return this;
        }

        public CreditCardDTOBuilder withClientId (Integer clientId) {
            creditCardDTO.setClientId(String.format("%03d", clientId));
            return this;
        }

        public CreditCardDTOBuilder withNumber (String number) {
            creditCardDTO.setNumber(String.valueOf(number));
            return this;
        }

        public CreditCardDTOBuilder withName (String name) {
            creditCardDTO.setName(String.valueOf(name));
            return this;
        }

        public CreditCardDTOBuilder withBalance (double balance) {
            creditCardDTO.setBalance(String.valueOf(balance));
            return this;
        }

        public CreditCardDTO build() { return creditCardDTO; }
    }
}

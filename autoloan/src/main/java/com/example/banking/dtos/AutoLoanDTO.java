package com.example.banking.dtos;

public class AutoLoanDTO {

    private String id;
    private String clientId;
    private String name;
    private String balance;

    public AutoLoanDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public AutoLoanDTO(String id, String clientId, String name, String balance) {
        this.id = id;
        this.clientId = clientId;
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
        return "AutoLoanDTO{" +
                "id='" + id + '\'' +
                ", clientId='" + clientId + '\'' +
                ", name='" + name + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }

    public static AutoLoanDTOBuilder builder() { return new AutoLoanDTOBuilder(); }

    public static final class AutoLoanDTOBuilder {
        private AutoLoanDTO autoLoanDTO;

        private AutoLoanDTOBuilder() { autoLoanDTO = new AutoLoanDTO(); }

        public AutoLoanDTOBuilder withId (Integer id) {
            autoLoanDTO.setId(String.valueOf(id));
            return this;
        }

        public AutoLoanDTOBuilder withClientId (Integer clientId) {
            autoLoanDTO.setClientId(String.format("%03d", clientId));
            return this;
        }

        public AutoLoanDTOBuilder withName (String name) {
            autoLoanDTO.setName(String.valueOf(name));
            return this;
        }

        public AutoLoanDTOBuilder withBalance (double balance) {
            autoLoanDTO.setBalance(String.valueOf(balance));
            return this;
        }

        public AutoLoanDTO build() { return autoLoanDTO; }


    }
}

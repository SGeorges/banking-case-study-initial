package com.example.banking.models;

public class DefaultMessage {

    public String defaultMessage = "No accounts available to show currently";

    public DefaultMessage() {
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    @Override
    public String toString() {
        return "DefaultMessage{" +
                "DefaultMessage='" + defaultMessage + '\'' +
                '}';
    }
}

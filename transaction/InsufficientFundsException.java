package com.mikadosolutions.training.spring.transaction;

public class InsufficientFundsException extends Exception {
    String message;

    public InsufficientFundsException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "InsufficientFundsException {" +
                "message = '" + message + '\'' +
                '}';
    }
}
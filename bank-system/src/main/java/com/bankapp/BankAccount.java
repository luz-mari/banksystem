package com.bankapp;

public class BankAccount {
    private String accountNumber; // numero unico de cuenta
    private Double balance; // saldo de la cuenta
    private AccountType accountType; // no estoy segura si va aca tipo de cuenta ahorro o corriente

    //Asociacion con Customer una cuenta pertenece a un cliente
    private Customer customer;

    public BankAccount(AccountType accountType, Customer customer) {
        String accountNumber = generateAccountNumber();
        if (accountType == null) {
            throw new IllegalArgumentException("accountType cannot be null");
        }
        if (customer == null) {
            throw new IllegalArgumentException("customer cannot be null");
        }
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.accountType = accountType;
        this.customer = customer;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public Customer getCustomer() {
        return customer;
    }

    // Genera un número de cuenta único de 8 dígitos
    private static String generateAccountNumber() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int digit = (int) (Math.random() * 10);
            sb.append(digit);
        }
        return sb.toString();
    }
    
}

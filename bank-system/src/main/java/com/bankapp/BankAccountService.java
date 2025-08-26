package com.bankapp;

import java.util.HashMap;
import java.util.Map;

public class BankAccountService {
    private Map<String, BankAccount> accounts = new HashMap<>();

    private final CustomerService customerService;

    public BankAccountService(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Crea una cuenta bancaria si el cliente existe y el tipo es válido
    public BankAccount openAccount(String customerDni, AccountType accountType) {
        if (customerDni == null || customerDni.trim().isEmpty()) {
            throw new IllegalArgumentException("El DNI del cliente es obligatorio.");
        }
        if (accountType == null) {
            throw new IllegalArgumentException("El tipo de cuenta es obligatorio.");
        }

        Customer customer = customerService.getCustomer(customerDni);
        if (customer == null) {
            throw new IllegalArgumentException("El cliente no existe.");
        }

        BankAccount account = new BankAccount(accountType, customer);
        accounts.put(account.getAccountNumber(), account);
        customer.addAccount(account); // Relaciona la cuenta con el cliente
        return account;
    }

    public BankAccount findAccountByNumber(String accountNumber) {
        return accounts.get(accountNumber);
    }
    
    // Metodo para depositar dinero en la cuenta
    public void deposit(String accountNumber, double amount) {
        BankAccount account = findAccountByNumber(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("La cuenta bancaria no existe.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo.");
        }
        account.setBalance(account.getBalance() + amount);
    }

    // Metodo para retirar dinero respetando las reglas
    public boolean withdraw(String accountNumber, double amount) {
        BankAccount account = findAccountByNumber(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("La cuenta bancaria no existe.");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo.");
        }
        AccountType accountType = account.getAccountType();
        double balance = account.getBalance();

        if (accountType == AccountType.SAVINGS) { // caso cuenta de ahorro
            if (balance - amount >= 0) { // no puede quedar en negativo
                account.setBalance(balance - amount);
                return true;
            }
        } else if (accountType == AccountType.CHECKING) { // caso cuenta corriente
            if (balance - amount >= -500) { // Puede ir hasta -500
                account.setBalance(balance - amount);
                return true;
            }
        }
        return false; // Si no cumple las reglas, no se realiza el retiro
    }
}
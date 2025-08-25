package com.bankapp;

public class BankAccount {
    private String accountNumber; // numero unico de cuenta
    private Double balance; // saldo de la cuenta
    private AccountType accountType; // no estoy segura si va aca tipo de cuenta ahorro o corriente

    //Asociacion con Customer una cuenta pertenece a un cliente
    private Customer customer;

    //constructor
    public BankAccount(String accountNumber, AccountType accountType,Customer customer){
        this.accountNumber = accountNumber; // Se asigna el número único
        this.balance = 0.0;                 // El saldo siempre inicia en 0
        this.accountType = accountType;     // Tipo de cuenta (enum)
        this.customer = customer;           // Cliente dueño de la cuenta
    }
    // Metodo para depositar dinero en la cuenta
    public void deposit(double amount){
        if (amount > 0){     //solo se permite monto positivo
            balance += amount;     // se suma al saldo actual
        }
    }

    // Metodo para retirar dinero respetando las reglas
    public boolean withdraw(double amount){
        if (accountType == AccountType.SAVINGS){  // caso cuenta de ahorro
            if (balance - amount >= 0){  // no puede quedar en negativo
                balance -= amount;  //resta saldo
                return  true;
            }
        }else if (accountType == AccountType.CHECKING){  // caso cuenta corriente
            if (balance - amount >= -500){    //Puede ir hasta -500
                balance -= amount;
                return true;
            }
        }
        return false; // Si no cumple las reglas, no se realiza el retiro
    }
    // Metodo para consultar saldo
    public double getBalance(){
        return balance;
    }
    // Getters

    public String getAccountNumber() {
        return accountNumber;
    }
    public AccountType getAccountType(){
        return  accountType;
    }
    public Customer getCustomer(){
        return customer;
    }
}

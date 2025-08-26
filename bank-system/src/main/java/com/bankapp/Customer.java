package com.bankapp;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    // Encapsulamiento Atributos privados -> solo accesibles dentro de esta clase
    private String firstName;
    private String lastName;
    private String email;
    private String documentNumber;

    private List<BankAccount> accounts = new ArrayList<>();

    //Constructor -> se usa para crear un objeto Customer con los datos obligatorios
    public Customer(String firstName, String lastName, String email, String documentNumber) {
        if (firstName == null || firstName.isEmpty() ||
            lastName == null || lastName.isEmpty() ||
            email == null || email.isEmpty() ||
            documentNumber == null || documentNumber.isEmpty()) {
            throw new IllegalArgumentException("Todos los campos son obligatorios.");
        }
        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
            throw new IllegalArgumentException("Formato de email inválido.");
        }
        this.firstName = firstName;  //asigna el nombre recibido al atributo interno
        this.lastName = lastName;
        this.email = email;
        this.documentNumber = documentNumber;
    }

    // Metodos getter sirven para leer los valores de los atributos privados
    public String getFirstName() {
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmail(){
        return email;
    }

    public String getDocumentNumber(){
        return  documentNumber;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    // Metodo setter permite modificar valores si fuera necesario
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.firstName = lastName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setDocumentNumber(String documentNumber){
        this.documentNumber = documentNumber;
    }

    // Metodo para agregar una cuenta a la lista de cuentas del cliente
    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    @Override
    public String toString() {
        return "Customer{documentNumber='" + documentNumber + "', firstName='" + firstName + "', lastName='" + lastName + "', email='" + email + "'}";
    }

}

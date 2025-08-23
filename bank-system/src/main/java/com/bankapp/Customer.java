package com.bankapp;

public class Customer {
    // Atributos privados -> solo accesibles dentro de esta clase
    private String firstName;
    private String lastName;
    private String email;
    private String documentNumber;

    //Constructor -> se usa para crear un objeto Customer con los datos obligatorios
    public Customer(String firstName, String lastName, String email, String dni){
        this.firstName = firstName;  //asigna el nombre recibido al atributo interno
        this.lastName = lastName;
        this.email = email;
        this.documentNumber = documentNumber;
    }

    public String getId() {
    }
}

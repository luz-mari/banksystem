package com.bankapp;

public class Customer {
    // Encapsulamiento Atributos privados -> solo accesibles dentro de esta clase
    private String firstName;
    private String lastName;
    private String email;
    private String documentNumber;

    //Constructor -> se usa para crear un objeto Customer con los datos obligatorios
    public Customer(String firstName, String lastName, String email, String documentNumber){
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
    @Override
    public String toString() {
        return "Customer{documentNumber='" + documentNumber + "', firstName='" + firstName + "', lastName='" + lastName + "', email='" + email + "'}";
    }

}

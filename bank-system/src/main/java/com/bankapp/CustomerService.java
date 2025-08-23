package com.bankapp;

import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    //Base de datos en memoria
    // La clave es el ID del cliente (String) y el valor es el objeto Customer.
    private Map<String, Customer> customerMap = new HashMap<>();

    // Metodo para registar/agregar un  nuevo cliente
    public void addCustomer(Customer customer){
        // put() agrega un nuevo cliente al Map usando su ID como clave
        customerMap.put(customer.getId(), customer);
        System.out.println(("Cliente agregado: " + customer.getName());
    }

}

package com.bankapp;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();

        // Crear clientes
        String number ="9876543";
        Customer c1 = new Customer("Maria", "Luz", "luz@example.com", "1234567");
        Customer c2 = new Customer("Valentina", "Sharo", "sharo@example.com", number);
        Customer c3 = new Customer("Aura", "Ana", "ana@example.com", "3456789");

        // Agregar clientes
        customerService.addCustomer(c1);
        customerService.addCustomer(c2);
        customerService.addCustomer(c3);

        // Mostrar todos
        customerService.showAllcustomers();

        // Buscar un cliente
        System.out.println("Buscando cliente con ID 9876543: " + customerService.getCustomer("9876543"));

        // Actualizar un cliente
        Customer c2Updated = new Customer("Valentina", "Sharo Montesinos", "sharo.m@example.com",number);
        customerService.updateCustomer( number,c2Updated);

        // Mostrar todos después de la actualización
        customerService.showAllcustomers();

        // Eliminar un cliente
        customerService.deleteCustomer("1234567");

        // Mostrar todos después de eliminar
        customerService.showAllcustomers();
    }
}
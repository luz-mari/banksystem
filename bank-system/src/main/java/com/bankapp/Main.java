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

        // Crear servicio de cuentas bancarias
        BankAccountService accountService = new BankAccountService(customerService);

        // Abrir cuentas para clientes existentes
        BankAccount cuentaAhorros = accountService.openAccount("9876543", AccountType.SAVINGS);
        BankAccount cuentaCorriente = accountService.openAccount("3456789", AccountType.CHECKING);

        // Prueba de depósito
        accountService.deposit(cuentaAhorros.getAccountNumber(), 1000.0);
        System.out.println("Saldo después de depósito (Ahorros): " + cuentaAhorros.getBalance());

        // Prueba de retiro válido en cuenta de ahorros
        boolean retiroExitoso = accountService.withdraw(cuentaAhorros.getAccountNumber(), 500.0);
        System.out.println("Retiro exitoso (Ahorros): " + retiroExitoso + ", Saldo: " + cuentaAhorros.getBalance());

        // Prueba de retiro inválido en cuenta de ahorros (excede saldo)
        retiroExitoso = accountService.withdraw(cuentaAhorros.getAccountNumber(), 600.0);
        System.out.println("Retiro excede saldo (Ahorros): " + retiroExitoso + ", Saldo: " + cuentaAhorros.getBalance());

        // Prueba de retiro en cuenta corriente (puede ir hasta -500)
        accountService.deposit(cuentaCorriente.getAccountNumber(), 200.0);
        retiroExitoso = accountService.withdraw(cuentaCorriente.getAccountNumber(), 600.0); // Queda en -400
        System.out.println("Retiro en cuenta corriente: " + retiroExitoso + ", Saldo: " + cuentaCorriente.getBalance());

        // Prueba de retiro que excede límite de sobregiro
        retiroExitoso = accountService.withdraw(cuentaCorriente.getAccountNumber(), 200.0); // Intento ir a -600
        System.out.println("Retiro excede sobregiro (Corriente): " + retiroExitoso + ", Saldo: " + cuentaCorriente.getBalance());
    }
}
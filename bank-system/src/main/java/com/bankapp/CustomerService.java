package com.bankapp;


import java.util.HashMap;
import java.util.Map;

public class CustomerService {
    // HashMap para almacenar los clientes en memoria
    // La clave es el dni (único por cliente) y el valor es el objeto Customer
    private Map<String, Customer> customerMap = new HashMap<>();

    //Registrar un nuevo cliente
    public void addCustomer(Customer customer) {
        if (customerMap.containsKey(customer.getDocumentNumber())){
            System.out.println("El cliente con DNI " + customer.getDocumentNumber() + "ya existe.");
        }else{
            customerMap.put(customer.getDocumentNumber(), customer);
            System.out.println("Cliente registrado correctamente: " + customer.getFirstName());
        }
    }
    //Obtener un cliente por su identificacion
    public Customer getCustomer(String documentNumber){
        return customerMap.get(documentNumber);  //devuelve el cliente si existe o null si no
    }
    //Actualizar datos de cliente
    public void  updateCustomer(String documentNumber, Customer updateCustomer) {
        if (customerMap.containsKey(documentNumber)){
            customerMap.put(documentNumber, updateCustomer);   //remplaza el objeto
            System.out.println("Cliente actualizado: " + updateCustomer.getFirstName());
        } else {
            System.out.println("No se encontro el cliente con documento de identificacion: " + documentNumber);
        }
    }

    //Eliminar cliente por su numero de  identificacion
    public void deleteCustomer(String documentNumber){
        if (customerMap.containsKey(documentNumber))  {
            customerMap.remove(documentNumber);
            System.out.println("Cliente eliminado correctamente.");
        } else {
            System.out.println("No se encontro el cliente: " + documentNumber);
        }
    }
    //Mostrar clientes registrados
    public void showAllcustomers(){
        if (customerMap.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        }
                else {
                    for (Customer c : customerMap.values())  {
                        System.out.println("Cliente: " + c.getFirstName() + " " + c.getLastName() + " -documentNumber : " + c.getDocumentNumber());
                    }
                }
    }

}

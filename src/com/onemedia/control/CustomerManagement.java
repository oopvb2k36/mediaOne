package com.onemedia.control;

import java.util.ArrayList;

public class CustomerManagement {

    public CustomerManagement() {
        customers = new ArrayList<>();
    }

    public boolean addCustomer(Customer customer) {
        if (customer == null) return false;
        for (int i=0; i < customers.size(); i++) {
            Customer o = customers.get(i);
            if (o.getIdCode().equals(customer.getIdCode()))
                return false;
        }
        customers.add(customer);
        return true;
    }

    public Customer rmvCustomer(String idCode) {
        for (int i=0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if (customer.getIdCode().equals(idCode)) {
                customers.remove(i);
                return customer;
            }
        }
        return null;
    }

    public boolean customerExisted(String idCode) {
        for (int i=0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if (customer.getIdCode().equals(idCode))
                return true;
        }
        return false;
    }

    public Customer getCustomerById(String idCode) {
        for (int i=0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if (customer.getIdCode().equals(idCode))
                return customer;
        }
        return null;
    }

    public void printInfo() {
        for (Customer o : customers) {
            o.printInfo();
        }
    }

    private ArrayList<Customer> customers;
}

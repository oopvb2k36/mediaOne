package com.onemedia.control;

public class Customer {

    public Customer() {
        idCode = "-1";
        name = "NO NAME";
        address = "NO ADDRESS";
        discount = 0;
    }

    public Customer(String idCode, String name) {
        setIdCode(idCode);
        setName(name);
        address = "NO ADDRESS";
        discount = 0;
    }

    public Customer(Customer customer) {
        setIdCode(customer.getIdCode());
        setName(customer.getName());
        setAddress(customer.getAddress());
        setDiscount(customer.getDiscount());
    }

    public void printInfo() {
        System.out.format("Ma KH: %s, Ten: %s, Dia chi: %s, Chiet khau: %s\n",
                idCode, name, address, discount);
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setDiscount(double discount) {
        if (discount < 0 ) this.discount = 0.0d;
        else this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    private String idCode;
    private String name;
    private String address;
    private double discount;
}

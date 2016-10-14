package com.onemedia.control;

public class Store {

    public Store(String name) {
        setName(name);
    }

    public Store(Store store) {
        setName(store.getName());
        setAddress(store.getAddress());
        setDirector(store.getDirector());
        setPhone(store.getPhone());
        setTaxCode(store.getTaxCode());
        setWebsite(store.getWebsite());
    }

    public void printInfo() {
        System.out.format("Ten: %s, Dia chi: %s, Giam doc: %s, Dien thoai: %s," +
                " Website: %s, MST: %s",
                name, address, director, phone, website, taxCode);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getTaxCode() {
        return taxCode;
    }

    private String name;
    private String director;
    private String phone;
    private String website;
    private String address;
    private String taxCode;

}

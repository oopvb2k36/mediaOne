package com.onemedia.control;

public class Provider {

    public Provider() {
        idCode = "-1";
        name = "NO NAME";
        address = "NO ADDRESS";
    }

    public Provider(String idCode, String name) {
        setIdCode(idCode);
        setName(name);
        address = "NO ADDRESS";
    }

    public Provider(Provider provider) {
        setIdCode(provider.getIdCode());
        setName(provider.getName());
        setAddress(provider.getAddress());
    }

    public void printInfo() {
        System.out.format("Ma NCC: %s, Ten: %s, Dia chi: %s\n",
                idCode, name, address);
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

    private String idCode;
    private String name;
    private String address;
}

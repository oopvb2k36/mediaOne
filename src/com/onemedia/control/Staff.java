package com.onemedia.control;

import java.time.LocalDate;

public class Staff {

    public Staff() {
        idCode = "-1";
        name = "NO NAME";
        address = "NO ADDRESS";
        salary = 0.0;
    }

    public Staff(String idCode, String name) {
        setIdCode(idCode);
        setName(name);
        address = "NO ADDRESS";
        salary = 0.0;
    }

    public Staff(Staff staff) {
        setIdCode(staff.getIdCode());
        setName(staff.getName());
        setAddress(staff.getAddress());
        setSalary(staff.getSalary());
    }

    public double getPaid() {
        return salary;
    }

    public void printInfo() {
        System.out.format("Ma NV %s, Ten %s, Ngay sinh:%s, Dia chi %s, Luong: %s\n",
                idCode, name, dateOfBirth.toString(), address, getSalary());
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

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setSalary(double salary) {
        if (salary < 0) this.salary = 0.0;
        else this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    private String idCode;
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private double salary;
}

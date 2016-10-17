package com.onemedia.control;

public class Cashier extends Staff {

    public Cashier() {
        super();
        user = "NO USER";
        pass = "NO PASS";
    }

    public Cashier(String idCode, String name) {
        super(idCode, name);
        user = "NO USER";
        pass = "NO PASS";
    }

    public Cashier(Staff staff) {
        super(staff);
        user = "NO USER";
        pass = "NO PASS";
    }

    public Cashier(Cashier cashier) {
        super(cashier);
        user = cashier.getUser();
        pass = cashier.getPass();
    }

    @Override
    public double getPaid() {
        return super.getPaid();
    }

    @Override
    public void printInfo() {
        System.out.format("Ma NV %s, Ten %s, Ngay sinh:%s, Dia chi: %s," +
                        " Luong: %s, Ten dang nhap: %s, Mat khau: %s\n",
                getIdCode(), getName(), getDateOfBirth(), getAddress(),
                getSalary(), getUser(), getPass());
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    private String user;
    private String pass;
}

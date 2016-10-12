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

    public Cashier(Cashier cashier) {
        super(cashier);
        user = "NO USER";
        pass = "NO PASS";
    }

    @Override
    public double getPaid() {
        // TODO: Bổ sung tính lương
        return 0;
    }

    @Override
    public void printInfo() {
        // TODO: Bổ sung in thông tin ra màn hình
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

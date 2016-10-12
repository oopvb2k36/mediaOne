package com.onemedia.control;

public class Director extends Staff {

    public Director() {
        super();
        user = "NO USER";
        pass = "NO PASS";
    }

    public Director(String idCode, String name) {
        super(idCode, name);
    }

    public Director(Director director) {
        super(director);
        setUser(director.getUser());
        setPass(director.getPass());
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

    public static void setAllowance(double allowance) {
        if (allowance < 0) Director.allowance = 0.0;
        else Director.allowance = allowance;
    }

    public static double getAllowance() {
        return allowance;
    }

    private String user;
    private String pass;
    private static double allowance;
}

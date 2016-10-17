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

    public Director(Staff staff) {
        super(staff);
        user = "NO USER";
        pass = "NO PASS";
    }

    public Director(Director director) {
        super(director);
        setUser(director.getUser());
        setPass(director.getPass());
    }

    @Override
    public double getPaid() {
        return super.getPaid() + allowance;
    }

    @Override
    public void printInfo() {
        System.out.format("Ma NV %s, Ten %s, Ngay sinh:%s, Dia chi: %s," +
                        " Luong: %s, Phu cap: %s, Ten dang nhap: %s, Mat khau: %s\n",
                getIdCode(), getName(), getDateOfBirth(), getAddress(),
                getSalary(), allowance, getUser(), getPass());
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

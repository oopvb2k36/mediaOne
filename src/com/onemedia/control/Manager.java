package com.onemedia.control;

public class Manager extends Staff {

    public Manager() {
        super();
        user = "NO USER";
        pass = "NO PASS";
    }

    public Manager(String idCode, String name) {
        super(idCode, name);
        user = "NO USER";
        pass = "NO PASS";
    }

    public Manager(Staff staff) {
        super(staff);
        user = "NO USER";
        pass = "NO PASS";
    }

    public Manager(Manager manager) {
        super(manager);
        setUser(manager.getUser());
        setPass(manager.getPass());
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
        if (allowance < 0) Manager.allowance = 0.0;
        else Manager.allowance = allowance;
    }

    public static double getAllowance() {
        return allowance;
    }

    private String user;
    private String pass;
    private static double allowance;
}

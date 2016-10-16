package com.onemedia.control;

import java.util.Date;

public class ExpenseTag {

    public ExpenseTag(String idCode) {
        this.idCode = idCode;
        paidMoney = 0;
        note = "NO NOTES";
        timestamp = new Date().getTime();
    }

    public ExpenseTag(ExpenseTag expenseTag) {
        setIdCode(expenseTag.getIdCode());
        setPaidMoney(expenseTag.getPaidMoney());
        setNote(expenseTag.getNote());
        timestamp = expenseTag.getTimestamp();
    }

    public void printInfo() {
        System.out.print("Ma phieu: " + idCode);
        System.out.print(", Thoi gian: " + new Date(timestamp).toString());
        System.out.print(", So tien: " + paidMoney);
        System.out.println(", Ghi chu: " + note);
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getIdCode() {
        return idCode;
    }

    public void setPaidMoney(double paidMoney) {
        if (paidMoney < 0) this.paidMoney = 0;
        else this.paidMoney = paidMoney;
    }

    public double getPaidMoney() {
        return paidMoney;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    private String idCode;
    private double paidMoney;
    private long timestamp;
    private String note;
}

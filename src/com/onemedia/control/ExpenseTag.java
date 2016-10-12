package com.onemedia.control;

public class ExpenseTag {

    public ExpenseTag(String idCode) {
        this.idCode = idCode;
        paidMoney = 0;
        note = "NO NOTES";
    }

    public ExpenseTag(ExpenseTag expenseTag) {
        setIdCode(expenseTag.getIdCode());
        setPaidMoney(expenseTag.getPaidMoney());
        setNote(expenseTag.getNote());
    }

    public void printInfo() {
        // TODO: bổ sung in thông tin ra màn hình
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

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    private String idCode;
    private double paidMoney;
    private String note;
}

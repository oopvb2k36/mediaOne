package com.onemedia.control;

import java.util.ArrayList;

public class ExpenseManagement {

    public ExpenseManagement() {
        expenseTags = new ArrayList<>();
    }

    public boolean addTag(ExpenseTag expenseTag) {
        // TODO: bổ sung thêm phiếu chi phí ngoài
        return true;
    }

    public ExpenseTag rmvTag(String idCode) {
        // TODO: bổ sung xóa phiếu chi phí ngoài
        return null;
    }

    public boolean tagExisted(String idCode) {
        // TODO: bổ sung kiểm tra phiếu chi phí
        return true;
    }

    public void printInfo() {
        // TODO: bổ sung in danh sách phiếu chi phí ngoài
    }

    ArrayList<ExpenseTag> expenseTags;
}

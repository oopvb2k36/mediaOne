package com.onemedia.control;

import java.util.ArrayList;

public class ExpenseManagement {

    public ExpenseManagement() {
        expenseTags = new ArrayList<>();
    }

    public boolean addTag(ExpenseTag expenseTag) {
        if (expenseTag == null) return false;
        for (ExpenseTag o : expenseTags) {
            if (o.getIdCode().equals(expenseTag.getIdCode()))
                return false;
        }
        expenseTags.add(expenseTag);
        return true;
    }

    public ExpenseTag rmvTag(String idCode) {
        for (int i=0; i < expenseTags.size(); i++) {
            ExpenseTag expenseTag = expenseTags.get(i);
            if (expenseTag.getIdCode().equals(idCode)) {
                expenseTags.remove(i);
                return expenseTag;
            }
        }
        return null;
    }

    public boolean tagExisted(String idCode) {
        for (ExpenseTag o : expenseTags) {
            if (o.getIdCode().equals(idCode))
                return true;
        }
        return false;
    }

    public void printInfo() {
        for (ExpenseTag expenseTag : expenseTags) {
            expenseTag.printInfo();
        }
    }

    public double getMoneyTotal() {
        double sum = 0;
        for (ExpenseTag expenseTag : expenseTags) {
            sum += expenseTag.getPaidMoney();
        }
        return sum;
    }

    ArrayList<ExpenseTag> expenseTags;
}

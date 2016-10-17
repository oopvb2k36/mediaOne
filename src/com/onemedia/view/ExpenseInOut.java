package com.onemedia.view;

import com.onemedia.control.*;

import java.util.Date;
import java.util.Scanner;

public class ExpenseInOut {

    ExpenseInOut(StoreManagement storeManagement) {
        this.storeManagement = storeManagement;
    }

    public void run(Scanner sc) {
        while (true) {
            System.out.println("QUAN LY CHI PHI");
            System.out.println("1.In danh sach");
            System.out.println("2.Them phieu chi");
            System.out.println("3.Xoa phieu chi");
            System.out.println("4.Quay lai");
            try {
                int key = Integer.parseInt(sc.nextLine());
                switch (key) {
                    case 1:
                        storeManagement.getExpenseManagement().printInfo();
                        break;
                    case 2:
                        addProcess(sc);
                        break;
                    case 3:
                        rmvProcess(sc);
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Ban nhap sai, hay nhap lai");
                        break;
                }
            }
            catch (NumberFormatException ex) {
                System.out.println("Ban nhap sai dinh dang!");
            }
        }
    }

    private void addProcess(Scanner sc) {
        ExpenseManagement mgr = storeManagement.getExpenseManagement();
        String idCode = "";
        do {idCode = "CP" + new Date().getTime();}
        while (mgr.tagExisted(idCode));

        ExpenseTag expenseTag = new ExpenseTag(idCode);

        System.out.println("Ban hay lua chon loai chi phi!");
        while (true) {
            System.out.println("1.Tra luong");
            System.out.println("2.Chi phi khac");
            System.out.println("3.Quay lai");
            System.out.print("Lua chon:");
            try {
                int key = Integer.parseInt(sc.nextLine());
                switch (key) {
                    case 1:
                        addInProcess(sc, expenseTag);
                        return;
                    case 2:
                        addExProcess (sc, expenseTag);
                        return;
                    case 3:
                        return;
                    default:
                        System.out.println("Ban nhap sai, hay nhap lai!");
                        break;
                }
            }
            catch (NumberFormatException ex) {
                System.out.println("Ban nhap sai dinh dang!");
            }
        }
    }

    private void addInProcess(Scanner sc, ExpenseTag expenseTag) {
        Staff staff = staffProcess(sc);

        if (staff != null) {
            expenseTag.setPaidMoney(staff.getPaid());
            System.out.print("Ghi chu: ");
            expenseTag.setNote(sc.nextLine());
            saveTagProcess(sc, expenseTag);
        }
    }

    private void addExProcess(Scanner sc, ExpenseTag expenseTag) {
        double paidMoney = 0;
        while (true) {
            System.out.print("Nhap so tien:");
            try {
                paidMoney = Double.parseDouble(sc.nextLine());
                expenseTag.setPaidMoney(paidMoney);
                System.out.print("Ghi chu: ");
                expenseTag.setNote(sc.nextLine());
                saveTagProcess(sc, expenseTag);
                return;
            }
            catch (NumberFormatException e) {
                System.out.println("Ban nhap sai dinh dang!");
            }
        }
    }

    public void saveTagProcess(Scanner sc, ExpenseTag expenseTag) {
        ExpenseManagement expMgr = storeManagement.getExpenseManagement();

        System.out.println("Thong tin phieu chi:");
        expenseTag.printInfo();
        System.out.print("Ban chac chan luu chu?(yes/no):");
        if (sc.nextLine().equals("yes")) {
            if (expMgr.addTag(expenseTag)) {
                System.out.println("Luu thanh cong");
            }
            else {
                System.out.println("Luu khong thanh cong");
            }
        }
    }

    private Staff staffProcess(Scanner sc) {
        StaffManagement mgr = storeManagement.getStaffManagement();
        Staff staff = null;
        int i = 3;
        while (i > 0) {
            System.out.print("Ma NV:");
            staff = mgr.getStaffById(sc.nextLine());
            if (staff != null) {
                staff.printInfo();
                break;
            }
            else {
                System.out.println("Ma nhan vien khong ton tai!");
            }
            i--;
        }
        return staff;
    }

    private void rmvProcess(Scanner sc) {
        ExpenseManagement expMgr = storeManagement.getExpenseManagement();
        expMgr.printInfo();
        System.out.print("Nhap ma so phieu:");
        String idCode = sc.nextLine();
        System.out.print("Ban co chac chan xoa khong?(yes/no):");
        if (sc.nextLine().equals("yes")) {
            expMgr.rmvTag(idCode);
        }
    }

    private StoreManagement storeManagement;
}


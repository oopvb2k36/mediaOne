package com.onemedia.view;

import com.onemedia.control.*;

import java.util.Date;
import java.util.Scanner;

public class ExpenseInOut {

    ExpenseInOut(StoreManagement storeManagement) {
        this.storeManagement = storeManagement;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            sc.reset();
            System.out.println("QUAN LY CHI PHI");
            System.out.println("1.In danh sach");
            System.out.println("2.Them phieu chi");
            System.out.println("3.Xoa chi phi");
            System.out.println("4.Quay lai");
            try {
                int key = sc.nextInt();
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
                System.out.println("Ban nhap sai, hay nhap lai");
            }
        }
    }

    private void addProcess(Scanner sc) {
        ExpenseManagement mgr = storeManagement.getExpenseManagement();
        String idCode = "";
        do {idCode = "CP" + new Date().getTime();}
        while (mgr.tagExisted(idCode));

        ExpenseTag expenseTag = new ExpenseTag(idCode);

        while (true) {
            System.out.println("1.Thanh toan tien luong");
            System.out.println("2.Thanh toan chi phi phat sinh");
            System.out.println("3.Luu chi phi");
            System.out.println("4.Quay lai");
            System.out.print("Lua chon:");
            try {
                int key = Integer.parseInt(sc.nextLine());
                switch (key) {
                    case 1:
                        addInProcess(sc, expenseTag);
                        break;
                    case 2:
                        addExProcess (sc, expenseTag);
                    case 3:
                        saveTagProcess(sc, expenseTag);
                    case 4:
                        return;
                    default:
                        System.out.println("Ban nhap sai, hay nhap lai!");
                        break;
                }
            }
            catch (NumberFormatException ex) {
                System.out.println("Ban nhap sai dinh dang");
            }
        }
    }

    private void addInProcess(Scanner sc, ExpenseTag expenseTag) {
        StaffManagement staffMgr = storeManagement.getStaffManagement();
        ExpenseManagement expMgr = storeManagement.getExpenseManagement();

        staffProcess(sc);
        saveTagProcess(sc, expenseTag);

    }

    private void addExProcess(Scanner sc, ExpenseTag expenseTag) {
        StaffManagement staffMgr = storeManagement.getStaffManagement();
        ExpenseManagement expMgr = storeManagement.getExpenseManagement();

        staffProcess(sc);

        int a;
        sc = new Scanner(System.in);
        System.out.println("Nhap chi phi phat sinh:");
        a = sc.nextInt();
        saveTagProcess(sc, expenseTag);
    }


    public void saveTagProcess(Scanner sc, ExpenseTag expenseTag) {
        StaffManagement staffMgr = storeManagement.getStaffManagement();
        ExpenseManagement expMgr = storeManagement.getExpenseManagement();

        System.out.println("Thong tin chi phi:");
        expenseTag.printInfo();
        System.out.print("Ban chac chan luu chu?(yes/no):");
        if (sc.nextLine().equals("yes")) {
            //  = expenseTag.getPaidMoney();

            if (expMgr.addTag(expenseTag))
                System.out.println("Luu thanh cong");
            else
                System.out.println("Luu khong thanh cong");
        }
    }

    private Staff staffProcess(Scanner sc) {
        StaffManagement mgr = storeManagement.getStaffManagement();
        Staff staff = null;
        int i = 0;
        while (i > 3) {
            System.out.print("Ma NV:");
            staff = mgr.getStaffById(sc.nextLine());
            if (staff != null) {
                staff.printInfo();
                break;
            }
            else
                System.out.println("Ma nhan vien khong ton tai!");

            i--;
        }
        return staff;
    }

    private void rmvProcess(Scanner sc) {
        ExportManagement expMgr = storeManagement.getExportManagement();
        expMgr.printInfo();
        System.out.print("Nhap ma so phieu:");
        String idCode = sc.nextLine();
        System.out.print("Ban co chac chan xoa khong?(yes/no):");
        if (sc.nextLine().equals("yes")) {
            expMgr.rmvTag(idCode);
            expMgr.printInfo();
        }

    }
        private StoreManagement storeManagement;
}


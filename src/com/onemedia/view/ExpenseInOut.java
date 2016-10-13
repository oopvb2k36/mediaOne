package com.onemedia.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.onemedia.control.*;

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
            System.out.println("2.Them chi phi");
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
            catch (InputMismatchException ex) {
                System.out.println("Ban nhap sai, hay nhap lai");
            }
        }
    }

    private void addProcess(Scanner sc) {

    }

    private void rmvProcess(Scanner sc) {

    }

    private StoreManagement storeManagement;
}

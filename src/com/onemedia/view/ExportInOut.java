package com.onemedia.view;

import com.onemedia.control.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExportInOut {
    public  ExportInOut(StoreManagement storeManagement) {
        this.storeManagement = storeManagement;
    }

    // Thống nhất tên hàm bắt đầu quá trình là run
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("QUAN LY XUAT HANG");
            System.out.println("1.Them phieu xuat");
            System.out.println("2.Xoa phieu xuat");
            System.out.println("3.In thong tin");
            System.out.println("4.Thoat");
            try {
                System.out.print("Lua chon:");
                int key = sc.nextInt();
                switch (key) {
                    case 1: // Them phieu
                        break;
                    case 2: // Xoa phieu
                        break;
                    case 3: // In thong tin
                        break;
                    case 4: // Thoat
                        break;
                }
            }
            catch (InputMismatchException ex) {
                System.out.println("Ban nhap sai, hay nhap lai!");
            }

        }
    }

    // Dinh nghia cac ham xu ly rieng...

    private StoreManagement storeManagement;

}

package com.onemedia.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.onemedia.control.*;
/**
 * Created by thanh on 13/10/2016.
 */
public class ProductInOut {
    public ProductInOut(StoreManagement storeManagement) {
        this.storeManagement = storeManagement;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            sc.reset();
            System.out.println("QUAN LY SAN PHAM");
            System.out.println("1.In danh sach san pham");
            System.out.println("2.Them san pham");
            System.out.println("3.Xoa san pham");
            System.out.println("4.Sua san pham");
            System.out.println("5.Quay lai");
            try {
                int key = sc.nextInt();
                switch (key) {
                    case 1:
                        storeManagement.getProductManagement().printInfo();
                        break;
                    case 2:
                        addProcess(sc);
                        break;
                    case 3:
                        rmvProcess(sc);
                        break;
                    case 4:
                        modifyProcess(sc);
                    case 5:
                        return;
                    default:
                        System.out.println("Ban nhap sai, hay nhap lai");
                        break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Ban nhap sai, hay nhap lai");
            }
        }
    }

    private void rmvProcess(Scanner sc) {
        sc.reset();
        System.out.print("Ma San Pham: ");
        String idCode = sc.nextLine();
        ProductManagement mgr = StoreManagement.getProductManagement();
        Product product = mgr.getProductById(idCode);
        if (product != null) {
            product.printInfo();
            System.out.print("Ban co chac chan xoa?(yes/no)");
            if (sc.nextLine().equals("yes")) {
                mgr.rmvProduct(idCode);
            }
        }
        else {
            System.out.println("Ma san pham khong ton tai");
        }

    private StoreManagement storeManagement;
}
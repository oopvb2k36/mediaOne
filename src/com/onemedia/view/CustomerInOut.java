package com.onemedia.view;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.onemedia.control.*;

public class CustomerInOut {

    public CustomerInOut(StoreManagement storeManagement) {
        this.storeManagement = storeManagement;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            sc.reset();
            System.out.println("QUAN LY KHACH HANG");
            System.out.println("1.In danh sach");
            System.out.println("2.Them khach hang");
            System.out.println("3.Xoa khach hang");
            System.out.println("4.Sua khach hang");
            System.out.println("5.Quay lai");
            try {
                int key = sc.nextInt();
                switch (key) {
                    case 1:
                        storeManagement.getCustomerManagement().printInfo();
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
            }
            catch (InputMismatchException ex) {
                System.out.println("Ban nhap sai, hay nhap lai");
            }
        }
    }

    private void addProcess(Scanner sc) {
        sc.reset();
        System.out.println("Ma khach hang sau khi nhap se duoc he thong" +
                " tu dong them tien to 'KH'");
        System.out.print("Ma KH:");
        String idCode = "KH" + sc.nextLine();
        CustomerManagement mgr = storeManagement.getCustomerManagement();
        if (mgr.customerExisted(idCode)) {
            System.out.println("Ma KH da ton tai");
            mgr.getCustomerById(idCode).printInfo();
        }
        else {
            Customer customer = new Customer(idCode, "NO NAME");
            System.out.print("Ten:");
            customer.setName(sc.nextLine());
            System.out.print("Dia chi:");
            customer.setName(sc.nextLine());
            System.out.print("Chiet khau:");
            try {
                double num = sc.nextDouble();
                customer.setDiscount(num);
            }
            catch (InputMismatchException ex) {
                System.out.println("Ban nhap sai chiet khau!");
            }

            System.out.println("Thong tin khach hang duoc them:");
            customer.printInfo();
            System.out.print("Ban co them khong?(yes/no)");
            if (sc.nextLine().equals("yes")) {
                mgr.addCustomer(customer);
            }
        }
    }

    private void rmvProcess(Scanner sc) {
        sc.reset();
        System.out.print("ma KH: ");
        String idCode = sc.nextLine();
        CustomerManagement mgr = storeManagement.getCustomerManagement();
        Customer customer = mgr.getCustomerById(idCode);
        if (customer != null) {
            customer.printInfo();
            System.out.print("Ban co chac chan xoa?(yes/no)");
            if (sc.nextLine().equals("yes")) {
                mgr.rmvCustomer(idCode);
            }
        }
        else {
            System.out.println("Ma khach hang khong ton tai");
        }

    }

    private void modifyProcess(Scanner sc) {
        sc.reset();
        System.out.print("Ma KH: ");
        String idCode = sc.nextLine();
        CustomerManagement mgr = storeManagement.getCustomerManagement();
        Customer customer = mgr.getCustomerById(idCode);
        if (customer != null) {
            System.out.println("Thong tin truoc khi sua:");
            customer.printInfo();

            String str = "";
            System.out.format("Ten(%s):", customer.getName());
            str = sc.nextLine();
            if (!str.equals("")) customer.setName(str);

            System.out.format("Dia chi(%s):", customer.getAddress());
            str = sc.nextLine();
            if (!str.equals("")) customer.setAddress(str);

            System.out.format("Chiet khau(%s):", customer.getDiscount());
            try {
                double discount = sc.nextDouble();
                customer.setDiscount(discount);
            }
            catch (InputMismatchException ex) {
                System.out.println("Ban nhap sai chiet khau!");
            }
            System.out.println("Thong tin sau khi sua:");
            customer.printInfo();
        }
        else {
            System.out.println("Ma khach hang khong ton tai");
        }
    }

    private StoreManagement storeManagement;
}

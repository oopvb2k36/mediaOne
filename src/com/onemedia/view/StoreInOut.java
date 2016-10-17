package com.onemedia.view;

import com.onemedia.control.*;

import java.util.Scanner;

public class StoreInOut {

    public StoreInOut(StoreManagement storeManagement) {
        this.storeManagement = storeManagement;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.Dang nhap");
            System.out.println("2.Dang xuat");
            System.out.println("3.Thoat");
            System.out.print("Lua chon:");
            try {
                int key = Integer.parseInt(sc.nextLine());
                switch (key) {
                    case 1: logInProcess(sc);
                        break;
                    case 2: storeManagement.logOut();
                        break;
                    case 3:
                        sc.close();
                        return;
                    default:
                        System.out.println("Ban nhap sai, hay nhap lai!");
                        break;
                }
            }
            catch (NumberFormatException ex) {
                System.out.println("Ban nhap sai, hay nhap lai!");
            }
        }
    }

    private void logInProcess(Scanner sc) {
        System.out.print("Ma nhan vien:");
        String idCode = sc.nextLine();
        System.out.print("Ten dang nhap:");
        String user = sc.nextLine();
        System.out.print("Mat khau:");
        String pass = sc.nextLine();
        System.out.format("Ban da nhap: %s, %s, %s\n", idCode, user, pass);
        Staff loggedStaff = storeManagement.logIn(idCode, user, pass);
        if (loggedStaff == null) {
            System.out.println("Dang nhap khong thanh cong!");
        }
        else {
            funcProcess(sc);
        }
    }

    private void funcProcess(Scanner sc) {
        while (true) {
            System.out.println("1.Quan ly nhan vien");
            System.out.println("2.Quan ly khach hang");
            System.out.println("3.Quan ly nha cung cap");
            System.out.println("4.Quan ly san pham");
            System.out.println("5.Quan ly nhap hang");
            System.out.println("6.Quan ly xuat hang");
            System.out.println("7.Quan ly chi phi");
            System.out.println("8.Quan ly thong tin cua hang");
            System.out.println("9.Quay lai");
            System.out.print("Lua chon:");
            try {
                int key = Integer.parseInt(sc.nextLine());
                switch (key) {
                    case 1: {
                        StaffInOut o = new StaffInOut(storeManagement);
                        o.run(sc);
                        break;
                    }
                    case 2: {
                        CustomerInOut o = new CustomerInOut(storeManagement);
                        o.run(sc);
                        break;
                    }
                    case 3: {
                        ProviderInOut o = new ProviderInOut(storeManagement);
                        o.run(sc);
                        break;
                    }
                    case 4: { // TODO: bo sung ProductInOut
                        System.out.println("Dang xay dung");
                        break;
                    }
                    case 5: {
                        ImportInOut o = new ImportInOut(storeManagement);
                        o.run(sc);
                        break;
                    }
                    case 6: {
                        ExportInOut o = new ExportInOut(storeManagement);
                        o.run(sc);
                        break;
                    }
                    case 7: {
                        ExpenseInOut o = new ExpenseInOut(storeManagement);
                        o.run(sc);
                        break;
                    }
                    case 8:
                        storeProcess(sc);
                        break;
                    case 9:
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

    private void storeProcess(Scanner sc) {
        while (true) {
            System.out.println("QUAN LY THONG TIN CUA HANG");
            System.out.println("1.In thong tin");
            System.out.println("2.Sua thong tin");
            System.out.println("3.In doanh thu");
            System.out.println("4.Quay lai");
            try {
                System.out.print("Lua chon:");
                int key = Integer.parseInt(sc.nextLine());
                switch (key) {
                    case 1:
                        storeManagement.printInfo();
                        break;
                    case 2:
                        modifyStoreInfoProcess(sc);
                        break;
                    case 3:
                        storeManagement.printFinancialInfo();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Ban nhap sai, hay nhap lai!");
                        break;
                }
            }
            catch (NumberFormatException ex) {
                System.out.println("Ban nhap sai, hay nhap lai!");
            }
        }
    }

    private void modifyStoreInfoProcess(Scanner sc) {
        Store store = storeManagement.getStore();
        System.out.println("Thong tin truoc khi sua:");
        store.printInfo();
        sc.reset();
        String str = "";
        System.out.format("Ten(%s):",store.getName());
        str = sc.nextLine();
        if (!str.equals("")) store.setName(str);

        System.out.format("Giam doc(%s):",store.getDirector());
        str = sc.nextLine();
        if (!str.equals("")) store.setDirector(str);

        System.out.format("Dien thoai(%s):",store.getPhone());
        str = sc.nextLine();
        if (!str.equals("")) store.setPhone(str);

        System.out.format("Website(%s):",store.getWebsite());
        str = sc.nextLine();
        if (!str.equals("")) store.setWebsite(str);

        System.out.format("Dia chi(%s):",store.getAddress());
        str = sc.nextLine();
        if (!str.equals("")) store.setAddress(str);

        System.out.format("MST(%s):",store.getTaxCode());
        str = sc.nextLine();
        if (!str.equals("")) store.setTaxCode(str);

        System.out.println("Thong tin sau khi sua:");
        store.printInfo();
    }

    private StoreManagement storeManagement;
}

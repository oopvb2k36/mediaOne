package com.onemedia.view;

import java.util.Scanner;
import com.onemedia.control.*;

public class ProviderInOut {

    public ProviderInOut(StoreManagement storeManagement) {
        this.storeManagement = storeManagement;
    }

    public void run(Scanner sc) {
        while (true) {
            System.out.println("QUAN LY NHA CUNG CAP");
            System.out.println("1.In danh sach");
            System.out.println("2.Them nha cung cap");
            System.out.println("3.Xoa nha cung cap");
            System.out.println("4.Sua nha cung cap");
            System.out.println("5.Quay lai");
            System.out.print("Lua chon:");
            try {
                int key = Integer.parseInt(sc.nextLine());
                switch (key) {
                    case 1:
                        storeManagement.getProviderManagement().printInfo();
                        break;
                    case 2:
                        addProcess(sc);
                        break;
                    case 3:
                        rmvProcess(sc);
                        break;
                    case 4:
                        modifyProcess(sc);
                        break;
                    case 5:
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
        System.out.println("Ma nha cung cap sau khi nhap se duoc he thong" +
                " tu dong them tien to 'NCC'");
        System.out.print("Ma NCC:");
        String idCode = "NCC" + sc.nextLine();
        ProviderManagement mgr = storeManagement.getProviderManagement();
        if (mgr.providerExisted(idCode)) {
            System.out.println("Ma NCC da ton tai");
            mgr.getProviderById(idCode).printInfo();
        }
        else {
            Provider provider = new Provider(idCode, "NO NAME");
            System.out.print("Ten:");
            provider.setName(sc.nextLine());
            System.out.print("Dia chi:");
            provider.setAddress(sc.nextLine());

            System.out.println("Thong tin nha cung cap duoc them:");
            provider.printInfo();
            System.out.print("Ban co them khong?(yes/no)");
            if (sc.nextLine().equals("yes")) {
                mgr.addProvider(provider);
            }
        }
    }

    private void rmvProcess(Scanner sc) {
        System.out.print("ma NCC: ");
        String idCode = sc.nextLine();
        ProviderManagement mgr = storeManagement.getProviderManagement();
        Provider provider = mgr.getProviderById(idCode);
        if (provider != null) {
            provider.printInfo();
            System.out.print("Ban co chac chan xoa?(yes/no)");
            if (sc.nextLine().equals("yes")) {
                mgr.rmvProvider(idCode);
            }
        }
        else {
            System.out.println("Ma khach hang khong ton tai");
        }

    }

    private void modifyProcess(Scanner sc) {
        System.out.print("Ma NCC: ");
        String idCode = sc.nextLine();
        ProviderManagement mgr = storeManagement.getProviderManagement();
        Provider provider = mgr.getProviderById(idCode);
        if (provider != null) {
            System.out.println("Thong tin truoc khi sua:");
            provider.printInfo();

            System.out.format("Ten(%s):", provider.getName());
            String name = sc.nextLine();

            System.out.format("Dia chi(%s):", provider.getAddress());
            String address = sc.nextLine();

            System.out.print("Ban co sua khong?(yes/no)");
            if (sc.nextLine().equals("yes")) {
                if (!name.equals("")) provider.setName(name);
                if (!address.equals("")) provider.setAddress(address);
            }

            System.out.println("Thong tin sau khi sua:");
            provider.printInfo();
        }
        else {
            System.out.println("Ma khach hang khong ton tai");
        }
    }

    private StoreManagement storeManagement;
}

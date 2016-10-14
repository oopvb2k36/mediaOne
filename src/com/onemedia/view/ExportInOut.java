package com.onemedia.view;

import com.onemedia.control.*;

import java.util.Date;
import java.util.Scanner;

public class ExportInOut {
    public  ExportInOut(StoreManagement storeManagement) {
        this.storeManagement = storeManagement;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("QUAN LY XUAT HANG");
            System.out.println("1.In danh sach");
            System.out.println("2.Them phieu xuat");
            System.out.println("3.Xoa phieu xuat");
            System.out.println("4.Thoat");
            try {
                System.out.print("Lua chon:");
                int key = Integer.parseInt(sc.nextLine());
                switch (key) {
                    case 1:
                        storeManagement.getExportManagement().printInfo();
                        break;
                    case 2:
                        addProcess(sc);
                        break;
                    case 3:
                        rmvProcess(sc);
                        break;
                    case 4:
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

    private void addProcess(Scanner sc) {
        ExportManagement mgr = storeManagement.getExportManagement();
        String idCode = "";
        do {idCode = "PX" + new Date().getTime();}
        while (mgr.tagExisted(idCode));

        ExportTag exportTag = new ExportTag(idCode);

        Customer customer = custProcess(sc);
        if (customer == null) return;
        exportTag.setCustomer(new Customer(customer));

        //sc.useDelimiter("\\*\\n");
        System.out.print("Ghi chu:");
        exportTag.setNote(sc.nextLine());
        //sc.reset();

        while (true) {
            System.out.println("1.Them hang");
            System.out.println("2.Xoa hang");
            System.out.println("3.Luu phieu");
            System.out.println("4.Quay lai");
            System.out.print("Lua chon:");
            try {
                int key = Integer.parseInt(sc.nextLine());
                switch (key) {
                    case 1:
                        addProProcess(sc, exportTag);
                        break;
                    case 2:
                        rmvProProcess(sc, exportTag);
                        break;
                    case 3:
                        saveTagProcess(sc, exportTag);
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

    public void addProProcess(Scanner sc, ExportTag exportTag) {
        Product product = proProcess(sc);
        if (product == null) return;

        product.printInfo();

        Product newProduct = null;
        if (product instanceof Book) {
            newProduct = new Book((Book)product);
        }
        else if (product instanceof Film) {
            newProduct = new Film((Film)product);
        }
        else {
            newProduct = new Music((Music)product);
        }

        try {
            System.out.print("So luong:");
            int qlt = Integer.parseInt(sc.nextLine());
            if (qlt <= product.getQuantity()) {
                newProduct.setQuantity(qlt);
                if (!exportTag.addProduct(newProduct))
                    System.out.println("Them san pham khong thanh cong!\n" +
                            "Co the da ton tai trong phieu");
            }
            else {
                System.out.println("San pham trong kho het!");
            }
        }
        catch (NumberFormatException ex) {
            System.out.println("Ban nhap sai, hay nhap nhap lai!");
        }
    }

    public void rmvProProcess(Scanner sc, ExportTag exportTag) {
        exportTag.printInfo();

        System.out.println("Ban muon xoa san pham nao?");
        System.out.print("Nhap ma san pham:");
        String idCode = sc.nextLine();
        if (!exportTag.rmvProduct(idCode))
            System.out.println("Xoa khong thanh cong");

        exportTag.printInfo();
    }

    public void saveTagProcess(Scanner sc, ExportTag exportTag) {
        ProductManagement proMgr = storeManagement.getProductManagement();
        ExportManagement expMgr = storeManagement.getExportManagement();

        System.out.println("Thong tin phieu xuat:");
        exportTag.printInfo();
        System.out.print("Ban chac chan luu chu?(yes/no):");
        if (sc.nextLine().equals("yes")) {
            Product[] newProducts = exportTag.getProducts();

            // Cap nhat so luong
            for (int i=0; i < newProducts.length; i++) {
                Product p = proMgr.getProductById(newProducts[i].getIdCode());
                int oldQlt = p.getQuantity();
                int soldQlt = newProducts[i].getQuantity();
                p.setQuantity(oldQlt - soldQlt);
            }

            if (expMgr.addTag(exportTag))
                System.out.println("Luu thanh cong");
            else
                System.out.println("Luu khong thanh cong");
        }
    }

    private Product proProcess(Scanner sc) {
        ProductManagement mgr = storeManagement.getProductManagement();
        Product product = null;
        int i = 3;
        while (i > 0) {
            System.out.print("Nhap ma san pham: ");
            product = mgr.getProductById(sc.nextLine());
            if (product != null)
                break;
            else
                System.out.println("Ma san pham khong ton tai!");
            i--;

        }
        return product;
    }

    private Customer custProcess(Scanner sc) {
        CustomerManagement mgr = storeManagement.getCustomerManagement();
        Customer customer = null;
        int i = 3;
        while (i > 0) {
            System.out.print("Ma KH:");
            customer = mgr.getCustomerById(sc.nextLine());
            if (customer != null) {
                customer.printInfo();
                break;
            }
            else
                System.out.println("Ma khach hang khong ton tai!");

            i--;
        }
        return customer;
    }

    private void rmvProcess(Scanner sc) {
        ExportManagement expMgr = storeManagement.getExportManagement();
        ProductManagement proMgr = storeManagement.getProductManagement();
        expMgr.printInfo();
        System.out.print("Nhap ma phieu:");
        String idCode = sc.nextLine();
        System.out.print("Ban co chac chan xoa khong?(yes/no):");
        if (sc.nextLine().equals("yes")) {
            ExportTag rmvTag = expMgr.rmvTag(idCode);
            if (rmvTag != null) {
                Product[] products = rmvTag.getProducts();

                // Cap nhat so luong
                for (int i=0; i < products.length; i++) {
                    Product p = proMgr.getProductById(products[i].getIdCode());
                    int oldQlt = p.getQuantity();
                    int rtnQlt = products[i].getQuantity();
                    p.setQuantity(oldQlt + rtnQlt);
                }

                expMgr.printInfo();
            }
            else {
                System.out.println("Ma phieu khong ton tai!");
            }
        }
    }

    private StoreManagement storeManagement;

}

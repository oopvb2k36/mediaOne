package com.onemedia.view;

import com.onemedia.control.*;

import java.util.Date;
import java.util.Scanner;

/**
 * Created by Thomas Lewis on 10/14/2016.
 */
public class ImportInOut {



    public ImportInOut(ImportManagement importManagement){this.importManagement = importManagement;}
    public ImportInOut(StoreManagement storeManagement){this.storeManagement = storeManagement;}


    public void run(){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("1. Them phieu nhap hang");
            System.out.println("2. Xoa phieu nhap hang");
            System.out.println("3. Kiem tra phieu nhap");
            System.out.println("4. In danh sach phieu nhap");
            System.out.println("5. Tinh tong tien");

         try {
             int key = Integer.parseInt(sc.nextLine());
             switch (key){
                 case 1:
                        addProcess(sc);
                     break;
                 case 2:
                        rmvProcess(sc);
                     break;
                 case 3:

                     break;
                 case 4:
                     break;
                 case 5:
                     break;
             }
        }
        catch (NumberFormatException ex){

           }
        }

    }



    private void addProcess(Scanner sc) {
        ImportManagement mgr = StoreManagement.getImportManagement();
        String idCode = "";
        do {idCode = "PN" + new Date().getTime();}
        while (mgr.tagExisted(idCode));

        ImportTag importTag = new ImportTag(idCode);

        Provider provider = provProcess(sc);
        if (provider == null) return;
        importTag.setProvider(new Provider(provider));

        //sc.useDelimiter("\\*\\n");
        System.out.print("Ghi chu:");
        importTag.setNote(sc.nextLine());
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
                        addProProcess(sc, importTag);
                        break;
                    case 2:
                        rmvProProcess(sc, importTag);
                        break;
                    case 3:
                        saveTagProcess(sc, importTag);
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

    private ImportManagement importManagement;

    private Provider provProcess(Scanner sc) {
        StoreManagement storeManagement = new StoreManagement();
        ProviderManagement mgr = storeManagement.getProviderManagement();
        Customer customer = null;
        int i = 3;
        Provider provider;
        while (i > 0) {
            System.out.print("Ma NCC:");
            provider = mgr.getProviderById(sc.nextLine());
            if (provider != null) {
                provider.printInfo();
                break;
            }
            else
                System.out.println("Ma nha cung cap khong ton tai!");

            i--;
        }
        return provider;
    }

    public void addProProcess(Scanner sc, ImportTag importTag) {
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
            /* if (qlt <= product.getQuantity()) {
                newProduct.setQuantity(qlt);
                if (!importTag.addProduct(newProduct))
                    System.out.println("Them san pham khong thanh cong!\n" +
                            "Co the da ton tai trong phieu");
            }
            else {
                System.out.println("San pham trong kho het!");
            }   */
        }
        catch (NumberFormatException ex) {
            System.out.println("Ban nhap sai, hay nhap nhap lai!");
        }
    }

    public void rmvProProcess(Scanner sc, ImportTag importTag) {
        importTag.printInfo();

        System.out.println("Ban muon xoa san pham nao?");
        System.out.print("Nhap ma san pham:");
        String idCode = sc.nextLine();
        if (!importTag.rmvProduct(idCode))
            System.out.println("Xoa khong thanh cong");

        importTag.printInfo();
    }

    public void saveTagProcess(Scanner sc, ImportTag importTag) {
        StoreManagement storeManagement = new StoreManagement();
        ProductManagement proMgr = storeManagement.getProductManagement();
        ImportManagement impMgr = storeManagement.getImportManagement();

        System.out.println("Thong tin phieu nhap:");
        importTag.printInfo();
        System.out.print("Ban chac chan luu chu?(yes/no):");
        if (sc.nextLine().equals("yes")) {
            Product[] newProducts = importTag.getProducts();

            // Cap nhat so luong
            for (int i=0; i < newProducts.length; i++) {
                Product p = proMgr.getProductById(newProducts[i].getIdCode());
                int oldQlt = p.getQuantity();
                int boughtQlt = newProducts[i].getQuantity();
                p.setQuantity(oldQlt + boughtQlt);
            }

            if (impMgr.addTag(importTag))
                System.out.println("Luu thanh cong");
            else
                System.out.println("Luu khong thanh cong");
        }
    }

    private Product proProcess(Scanner sc) {
        StoreManagement storeManagement = new StoreManagement();
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

    private Provider provnProcess(Scanner sc) {
        StoreManagement storeManagement = new StoreManagement();
        ProviderManagement mgr = storeManagement.getProviderManagement();
        Provider provider = null;
        int i = 3;
        while (i > 0) {
            System.out.print("Ma NCC:");
            provider = mgr.getProviderById(sc.nextLine());
            if (provider != null) {
                provider.printInfo();
                break;
            }
            else
                System.out.println("Ma nha cung cap khong ton tai!");

            i--;
        }
        return provider;
    }

    private void rmvProcess(Scanner sc) {
        StoreManagement storeManagement = new StoreManagement();
        ImportManagement impMgr = storeManagement.getImportManagement();
        ProductManagement proMgr = storeManagement.getProductManagement();
        impMgr.printInfo();
        System.out.print("Nhap ma phieu:");
        String idCode = sc.nextLine();
        System.out.print("Ban co chac chan xoa khong?(yes/no):");
        if (sc.nextLine().equals("yes")) {
            ImportTag rmvTag = impMgr.rmvTag(idCode);
            if (rmvTag != null) {
                Product[] products = rmvTag.getProducts();

                // Cap nhat so luong
                for (int i=0; i < products.length; i++) {
                    Product p = proMgr.getProductById(products[i].getIdCode());
                    int oldQlt = p.getQuantity();
                    int rtnQlt = products[i].getQuantity();
                    p.setQuantity(oldQlt + rtnQlt);
                }

                impMgr.printInfo();
            }
            else {
                System.out.println("Ma phieu khong ton tai!");
            }
        }
    }
}
